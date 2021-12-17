package game;

import game.levels.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/** Class for saving and loading instructions
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class GameSaverLoader {
    /**
     * Saves a game to a file
     * <p>
     * Saves the current state of the game
     *
     * @param  level level that you are in
     * @param  fileName File to which the game is saved
     * @return Nothing
     */
    public static void save(GameLevel level, String fileName)
        throws IOException
    {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + "," + level.getAstronaut().getPipeCount() + "," +
                    level.getAstronaut().getBagCount() + "," + level.getAstronaut().getTapeCount() + "," +
                    level.getAstronaut().getCanisterCount() + "," + level.getAstronaut().getCardboardCount() + "," +
                    level.getAstronaut().getHpCount() +"\n"
                   + level.getLevelName() + "\n" + "Pipes : " +level.getAstronaut().getPipeCount() + "\n"
            + "Bags : " +level.getAstronaut().getBagCount() + "\n"
                    + "Tape : " +level.getAstronaut().getTapeCount() + "\n"
                    + "Canisters : " +level.getAstronaut().getCanisterCount() +"\n"
                    + "Cardboard : " +level.getAstronaut().getCardboardCount() + "\n"
                    + "HP : " +level.getAstronaut().getHpCount());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    /**
     * Loads a game from a file
     * <p>
     * Loads a previous save of the game
     *
     * @param  game Game that you are in
     * @param  fileName File from which the game is loaded
     * @return The previously saved game
     */
    public static GameLevel load(Game game, String fileName)
    throws IOException
    {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            int pipeCount = Integer.parseInt(tokens[1]);
            int bagCount = Integer.parseInt(tokens[2]);
            int tapeCount = Integer.parseInt(tokens[3]);
            int canisterCount = Integer.parseInt(tokens[4]);
            int cardboardCount = Integer.parseInt(tokens[5]);
            int hpCount = Integer.parseInt(tokens[6]);

            GameLevel level = null;
            if (name.equals("Level1"))
                level = new Level1(game);
            else if (name.equals("Level2"))
                level = new Level2(game);
            else if (name.equals("Level3"))
                level = new Level3(game);
            else if (name.equals("Level4"))
                level = new Level4(game);

            level.getAstronaut().setPipeCount(pipeCount);
            level.getAstronaut().setBagCount(bagCount);
            level.getAstronaut().setTapeCount(tapeCount);
            level.getAstronaut().setCanisterCount(canisterCount);
            level.getAstronaut().setCardboardCount(cardboardCount);
            level.getAstronaut().setHPCount(hpCount);

            return level;
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
