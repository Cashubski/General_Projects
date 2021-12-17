package game.bodies;

import city.cs.engine.*;
import java.util.Random;
/** The walker class of the Astronaut
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class Astronaut extends Walker {
    private Random random;
    private static final Shape astronautShape = new PolygonShape(
            -1.09f,3.21f,
            -2.1f,0.38f,
            -1.18f,-3.7f,
            1.29f,-3.78f,
            1.89f,0.74f,
            0.26f,3.44f);

    private static final BodyImage image =
            new BodyImage("data/astronaut.png", 9.5f);

    // Private labels below
    private int tapeCount;
    private int canisterCount;
    private int pipeCount;
    private int bagCount;
    private int cardboardCount;
    private int iceCreamCount;
    private int hpCount;

    /**
     * Astronaut Attributes
     * <p>
     * The attributes that the astronaut contains from the beginning.
     *
     * @param  world link with the main world
     * @return nothing
     */
    public Astronaut(World world) {
        //attributes of the Astronaut
        super(world, astronautShape);
        addImage(image);
        //random = new Random();
        //random.nextInt(100);
        tapeCount = 0;
        canisterCount = 0;
        pipeCount = 0;
        bagCount = 0;
        cardboardCount = 0;
        iceCreamCount = 3;
        hpCount = 100;

    }
    // Series of accessors and mutators below to obtain proper encapsulation listed below.

    /**
     * Method which increments the tape count
     * <p>
     * Tape count increment
     *
     * @return The tape count & how many tapes have already been collected
     */
    public void addTape(){
        tapeCount++;
        System.out.println("You have collected " + tapeCount + " tape so far.");
        if (tapeCount == 2) {
            System.out.println("Well done, you have all the Duct Tape you need");
        }
    }
    /**
     * Getter method for the tape count
     * <p>
     * Retrieves the tape count
     *
     * @return The tape count
     */
    public int getTapeCount(){
        return tapeCount;
    }
    /**
     * Method which increments the canister count
     * <p>
     * Canister count increment
     *
     * @return The Canister count & how many canisters have already been collected
     */
    public void addCanister(){
        canisterCount++;
        System.out.println("You have collected " + canisterCount + " LiOH Canister and you only need one for the mission");
        }
    /**
     * Getter method for the canister count
     * <p>
     * Retrieves the canister count
     *
     * @return The canister count
     */
    public int getCanisterCount(){ return canisterCount; }
    /**
     * Method which increments the pipe count
     * <p>
     * Pipe count increment
     *
     * @return The pipe count & how many pipes have already been collected
     */
    public void addPipe(){
        pipeCount++;
        System.out.println("You have collected " + pipeCount + " pipes so far.");
        if (pipeCount == 2) {
            System.out.println("Well done, you have all the pipes you need");
        }
    }
    /**
     * Getter method for the pipe count
     * <p>
     * Retrieves the pipe count
     *
     * @return The pipe count
     */
    public int getPipeCount(){ return pipeCount; }
    /**
     * Method which increments the bag count
     * <p>
     * Bag count increment
     *
     * @return The bag count & how many bags have already been collected
     */
    public void addBag(){
        bagCount++;
        System.out.println("You have collected " + bagCount + " bags so far.");
        if (bagCount == 2) {
            System.out.println("Well done, you have all the bags you need");
        }
    }
    /**
     * Getter method for the bag count
     * <p>
     * Retrieves the bag count
     *
     * @return The bag count
     */
    public int getBagCount(){ return bagCount; }
    /**
     * Method which increments the Ice Cream count
     * <p>
     * Ice Cream count increment & hp increment by 20
     *
     * @return The Ice Cream count & how much Ice cream has been collected and by how much your hp has increased
     */
    public void addIceCream(){
        iceCreamCount++;
        hpCount = hpCount + 20;
        System.out.println("You have collected " + iceCreamCount + " ice cream, your hp increased by 20!");
    }
    /**
     * Getter method for the ice cream count
     * <p>
     * Retrieves the ice cream count
     *
     * @return The ice cream count
     */
    public int getIceCreamCount(){ return iceCreamCount; }
    /**
     * Method which increments the Cardboard count
     * <p>
     * Cardboard count increment
     *
     * @return The cardboard count & how much cardboard has already been collected
     */
    public void addCardboard(){
        cardboardCount++;
        System.out.println("You have collected " + cardboardCount + " cardboard piece and you only need one for the mission");
    }
    /**
     * Getter method for the cardboard count
     * <p>
     * Retrieves the cardboard count
     *
     * @return The cardboard count
     */
    public int getCardboardCount(){ return cardboardCount; }
    /**
     * Method which decrements the HP count
     * <p>
     * HP count decrement
     *
     * @return How much hp has been lost
     */
    public void decHealth(){
        hpCount = hpCount - 20;
        System.out.println("You have lost 20HP");
    }
    /**
     * Getter method for the hp count
     * <p>
     * Retrieves the hp count
     *
     * @return The hp count
     */
    public int getHpCount(){ return hpCount; }
    /**
     * Responsible for holding & displaying the variable counts that are in the inventory
     */
    String Invy(){
        String Inv = ("You currently have: " + tapeCount + " Tape, "
                + canisterCount + " LiOH canisters, " + pipeCount + " Pipes, " + bagCount + "" +
                " Bags, " + iceCreamCount + " Ice cream and "+cardboardCount+" Cardboard in your inventory.");
        return Inv;
    }
    int count = (pipeCount + bagCount + tapeCount + canisterCount + cardboardCount + iceCreamCount + hpCount);
    public int getCount(){ return count; }

    /**
     * Setter method for the pipe count
     * <p>
     * @param  pc pipe count integer variable
     * Sets the pipe count to a variable
     *
     * @return Nothing
     */
    public void setPipeCount(int pc){
        pipeCount = pc;
    }
    /**
     * Setter method for the bag count
     * <p>
     * @param  bc bag count integer variable
     * Sets the bag count to a variable
     *
     * @return Nothing
     */
    public void setBagCount(int bc){
        bagCount = bc;
    }
    /**
     * Setter method for the tape count
     * <p>
     * @param  tc tape count integer variable
     * Sets the tape count to a variable
     *
     * @return Nothing
     */
    public void setTapeCount(int tc){
        tapeCount = tc;
    }
    /**
     * Setter method for the canister count
     * <p>
     * @param  cc canister count integer variable
     * Sets the canister count to a variable
     *
     * @return Nothing
     */
    public void setCanisterCount(int cc){
        canisterCount = cc;
    }
    /**
     * Setter method for the cardboard count
     * <p>
     * @param  cac cardboard count integer variable
     * Sets the cardboard count to a variable
     *
     * @return Nothing
     */
    public void setCardboardCount(int cac){
        cardboardCount = cac;
    }
    /**
     * Setter method for the hp count
     * <p>
     * @param  hc hp count integer variable
     * Sets the hp count to a variable
     *
     * @return Nothing
     */
    public void setHPCount(int hc){
        hpCount = hc;
    }
}