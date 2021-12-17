package game;

import city.cs.engine.SoundClip;
import game.bodies.Astronaut;
import game.bodies.AstronautController;
import game.gui.ControlPanel;
import game.gui.GameView;
import game.gui.HighScore;
import game.gui.MouseHandler;
import game.levels.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
/** The main game class
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 * A game based in space, where you are a member of the Apollo 13 crew and you need to repair the spacecraft
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private static GameLevel level;
    private Astronaut astronaut;
    /** A graphical display of the world (a specialised JPanel). */
    private static GameView view;
    public SoundClip gameMusic;
    private static AstronautController controller;
    private final JFrame frame;
    /**
     * Initializes a new game
     * <p>
     * Holds the code for initializing the game
     *
     * @return The game
     */
    public Game() {

        // make the world
        level = new Level1(this);
        astronaut = level.getAstronaut();

        if (level instanceof Level1) {
            try {
                gameMusic = new SoundClip("data/level1.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
        // make a view
        System.out.println("new "+  level.getAstronaut().getHpCount());
        view = new GameView(level, 512, 512);
        view.setZoom(17);
        view.setBack(level.paintBackground());

        controller = new AstronautController(level.getAstronaut());
        view.addKeyListener(controller);
        level.getAstronaut().getHpCount();


        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new MouseHandler((Level1) level, view, level.getAstronaut()));



        view.addMouseListener(new GiveFocus(view));

        //level.addStepListener(new Tracker(view, level.getAstronaut()));

        Tracker tracker = new Tracker(view, level.getAstronaut());
        level.addStepListener(tracker);
        // add the view to a frame (Java top level window)
        frame = new JFrame("Apollo Rescue");
        frame.add(view);
        ImageIcon img = new ImageIcon("data/Apollo1.png");
        frame.setIconImage(img.getImage());
        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(),BorderLayout.EAST);
        JLabel versionLabel = new JLabel();
        versionLabel.setText("Version 3.0");
        frame.add(versionLabel, BorderLayout.SOUTH);
        versionLabel.setBackground(Color.black);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);
        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 512, 512);
        // start our game world simulation!
        level.start();
    }
    /**
     * Sets the level to the game
     * <p>
     * Creates the setting for the loaded level
     *
     * @param  level Level that loading the game will set to
     * @return starts the loaded level
     */
    public static void setLevel(GameLevel level){
        //level now refers to new level
        //stop the current level
        level.stop();
        level = level;
        //change the view to look into new level
        Tracker tracker = new Tracker(view, level.getAstronaut());
        level.addStepListener(tracker);
        view.setWorld(level);
        view.update(level.getAstronaut());
        //start the simulation in the new level
        controller.updateAstronaut(level.getAstronaut());
        level.start();
    }

    public Astronaut getAstronaut() {
        return level.getAstronaut();
    }

    /**
     * Initializes next level progression
     * <p>
     * Sets the parameters which indicate when the player goes to the next level
     *
     * @return Starts levels
     */
    public void goToNextLevel(){

        if (level instanceof Level1){
            //stop the current level and music
            gameMusic.stop();
            Astronaut old = level.getAstronaut();
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            view.setBack(level.paintBackground());
            try {
                gameMusic = new SoundClip("data/level2.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            Tracker tracker = new Tracker(view, level.getAstronaut());
            level.addStepListener(tracker);
            //change the view to look into new level
            view.setWorld(level);
            level.updateAstronaut(old);
            view.update(level.getAstronaut());
            //change the controller to control the
            //Astronaut in the new world
            controller.updateAstronaut(level.getAstronaut());
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level2){
            //stop the current level
            gameMusic.stop();
            Astronaut old = level.getAstronaut();
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            view.setBack(level.paintBackground());
            try {
                gameMusic = new SoundClip("data/level3.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            Tracker tracker = new Tracker(view, level.getAstronaut());
            level.addStepListener(tracker);
            //change the view to look into new level
            view.setWorld(level);
            level.updateAstronaut(old);
            view.update(level.getAstronaut());
            //change the controller to control the
            //Astronaut in the new world
            controller.updateAstronaut(level.getAstronaut());
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level3){
            //stop the current level
            gameMusic.stop();
            Astronaut old = level.getAstronaut();
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level4(this);
            view.setBack(level.paintBackground());
            try {
                gameMusic = new SoundClip("data/level4.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
            Tracker tracker = new Tracker(view, level.getAstronaut());
            level.addStepListener(tracker);
            //change the view to look into new level
            view.setWorld(level);
            level.updateAstronaut(old);
            view.update(level.getAstronaut());
            //change the controller to control the
            //Astronaut in the new world
            controller.updateAstronaut(level.getAstronaut());
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level4){
            System.out.println("Well done! Game complete.");
            JDialog diaScore = new JDialog(frame, true);
            HighScore highScore = new HighScore(this);
            diaScore.getContentPane().add(highScore.getPnlScores());
            diaScore.pack();
            diaScore.setVisible(true);

        }

    }
    /**
     * Pauses the game
     * <p>
     * Accesses the level to be able to stop it.
     *
     * @return nothing
     */
    public void pause() {
        level.stop();
    }
    /**
     * resumes the game
     * <p>
     * Accesses the level to be able to resume it.
     *
     * @return nothing
     */
    public void resume() {
        level.start();
    }

    /** Run the game.
     * initiates a new game
     * <p>
     *Creates a new game and displays instructions in the command line
     *
     * @param  args
     * @return Text & Instructions
     */
    public static void main(String[] args) throws InterruptedException {

        new Game();
        //Print out text to add context to the game and let the user know what keys to press.
        System.out.println("Houston, we've had a problem");
        //delayed prints to mimic a real conversation.
        Thread.sleep(2000);
        System.out.println("You are a crew member of the Apollo 13 and you find out that the explosion you just heard was the oxygen tank and the spacecraft is damaged.");
        Thread.sleep(4700);
        System.out.println("You must find the necessary items to attach a CO2 scrubber to cleanse the air supply in the ship. Your lives are in danger.");
        Thread.sleep(4500);
        System.out.println("You will need: 8 Pieces of duct tape, 4 LiOH canisters, 8 pvc suction pipes, 8 plastic bags and 4 pieces of cardboard and you must collect them over 4 different levels.");
        Thread.sleep(3000);
        System.out.println("Aliens are on the loose, avoid them at all cost. If you need to heal, press mouse button 1 or 2 in order to eat Ice cream");
        Thread.sleep(3000);
        System.out.println("Now get to work, time is of the essence!");
        System.out.println("Press A to move left, W to jump, D to move right, I to check your inventory, H to check your HP and Q to quit.");
    }
    /**
     * Pauses the music
     * <p>
     * Accesses the gameMusic parameter and give the option to pause the music
     *
     * @return nothing
     */
    public void pauseMusic() {
        gameMusic.pause();
    }
    /**
     * Retrieves the game level
     * <p>
     * Gathers the current level to the GameLevel class.
     *
     * @return Returns the level
     */
    public static GameLevel getLevel(){
        return level;
    }
}

