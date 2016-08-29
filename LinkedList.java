/** Link class
 *  > type Object
 *  > used for both Student & Apartment Links
 *  @author Finn
 */

class Link
{
	public Object obj;                
	public Link next;                

	public Link(Object o)              
    { 
		obj = o;
	}
	
	/** 
	 *  > Returns Link Object
	 */
	public Object displayLink()
	{
		return obj;
	}
}  

////////////////////////////////////////////////////////////////
/** LinkedList class
 *  > type Object
 *  > used for both Student & Apartment LinkedList
 *  @author Finn
 */

class LinkedList
{
	private Link first;
	private Link last;

	public LinkedList()            
    {
		first = null;                  
    }

	/** 
	 *  > Returns ListIterator for LinkedList
	 */
	public ListIterator getIterator()
    {
		return new ListIterator(this);
    }  
	
	/** 
	 *  > Returns first Link in LinkedList
	 */
	public Link getFirst()         
    { 
		return first; 
	}

	/** 
	 *  > Sets first Link in LinkedList
	 */
	public void setFirst(Link f)
    { 
		first = f; 
	}
	
	/** 
	 *  > Inserts new Link at end of LinkedList
	 */
	public void insertLast(Object o)
    {
		Link newLink = new Link(o);
		if(isEmpty())
			first = newLink;
		else
			last.next = newLink;
		last = newLink;
    }

	/** 
	 *  > Deletes first Link in LinkedList
	 */
	public Object deleteFirst()         
    {                              
		Link temp = first;
		if(first.next == null)         
			last = null;
		first = first.next;
		return temp.obj;
    }

	/** 
	 *  > Checks if LinkedList is empty
	 */
	public boolean isEmpty()
    { 
		return first==null; 
	}
	
	/** 
	 *  > Casts the current Link Object as an Apartment
	 *  > Implements the Apartment class toString()
	 */
	public void displayApartmentList()
    {
		Link current = first;
		while(current != null)
        {
			Apartment temp = (Apartment) current.displayLink();
			System.out.println(temp.toString());
			current = current.next;
        }
		System.out.println("");
    }
	
	/** 
	 *  > Casts the current Link Object as a Student
	 *  > Implements the Student class toString()
	 */
	public void displayStudentList()
    {
		Link current = first;
		while(current != null)
        {
			Student temp = (Student) current.displayLink();
			System.out.println(temp.toString());
			current = current.next;
        }
		System.out.println("");
    }
}  
