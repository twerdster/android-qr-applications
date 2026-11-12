// this is a php code which runs with eval() command

// get info for drop down menu
$persons_set = get_all_staff_members();
$persons_total = mysql_num_rows($persons_set);

$rooms_set = get_all_rooms();
$rooms_total = mysql_num_rows($rooms_set);

echo "<br>Add Course:<br><br>

<form action=\"create_course.php\" method=\"post\">
<table border=\"0\">

<tr>
<td>Course Name:</td>
<td><input type=\"text\" name=\"course_name\" /></td>
</tr> 

<tr>
<td>Course Number:</td>
<td><input type=\"text\" name=\"course_number\" /></td>
</tr> 

<tr>
<td>Description:</td>
<td><input type=\"text\" name=\"description\" /></td>
</tr> 

<tr>
<td>Primary Lecturer:</td>
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

</table> 
<br>
<input type=\"submit\" />
</form>";