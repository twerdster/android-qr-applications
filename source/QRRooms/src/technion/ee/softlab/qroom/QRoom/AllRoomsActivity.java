package technion.ee.softlab.qroom.QRoom;

import java.util.ArrayList;
import java.util.Calendar;
import technion.ee.softlab.qroom.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;



/**
 * The AllRoomsActivity, show all rooms.
 */
public class AllRoomsActivity extends QRoomListActivity {
	private ArrayList<ExtendedRoom> m_extendedRoomList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_rooms);
		m_extendedRoomList = PHPGetter.instance().getAllExtendedRooms();
		setListAdapter(new AllRoomsAdapter(this, R.layout.base_hour_list_item, m_extendedRoomList));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		ExtendedRoom extendedRoom= m_extendedRoomList.get(position);
		
		if (extendedRoom.Type==0){ //libfarm
			Intent libfarmIntent = new Intent(this,LibFarmActivity.class);
			libfarmIntent.putExtra("libfarmId",extendedRoom.ID);
			startActivity(libfarmIntent);
		} else if (extendedRoom.Type==1){ //office
			Intent officeIntent = new Intent(this,OfficeActivity.class);
			officeIntent.putExtra("officeId",extendedRoom.ID);
			startActivity(officeIntent);
		} else if (extendedRoom.Type==2) { //class room
			//get current time
		    Calendar calendar = Calendar.getInstance();
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			String currentTime = String.format("%d:%d", calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE));
			
			//get education hour id if it exists for this room and time
			int educationHourId = PHPGetter.instance().getEducationIdIfExists(dayOfWeek, currentTime, extendedRoom.ID);
			
			if (educationHourId!=0)
			{
				//call to educationHourActivity
				Intent educationHourIntent = new Intent(this,EducationHourActivity.class);
				educationHourIntent.putExtra("educationHourId",educationHourId);
				startActivity(educationHourIntent);
				
			} else {
				//call to allClassesActivity
				Intent allClassesIntent = new Intent(this,AllClassesActivity.class);
				allClassesIntent.putExtra("roomId",extendedRoom.ID);
				startActivity(allClassesIntent);
			}
		}
	}
}