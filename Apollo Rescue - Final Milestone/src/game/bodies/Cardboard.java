package game.bodies;

import city.cs.engine.*;
/** The dynamicBody class of the cardboard
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class Cardboard extends DynamicBody {

    private static final Shape cardboardShape = new PolygonShape(-1.653f,1.062f,
            -1.6f,-1.047f,
            1.305f,-1.082f,
            1.278f,1.08f,
            -1.591f,1.098f);

    private static final BodyImage image =
            new BodyImage("data/Cardboard.png", 2.5f);
    /**
     * Cardboard body constructor.
     */
    public Cardboard(World w) {
        super(w, cardboardShape);
        addImage(image);

    }
}