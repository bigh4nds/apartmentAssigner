/** WaitingStudentQueue class
 *  > Queue interface for implementing LinkedList
 *  @author Finn
 */

class WaitingStudentQueue
{
	private LinkedList list;

	public WaitingStudentQueue()                
    { 
		list = new LinkedList();
	}

	/** 
	 *  > Returns if LinkedList is empty
	 */
	public boolean isEmpty()         
    { 
		return list.isEmpty(); 
	}

	/** 
	 *  > Adds Student s to end of LinkedList
	 */
	public void enque(Student s)
    {
		list.insertLast(s); 
	}

	/** 
	 *  > Removes, casts as Student, & returns the first Link object
	 */
	public Student deque()
    {  
		return (Student) list.deleteFirst();  
	}

	/** 
	 *  > Displays LinkedList contents
	 */
	public void displayQueue()
    {
		System.out.println("Queue (front-->rear): ");
		list.displayStudentList();
    }
} 