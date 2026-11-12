<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	//$query = "SELECT * FROM ReceptionHour WHERE CourseID='".$_REQUEST['courseID']."'";
	$query = "SELECT *, ReceptionHour.id FROM ReceptionHour, Course WHERE (ReceptionHour.CourseID='".$_REQUEST['courseID']."' AND ReceptionHour.CourseID = Course.id) ORDER BY DayOfWeek ASC";

	fetch_query_and_json_encode($query);
	mysql_close();
?>