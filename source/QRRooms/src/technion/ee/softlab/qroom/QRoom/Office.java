package technion.ee.softlab.qroom.QRoom;

import java.util.ArrayList;

/**
 * The Class Office.
 */
public class Office{
	public int ID;
	public int RoomID;
	public ArrayList<Integer> PersonIDs = new ArrayList<Integer>();
	public ArrayList<Person> PersonList = new ArrayList<Person>();
}