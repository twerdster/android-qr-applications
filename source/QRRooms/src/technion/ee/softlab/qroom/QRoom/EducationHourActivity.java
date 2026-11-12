package technion.ee.softlab.qroom.QRoom;

import technion.ee.softlab.qroom.R;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * The Class EducationHourActivity. Displays Education hour information.
 */
public class EducationHourActivity extends qrRoomsActivity {
	private EducationHour m_educationHour;
	private Person m_person;
	private Course m_course;
	private Room m_room;
	private Building m_building;
	private ImageView m_typeImageView;
	private TextView m_courseNameTextView;
	private TextView m_courseNumberTextView;
	private TextView m_locationTextView;
	private TextView m_personTextView;
	private TextView m_timeTextView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.education_hour);
		initComponents();

		int educatipnHourId = getIntent().getExtras().getInt("educationHourId");		
			
		//getting information from the database
		m_educationHour = PHPGetter.instance().getEducationHour(educatipnHourId);
		m_person = PHPGetter.instance().getPerson(m_educationHour.PersonID);
		m_course = PHPGetter.instance().getCourse(m_educationHour.Course.ID);
		m_room = PHPGetter.instance().getRoomData(m_educationHour.RoomID);
		m_building = PHPGetter.instance().getBuilding(m_room.BuildingID);
		
		//underlined string
		SpannableString courseName = GlobalHelper.instance().getUnderlinedString(m_course.Name);
		m_courseNameTextView.setText(courseName);
		
		m_courseNumberTextView.setText(String.format("#%s", m_course.Number));	

		//underlined string
		SpannableString personName = GlobalHelper.instance().getUnderlinedString(String.format("by %s %s", m_person.FirstName,m_person.LastName));
		m_personTextView.setText(personName);
		
		String location = String.format("Location: %s (%s)\nRoom: %s, Floor: %d", m_building.Name,
				m_building.Faculty,m_room.RoomNumber,m_room.Floor);
		m_locationTextView.setText(location);
        String time = String.format("%s, %s - %s",GlobalHelper.instance().getDayOfWeek(m_educationHour.DayOfWeek),GlobalHelper.instance().getShortTimeString(m_educationHour.StartTime) ,GlobalHelper.instance().getShortTimeString(m_educationHour.EndTime));
		m_timeTextView.setText(time);
		
		
		// Types: l - Lecture, t - Tutorial, w - Workshop
		if (m_educationHour.LessonType.equals("l"))
		{
			m_typeImageView.setImageDrawable(getResources().getDrawable(R.drawable.lecture_128));
		} else if (m_educationHour.LessonType.equals("t"))
		{
			m_typeImageView.setImageDrawable(getResources().getDrawable(R.drawable.tutorial_128));
		} else if (m_educationHour.LessonType.equals("w"))
		{
			m_typeImageView.setImageDrawable(getResources().getDrawable(R.drawable.workshop_128));
		}
		TextView otherClasses = (TextView)findViewById(R.id.educationHourOtherClassesInRoomTextView);
		SpannableString moreRooms = GlobalHelper.instance().getUnderlinedString("see other classes in this room");
		otherClasses.setText(moreRooms);
	}

	
	/**
	 * Inits the components.
	 */
	private void initComponents() {
		m_typeImageView = (ImageView)findViewById(R.id.educationHourImageView);
		m_courseNameTextView = (TextView)findViewById(R.id.educationHourCourseNameTextView);
		m_courseNumberTextView = (TextView)findViewById(R.id.educationHourCourseNumberTextView);
		m_locationTextView = (TextView)findViewById(R.id.educationHourLocationTextView);
		m_personTextView = (TextView)findViewById(R.id.educationHourPersonTextView);
		m_timeTextView = (TextView)findViewById(R.id.educationHourTimeTextView);

	}
	
	//call to courseActivity
    public void courseOnClick(View v) {
		int courseId=m_educationHour.Course.ID;
		Intent courseIntent = new Intent(EducationHourActivity.this,CourseActivity.class);
		courseIntent.putExtra("courseId",courseId);
		startActivity(courseIntent);
    }
    
	//call to personActivity
    public void personOnClick(View v) {
		int personId=m_educationHour.PersonID;
		Intent personIntent = new Intent(EducationHourActivity.this,PersonActivity.class);
		personIntent.putExtra("personId",personId);
		startActivity(personIntent);
    }
    
    //call to allClassesActivity
    public void otherClassesInRoomOnClick(View v) {
		Intent personIntent = new Intent(EducationHourActivity.this,AllClassesActivity.class);
		personIntent.putExtra("roomId",m_educationHour.RoomID);
		startActivity(personIntent);
    } 
}