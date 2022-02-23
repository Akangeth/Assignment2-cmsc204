 
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	//public MyQueue<String> studentStringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public double  studentTestA = 3.1, studentTestB = 3.2, studentTestC = 3.3;
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests

	@Before
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		
		doubleQ = new MyQueue<Double>(5);
		doubleQ.enqueue(studentTestA);
		doubleQ.enqueue(studentTestB);
		doubleQ.enqueue(studentTestC);
		
		//STUDENT: add setup for doubleQ for student tests
	}

	@After
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	@Test
	public void testDequeueStudent() {
		try {
			assertEquals(Double.valueOf(studentTestA), doubleQ.dequeue());
			assertEquals(Double.valueOf(studentTestB), doubleQ.dequeue());
			assertEquals(Double.valueOf(studentTestC), doubleQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			doubleQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}

	@Test
	public void testSize() {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testEnqueueStudent() {
		try {
			assertEquals(3, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(studentTestA));
			assertEquals(4, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(studentTestB));
			assertEquals(5, doubleQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			doubleQ.enqueue(studentTestC);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testIsFull() {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(true, stringQ.isFull());
	}

	@Test
	public void testToString() {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}
	
	@Test
	public void testToStringStudent() {
		assertEquals("3.13.23.3", doubleQ.toString());
		doubleQ.enqueue(3.1);
		assertEquals("3.13.23.33.1", doubleQ.toString());
		doubleQ.enqueue(2.4);
		assertEquals("3.13.23.33.12.4", doubleQ.toString());
	}

	@Test
	public void testToStringDelimiter() {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}