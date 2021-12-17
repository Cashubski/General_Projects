package game.bodies;

import city.cs.engine.*;
/** The dynamicBody class of the tape
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class Tape extends DynamicBody {

    private static final Shape tapeShape = new PolygonShape(-1.075f,-0.36f,
            0.705f,-1.285f,
            1.21f,-1.02f,
            0.19f,1.225f,
            -0.925f,1.13f,
            -1.13f,0.09f);

    private static final BodyImage image =
            new BodyImage("data/ducttape.png", 2.5f);
    /**
     * Tape body constructor.
     */
    public Tape(World w) {
        super(w,tapeShape);
        addImage(image);

    }
}
