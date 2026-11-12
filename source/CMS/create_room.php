<?php require_once("includes/connection.php"); ?>
<?php require_once("includes/functions.php"); ?>

<?php	
	$query="INSERT INTO Room (Type, RoomNumber,BuildingID,Floor)
	VALUES
	('$_POST[type]','$_POST[room_number]','$_POST[building_id]','$_POST[floor]')";
	
	$result = mysql_query($query, $connection);
	if ($result) {
		// Success!
		header("Location: content.php");
		exit;
	} else {
		// Display error message.
		echo "<p>Room creation failed.</p>";
		echo "<p>" . mysql_error() . "</p>";
	}
?>

<?php mysql_close($connection); ?>