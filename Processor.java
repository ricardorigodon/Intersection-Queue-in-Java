/**
 * Ricardo Rigodon 
 * Dr. DePasquale
 * Project 2 - Processor
 * 10 April 2015
*/

import java.util.*;
import jsjf.*;
import jsjf.exceptions.*;
import java.io.*;

/**
 * This Processor class generates the random lane for each vehicle that is created, keeps track of the car number, the
 * amount of time that has passed, and the array that holds the queues for the cars
 * It has a method that generates the queues for each lane, a method that creates each vehicle, and a method that runs
 * the "traffic" in the intersection
 * 
 * @author Ricardo Rigodon
 */
public class Processor
{
    //Random number in createVehicles used to assign vehicle to a lane
    Random rand = new Random(); 
    //the value of the car number
    int carNumber = 1;
    //the value for the time that has "passed"
    int time=0;
    //Used to determine how many cars need to processed at each createVehicles
    int carCount = 0; 
    //the array that holds each of the queues for the specific lanes
    LinkedQueue<Vehicle>[] intersection = (LinkedQueue<Vehicle>[]) new LinkedQueue<?>[6];

    /**
     * This method generates the queues that are needed for each lane on Church and Main and stores each one at an
     * index of an array of Vehicle types.  Each index represents one lane: 0- church left, 1- church right, 2- main
     * right, 3- main going west, 4- main going east, 5- main left 
    */
   public void createQueues()
   {
       //puts each queue into the proper spot in the array
       for (int i=0; i<6; i++)   
       {
           intersection[i] = new LinkedQueue<Vehicle>();
        }
   }
    
   /**
     * This method generates the vehicles and gives each one their own value for what street and what direction it is
     * going in, and what number vehicle it is.  It then puts the vehicle in the proper queue.  It also keeps track 
     * of the number of vehicles that have been made
     * 
     * @param min The minimum number of cars to be made at a time
     * @param max The maximum number of cars to be made at a time
    */
   public void createVehicles(int min, int max) 
   {   
        //the random number of vehicles to be generated 
        int randoNum = rand.nextInt((max-min) + 1) + min;
        //the declares the vehicle object
        Vehicle v;
        //sets the value of the street of the vehicle to null
        Vehicle.Street tempStreet = null;
        //sets the vlaue of the direction to null
        Vehicle.Direction tempDirection = null;
        //the lane that the vehicle will be placed in
        int lanes;
        
        for(int i = 0; i < randoNum; i++)
        {
            lanes = rand.nextInt(6);
            //continues until there is a total number of 120 cars made in the simulaiton
            if(carCount < 120){
                switch(lanes) // 0 put on Church West, and so on..
                {
                    case 0: tempStreet = Vehicle.Street.Church;
                        tempDirection = Vehicle.Direction.W;
                        break;
                    case 1: tempStreet = Vehicle.Street.Church;
                        tempDirection = Vehicle.Direction.E;
                        break;
                    case 2: tempStreet = Vehicle.Street.Main;
                        tempDirection = Vehicle.Direction.N;
                        break;
                    case 3:  tempStreet = Vehicle.Street.Main;
                        tempDirection = Vehicle.Direction.W;
                        break;
                    case 4: tempStreet = Vehicle.Street.Main;
                        tempDirection = Vehicle.Direction.N;
                        break;
                    case 5: tempStreet = Vehicle.Street.Main;
                        tempDirection = Vehicle.Direction.E;
                }
                //instantiates the vehicle with its number, street, direction, and arrival time
                v = new Vehicle(carNumber, tempStreet, tempDirection, time);
                //increments car number for next vehicle
                carNumber++;
                //increments number of cars so as to not go over 120
                carCount++;
                
                //adds the vehicle to the proper queue
                intersection[lanes].enqueue(v);
            }
        }
   }
   
   /**
     * This method provides the simulation of the intersection.
     * 
     * @param writer The writer that is writing the results to a file
     * @throws EmptyCollectionException The exception that is thrown when the queue is empty
    */
   public void traffic(PrintWriter writer) throws EmptyCollectionException
   {
        if(carCount == 0)
        {
            //creates a random number of cars btwn 7-12 at the begining of the simulation
            createVehicles(7, 12);
            writer.println("----Start of simulation, time set to 0----");
        }
        
        // Instantiates vehicle objects named car 1-4, used to store Vehicle objects when taken off queue
        Vehicle car = null;
        Vehicle car2 = null;
        Vehicle car3 = null;
        Vehicle car4 = null;
        //Total wait time, current time - departure time    
        int cartime = 0;
        //Adds 6 to current time, used to evaluate how many times to process lanes as traffic processes the queues executes twice
        int churchtime = time + 6;

        writer.println("---- Processing Church Street southbound traffic ----");

        while(time != churchtime)   // Church southbound lanes
        {
            //checks to see if lane 1 still has vehicles
            if(!intersection[0].isEmpty())
            {
                //removes the vehicle from the queue
                car = intersection[0].dequeue();
                //sets the departure time to the current time
                car.setDepartureTime(time);
                //is the time spent waiting at the intersection
                cartime = time - car.getArrivalTime();
                
                writer.println("[Time " + time + "]  Vehicle #" +car.getVehicleNumber() +  
                " (southbound) turned left and headed westbound.  Total wait time " + cartime + " seconds");
            }

            //checks to see if lane 1 still has vehicles
            if(!intersection[1].isEmpty())
            {
                //removes the vehicle from the intersection
                car2 = intersection[1].dequeue();
                //sets the departure time to the current time
                car2.setDepartureTime(time);
                //is the time spent waiting at the intersection
                cartime = time - car2.getArrivalTime();
                
                writer.println("[Time " + time + "]  Vehicle #" +car2.getVehicleNumber() +  
                " (southbound) turned right and headed eastbound.  Total wait time " + cartime + " seconds");
            } 
            
            time = time + 3;
        }
        
        //checks to make sure that the amount of cars is not >= 120
        if(carCount < 120)
        {
            createVehicles(8, 15);
        }


        // Adds 9 to current time, used to process how many times to go through following while loop only executes 3 times
        int maintime = time + 9;

        writer.println("---- Processing Main Street traffic ----");

        while(time != maintime)   // Main Street lanes
        {
            //checks to see if lane 2 still has vehicles
            if(!intersection[2].isEmpty())
            {
                //removes the vehicle from the intersection
                car = intersection[2].dequeue();
                //sets the departure time to the current time
                car.setDepartureTime(time);
                //is the time spent waiting at the intersection
                cartime = time - car.getArrivalTime();

                writer.println("[Time " + time + "]  Vehicle #" +car.getVehicleNumber() +  
                " (westbound) turned right and headed northbound.  Total wait time " + cartime + " seconds");
            }

            //checks to see if lane 3 still has vehicles
            if(!intersection[3].isEmpty())
            {
                //removes the vehicle from the intersection
                car2 = intersection[3].dequeue();
                //sets the departure time to the current time
                car2.setDepartureTime(time);
                //is the time spent waiting at the intersection
                cartime = time - car2.getArrivalTime();

                writer.println("[Time " + time + "]  Vehicle #" +car2.getVehicleNumber() + 
                " (westbound) continued straight and continued westbound.  Total wait time " + cartime + " seconds");
            } 

            //checks to see if lane 4 still has vehicles
            if(!intersection[4].isEmpty())
            {
                //removes the vehicle from the intersection
                car3 = intersection[4].dequeue();
                //sets the departure time to the current time
                car3.setDepartureTime(time);
                //is the time spent waiting at the intersection
                cartime = time - car3.getArrivalTime();

                writer.println("[Time " + time + "]  Vehicle #" +car3.getVehicleNumber() +  
                " (eastbound) turned left and headed northbound.  Total wait time " + cartime + " seconds");
            }
            
            //checks to see if lane 5 still has vehicles
            if(!intersection[5].isEmpty())    
            {
                //removes the vehicle from the intersection
                car4 = intersection[5].dequeue();
                //sets the departure time to the current time
                car4.setDepartureTime(time);
                //is the time spent waiting at the intersection
                cartime = time - car4.getArrivalTime();

                writer.println("[Time " + time + "]  Vehicle #" +car4.getVehicleNumber() +  
                " (eastbound) continued straight and continued eastbound.  Total wait time " + cartime + " seconds");
            } 

            time = time +3; // adds 3 to time after if statements
        } 
        
        //checks to make sure that the amount of cars is not > 120
        if(carCount < 120)
        {
            createVehicles(3,15);
        }
        
        //checks to make sure that there are lanes still with vehicles in them
        if(!intersection[0].isEmpty() || !intersection[1].isEmpty() || !intersection[2].isEmpty() || !intersection[3].isEmpty() || !intersection[4].isEmpty() || !intersection[5].isEmpty() )
        {
            traffic(writer); //traffic invokes itself to go through process for any cars not processed
        }
        else 
        {
            writer.println("Simulation ended. No more vehicles to process.");
            writer.close(); // closes the writer
        }
   }
}