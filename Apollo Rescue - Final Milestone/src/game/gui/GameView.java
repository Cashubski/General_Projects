package game.gui;

import city.cs.engine.UserView;
import game.bodies.Astronaut;
import game.levels.GameLevel;

import java.awt.*;
/**
 * Displays attributes on the screen
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class GameView extends UserView {
    private Image background;
    public Image back;
    public GameLevel w;
    public Astronaut astronaut;
    public GameView(GameLevel w, int width, int height) {
        super(w, width, height);
        this.w = w;
        astronaut = w.getAstronaut();
        //background = new ImageIcon("data/Galaxy.gif").getImage();
    }
    //int health = astronaut.getHpCount();
    public void setBack(Image background){
        this.back = background;
    }
    public void update(Astronaut a){this.astronaut = a;}
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(back, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        //changes the colour of the writing
        g.setColor(Color.GRAY);
        //changes the font of the writing
        g.setFont(new Font("Arial",Font.BOLD,15));
        //the drawStrings below display the information on the screen.
        g.drawString("Pipes: " + astronaut.getPipeCount(),0,420);
        g.drawString("Bags: " + astronaut.getBagCount(),0,435);
        g.drawString("Tape: " + astronaut.getTapeCount(),0,450);
        g.drawString("Canisters: " + astronaut.getCanisterCount(),0,465);
        g.drawString("Cardboard: "+ astronaut.getCardboardCount(),0,480);
        g.drawString("HP: " + astronaut.getHpCount(),0,495);
        g.drawString("Apollo Rescue" ,0,510);
    }

}
