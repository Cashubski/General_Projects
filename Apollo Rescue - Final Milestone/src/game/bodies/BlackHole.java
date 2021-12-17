package game.bodies;

import city.cs.engine.*;
/** The dynamicBody class of the black hole
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class BlackHole extends DynamicBody {

    private static final Shape holeShape = new PolygonShape(-0.106f,1.205f,
            -1.352f,0.284f,
            -0.385f,-1.152f,
            0.341f,-1.158f,
            1.391f,-0.007f,
            -0.022f,1.222f);

    private static final BodyImage image =
            new BodyImage("data/blackhole.png", 2.5f);
    /**
     * Black Hole constructor
     */
    public BlackHole(World w) {
        super(w, holeShape);
        addImage(image);

    }
}