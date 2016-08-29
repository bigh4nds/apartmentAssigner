/** ApartmentAssigner Class
 *  > Contains main method of program
 *  > Initializes WaitingStudentQueue, ApartmentList, ListIterator
 *  > Prompts for student input file path
 *  > Parses student input file line by line, creates student objects, & enques them to WaitingStudentQueue
 *  > Prompts for apartment input file path
 *  > Parses apartment input file line by line, creates apartment objects, & adds them to a LinkedList
 *  > Prints output
 *  @author Finn
 */

import java.io.*;
import java.util.Scanner;

public class ApartmentAssigner 
{
	public static void main(String[] args) 
	{
		WaitingStudentQueue sList = new WaitingStudentQueue();
		ApartmentList aList = new ApartmentList();
		WaitingStudentQueue unhousedStudents = new WaitingStudentQueue();
		ParseStudentFile(sList);
		ParseApartmentFile(aList);
		ListIterator iter = aList.getIterator();
		while(!aList.isEmpty() && !sList.isEmpty())
		{
			iter.reset();
			Student student = sList.deque();
			Match(student, aList, iter, unhousedStudents);
		}
		AssignmentCheck(unhousedStudents, aList, iter);
	}
	
	/**Match
	 * > Iterates through ApartmentList for an Apartment suitable for Student
	 * > Requirements:
	 *  -> Apartment rating >= Student rating  or  Student rating = Any
	 *  -> Apartment loc = Student loc  or  Student loc = Any
	 *  -> Apartment nBeds = Student nBeds  or  Student nBeds = Any
	 *  -> Apartment incLaundry = Student incLaundry  or  Student incLaundry = Any
	 * > If matched, Apartment is removed from ApartmentList
	 */
	public static void Match(Student student, ApartmentList aList, ListIterator iter, WaitingStudentQueue unhousedStudents)
	{
		while(!iter.atEnd())
		{
			int count = 0;
			Apartment apartment = (Apartment) iter.getCurrent().obj;
			if(apartment.getRating() >= student.getRating() || student.getRating() == 0)
				count++;
			if(apartment.getLoc().equals(student.getLoc()) || student.getLoc().equals("Any"))
				count++;
			if(apartment.getnBeds() == student.getnBeds() || student.getnBeds() == 0)
				count++;
			if(apartment.getincLaundry().equals(student.getincLaundry()) || student.getincLaundry().equals("Any"))
				count++;
			if(count == 4)
			{
				System.out.println("The apartment " + apartment.getId() + " is assigned to "+student.getName() + " (" + student.getId() + ").");
				iter.deleteCurrent();
				return;
			}
			iter.nextLink();
		}
		unhousedStudents.enque(student);
	}
	
	/** AssignmentCheck
	 *  > Outputs unhoused students & unassigned apartments
	 */
	public static void AssignmentCheck(WaitingStudentQueue unhousedStudents, ApartmentList aList, ListIterator iter)
	{
		if(unhousedStudents.isEmpty())
			System.out.println("There are no unhoused students.");
		else
		{	
			while(!unhousedStudents.isEmpty())
			{
				Student student = unhousedStudents.deque();
				System.out.println("The student " + student.getName() + " (" + student.getId() + ") is unhoused.");
			}
		}
		if(aList.isEmpty())
			System.out.println("There are no unassigned apartments.");
		else
		{	
			iter.reset();
			while(!iter.atEnd())
			{
				Apartment apartment = (Apartment) iter.getCurrent().obj;
				System.out.println("The apartment " + apartment.getId() + " is unassigned.");
				iter.nextLink();
			}
		}
	}
	
	
	
/////////////////////////////////////////////////////////////////////////////////	
	/**Student Input Parsing
	 * Two Methods: 
	 *  > ParseStudentFile(WaitingStudentQueue sList)
	 *    -> Reads input file
	 *  > CreateStudent(String line, WaitingStudentQueue sList)
	 *    -> Parses the line
	 *    -> Creates new Student object
	 *    -> Enques new Student object to a WaitingStudentQueue
	 */
	
	public static void ParseStudentFile(WaitingStudentQueue sList) 
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Enter student text file: ");
		String filename = console.nextLine();
		String line;
		try
	    {    
            BufferedReader in = new BufferedReader(new FileReader(filename));
            if (!in.ready())
                throw new IOException();
            while ((line = in.readLine()) != null)
                CreateStudent(line, sList);
            in.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
	}
	
	public static void CreateStudent(String line, WaitingStudentQueue sList)
	{
		int nBeds;
	    int rating;
		line = line.trim();
		String [] temp = line.split(" ");
		int id = Integer.parseInt(temp[0]);
		String name = temp[1];
		String loc = temp[2];
		if(temp[3].equals("Any"))
			nBeds = 0;
		else
			nBeds = Integer.parseInt(temp[3]);
		String incLaundry = temp[4];
		if(temp[5].equals("Any"))
			rating = 0;
		else
			rating = Integer.parseInt(temp[5]);
		Student s = new Student(id,name,loc,nBeds,incLaundry,rating);
		sList.enque(s);
	}
	/**
	 * Student Input Parsing end
	 */
	
	
	
/////////////////////////////////////////////////////////////////////////////////		
	/**Apartment Input Parsing
	 * Two Methods: 
	 *  > ParseApartmentFile(Apartment List aList)
	 *    -> Reads input file
	 *  > CreateApartment(String line, ApartmentList aList)
	 *    -> Parses the line
	 *    -> Creates new Apartment object
	 *    -> Adds new Apartment object to an ApartmentList 
	 */
	
	public static void ParseApartmentFile(ApartmentList aList) 
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Enter apartment text file: ");
		String filename = console.nextLine();
		String line;
		try
	    {    
            BufferedReader in = new BufferedReader(new FileReader(filename));
            if (!in.ready())
                throw new IOException();
            while ((line = in.readLine()) != null)
                CreateApartment(line, aList);
            in.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
	}
	
	public static void CreateApartment(String line, ApartmentList aList)
	{
		int nBeds;
	    int rating;
		line = line.trim();
		String [] temp = line.split(" ");
		int id = Integer.parseInt(temp[0]);
		String loc = temp[1];
		if(temp[2].equals("Any"))
			nBeds = 0;
		else
			nBeds = Integer.parseInt(temp[2]);
		String incLaundry = temp[3];
		if(temp[4].equals("Any"))
			rating = 0;
		else
			rating = Integer.parseInt(temp[4]);
		Apartment a = new Apartment(id,loc,nBeds,incLaundry,rating);
		aList.insertLast(a);
	}
	/**
	 * Apartment Input Parsing end
	 */
}