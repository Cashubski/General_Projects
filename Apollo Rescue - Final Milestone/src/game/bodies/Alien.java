package game.bodies;

import city.cs.engine.*;
/** The walker class of the Alien
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class Alien extends Walker {

    private static final Shape alienShape = new PolygonShape(
            -0.67f,3.4f,
            -2.41f,-1.75f,
            -1.81f,-4.09f,
            1.63f,-4.3f,
            2.77f,-1.32f,
            0.6f,3.44f);

    private static final BodyImage image =
            new BodyImage("data/alien.png", 10f);

    /**
     * Alien body constructor.
     */
    public Alien(World world) {
        super(world, alienShape);
        addImage(image);
    }
}
