/**
 * Ricardo Rigodon 
 * Dr. DePasquale
 * Project 2 - Driver
 * 10 April 2015
*/

import java.io.*;

/**
 * This Driver class creates and fills queues for each of the six lines, either on Church or Main Street, with vehicles.
 * The program then calles the traffic method which "directs" or "allows the cars to come in and out of the lanes". 
 * In other words it performs the simulation of the traffic through the intersection. It also creates the output 
 * file for the result of the program to be written to.
 * 
 * @author Ricardo Rigodon
 */
public class Driver
{
    /**
     * Is the main method that does all the above tasks listed in the class comment above
     * 
     * @param args The args string array
     * @throws an IOException caused by the scanner
    */
    public static void main(String []   args) throws IOException
    {
        //The object that does the simulaiton
        Processor process = new Processor();
        
        // name of output file
        String file = "output.txt";
        //the objects used to be able to create and write to the output file
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        PrintWriter writer = new PrintWriter(buffWriter);
 
        //creates the queues needed for the simulaiton
        process.createQueues();
        //simulates the traffic at the intersection
        process.traffic(writer);
    }
}