package com.jakefoundation.buildabotworkshop.domain;
/* Create a class named Owner in Domain and implement it according to this UML.
 * Let private fields be final.
 * */

public class Owner {

    private final String ownerName;
    private final int ownerId;

public Owner(String theName , int theId) {
    this.ownerName = theName;
    this.ownerId = theId;
}

    public String getOwnerName() {
        return ownerName;
    }

    public int getOwnerId() {
        return ownerId;
    }
}
