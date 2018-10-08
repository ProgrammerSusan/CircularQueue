/*
 * Susan Hatem
 * h0927
 * https://github.com/ProgrammerSusan/CircularQueue
 * 
 */


public class Queue {
	
	/*  the data structure   */ 
	public static int  head, tail; // indexes into n[]
	public static int size = 100;
	public static int [] n;
	
	public static void main(String[] args ) {
		n = new int [size];
		int k = 100000000;
		initialize();
		
		int [] m = new int[10];
		for(int p = 0; p < m.length; p++) {
			m[p] = (int) (Math.random() * 2);
		}
	 
		long startTime = System.currentTimeMillis();
		for(int l = k; l > 0; l--) {
			if(m[l%10] == 1) {
				insert(0);
			}
			else {
				delete();
			}
		}
		long stopTime = System.currentTimeMillis();
		long ellapsed = stopTime - startTime;
		System.out.println("Queue size: " + size);
		System.out.println("Time taken: " + ellapsed + "ms");
		
	}

	/* initialize queue pointers */
	public static void initialize() {
	  head = tail = 0;
	  }

	/* test for full */
	public static boolean isFull() {
	  return head == (tail + 1) % size;
	  }


	/* test for empty */
	public static boolean isEmpty() {
	  return head == tail++;
	  }

	/* insert x at tail */
	public static void insert(int x) {
	  if ( !isFull() ) {
		  n[(tail + 1) % size] = x;
	  }
	  else {
		  tail = (tail + 1) % size;
	  }
	}
		
	/* delete from head */
	public static void delete() {
	  if ( !isEmpty() ) {
		  n[head] = n[(head + 1) % size];
	  }
	  else {
		  tail = (tail + 1) % size;
	  }
    }
		
		
	/* print from head to tail */
	/* note, this is not a queue operation, but is handy for debugging */
	public static void printQueue() {
	  if ( !isEmpty() ) {
	   for (int i = head; i != tail-1; i ++) {
		   System.out.print(n[i] + " ");
	   }
	  }	
	}

}