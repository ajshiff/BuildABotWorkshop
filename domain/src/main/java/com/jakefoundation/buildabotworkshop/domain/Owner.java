package com.jakefoundation.buildabotworkshop.domain;

public class Owner {

    private final String ownerName;

    public Owner(String theName) {
        this.ownerName = theName;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
