import java.util.ArrayList;

/**
 * This class checks controls the queue of the program 
 * 
 * 
 */
public class MyQueue<T> implements QueueInterface<T> {

	private final T[] queue; //array
	int numberOfEntries; //number of entries the user inputs
	private static final int DEFAULT_CAPACITY = 25; //default capacity
	public static final int MAX_CAPACITY = 40; //max capacity
	
	public MyQueue()
	{
		this(DEFAULT_CAPACITY);
	}
	
	
	/**
	 * 
	 * @author Allan Kangethe
	 *
	 */
	
	
	
	/**
	 * Constructor
	 * 
	 * @param desiredCapacity is the desired capacity the user would like to use in the queue
	 * @throws IllegalStateException Throws exception
	 */

	public MyQueue(int desiredCapacity)
	{
		
		if(desiredCapacity <= MAX_CAPACITY) 
		{
			// The cast is safe because the new array contains null entries.
		      @SuppressWarnings("unchecked")
		      T[] tempQueue = (T[])new Object[desiredCapacity]; // Unchecked cast
		      queue = tempQueue;
		      numberOfEntries = 0;
		}
		else 
		{
			throw new IllegalStateException("ILLEGAL STATE EXCEPTION WAS THROWN");
		}
      
	} // end constructor

	
	
	/**
	 * Checks if queue is empty
	 * 
	 * 
	 * @return return true if empty
	 */
	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
		}

	
	/**
	 * Checks if queue is full
	 * 
	 * 
	 * @return return true if full
	 */
	@Override
	public boolean isFull() {
		return numberOfEntries >= queue.length;
		}

	
	/**
	 * Dequeues the array
	 * 
	 * 
	 * @return return the data type that was dequeued
	 * @throws QueueUnderflowException throws exception when empty. Can't dequeue if empty.
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
        // TODO Auto-generated method stub

        //return queue[0]; //returns first entry
        if(isEmpty())
            throw new QueueUnderflowException();
        T result = queue[0];
        for(int i = 0; i < queue.length; i++)
        {
            if(i != queue.length - 1)
                queue[i] = queue[i+1];
        }
        numberOfEntries--;
        return result;

    } 


	/**
	 * Returns size of queue
	 * 
	 * 
	 * @return return number of elements in queue
	 * 
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
	return numberOfEntries;
		
	}

	
	/**
	 * Checks if item was queued
	 * 
	 * 
	 * @return true if queued correctly
	 * @throws QueueOverflowException throws exception when full. Can't enqueue if full.
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {

		boolean result;
		
		if(isFull())
		{
			result = false;
			throw new QueueOverflowException();
		}
		else
		{
			queue[numberOfEntries] = e;
			numberOfEntries++;
			result = true;
		}
		return result;
		

	}
	
	
	/**
	 * Returns the string equivalent of the queue with elements
	 * 
	 * 
	 * @return the string equivalent of the queue with elements
	 */
	public String toString() {
        String str = "";
        for (int i = 0; i < numberOfEntries; i++)
        {
                str += queue[i];
        }
        return str;
    }

	
	/**
	 * Returns the string equivalent of the queue with elements
	 * 
	 * @return string equivalent of the queue with elements
	 */
	@Override
	public String toString(String delimiter) {
        String string = "";
        String result = "";
        for (int i = 0; i < numberOfEntries; i++)
        {

        	string += queue[i] + delimiter;

        }

        result = string.substring(0, string.length()-1);
        
        return result;
    }
	
	
	 /**
	  * Fills the Queue with the elements of the ArrayList
	  * 
	  * 
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList<T> list) {
	       ArrayList<T> copyOfList = list;
	       for (int i = 0; i < copyOfList.size(); i++)
	       {
	           queue[i] = copyOfList.get(i);
	       }
	       numberOfEntries = copyOfList.size();

	    }
}
