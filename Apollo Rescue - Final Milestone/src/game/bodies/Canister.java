package game.bodies;

import city.cs.engine.*;

/** The dynamicBody class of the Canister
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class Canister extends DynamicBody {

    private static final Shape canisterShape = new PolygonShape(-0.649f,0.95f,
            -1.179f,0.18f,
            -0.609f,-0.97f,
            0.816f,-1.015f,
            1.141f,-0.22f,
            0.726f,1.02f,
            -0.599f,0.965f);

    private static final BodyImage image =
            new BodyImage("data/Canister.png", 2.5f);
    /**
     * Canister body constructor.
     */
    public Canister(World w) {
        super(w, canisterShape);
        addImage(image);

    }
}