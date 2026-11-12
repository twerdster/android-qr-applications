<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	//$query = "SELECT * FROM EducationHour WHERE RoomID='".$_REQUEST['roomID']."' ORDER BY DayOfWeek ASC";
	$query = "SELECT *, EducationHour.id FROM EducationHour, Course WHERE (EducationHour.RoomID='".$_REQUEST['roomID']."' AND EducationHour.CourseID = Course.id) ORDER BY DayOfWeek ASC";

	fetch_query_and_json_encode($query);
	mysql_close();
?>