package technion.ee.softlab.qroom.QRoom;

import java.util.ArrayList;
import technion.ee.softlab.qroom.R;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * The Class CourseActivity.
 */
public class CourseActivity extends QRoomListActivity {
	private TextView m_courseNameTextView;
	private TextView m_courseNumberTextView;
	private TextView m_coursePrimaryLecturerTextView;
	private TextView m_courseDescriptionTextView;
	private TextView m_courseEducationHoursTextView;
	private Course m_course;
	private ArrayList<ExtendedEducationHour> m_extendedEducationHourList = new ArrayList<ExtendedEducationHour>();
	private Person m_primaryLecturer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course);
		initComponents();

		//getting course information	
		int courseId = getIntent().getExtras().getInt("courseId");
		m_course = PHPGetter.instance().getCourse(courseId);
		m_primaryLecturer = PHPGetter.instance().getPerson(m_course.MainLecturerID);	
		m_extendedEducationHourList = PHPGetter.instance().getCourseExtendedEducationHoursList(courseId);
		
		//setting adapter
		setListAdapter(new CourseEducationHourAdapter(this, R.layout.base_hour_list_item, m_extendedEducationHourList));

		m_courseNameTextView.setText(m_course.Name);
		m_courseNumberTextView.setText(String.format("#%s", m_course.Number));
		if (m_primaryLecturer!=null)
		{
			//underlined string
			SpannableString personName = GlobalHelper.instance().getUnderlinedString(String.format("by %s %s",m_primaryLecturer.FirstName,m_primaryLecturer.LastName));
			m_coursePrimaryLecturerTextView.setText(personName);
		}
		m_courseDescriptionTextView.setText(m_course.Description);

		if (m_extendedEducationHourList.size()==0)
		{
			m_courseEducationHoursTextView.setText("");
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Intent educationHourIntent = new Intent(this,EducationHourActivity.class);
		
		//assuming that the position is the same as in adapter "parser".
		educationHourIntent.putExtra("educationHourId",m_extendedEducationHourList.get(position).ID);
		startActivity(educationHourIntent);
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {
		m_courseNameTextView = (TextView)findViewById(R.id.courseNameTextView);
		m_courseNumberTextView = (TextView)findViewById(R.id.courseNumberTextView);
		m_coursePrimaryLecturerTextView = (TextView)findViewById(R.id.coursePrimaryLecturerTextView);
		m_courseDescriptionTextView = (TextView)findViewById(R.id.courseDescriptionTextView);
		m_courseEducationHoursTextView = (TextView)findViewById(R.id.courseEducationHoursTextView);
	}
	
	/**
	 * Person on click function. Starts a new person activity.
	 *
	 * @param v the view
	 */
	public void personOnClick(View v) {
		int personId=m_course.MainLecturerID;
		//call to personActivity
		Intent personIntent = new Intent(CourseActivity.this,PersonActivity.class);
		personIntent.putExtra("personId",personId);
		startActivity(personIntent);
	} 
}