<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	$query = "SELECT * FROM Building WHERE id='".$_REQUEST['buildingID']."'";
	
	fetch_query_and_json_encode($query);
	mysql_close();
?>