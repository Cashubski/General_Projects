package game.bodies;

import city.cs.engine.*;
/** The dynamicBody class of the ice cream
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class IceCream extends DynamicBody {

    private static final Shape iceCreamShape = new PolygonShape(-0.144f,1.209f,
            -1.677f,0.349f,
            -1.671f,-0.29f,
            0.193f,-1.28f,
            1.671f,-0.283f,
            1.664f,0.336f,
            -0.034f,1.223f);

    private static final BodyImage image =
            new BodyImage("data/IceCream.png", 2.5f);
    /**
     * Ice Cream body constructor.
     */
    public IceCream(World w) {
        super(w, iceCreamShape);
        addImage(image);

    }
}