package technion.ee.softlab.qroom.QRoom;

import static technion.ee.softlab.qroom.QRoom.ConstantValues.*;
import technion.ee.softlab.qroom.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.util.Calendar;

/**
 * The Class MainActivity. The app starts in this activity.
 */
public class MainActivity extends qrRoomsActivity {
	private qrRoomsApplication m_application;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initComponents();

	}

	/**
	 * Display room's data based on it's type
	 */
	private void displayData() {
		Room room = m_application.getRoom();
		if (room==null)
		{
			Context context = getApplicationContext();
			Toast toast = Toast.makeText(context, "There is no such room, please try again.", Toast.LENGTH_LONG);
			toast.show();
			return;
		}
		switch (room.Type) {
		case 0:
			displayLibFarm(room.ID);
			break;
		case 1:
			displayOffice(room.ID);
			break;
		case 2:

			displayClass(room.ID);
			break;
		default:
			break;
		}	
	}

	/**
	 * Starts Library/Farm activity.
	 *
	 * @param p_roomId the room id
	 */
	private void displayLibFarm(int p_roomId) {		
		Intent libfarmIntent = new Intent(MainActivity.this,LibFarmActivity.class);
		libfarmIntent.putExtra("libfarmId",p_roomId);
		startActivity(libfarmIntent);
	}
	
	/**
	 * Starts Office activity.
	 *
	 * @param p_roomId the room id
	 */
	private void displayOffice(int p_roomId) {
		
		Intent officeIntent = new Intent(MainActivity.this,OfficeActivity.class);
		officeIntent.putExtra("officeId",p_roomId);
		startActivity(officeIntent);
	}
	
	/**
	 * Starts AllClassesActivity or EducationHourActivity activity, depends on current time.
	 * If at the time of the qr code scan, there is a education hour (class) in the selected room, show it's activity.
	 * Otherwise, show AllClassesActivity of the selected room.
	 *
	 * @param p_roomId the roomid
	 */
	private void displayClass(int p_roomId) {
		
		//get current time
	    Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		String currentTime = String.format("%d:%d", calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE));
		
		//get education hour id if it exists for this room and time
		int educationHourId = PHPGetter.instance().getEducationIdIfExists(dayOfWeek, currentTime, p_roomId);
		
		if (educationHourId!=0)
		{
			//call to educationHourActivity
			Intent educationHourIntent = new Intent(MainActivity.this,EducationHourActivity.class);
			educationHourIntent.putExtra("educationHourId",educationHourId);
			startActivity(educationHourIntent);
			
		} else {
			//call to allClassesActivity
			Intent allClassesIntent = new Intent(MainActivity.this,AllClassesActivity.class);
			allClassesIntent.putExtra("roomId",p_roomId);
			startActivity(allClassesIntent);
		}
	}
	
	/**
	 * Inits the components.
	 */
	private void initComponents() {
		m_application = getMainApplication();
	}

	
	//set room, when results from the scanned arrive
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    if (requestCode == 0) {
	        if (resultCode == RESULT_OK) {
	        	String contents = intent.getStringExtra("SCAN_RESULT");
	        	
	        	//get roomID from the database and store it in the application
	        	int roomID = getRoomIDFromString(contents);
	        	Room room = PHPGetter.instance().getRoomData(roomID);
	        	m_application.SetRoom(room);
	        	
	        	displayData();
	        } else if (resultCode == RESULT_CANCELED) {
	        	Context context = getApplicationContext();
				Toast toast = Toast.makeText(context, "Scanning process was canceled.", Toast.LENGTH_LONG);
				toast.show();
	        }
	    }
	}
	
	//returns the room id from a qrcode result string
	//TODO change to int
	
	/**
	 * Gets the room id from a string.
	 * This string was decoded by the scanner.
	 * It's assumed that rooms's id is located at the and of the text QR code/
	 *
	 * @param p_string the input string
	 * @return the room id on success, 0 on fail.
	 */
	private int getRoomIDFromString(String p_string) {
    	//check if it has a generic text which stored in R.string
    	if (p_string.contains(qr_scanner_id_prefix_string)==true)
		{
    		String tmp[] = p_string.split(qr_scanner_id_prefix_char);
    		return Integer.parseInt(tmp[1]);
		}
		return 0;
	}
	
    /**
     * Call a scan Activity when ScanIcon was clicked.
     *
     * @param v the view
     */
	public void scanOnClick(View v) {
		Intent intent = new Intent("technion.ee.softlab.qroom.SCAN");
		intent.setPackage("technion.ee.softlab.qroom");
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, 0);
	}
}