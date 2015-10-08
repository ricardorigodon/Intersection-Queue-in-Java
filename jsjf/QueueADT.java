/**
 * Ricardo Rigodon 
 * Dr. DePasquale
 * Project 2 - LinkedQueue
 * 10 April 2015
*/
package jsjf;

/**
 * Interface for Queues implemented in LinkedQueue.java with methods of enqueue(), dequeue(), first(), toString(), isEmpty()
 * and size().
 * 
 * @author Java Foundations
 * @author Ricardo Rigodon
 */

public interface QueueADT<T>
{
	/**
     * This method is to be defined in the LinkedQueue class, but it will allow for elements to be added.
     * 
     * @param element The element to be added.
    */
	public void enqueue(T element);

	/**
     * This method is to be defined in the LinkedQueue class, but it will allow for elements to be removed.
     * 
     * @return The element at the top of the queue which is removed
    */
	public T dequeue();

	/**
     * This method is to be defined in the LinkedQueue class, but it will allow for the first element to be looked at
     * 
     * @return The element at the top of the queue.
    */
	public T first();

	/**
     * This method is to be defined in the LinkedQueue class, but it will check to see if the queue is empty.
     * 
     * @return Whether the queue is empty or not (T/F).
    */
	public boolean isEmpty();

	/**
     * This method is to be defined in the LinkedQueue class, but it will return the # of elements in the array.
     * 
     * @return The number of elements in the array.
    */
	public int size();

	/**
     * This method is to be defined in the LinkedQueue class, but it will allow for the queue to be printed.
     * 
     * @return The string of all the values in the queue.
    */
	public String toString();
}