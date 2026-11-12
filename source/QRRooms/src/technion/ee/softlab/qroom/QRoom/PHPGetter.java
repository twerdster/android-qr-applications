package technion.ee.softlab.qroom.QRoom;

import static technion.ee.softlab.qroom.QRoom.ConstantValues.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

/**
 * The Class PHPGetter. It's a singleton which provides the connection to the database.
 * It has many function for different objects.
 */
public class PHPGetter {
	private static PHPGetter m_instance = new PHPGetter();
	private PHPGetter() {}
	public static PHPGetter instance() {
		return m_instance;
	}

	/**
	 * Gets the room data.
	 *
	 * @param p_roomID the room id
	 * @return the room data
	 */
	public Room getRoomData(int p_roomID) {
		Room room = new Room();
		InputStream is = null;
		String result = "";

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("roomID", Integer.toString(p_roomID)));

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_room_php_location);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
			room=null;
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
			room=null;
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);
				room.ID=json_data.getInt("id");
				room.Type=json_data.getInt("Type");
				room.RoomNumber=json_data.getInt("RoomNumber");
				room.BuildingID=json_data.getInt("BuildingID");

				//handle Floors with nulls
				try
				{
					room.Floor=json_data.getInt("Floor");
				} 
				catch (Exception e)
				{
					// handle exception
				}
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
			room=null;
		}
		return room;
	} 	   



	/**
	 * Gets the person's data.
	 *
	 * @param p_personId the person id
	 * @return the person's data
	 */
	public Person getPerson(int p_personId) {
		Person person = new Person();
		InputStream is = null;
		String result = "";

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("personID", Integer.toString(p_personId)));

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_person_php_location);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
			person=null;
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
			person=null;
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);		

				person.ID=json_data.getInt("id");
				person.FirstName=json_data.getString("FirstName");
				person.LastName=json_data.getString("LastName");
				person.Specialization=json_data.getString("Specialization");
				person.Phone=json_data.getString("Phone");
				person.Fax=json_data.getString("Fax");
				person.Email=json_data.getString("Email");
				person.WorkerType=json_data.getString("WorkerType");
				person.WorkerDegree=json_data.getString("WorkerDegree");
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
			person=null;
		}
		return person;
	} 	   


	/**
	 * Gets building data.
	 *
	 * @param p_buildingId the building id
	 * @return the building data
	 */
	public Building getBuilding(int p_buildingId) {
		Building building = new Building();
		InputStream is = null;
		String result = "";

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("buildingID", Integer.toString(p_buildingId)));

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_building_php_location);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
			building=null;
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
			building=null;
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);		

				building.ID=json_data.getInt("id");
				building.Faculty=json_data.getString("Faculty");
				building.Name=json_data.getString("Name");
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
			building=null;
		}
		return building;
	} 	   


	/**
	 * Gets Library/Farm data
	 *
	 * @param p_roomID the room id
	 * @return the Library/Farm data
	 */
	public LibFarm getLibFarmData(int p_roomID) {
		LibFarm libFarm = new LibFarm();
		InputStream is = null;
		String result = "";

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("roomID", Integer.toString(p_roomID)));

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_lib_farm_php_location);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);

				libFarm.ID=json_data.getInt("id");
				libFarm.RoomID=json_data.getInt("RoomID");
				libFarm.Type=json_data.getString("Type");
				libFarm.Name=json_data.getString("Name");
				libFarm.WorkingHours=json_data.getString("WorkingHours");
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
		return libFarm;
	}


	/**
	 * Gets office data.
	 *
	 * @param p_roomID the room id
	 * @return the office data
	 */
	public Office getOfficeData(int p_roomID) {
		Office office = new Office();
		InputStream is = null;
		String result = "";

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("roomID", Integer.toString(p_roomID)));

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_office_php_location); 
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);

				office.ID=json_data.getInt("id");
				office.RoomID=json_data.getInt("RoomID");
				Integer tmpInt = new Integer(json_data.getInt("PersonID"));
				office.PersonIDs.add(tmpInt);
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
		for (Integer roomID : office.PersonIDs) {
			Person person = new Person();
			person = getPerson(roomID);
			office.PersonList.add(person);
		}
		return office;
	}

	/**
	 * Gets the education hour id if exists.
	 * Checks if there is an education hour at a given day, time, room.
	 *
	 * @param p_dayOfWeek the day of week
	 * @param p_currentTime the current time
	 * @param p_roomID the room id
	 * @return the education hour id on success, 0 on fail
	 */
	public int getEducationIdIfExists(int p_dayOfWeek, String p_currentTime, int p_roomID) {
		int educationHourId=0;
		InputStream is = null;
		String result = "";

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("currentTime", p_currentTime));
		nameValuePairs.add(new BasicNameValuePair("roomID", Integer.toString(p_roomID)));
		nameValuePairs.add(new BasicNameValuePair("day", Integer.toString(p_dayOfWeek)));
		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_education_hour_by_time_php_location);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);
				educationHourId=json_data.getInt("id");
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
		return educationHourId;
	}

	/**
	 * Gets educationHour data by its id
	 *
	 * @param p_educationHourId the education hour id
	 * @return the education hour
	 */
	public EducationHour getEducationHour(int p_educationHourId) {
		EducationHour educationHour = new EducationHour();
		InputStream is = null;
		String result = "";

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("educationHourID", Integer.toString(p_educationHourId)));

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_education_hour_php_location);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);

				educationHour.ID=json_data.getInt("id");
				educationHour.PersonID=json_data.getInt("PersonID");
				educationHour.RoomID=json_data.getInt("RoomID");
				educationHour.GroupNumber=json_data.getInt("GroupNumber");
				educationHour.DayOfWeek=json_data.getInt("DayOfWeek");
				educationHour.LessonType=json_data.getString("LessonType");			
				educationHour.StartTime=json_data.getString("StartTime");
				educationHour.EndTime=json_data.getString("EndTime");
				educationHour.Course.ID=json_data.getInt("CourseID");
				educationHour.Course.Name=json_data.getString("Name");
				educationHour.Course.MainLecturerID=json_data.getInt("MainLecturerID");
				educationHour.Course.Number=json_data.getInt("Number");
				educationHour.Course.Description=json_data.getString("Description");
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}

		//validate that the data received correctly
		if (educationHour.ID==p_educationHourId)
		{
			return educationHour;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Gets course data
	 *
	 * @param p_courseID the course id
	 * @return the course data
	 */
	public Course getCourse(int p_courseID) {
		Course course = new Course();
		InputStream is = null;
		String result = "";

		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("courseID", Integer.toString(p_courseID)));

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_course_php_location);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);

				course.ID=json_data.getInt("id");
				course.Name=json_data.getString("Name");
				course.MainLecturerID=json_data.getInt("MainLecturerID");
				course.Number=json_data.getInt("Number");
				course.Description=json_data.getString("Description");
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
		return course;
	}

	/**
	 * Gets the office id by person id.
	 *
	 * @param p_personID the person id
	 * @return the office id
	 */
	public int getOfficeIdByPersonId(int p_personID) {
		int officeId=0;
		InputStream is = null;
		String result = "";
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("personID", Integer.toString(p_personID)));

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_office_id_by_person_id_php_location);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);

				officeId=json_data.getInt("id");
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
		return officeId;
	} 

	/**
	 * Get person reception hours and store it into list which is returned.
	 *
	 * @param p_personID the person id
	 * @return the list of person's reception hours
	 */
	public ArrayList<ReceptionHour> getPersonsReceptionHours(int p_personID) {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("personID", Integer.toString(p_personID)));	
		return getReceptionHoursList(get_persons_reception_hours_php_location, nameValuePairs);
	}

	/**
	 * Get course reception hours and store it into list which is returned
	 *
	 * @param p_courseID the course id
	 * @return the list of course reception hours
	 */
	public ArrayList<ReceptionHour> getCourseReceptionHours(int p_courseID)	{
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("courseID", Integer.toString(p_courseID)));
		return getReceptionHoursList(get_persons_education_hours_php_location, nameValuePairs);
	}



	/**
	 * Gets the reception hours list based on connection string and search values
	 *
	 * @param p_connectionString the database connection string
	 * @param p_nameValuePairs the array of value pairs (for example: "courseID" or "personID" and its value)
	 * 
	 * @return the reception hours array list
	 */
	public ArrayList<ReceptionHour> getReceptionHoursList(String p_connectionString, ArrayList<NameValuePair> p_nameValuePairs) {
		ArrayList<ReceptionHour> receptionHoursList = new ArrayList<ReceptionHour>();
		InputStream is = null;
		String result = "";

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(p_connectionString);
			httppost.setEntity(new UrlEncodedFormEntity(p_nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);
				ReceptionHour receptionHour = new ReceptionHour();

				receptionHour.ID=json_data.getInt("id");
				receptionHour.RoomID=json_data.getInt("RoomID");
				receptionHour.PersonID=json_data.getInt("PersonID");
				receptionHour.DayOfWeek=json_data.getInt("DayOfWeek");
				receptionHour.StartTime=json_data.getString("StartTime");
				receptionHour.EndTime=json_data.getString("EndTime");
				receptionHour.Course.ID=json_data.getInt("CourseID");
				receptionHour.Course.Name=json_data.getString("Name");
				receptionHour.Course.MainLecturerID=json_data.getInt("MainLecturerID");
				receptionHour.Course.Number=json_data.getInt("Number");
				receptionHour.Course.Description=json_data.getString("Description");

				receptionHoursList.add(receptionHour);
			}

		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
		return receptionHoursList;
	}

	/**
	 * Get all education hours from the current room and store the information in array list which is returned
	 *
	 * @param p_roomId the room id
	 * @return the array list of all education hours in room
	 */
	public ArrayList<EducationHour> getAllEducationHoursInRoom(int p_roomId) {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("roomID", Integer.toString(p_roomId)));
		return getEducationHoursList(get_all_education_hours_in_room_php_location, nameValuePairs);
	}


	/**
	 * 	Get person education hours and store it into array list which is returned
	 *
	 * @param p_personID the person id
	 * @return the array list of person's education hours
	 */
	public ArrayList<EducationHour> getPersonsEducationHours(int p_personID) {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("personID", Integer.toString(p_personID)));
		return getEducationHoursList(get_persons_education_hours_php_location, nameValuePairs);
	}

	/**
	 * Get course education hours and store it into list which is returned 
	 *
	 * @param p_courseID the course id
	 * @return the array list of course education hours
	 */
	public ArrayList<EducationHour> getCourseEducationHours(int p_courseID) {	
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("courseID", Integer.toString(p_courseID)));
		return getEducationHoursList(get_course_education_hours_php_location, nameValuePairs);
	}

	/**
	 * Generic function for getting a list of educationHours
	 *
	 * @param p_connectionString the database connection string
	 * @param p_nameValuePairs the array of value pairs (for example: "courseID" or "personID" and its value)
	 * @return the education hours array list
	 */
	private ArrayList<EducationHour> getEducationHoursList(String p_connectionString, ArrayList<NameValuePair> p_nameValuePairs) {
		ArrayList<EducationHour> educationHoursList = new ArrayList<EducationHour>();
		InputStream is = null;
		String result = "";

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(p_connectionString);
			httppost.setEntity(new UrlEncodedFormEntity(p_nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);
				EducationHour educationHour = new EducationHour();

				educationHour.ID=json_data.getInt("id");
				educationHour.PersonID=json_data.getInt("PersonID");
				educationHour.RoomID=json_data.getInt("RoomID");
				educationHour.LessonType=json_data.getString("LessonType");
				educationHour.GroupNumber=json_data.getInt("GroupNumber");
				educationHour.DayOfWeek=json_data.getInt("DayOfWeek");
				educationHour.StartTime=json_data.getString("StartTime");
				educationHour.EndTime=json_data.getString("EndTime");
				educationHour.Course.ID=json_data.getInt("CourseID");
				educationHour.Course.Name=json_data.getString("Name");
				educationHour.Course.MainLecturerID=json_data.getInt("MainLecturerID");
				educationHour.Course.Number=json_data.getInt("Number");
				educationHour.Course.Description=json_data.getString("Description");

				educationHoursList.add(educationHour);
			}
		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
		return educationHoursList;
	}
	
	/**
	 * Gets the all extended rooms.
	 *
	 * @return the all extended rooms idata
	 */
	public ArrayList<ExtendedRoom> getAllExtendedRooms() {
		ArrayList<ExtendedRoom> roomsList = new ArrayList<ExtendedRoom>();
		InputStream is = null;
		String result = "";

		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_all_extended_rooms_php_location);
			
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);
				ExtendedRoom room = new ExtendedRoom();

				room.ID=json_data.getInt("id");
				room.Type=json_data.getInt("Type");
				room.RoomNumber=json_data.getInt("RoomNumber");
				room.BuildingID=json_data.getInt("BuildingID");
				room.BuildindData.ID=json_data.getInt("BuildingID");
				room.Floor=json_data.getInt("Floor");
				room.BuildindData.Name=json_data.getString("Name");
				room.BuildindData.Faculty=json_data.getString("Faculty");

				roomsList.add(room);
			}
		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
		return roomsList;
	}
	
	public ArrayList<ExtendedEducationHour> getCourseExtendedEducationHoursList(int p_courseID) {
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("courseID", Integer.toString(p_courseID)));
		
		ArrayList<ExtendedEducationHour> extendedEducationHoursList = new ArrayList<ExtendedEducationHour>();
		InputStream is = null;
		String result = "";
		

		
		//http post
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(get_course_extended_education_hours_php_location);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();

		}catch(Exception e){
			Log.e("log_tag", "Error in http connection "+e.toString());
		}

		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}

		//parse json data
		try{
			JSONArray jArray = new JSONArray(result);
			for(int i=0;i<jArray.length();i++){
				JSONObject json_data = jArray.getJSONObject(i);
				ExtendedEducationHour extendedEducationHour = new ExtendedEducationHour();

				extendedEducationHour.ID=json_data.getInt("id");
				extendedEducationHour.PersonID=json_data.getInt("PersonID");
				extendedEducationHour.LessonType=json_data.getString("LessonType");
				extendedEducationHour.CourseID=json_data.getInt("CourseID");
				extendedEducationHour.GroupNumber=json_data.getInt("GroupNumber");
				extendedEducationHour.DayOfWeek=json_data.getInt("DayOfWeek");
				extendedEducationHour.StartTime=json_data.getString("StartTime");
				extendedEducationHour.EndTime=json_data.getString("EndTime");
				
				extendedEducationHour.RoomID=json_data.getInt("RoomID");
				extendedEducationHour.RoomData.ID=extendedEducationHour.RoomID;
				extendedEducationHour.RoomData.Floor=json_data.getInt("Floor");
				extendedEducationHour.RoomData.RoomNumber=json_data.getInt("RoomNumber");
				extendedEducationHour.RoomData.Type=json_data.getInt("Type");
		
				extendedEducationHour.BuildindData.ID=json_data.getInt("BuildingID");
				extendedEducationHour.RoomData.BuildingID=extendedEducationHour.BuildindData.ID;
				extendedEducationHour.BuildindData.Name=json_data.getString("Name");
				extendedEducationHour.BuildindData.Faculty=json_data.getString("Faculty");
			
				extendedEducationHoursList.add(extendedEducationHour);
			}
		}catch(JSONException e){
			Log.e("log_tag", "Error parsing data "+e.toString());
		}
		return extendedEducationHoursList;
	}
	
}