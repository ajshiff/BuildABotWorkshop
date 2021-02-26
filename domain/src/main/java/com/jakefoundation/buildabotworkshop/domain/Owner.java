package com.jakefoundation.buildabotworkshop.domain;

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
