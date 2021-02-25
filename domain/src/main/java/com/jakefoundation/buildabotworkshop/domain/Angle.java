/**
 * Create a class in Domain called Angle.
 *
 * Give it a single constructor that requires a double representing the angle to be provided. Make sure that this number is always a positive number between 0 and 360. If it is not, coerce it into a value between 0 and 360. Create unit tests to confirm this functionality for a variety of numbers.
 *
 * Let its value field be private final. (Final makes it not writable outside of the constructor)
 *
 * Provide a getter for that value.
 *
 * See UML for details
 */
public class Angle;
//class
{
    private final doble angle;//not sure if that is at the right place, intended to make it not writable

public Angle(double angleValue) {
        //constructor
        this.angle = angleValue % 360;
        if (this.angle > 0)
        {
        this.angle -= 360;
        }

        }

public int getAngleValue() {
        //getter for the angle
        return this.angle;
        }
        }