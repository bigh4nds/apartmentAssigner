/** ApartmentList class
 *  > Apartment interface for implementing LinkedList
 *  @author Finn
 */

class ApartmentList
{
	private LinkedList list;

	public ApartmentList()            
    {
		list = new LinkedList();               
    }

	/** 
	 *  > Inserts Apartment at end of LinkedList
	 */
	public void insertLast(Apartment a)
    {
		list.insertLast(a);
    }

	/** 
	 *  > Returns & removes first Apartment in LinkedList
	 */
	public Apartment deleteFirst()         
    {                              
		Apartment temp = (Apartment) list.deleteFirst();
		return temp;
    }

	/** 
	 *  > Returns if LinkedList is empty
	 */
	public boolean isEmpty()
    { 
		return (list.isEmpty()); 
	}
	
	/** 
	 *  > Displays contents of LinkedList
	 */
	public void displayList()
    {
		list.displayApartmentList();
    }

	/** 
	 *  > Returns ListIterator associated with LinkedList
	 */
	public ListIterator getIterator() 
	{
		return list.getIterator();
	}
}  
