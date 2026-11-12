package technion.ee.softlab.qroom.QRoom;

/**
 * The Class ExtendedEducationHour. It extends EducationHour by adding a Building and Room classes that
 * stores it's building and room info
 */
public class ExtendedEducationHour extends EducationHour{
	public Building BuildindData;
	public Room RoomData;
	
	public ExtendedEducationHour(){
		BuildindData=new Building();
		RoomData=new Room();
	}
}