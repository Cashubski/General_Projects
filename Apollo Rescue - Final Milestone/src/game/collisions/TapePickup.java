package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.bodies.Astronaut;
import game.bodies.Tape;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** The collision listener class for the tape
*
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class TapePickup implements CollisionListener {

    private Astronaut astronaut;
    public TapePickup(Astronaut a){ this.astronaut = a; }
    private static SoundClip tapeSound;
    static {
        try {
            //the line below plays the sound of the tape
            tapeSound = new SoundClip("data/tape.wav");
            System.out.println("Loading tape sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    @Override
    //public collision event method
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Tape) {
            astronaut.addTape();
            tapeSound.play();
            e.getOtherBody().destroy();
        }
    }
}