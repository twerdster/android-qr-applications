package technion.ee.softlab.qroom.QRoom;

/**
 * The Class EducationHour.
 */
public class EducationHour {
	public int ID;
	public int PersonID;
	public int RoomID;
	public int CourseID;
	public int GroupNumber;
	public int DayOfWeek;
	public String LessonType;
	public String StartTime;
	public String EndTime;
	public Course Course = new Course();
}