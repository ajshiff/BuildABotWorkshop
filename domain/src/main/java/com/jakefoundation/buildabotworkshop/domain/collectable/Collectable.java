package com.jakefoundation.buildabotworkshop.domain.collectable;

import com.jakefoundation.buildabotworkshop.domain.Position;

public class Collectable {

    private final CollectableEffect effect;
    private final Position position;

    public Collectable( CollectableEffect effect, Position position){
        this.effect = effect;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public CollectableEffect getEffect() {
        return effect;
    }

}