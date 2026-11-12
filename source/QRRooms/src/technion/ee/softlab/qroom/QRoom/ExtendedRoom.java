package technion.ee.softlab.qroom.QRoom;

/**
 * The Class ExtendedRoom. It extends Room by adding a Building class that
 * stores room's building info
 */
public class ExtendedRoom extends Room{
	public Building BuildindData;
	
	public ExtendedRoom(){
		BuildindData=new Building();
	}
}