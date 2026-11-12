<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	$query = "SELECT *,Building.Name, Room.id FROM Room, Building WHERE Building.id=Room.BuildingID";
	fetch_query_and_json_encode($query);
	mysql_close();
?>