/** Apartment class
 *  > Constructor & methods for Apartment objects
 *  @author Finn
 */

public class Apartment 
{
	private int id;
	private String loc;
	private int nBeds;
	private String incLaundry;
	private int rating;
	
	public Apartment(int i, String l, int n, String il, int r)
	{
		id = i;
		loc = l;
		nBeds = n;
		incLaundry = il;
		rating = r;
	}
	
	/**
	 * Overridden toString method to match input format
	 */
	public String toString()
	{
		return(id+" "+loc+" "+nBeds+" "+incLaundry+" "+rating);
	}
	
	/**
	 * Get methods to return specific object values
	 */
	public int getId()
	{
		return id;
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
