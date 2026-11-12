<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	$query = "SELECT *,EducationHour.id FROM EducationHour,Room,Building WHERE (EducationHour.CourseID = '".$_REQUEST['courseID']."' AND EducationHour.RoomID=Room.id AND Building.id=Room.BuildingID)";
	fetch_query_and_json_encode($query);
	mysql_close();
?>