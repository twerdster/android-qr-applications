<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	//$query = "SELECT * FROM EducationHour WHERE PersonID='".$_REQUEST['personID']."'";
	$query = "SELECT *, EducationHour.id FROM EducationHour, Course WHERE (EducationHour.PersonID='".$_REQUEST['personID']."' AND EducationHour.CourseID = Course.id) ORDER BY DayOfWeek ASC";

	
	fetch_query_and_json_encode($query);
	mysql_close();
?>