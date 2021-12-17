package game.levels;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import game.*;
import game.bodies.*;
import game.collisions.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
/** Class for the third level
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public class Level3 extends GameLevel {

    public Level3(Game game){

        super(game);
        // make the ground

        Shape shape = new BoxShape(27, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.setFillColor(Color.red);
        // make a platform
        Shape platform1Shape = new BoxShape(6, 0.2f);

        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-12, -3.5f));
        platform1.setFillColor(Color.red);

        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(5, 2.5f));
        platform2.setFillColor(Color.red);

        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(9, 10.5f));
        platform3.setFillColor(Color.red);

        StaticBody platform4 = new StaticBody(this, platform1Shape);
        platform4.setPosition(new Vec2(-9, 17.5f));
        platform4.setFillColor(Color.red);

        StaticBody platform5 = new StaticBody(this, platform1Shape);
        platform5.setPosition(new Vec2(-3, 27.5f));
        platform5.setFillColor(Color.red);

        StaticBody platform6 = new StaticBody(this, platform1Shape);
        platform6.setPosition(new Vec2(2, 34.0f));
        platform6.setFillColor(Color.red);

        StaticBody platform7 = new StaticBody(this, platform1Shape);
        platform7.setPosition(new Vec2(9, 42.5f));
        platform7.setFillColor(Color.red);

        StaticBody platform8 = new StaticBody(this, platform1Shape);
        platform8.setPosition(new Vec2(15, 52.5f));
        platform8.setFillColor(Color.red);

        StaticBody platform9 = new StaticBody(this, platform1Shape);
        platform9.setPosition(new Vec2(7, 61.5f));
        platform9.setFillColor(Color.red);

        StaticBody platform10 = new StaticBody(this, platform1Shape);
        platform10.setPosition(new Vec2(2, 70.5f));
        platform10.setFillColor(Color.red);

        // add another platform here
        Shape wallShape = new BoxShape(0.5f, 200f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-26.5f, -6));
        wall1.setFillColor(Color.red);

        // add another platform here
        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(26.5f, -6));
        wall2.setFillColor(Color.red);


        getAstronaut().setPosition(new Vec2(-8, -10));
        getAstronaut().setGravityScale(3);

        TapePickup pickup = new TapePickup(getAstronaut());
        getAstronaut().addCollisionListener(pickup);

        CanisterPickup pickup1 = new CanisterPickup(getAstronaut());
        getAstronaut().addCollisionListener(pickup1);

        BagPickup pickup2 = new BagPickup(getAstronaut());
        getAstronaut().addCollisionListener(pickup2);

        CardboardPickup pickup3 = new CardboardPickup(getAstronaut());
        getAstronaut().addCollisionListener(pickup3);

        PipePickup pickup4 = new PipePickup(getAstronaut());
        getAstronaut().addCollisionListener(pickup4);

        IceCreamPickup pickup5 = new IceCreamPickup(getAstronaut());
        getAstronaut().addCollisionListener(pickup5);

        AlienTouch touch = new AlienTouch(getAstronaut());
        getAstronaut().addCollisionListener(touch);
        // Alien

        getAlien().setPosition(new Vec2(-2,-10));

        Tape tape = new Tape(this);
        tape.setPosition(new Vec2(-25,-10));

        Bag bag = new Bag(this);
        bag.setPosition(new Vec2(6,2.5f));

        Pipe pipe = new Pipe(this);
        pipe.setPosition(new Vec2(11,11.5f));

        Alien alien2 = new Alien(this);
        alien2.setPosition(new Vec2(9.5f,11.5f));

        Cardboard cardboard = new Cardboard(this);
        cardboard.setPosition(new Vec2(-12,17.5f));

        Tape tape2 = new Tape(this);
        tape2.setPosition(new Vec2(-5,28f));

        Canister canister = new Canister(this);
        canister.setPosition(new Vec2(2,34f));

        Pipe pipe2 = new Pipe(this);
        pipe2.setPosition(new Vec2(5,43));

        Alien alien3 = new Alien(this);
        alien3.setPosition(new Vec2(19,53f));

        IceCream iceCream = new IceCream(this);
        iceCream.setPosition(new Vec2(7,62f));

        Bag bag2 = new Bag(this);
        bag2.setPosition(new Vec2(0,71f));

        BlackHole blackHole = new BlackHole(this);
        blackHole.setPosition(new Vec2(-2,71f));
    }


    @Override
    public boolean isComplete() {
        if (getAstronaut().getCanisterCount() >= 1)
            return true;
        else
            return false;
    }
    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/galaxy3.gif").getImage();
        return background;
    }
    @Override
    public String getLevelName() {
        return "Level3";
    }
}
