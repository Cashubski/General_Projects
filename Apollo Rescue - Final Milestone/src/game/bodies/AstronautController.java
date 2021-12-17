package game.bodies;

import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import game.Game;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** The key listener class for the Astronaut
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class AstronautController implements KeyListener {

    private static final float WALKING_SPEED = 4;

    private Astronaut astronaut;
    private Game game;
    /**
     * Astronaut controller
     * <p>
     * links astronaut with a variable
     *
     * @param  a the variable that will be used to help specify the astronaut
     * @return nothing
     */
    public AstronautController(Astronaut a){
        astronaut = a;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        //movement is not Walking speed, so the movement mimics the movement on the moon more accurately.
        if (code == KeyEvent.VK_A) {
            astronaut.startWalking(-5);
        } else if (code == KeyEvent.VK_D) {
            astronaut.startWalking(5);
        }
        //Increased dump speed mimics the gravity on the moon.
        else if (code == KeyEvent.VK_W) {
            astronaut.jump(25);
        }
        else if (code == KeyEvent.VK_I) {
            String Inventory = astronaut.Invy();
            System.out.println(Inventory);
        }
        else if (code == KeyEvent.VK_H) {
            int Health = astronaut.getHpCount();
            System.out.println(Health + "HP");
        }
        else if (code == KeyEvent.VK_Q) {
                System.exit(1);
            }
        else if (code == KeyEvent.VK_P) {
            DynamicBody projectile = new DynamicBody(astronaut.getWorld(), new CircleShape(0.2f));
            projectile.setPosition(astronaut.getPosition().add(new Vec2(0.5f, 0)));
            projectile.applyImpulse(new Vec2(20,0));
        }
//        else if (code == KeyEvent.VK_S) {
//            try {
//                GameSaverLoader.save(game.getLevel(), "data/save.txt");
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//        else if (code == KeyEvent.VK_L) {
//            try {
//               GameLevel level = GameSaverLoader.load(game, "data/save.txt");
//               game.setLevel(level);
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
        //if statement that ends the game if you have collected all the resources.
//        if (astronaut.getTapeCount() == 2 && astronaut.getCanisterCount() == 1 && astronaut.getPipeCount() ==2 && astronaut.getBagCount() == 2 && astronaut.getCardboardCount() == 1){
//            System.out.println("Congratulations! you have collected all the resources needed to repair the spacecraft");
//            System.exit(1);
//        }
        if (astronaut.getHpCount() == 0) {
            System.out.println("The aliens have killed you! Game Over.");
            System.exit(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            astronaut.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            astronaut.stopWalking();
        }
    }

    public void updateAstronaut(Astronaut astronaut){
        this.astronaut = astronaut;
    }
}
