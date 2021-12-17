package game.bodies;

import city.cs.engine.*;

/** The dynamicBody class of the bag
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class Bag extends DynamicBody {
    private static final Shape bagShape = new PolygonShape(-0.615f,1.18f,
            -0.74f,-0.96f,
            -0.58f,-1.11f,
            0.83f,-1.04f,
            0.84f,1.11f,
            0.44f,1.14f,
            -0.5f,1.19f);

    private static final BodyImage image =
            new BodyImage("data/Bag.png", 2.5f);
    /**
     * Bag body constructor.
     */
    public Bag(World w) {
        super(w, bagShape);
        addImage(image);

    }
}