<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	//$query = "SELECT * FROM ReceptionHour WHERE PersonID='".$_REQUEST['personID']."'";
	$query = "SELECT *, ReceptionHour.id FROM ReceptionHour, Course WHERE (ReceptionHour.PersonID='".$_REQUEST['personID']."' AND ReceptionHour.CourseID = Course.id) ORDER BY DayOfWeek ASC";

	fetch_query_and_json_encode($query);
	mysql_close();
?>