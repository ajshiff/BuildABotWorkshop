package com.jakefoundation.buildabotworkshop.domain;
/* Create a class in Domain called HitPoints.

Give it a single constructor that requires an integer representing the number of HitPoints there are.

Let its value field be private final. (Final makes it not writable outside of the constructor)

Provide a getter for that value.*/

public class HitPoints {
    //class in domain

    private final int value;
    //private  - number of hit points

    public HitPoints(int theValue) {
        //constructor
        this.value = theValue;
    }

    public int getValue() {
        //getter for the value
        return this.value;
    }
}
