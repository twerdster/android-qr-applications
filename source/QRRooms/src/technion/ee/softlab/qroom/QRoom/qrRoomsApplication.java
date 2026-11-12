package technion.ee.softlab.qroom.QRoom;

import android.app.Application;

/**
 * The Class qrRoomsApplication.
 * It is uses to store a global room id variable so that any other activities
 * will be able to get it. 
 */
public class qrRoomsApplication extends Application {
	private Room room;

	@Override
	public void onCreate() {
		super.onCreate();    
		if (room == null) {  
			room = new Room(); 
		}
	}
	
	/**
	 * Room getter.
	 *
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}
	
	/**
	 * Room setter.
	 *
	 * @param p_room the r
	 */
	public void SetRoom(Room p_room) {
		room = p_room;
	}
}