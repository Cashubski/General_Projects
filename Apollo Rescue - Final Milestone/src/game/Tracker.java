package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.bodies.Astronaut;
import game.gui.GameView;
import org.jbox2d.common.Vec2;
/**
 * Responsible for tracking the astronaut
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class Tracker implements StepListener {
    private GameView view;
    private Astronaut astronaut;
    public Tracker(GameView view, Astronaut astronaut) {
        this.view = view;
        this.astronaut = astronaut;
    }
    public void preStep(StepEvent e) {}
    //Centers the view so that the astronaut is always in the middle of the screen
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(astronaut.getPosition()));
    }
}  //.x,0 to make it not completely centered