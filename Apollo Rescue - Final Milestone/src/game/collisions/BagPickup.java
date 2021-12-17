package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.bodies.Astronaut;
import game.bodies.Bag;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** The collision listener class for the bag
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class BagPickup implements CollisionListener {

    private Astronaut astronaut;
    public BagPickup(Astronaut a){
        this.astronaut = a;
    }
    private static SoundClip bagSound;
    static {
        try {
            //the line below plays the sound of the bag
            bagSound = new SoundClip("data/bag.wav");
            System.out.println("Loading bag sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    @Override
    //public collision event method
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Bag) {
            astronaut.addBag();
            bagSound.play();
            e.getOtherBody().destroy();
        }
    }
}