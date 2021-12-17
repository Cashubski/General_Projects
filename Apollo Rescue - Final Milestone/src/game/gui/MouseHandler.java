package game.gui;

import game.bodies.Astronaut;
import game.bodies.IceCream;
import game.levels.Level1;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Responsible for mouse handling
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class MouseHandler extends MouseAdapter {

    private Level1 level;
    private GameView view;
    private Astronaut astronaut;

    public MouseHandler(Level1 w, GameView v, Astronaut a) {
        level = w;
        view = v;
        astronaut = a;
    }

    @Override
    public void mousePressed(MouseEvent e){
    //create Ice Cream and add it to world
        int ice = astronaut.getIceCreamCount();
        if(ice > 0 && ice <=3) {
            IceCream iceCream = new IceCream(level);
//        //get the mouse coordinates
            Point mousePoint = e.getPoint();
//        //transform them to world coordinates
            Vec2 worldPoint = view.viewToWorld(mousePoint);
//        //position the ice cream
            iceCream.setPosition(worldPoint);
    }
}

        //we have to implement the other methods to satisfy
        //the interface, but we can leave them empty.

        @Override
        public void mouseClicked (MouseEvent e){
        }
        @Override
        public void mouseReleased (MouseEvent e){
        }
        @Override
        public void mouseEntered (MouseEvent e){
        }
        @Override
        public void mouseExited (MouseEvent e){
        }
    }

