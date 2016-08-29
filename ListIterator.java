/** ListIterator class
 *  > type Object
 *  > Used to iterate LinkedList via ApartmentList
 *  @author Finn
 */

class ListIterator
   {
   private Link current;          
   private Link previous;        
   private LinkedList ourList;      

   public ListIterator(LinkedList list)
   {
	   ourList = list;
       reset();
   }

   /** 
	 *  > Resets current Link to first Link of LinkedList
	 */
   public void reset()         
   {
	   current = ourList.getFirst();
       previous = null;
   }

   /** 
	 *  > Returns if ListIterator is at end of LinkedList
	 */
   public boolean atEnd()      
   { 
	   return (current.next==null); 
   }

   /** 
	 *  > Iterates to next LinkedList Link
	 */
   public void nextLink()        
   {
       previous = current;
       current = current.next;
   }

   /** 
	 *  > Returns current ListIterator Link
	 */
   public Link getCurrent()       
   { 
	   return current; 
   }

   /** 
	 *  > Deletes (from LinkedList) & returns the current ListIterator Link
	 */
   public Object deleteCurrent()
   {
   		Object value = current.obj;
   		if(previous == null) 
   		{
   			ourList.setFirst(current.next);
   			reset();
        }
   		else
        {
   			previous.next = current.next;
   			if(atEnd())
   				reset();
   			else
   				current = current.next;
        }
   		return value;
   }
}  