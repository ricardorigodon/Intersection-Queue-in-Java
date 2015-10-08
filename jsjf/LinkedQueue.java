/**
 * Ricardo Rigodon 
 * Dr. DePasquale
 * Project 2 - LinkedQueue
 * 10 April 2015
*/
package jsjf;
import jsjf.exceptions.*;

/**
 * This LinkedQueue class has all of the methods that are in the QueueADT interface that need to be filled in.  Has
 * methods for adding (enqueue) to the queue, removing (dequeue) from the queue, checking the size of the queue, 
 * checking if the queue is empty, looking at the first element in the queue, and a toString for the queue.
 * 
 * @author Ricardo Rigodon
 */
public class LinkedQueue<T> implements QueueADT<T>
{
    //counter for the number of nodes/elements in the queue
    private int count;
    //the head and tail of the queue
    private LinearNode<T> head, tail;
    
    /**
     * This is the constructor for the queue. It sets up the values for the counter, head, and tail of the queue 
    */
    public LinkedQueue()
    {
        count = 0;
        head = tail = null;
    }

    /**
     * This method allows an element that is sent in to be added to the queue.
     * 
     * @param element The element to be added
    */
    public void enqueue(T element)
    {
        LinearNode<T> node = new LinearNode<T>(element);

        if(isEmpty()){
            head = node;
        }
        else 
        {
            tail.setNext(node);
        }
        tail = node;
        count++;
    }

    /**
     * This method allows the element at the top of the queue to de removed.
     * 
     * @return The element that is removed
     * @throws EmptyCollectionException The exception when the queue is empty.
    */
    public T dequeue() throws EmptyCollectionException
    {
        if (isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        T result = head.getElement();
        head = head.getNext();
        count--;

        if(isEmpty()){
            tail = null;
        }
        return result;
    }

    /**
     * This method returns the size of the queue (aka the # of elements in the queue). 
    */
    public int size()
    {
        return count;
    }

    /**
     * This method checks to see if the queue does not have any elements in it.
     * 
     * @return Whether or not the queue is empty (T/F).
    */
    public boolean isEmpty()
    {
        return count == 0;
    }

    /**
     * This method returns the element at the top of the queue if there is an element there.
     * 
     * @return The first element in the queue.
    */
    public T first()
    {
        if (isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        return head.getElement();
    }

    /**
     * This method allows the queue to be printed out as a string.
     * 
     * @return The string that represents all the values held in the array.
    */
    public String toString()
    {
        String result = "";
        LinearNode<T> current = head;

        while(current != null)
        {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }
        return result;  
    }
}