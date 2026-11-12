<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	//$query = "SELECT * FROM EducationHour WHERE CourseID='".$_REQUEST['courseID']."'";
	$query = "SELECT *, EducationHour.id FROM EducationHour, Course WHERE (EducationHour.CourseID='".$_REQUEST['courseID']."' AND EducationHour.CourseID = Course.id) ORDER BY DayOfWeek ASC";

	
	fetch_query_and_json_encode($query);
	mysql_close();
?>