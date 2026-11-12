<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	//gets educationhour and course info
	$query = "SELECT *, EducationHour.id FROM EducationHour, Course WHERE (EducationHour.id = '".$_REQUEST['educationHourID']."' AND EducationHour.CourseID = Course.id)";
	fetch_query_and_json_encode($query);
	mysql_close();
?>