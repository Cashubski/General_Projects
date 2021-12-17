package game.gui;

import game.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
/**
 * High Score panel in which buttons and their uses reside
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class HighScore {
    private JPanel pnlScores;
    private JPanel pnlControls;
    private JLabel lblPlayerName;
    private JTextField txtName;
    private JLabel lblScoreTitle;
    private JLabel lblScore;
    private JButton btnSave;
    private JButton btnCancel;
    private JScrollPane scrollPaneScores;
    private JList<String> lstScores;

    private Game game;
    private HighScoreWriter highScoreWriter;
    private HighScoreReader highScoreReader;
    //the file that the scores will be saved to and also read from.
    private final String fileName = "highScores.txt";

    public HighScore(Game game){
        this.game = game;
        //getCount will return all the attributes scores combined.
        lblScore.setText(game.getAstronaut().getTapeCount()+"");

        File scores = new File(fileName);
        try {
            scores.createNewFile();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        highScoreWriter = new HighScoreWriter(fileName);
        highScoreReader = new HighScoreReader(fileName);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    highScoreWriter.writeHighScore(
                            txtName.getText(),
                            game.getAstronaut().getTapeCount()
                            );
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                System.exit(0) ;
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        DefaultListModel<String> model = new DefaultListModel<>();
        try{
            model.addAll(highScoreReader.readScores());
        } catch (IOException ex){
            ex.printStackTrace();
        }
        lstScores.setModel(model);

    }

    public JPanel getPnlScores(){
        return pnlScores;
    }
}
