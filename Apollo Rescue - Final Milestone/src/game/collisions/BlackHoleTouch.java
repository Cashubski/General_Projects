package game.collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.bodies.BlackHole;
import game.Game;
import game.levels.GameLevel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/** The collision listener class for the black hole
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class BlackHoleTouch implements CollisionListener {

    private GameLevel level;
    private Game game;

    public BlackHoleTouch(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    private static SoundClip blackholeSound;
    static {
        try {
            //the line below plays the sound of the blackhole
            blackholeSound = new SoundClip("data/blackhole.wav");
            System.out.println("Loading blackhole sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    @Override
    public void collide(CollisionEvent e) {
        //if student collided with professor and the
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof BlackHole
                && level.isComplete()){
            game.goToNextLevel();
            blackholeSound.play();
        }
    }
}