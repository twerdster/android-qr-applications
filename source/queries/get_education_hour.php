<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	$query = "SELECT * FROM EducationHour WHERE id='".$_REQUEST['educationHourID']."'";
	
	fetch_query_and_json_encode($query);
	mysql_close();
?>