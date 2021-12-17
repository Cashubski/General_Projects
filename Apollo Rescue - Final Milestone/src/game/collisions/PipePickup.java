package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.bodies.Astronaut;
import game.bodies.Pipe;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** The collision listener class for the pipe
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class PipePickup implements CollisionListener {

    private Astronaut astronaut;
    public PipePickup(Astronaut a){ this.astronaut = a; }
    private static SoundClip pipeSound;
    static {
        try {
            //the line below plays the sound of the plastic pipe
            pipeSound = new SoundClip("data/pipe.wav");
            System.out.println("Loading pipe sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    @Override
    //public collision event method
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Pipe) {
            astronaut.addPipe();
            pipeSound.play();
            e.getOtherBody().destroy();
        }
    }
}