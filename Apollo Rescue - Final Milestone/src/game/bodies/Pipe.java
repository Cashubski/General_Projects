package game.bodies;

import city.cs.engine.*;
/** The dynamicBody class of the pipe
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class Pipe extends DynamicBody {

    private static final Shape pipeShape = new PolygonShape(-1.539f,1.227f,
            -1.562f,-1.228f,
            1.509f,-1.243f,
            1.524f,1.227f,
            -1.464f,1.242f);

    private static final BodyImage image =
            new BodyImage("data/Pipe.png", 2.5f);
    /**
     * Pipe body constructor.
     */
    public Pipe(World w) {
        super(w, pipeShape);
        addImage(image);

    }
}