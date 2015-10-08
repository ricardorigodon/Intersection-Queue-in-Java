/**
 * Ricardo Rigodon 
 * Dr. DePasquale
 * Project 2 - Vehicle
 * 10 April 2015
*/

/**
 * This Vehicle class creates the vehicle objects that are going to be used for the simulation.  It gives the objects
 * instance variables for the vehicle number, its arrival time, its departure time, the street it is on, and the 
 * direction it is going in.
 * 
 * @author Ricardo Rigodon
 */
public class Vehicle
{
    //the vehicle's number
    private int vehicleNumber;
    //the vehicle's arrival time
    private int arrivalTime;
    //the vehicle's departure time
    private int departureTime;
    //the vehicle's street
    private Street street;
    //the vehicle's direction
    private Direction direction;
    
    /** This Street class is for the enum values for the possible streets that a vehicle could have**/
    public enum Street{
        Church, Main
    }
    /** This Direction class is for the enum values for the possible direction that a vehicle could be going in**/
    public enum Direction{
        E, W, N
    }

    /**
     * Is the constructor for the Vehicle class that sets up all of the instance variables.
     * 
     * @param vehicleNumber The number of the Vehicle
     * @param street The street that the vehicle is on
     * @param direction The direction that the vehicle is going in
     * @param arrivalTime The arrival time of the vehicle
    */
    public Vehicle(int vehicleNumber, Street street, Direction direction, int arrivalTime)
    {
        this.vehicleNumber = vehicleNumber;
        this.street = street;
        this.direction = direction;
        this.arrivalTime = arrivalTime;
    }

    /**
     * This method returns the value of the vehicle number
     * 
     * @return Returns the vehicle number
    */
    public int getVehicleNumber()
    {
        return vehicleNumber;
    }

    /**
     * This method returns the value of the street that the vehicle is on
     * 
     * @return Returns the street
    */
    public Street getStreet()
    {
        return street;
    }

    /**
     * This method returns the value of the vehicle's direction
     * 
     * @return Returns the vehicle's direction
    */
    public Direction getDirection()
    {
        return direction;
    }

    /**
     * This method returns the value of the vehicle's arrival time
     * 
     * @return Returns the vehicle's arrival time
    */
    public int getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * This method sets the value at which the vehicle leaves the intersection 
     * 
     * @param time The current time in the simulation (aka the departure time)
    */
    public void setDepartureTime(int time)
    {
        departureTime = time;
    }

    /**
     * This method returns the value of the vehicle's departure time
     * 
     * @return Returns the vehicle's departure time
    */
    public int getDepartureTime()
    {
        return departureTime;
    }

    /**
     * This method returns the string of all of the values that a Vehicle has
     * 
     * @return Returns the string of all of the values a Vehicle has
    */
    public String toString()
    {
        //the string for all the values that a vehicle has
        String result = "# : " + vehicleNumber + " " + street + " " + direction + " " + arrivalTime;
        return result;
    }
}