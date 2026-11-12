// this is a php code which runs with eval() command

// get info for drop down menu
$persons_set = get_all_staff_members();
$persons_total = mysql_num_rows($persons_set);

$rooms_set = get_all_rooms();
$rooms_total = mysql_num_rows($rooms_set);

echo "<br>Add Library/Farm:<br><br>

<form action=\"create_libfarm.php\" method=\"post\">
<table border=\"0\">

<tr>
<td>Name:</td>
<td> <input type=\"text\" name=\"name\" /></td>
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
	
	if ($room_row["Type"] == 0)
	{
		echo "<option value=\"{$room_row["id"]}\">{$building_name} {$room_row["RoomNumber"]} ({$building_faculty})</option>";
	}
}
//end php code

echo "</select>&nbsp;<a href=\"content.php?page=3\">Add new room</a>

</td>
</tr>

<tr>
<td>Type:</td>
<td>
Library:<input type=\"radio\" value=\"l\" name=\"type\" checked=\"yes\">&nbsp;
Farm:<input type=\"radio\" value=\"f\" name=\"type\">&nbsp;
</td>
</tr>

<tr>
<td>Working Hours:</td>
<td> <input type=\"text\" name=\"working_hours\" /></td>
</tr>

</table> 
<br>
<input type=\"submit\" />
</form>";