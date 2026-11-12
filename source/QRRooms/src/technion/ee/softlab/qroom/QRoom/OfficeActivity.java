package technion.ee.softlab.qroom.QRoom;

import technion.ee.softlab.qroom.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * The Class OfficeActivity. Show office information.
 */
public class OfficeActivity extends QRoomListActivity {
	private TextView m_nameTitleTextView;
	private TextView m_facultyTitleTextView;
	private TextView m_floorTitleTextView;
	private TextView m_personsInOfficeTitleTextView;
	private Office m_office;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.office);
		initComponents();
	
		int officeId = getIntent().getExtras().getInt("officeId");		
		m_office = PHPGetter.instance().getOfficeData(officeId);
		
		Room room = PHPGetter.instance().getRoomData(m_office.RoomID);
		Building building = PHPGetter.instance().getBuilding(room.BuildingID);
		String title = String.format("%s %d", building.Name,room.RoomNumber);
		m_nameTitleTextView.setText(title);
		m_facultyTitleTextView.setText(String.format("Faculty: %s", building.Faculty));
		m_floorTitleTextView.setText(String.format("Floor: %d", room.Floor));
		
		if (m_office.PersonList.size()==0)
		{
			m_personsInOfficeTitleTextView.setText("");
		}
		setListAdapter(new OfficeAdapter(this, R.layout.base_hour_list_item, m_office.PersonList));
	}


	/**
	 * Inits the components.
	 */
	private void initComponents() {
		m_nameTitleTextView = (TextView)findViewById(R.id.officeNameTextView);
		m_facultyTitleTextView = (TextView)findViewById(R.id.officeFacultyTextView);
		m_floorTitleTextView = (TextView)findViewById(R.id.officeFloorTextView);
		m_personsInOfficeTitleTextView = (TextView)findViewById(R.id.officePersonsInOfficeTextView);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		//assuming that the position is the same as in adapter "parser".
		Intent personIntent = new Intent(OfficeActivity.this,PersonActivity.class);
		personIntent.putExtra("personId",m_office.PersonList.get(position).ID);
		startActivity(personIntent);
	}
}