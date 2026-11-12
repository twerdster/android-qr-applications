package technion.ee.softlab.qroom.QRoom;

import java.util.ArrayList;
import technion.ee.softlab.qroom.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


/**
 * The AllClassesActivity, show all classes in room.
 */
public class AllClassesActivity extends QRoomListActivity {
	private TextView m_nameTextView;
	private ArrayList<EducationHour> m_educationHourList;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.all_classes);
		initComponents();
		//getting room data
		int roomId = getIntent().getExtras().getInt("roomId");		
		Room room = PHPGetter.instance().getRoomData(roomId);
		Building building = PHPGetter.instance().getBuilding(room.BuildingID);
		String title = String.format("%s %d", building.Name,room.RoomNumber);
		m_nameTextView.setText(title);
		m_educationHourList = PHPGetter.instance().getAllEducationHoursInRoom(roomId);
		setListAdapter(new AllClassesAdapter(this, R.layout.base_hour_list_item, m_educationHourList));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		Intent educationHourIntent = new Intent(this,EducationHourActivity.class);
		//assuming that the position is the same as in adapter "parser".
		educationHourIntent.putExtra("educationHourId",m_educationHourList.get(position).ID);
		startActivity(educationHourIntent);
	}

	private void initComponents() {
		m_nameTextView = (TextView)findViewById(R.id.all_classes_title_text_view);
	}
}