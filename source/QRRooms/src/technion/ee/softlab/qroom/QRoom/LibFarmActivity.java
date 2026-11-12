package technion.ee.softlab.qroom.QRoom;

import technion.ee.softlab.qroom.R;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The Class LibFarmActivity. Shows Library or Farm information.
 */
public class LibFarmActivity extends qrRoomsActivity {
	private TextView m_nameTextView;
	private ImageView m_typeImageView;
	private TextView m_roomTextView;
	private TextView m_facultyTextView;
	private TextView m_moreInformationTextView;
	private TextView m_workingHoursTextView;
	private LibFarm m_libfarm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.libfarm);
		initComponents();

		int libfarmId = getIntent().getExtras().getInt("libfarmId");		
		m_libfarm = PHPGetter.instance().getLibFarmData(libfarmId);
		Room room = PHPGetter.instance().getRoomData(m_libfarm.RoomID);
		Building building = PHPGetter.instance().getBuilding(room.BuildingID);
		m_nameTextView.setText(m_libfarm.Name);
		String roomString = String.format("%s %d", building.Name,room.RoomNumber);
		m_roomTextView.setText(roomString);
		m_facultyTextView.setText(String.format("Faculty: %s", building.Faculty));
		String moreInformation = String.format("Type: %s, Floor: %d", GlobalHelper.instance().getFullLibFarmType(m_libfarm.Type),room.Floor);
		m_moreInformationTextView.setText(moreInformation);
		m_workingHoursTextView.setText("Working Hours:\n" + m_libfarm.WorkingHours);

		// Types: l - Library, f - Farm
		if (m_libfarm.Type.equals("l"))
		{
			m_typeImageView.setImageDrawable(getResources().getDrawable(R.drawable.library_128));
		}
		else if (m_libfarm.Type.equals("f"))
		{
			m_typeImageView.setImageDrawable(getResources().getDrawable(R.drawable.farm_128));
		}
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {
		m_typeImageView = (ImageView)findViewById(R.id.libFarmImageView);
		m_nameTextView = (TextView)findViewById(R.id.libfarmNameTextView);
		m_roomTextView = (TextView)findViewById(R.id.libfarmRoomTextView);
		m_facultyTextView = (TextView)findViewById(R.id.libfarmFacultyTextView);
		m_moreInformationTextView = (TextView)findViewById(R.id.libfarmMoreInformationTextView);
		m_workingHoursTextView = (TextView)findViewById(R.id.libfarmWorkingHoursTextView);		
	}
}