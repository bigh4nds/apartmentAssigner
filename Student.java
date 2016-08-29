/** Student class
 *  > Constructor & methods for Student objects
 *  @author Finn
 */

public class Student 
{
	private int id;
	private String name;
	private String loc;
	private int nBeds;
	private String incLaundry;
	private int rating;

	public Student(int i, String n, String l, int nB, String il, int r)
	{
		id = i;
		name = n;
		loc = l;
		nBeds = nB;
		incLaundry = il;
		rating = r;
	}
	
	/**
	 * Overridden toString method to match input format
	 */
	public String toString()
	{
		return(id+" "+name+" "+loc+" "+nBeds+" "+incLaundry+" "+rating);
	}
	
	/**
	 * Get methods to return specific object values
	 */
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getLoc()
	{
		return loc;
	}
	
	public int getnBeds()
	{
		return nBeds;
	}
	
	public String getincLaundry()
	{
		return incLaundry;
	}
	
	public int getRating()
	{
		return rating;
	}
}
