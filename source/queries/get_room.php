<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	$query = "SELECT * FROM Room WHERE id='".$_REQUEST['roomID']."'";
	
	fetch_query_and_json_encode($query);
	mysql_close();
?>
