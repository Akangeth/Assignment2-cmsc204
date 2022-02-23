import java.util.ArrayList;

/**
 * This class checks controls the stack of the program 
 * 
 * 
 */
public class MyStack<T> implements StackInterface<T> {

	private T[] stack;
	int numberOfEntries; //number of entries the user inputs
	private static final int DEFAULT_CAPACITY = 25; //default capacity
	public static final int MAX_CAPACITY = 40; //max capacity
	

	public MyStack() {
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

	@SuppressWarnings("unchecked")
	public MyStack(int desiredCapacity) {

		if (desiredCapacity <= MAX_CAPACITY) {
			stack = (T[]) new Object[desiredCapacity];
			numberOfEntries = 0;
		} else {
			throw new IllegalStateException("Array number of entries has passed the maximum number of entries");
		}

	}

	
	/**
	 * Checks if queue is empty
	 * 
	 * 
	 * @return return true if empty
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	/**
	 * Checks if queue is full
	 * 
	 * 
	 * @return return true if full
	 */
	public boolean isFull() {
		return numberOfEntries >= stack.length;
	}

	/**
	 * pops the array
	 * 
	 * 
	 * @return return the data type that was pop
	 * @throws StackUnderflowException throws exception when empty. Can't dequeue if empty.
	 */
	public T pop() throws StackUnderflowException {
		if (isEmpty())
		{
			throw new StackUnderflowException();

		}
		T result = stack[numberOfEntries - 1];
		stack[numberOfEntries--] = null;
		return result;
	}

	/**
	 * Number of elements in the Stack
	 * 
	 * 
	 * @return return number of elements in the Stack
	 * @throws StackUnderflowException throws exception when empty. Can't dequeue if empty.
	 */
	public T top() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();
		return stack[numberOfEntries - 1];
	}

	/**
	 * Returns size of stack
	 * 
	 * 
	 * @return return number of elements in queue
	 * 
	 */
	public int size() {
		return numberOfEntries;
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();
		stack[numberOfEntries++] = e;
		return true;
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top
	 * 
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		String string = "";
		int index = 0;
		
		while(index < numberOfEntries)
		{
			string += stack[index];
			
			index++;
		}
		return string;
		
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < numberOfEntries; i++) {

			str += stack[i] + delimiter;

		}
		return str.substring(0, str.length() - 1);
	}

	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  *
	  *
	  *
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@SuppressWarnings("unchecked")
	public void fill(ArrayList<T> list) {
		ArrayList<T> copyList = list;
		for(int i = 0; i < copyList.size(); i++)
		{
			stack[i] = copyList.get(i);
		}
		numberOfEntries = copyList.size();

	}

}