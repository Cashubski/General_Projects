package game.gui;

import city.cs.engine.SoundClip;
import game.Game;
import game.GameSaverLoader;
import game.levels.GameLevel;

import javax.swing.*;
import java.io.IOException;
/**
 * Control panel in which buttons and their uses reside
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class ControlPanel {
    private Game game;
    private SoundClip music;
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton musicStopButton;
    private JButton quitButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton save2Button;
    private JButton load2Button;

    /**
     * The control panel for buttons
     * <p>
     * Creates the setting for the buttons and their functions.
     *
     * @param  game Accesses the game parameters
     * @return Buttons
     */
    public ControlPanel(Game game) {
        this.game = game;
        this.music = music;
        //Button that allows the user to quit the game
        quitButton.addActionListener(e -> System.exit(0));
        //Button to pause the game
        pauseButton.addActionListener(e -> game.pause());
        //Button to resume the game from being paused.
        resumeButton.addActionListener(e -> game.resume());
        //Couldn't figure out how to restart the game with a button.
//        restartButton.addActionListener(e -> game.restart());
        //Tried to add a music button but didn't get it to work properly
        musicStopButton.addActionListener(e -> game.pauseMusic());
        saveButton.addActionListener(e -> {
            try {
                GameSaverLoader.save(game.getLevel(), "data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        loadButton.addActionListener(e -> {
            try {
                GameLevel level = GameSaverLoader.load(game, "data/save.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        save2Button.addActionListener(e -> {
            try {
                GameSaverLoader.save(game.getLevel(), "data/save2.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        load2Button.addActionListener(e -> {
            try {
                GameLevel level = GameSaverLoader.load(game, "data/save2.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
    /** Getter for the main panel
     *
     * <p>
     * Retrieves the main panel to enable control panel connection
     * @return The main panel
     */
    public JPanel getMainPanel(){
        return mainPanel;
    }
}
