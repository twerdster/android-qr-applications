<?php
	require_once("includes/connection.php");
	require_once("includes/functions.php");

	//


	$q=mysql_query("SELECT * FROM Room WHERE ID='".$_REQUEST['roomID']."'");
	while($e=mysql_fetch_assoc($q))
		$output[]=$e;
	print(json_encode($output));
    
	// end
	mysql_close();
?>