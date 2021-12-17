package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.bodies.Alien;
import game.bodies.Astronaut;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** The collision listener class for the alien
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class AlienTouch implements CollisionListener {

    private Astronaut astronaut;
    public AlienTouch(Astronaut a){
        this.astronaut = a;
    }
    private static SoundClip alienSound;
    static {
        try {
            //the line below plays the sound of the alien encounter
            alienSound = new SoundClip("data/alien.wav");
            System.out.println("Loading alien sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Alien) {
            astronaut.decHealth();
            alienSound.play();
        }
    }
}