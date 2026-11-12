// this is a php code which runs with eval() command

echo "<br>Add Room:<br><br>

<form action=\"create_room.php\" method=\"post\">
<table border=\"0\">
<tr>
<td>Type:</td>
<td>
Class:<input type=\"radio\" value=\"2\" name=\"type\" checked=\"yes\">&nbsp;
Office:<input type=\"radio\" value=\"1\" name=\"type\">&nbsp;
LibFarm:<input type=\"radio\" value=\"0\" name=\"type\">&nbsp;
</td>
</tr>

<tr>
<td>Building:</td>
<td>
<select name=\"building_id\">";

//begin php code

 	$buildings_set = get_all_buildings();
	$buildings_total = mysql_num_rows($buildings_set);
	
	while ($building_row = mysql_fetch_array($buildings_set)) {
		echo "<option value=\"{$building_row["id"]}\">{$building_row["Name"]} ({$building_row["Faculty"]})</option>";
	}

//end php code

echo "</select>&nbsp;<a href=\"content.php?page=1\">Add new Building</a>
</td>
</tr>

<tr>
<td>Floor:</td>
<td><input type=\"text\" name=\"floor\" /></td>
</tr>

<tr>
<td>Room Number</td>
<td><input type=\"text\" name=\"room_number\" /></td>
</tr>

</table> 
<br>
<input type=\"submit\" />
</form>";