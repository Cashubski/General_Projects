package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.bodies.Astronaut;
import game.bodies.Canister;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** The collision listener class for the canister
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class CanisterPickup implements CollisionListener {

    private Astronaut astronaut;
    public CanisterPickup(Astronaut a){
        this.astronaut = a;
    }
    private static SoundClip canisterSound;
    static {
        try {
            //the line below plays the sound of the canister
            canisterSound = new SoundClip("data/canister.wav");
            System.out.println("Loading canister sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    @Override
    //public collision event method
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Canister) {
            astronaut.addCanister();
            canisterSound.play();
            e.getOtherBody().destroy();
        }
    }
}