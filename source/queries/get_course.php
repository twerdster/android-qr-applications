<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	$query = "SELECT * FROM Course WHERE id='".$_REQUEST['courseID']."'";
	
	fetch_query_and_json_encode($query);
	mysql_close();
?>