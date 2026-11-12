<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	$query = "SELECT * FROM Person WHERE id='".$_REQUEST['personID']."'";
	
	fetch_query_and_json_encode($query);
	mysql_close();
?>
