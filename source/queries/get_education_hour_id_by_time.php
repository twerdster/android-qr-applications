<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	$query = "SELECT * FROM EducationHour WHERE '".$_REQUEST['currentTime']."' between StartTime and EndTime and RoomID='".$_REQUEST['roomID']."' and DayOfWeek='".$_REQUEST['day']."'";
	
	fetch_query_and_json_encode($query);
	mysql_close();
?>