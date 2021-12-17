package game.levels;

import city.cs.engine.World;
import game.bodies.Alien;
import game.bodies.Astronaut;
import game.collisions.BlackHoleTouch;
import game.Game;

import java.awt.*;
/** Class for holding game bodies
 *
 * @author      Michal, Kaszubski, michal.kaszubski@city.ac.uk
 * @version     3.0
 * @since       March 2021
 */
public abstract class GameLevel extends World {
    private Astronaut astronaut;
    private Alien alien;

    public GameLevel(Game game){

        //Every level has a Astronaut, Alien and a black hole.
        //Upon collision with the black hole, it transfers the user to the next level.
        //Entry to the next level is only permitted if certain requirements are met.
        astronaut = new Astronaut(this);
        alien = new Alien(this);
        BlackHoleTouch touch = new BlackHoleTouch(this, game);
        astronaut.addCollisionListener(touch);


    }
    public Astronaut getAstronaut(){
        return astronaut;
    }
    public Alien getAlien(){
        return alien;
    }
    public abstract boolean isComplete();
    public abstract Image paintBackground();

    public void updateAstronaut(Astronaut a) {
        for ( int i=0; i<a.getPipeCount(); ++i){
            astronaut.addPipe();
        }
        for ( int i=0; i<a.getBagCount(); ++i){
            astronaut.addBag();
        }
        for ( int i=0; i<a.getTapeCount(); ++i){
            astronaut.addTape();
        }
        for ( int i=0; i<a.getCanisterCount(); ++i){
            astronaut.addCanister();
        }
        for ( int i=0; i<a.getCardboardCount(); ++i){
            astronaut.addCardboard();
        }
    }
    public abstract String getLevelName();
}