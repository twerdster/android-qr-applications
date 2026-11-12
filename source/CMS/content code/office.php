// this is a php code which runs with eval() command

// get info for drop down menu
$persons_set = get_all_staff_members();
$persons_total = mysql_num_rows($persons_set);

$rooms_set = get_all_rooms();
$rooms_total = mysql_num_rows($rooms_set);

echo "<br>Add Office:<br><br>

<form action=\"create_office.php\" method=\"post\">
<table border=\"0\">
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
	
	if ($room_row["Type"] == 1)
	{
		echo "<option value=\"{$room_row["id"]}\">{$building_name} {$room_row["RoomNumber"]} ({$building_faculty})</option>";
	}
}
//end php code

echo "</select>&nbsp;<a href=\"content.php?page=3\">Add new room</a>

</td>
</tr>

</table> 
<br>
<input type=\"submit\" />
</form>";