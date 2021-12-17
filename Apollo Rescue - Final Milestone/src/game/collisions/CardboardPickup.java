package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.bodies.Astronaut;
import game.bodies.Cardboard;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** The collision listener class for the cardboard
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class CardboardPickup implements CollisionListener {

    private Astronaut astronaut;
    public CardboardPickup(Astronaut a){
        this.astronaut = a;
    }
    private static SoundClip cardboardSound;
    static {
        try {
            cardboardSound = new SoundClip("data/cardboard.wav");
            System.out.println("Loading cardboard sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    @Override
    //public collision event method
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Cardboard) {
            astronaut.addCardboard();
            cardboardSound.play();
            e.getOtherBody().destroy();
        }
    }
}