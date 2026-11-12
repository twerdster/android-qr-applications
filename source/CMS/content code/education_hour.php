// this is a php code which runs with eval() command

// get info for drop down menu
$persons_set = get_all_staff_members();
$persons_total = mysql_num_rows($persons_set);

$rooms_set = get_all_rooms();
$rooms_total = mysql_num_rows($rooms_set);

$courses_set = get_all_courses();
$courses_total = mysql_num_rows($courses_set);


echo "<br>Add Education hour:<br><br>

<form action=\"create_education_hour.php\" method=\"post\">
<table border=\"0\">


<tr>
<td>Course:</td>
<td>
<select name=\"course_id\">";

//begin php code

while ($course_row = mysql_fetch_array($courses_set)) {
	echo "<option value=\"{$course_row ["id"]}\">{$course_row ["Number"]} {$course_row ["Name"]}</option>";
};

//end php code

echo "</select>&nbsp;<a href=\"content.php?page=8\">Add New Course</a>
</td>
</tr>

<tr>
<td>Group:</td>
<td><input type=\"text\" name=\"group_number\" /></td>
</tr>

<tr>
<td>Staff Member:</td>
<td>
<select name=\"person_id\">";

//begin php code

while ($person_row = mysql_fetch_array($persons_set)) {
	echo "<option value=\"{$person_row ["id"]}\">{$person_row ["LastName"]} {$person_row ["FirstName"]}</option>";
};

//end php code

echo "</select>&nbsp;<a href=\"content.php?page=2\">Add new staff member</a>
</td>
</tr>

<tr>
<td>Room:</td>
<td>
<select name=\"room_id\">";

//begin php code

while ($room_row = mysql_fetch_array($rooms_set)) {
	//getting building's information
	
	$building_name = "";
	$building_faculty = "";
	
	// TODO implement in other way... 
	$buildings_set = get_all_buildings();
	$buildings_total = mysql_num_rows($buildings_set);
	
	while ($building_row = mysql_fetch_array($buildings_set)) {
		if ($room_row["BuildingID"] == $building_row["id"]) {
			$building_name = $building_row["Name"];
			$building_faculty = $building_row["Faculty"];		
			//break;
		}
	}
	
	if ($room_row["Type"] == 2)
	{
		echo "<option value=\"{$room_row["id"]}\">{$building_name} {$room_row["RoomNumber"]} ({$building_faculty})</option>";
	}
}
//end php code

echo "</select>&nbsp;<a href=\"content.php?page=3\">Add new room</a>

</td>
</tr>


<tr>
<td>Day of Week:</td>
<td>Sun:<input type=\"radio\" value=\"1\" name=\"week_day\" checked=\"yes\">&nbsp;
Mon:<input type=\"radio\" value=\"2\" name=\"week_day\">&nbsp;
Tue:<input type=\"radio\" value=\"3\" name=\"week_day\">&nbsp;
Wed:<input type=\"radio\" value=\"4\" name=\"week_day\">&nbsp;
Thu:<input type=\"radio\" value=\"5\" name=\"week_day\">&nbsp;
Fri:<input type=\"radio\" value=\"6\" name=\"week_day\">&nbsp;
</tr>


<tr>
<td>Starts at:</td>
<td> 
	<select name=\"start_time\">
	<option value=\"07:30\">07:30</option>
	<option value=\"08:30\">08:30</option>
	<option value=\"09:30\">09:30</option>
	<option value=\"10:30\">10:30</option>
	<option value=\"11:30\">11:30</option>
	<option value=\"12:30\">12:30</option>
	<option value=\"13:30\">13:30</option>
	<option value=\"14:30\">14:30</option>
	<option value=\"15:30\">15:30</option>
	<option value=\"16:30\">16:30</option>
	<option value=\"17:30\">17:30</option>
	<option value=\"18:30\">18:30</option>
	<option value=\"19:30\">19:30</option>
	<option value=\"20:30\">20:30</option>
	<option value=\"21:30\">21:30</option>
</select>
&nbsp;&nbsp;
Ends at:
&nbsp;&nbsp;
	<select name=\"end_time\">
	<option value=\"07:30\">07:30</option>
	<option value=\"08:30\">08:30</option>
	<option value=\"09:30\">09:30</option>
	<option value=\"10:30\">10:30</option>
	<option value=\"11:30\">11:30</option>
	<option value=\"12:30\">12:30</option>
	<option value=\"13:30\">13:30</option>
	<option value=\"14:30\">14:30</option>
	<option value=\"15:30\">15:30</option>
	<option value=\"16:30\">16:30</option>
	<option value=\"17:30\">17:30</option>
	<option value=\"18:30\">18:30</option>
	<option value=\"19:30\">19:30</option>
	<option value=\"20:30\">20:30</option>
	<option value=\"21:30\">21:30</option>
</select>
</td>
</tr>

<tr>
<td>Type:</td>
<td>Lecture:<input type=\"radio\" value=\"l\" name=\"type\" checked=\"yes\">&nbsp;
Tutorial:<input type=\"radio\" value=\"t\" name=\"type\">&nbsp;
Workshop:<input type=\"radio\" value=\"w\" name=\"type\">&nbsp;</td>
</tr>

</table> 
<br>
<input type=\"submit\" />
</form>";