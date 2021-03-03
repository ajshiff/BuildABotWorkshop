package com.jakefoundation.buildabotworkshop.domain.unit;

/*In domain, Create a folder called Collectable.
 *In that folder, create a class named Collectable
 * Let private fields be final.
 */
import com.jakefoundation.buildabotworkshop.domain.Position;

public class Collectable {

    private final CollectableEffect type;
    private final Position position;

    public collectable( CollectableEffect type, Position position){
        //constructor
        this.type = effect;
        this.position = thePosition;

    }

    public double getPosition() {
        //getter for position
        return position;
    }

    public double getEffect() {
        //getter for type
        return type;
    }

}