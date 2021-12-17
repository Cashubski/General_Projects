import numpy as np
from scipy.stats import norm
import math
import time

class OptionPricing:

    def __init__(self,S0,E,T,rf,sigma,iterations):
        self.S0 = S0 #initial price of the underlying stock
        self.E = E #the strike price
        self.T = T #expiry
        self.rf = rf #risk free interest rate
        self.sigma = sigma #sigma volatilty
        self.iterations = iterations #how many iterations will be simulated

    def call_option_simulation(self):
        #we have 2 columns: first with 0s the second column will store the payoff
        #we need the first column of 0s: payoff funcition is max (0,S-E) for call option
        option_data = np.zeros([self.iterations, 2])

        #dimensions: 1 dimensional array with as many items as the iterations
        rand = np.random.normal(0, 1, [1, self.iterations])

        #equation for the S(t) stock price
        stock_price = self.S0*np.exp(self.T*(self.rf - 0.5*self.sigma**2)+self.sigma*np.sqrt(self.T)*rand)

        #we need S-E because we have to calculate the max (S-E,0)
        option_data[:,1] = stock_price - self.E

        #average for the Monte-Carlo method
        #np-amax() returns the max(0,S-E) according to the formula
        average = np.sum(np.amax(option_data, axis=1))/float(self.iterations)

        #have to use the exp(-rT) discount factor
        return np.exp(-1.0*self.rf*self.T)*average

    def put_option_simulation(self):
        #we have 2 columns: first with 0s the second column will store the payoff
        #we need the first column of the 0s: payoff function is max(0,E-S) for put option
        option_data = np.zeros([self.iterations, 2])

        #dimensions: 1 dimensionsal aray with as many items as the iterations
        rand = np.random.normal(0, 1, [1, self.iterations])

        #equation for the S(t) stock price
        stock_price = self.S0 * np.exp(self.T * (self.rf - 0.5 * self.sigma ** 2) + self.sigma * np.sqrt(self.T) * rand)

        # we need E-S because we have to calculate the max (E-S,0)
        option_data[:, 1] = self.E - stock_price

        # average for the Monte-Carlo method
        # np-amax() returns the max(0,E-S) according to the formula
        average = np.sum(np.amax(option_data, axis=1)) / float(self.iterations)

        #have to use the exp(-rT) discount factor
        return np.exp(-1.0*self.rf*self.T)*average



if __name__ == "__main__":

    S0=100
    E=100
    T=1
    rf=0.05
    sigma=0.2
    iterations = 10000000

    def blackScholes(rf,S0,E,T,sigma, type="Call"):
        #caclulate BlackScholes option price for a call or a put.
        d1 = (np.log(S0/E) + (rf + sigma **2/2)*T)/(sigma*np.sqrt(T))
        d2 = d1 - sigma*np.sqrt(T)
        try:
            if type == "Call":
                price = S0*norm.cdf(d1, 0, 1) - E*np.exp(-rf*T)*norm.cdf(d2, 0, 1)
            elif type == "Put":
                price = E*np.exp(-rf*T)*norm.cdf(-d2, 0, 1) - S0*norm.cdf(-d1, 0, 1)
            return price
        except:
            print("Please confirm all option parameters above!!!")
    print("CALL option price with Black-Scholes is: ", round(blackScholes(rf, S0, E, T, sigma, type="Call"), 6))
    print("PUT option price with Black-Scholes is: ", round(blackScholes(rf, S0, E, T, sigma, type="Put"), 6))
    model = OptionPricing(S0,E,T,rf,sigma,iterations)
    print("CALL option price with Monte-Carlo: ", model.call_option_simulation())
    print("PUT option price with Monte-Carlo: ", model.put_option_simulation())


