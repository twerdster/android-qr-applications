<?php require_once("includes/connection.php"); ?>
<?php require_once("includes/functions.php"); ?>


<?php	
	$query="INSERT INTO LibFarm (RoomID,Type,Name,WorkingHours)
	VALUES
	('$_POST[room_id]','$_POST[type]','$_POST[name]','$_POST[working_hours]')";
	
	$result = mysql_query($query, $connection);
	if ($result) {
		// Success!
		header("Location: content.php");
		exit;
	} else {
		// Display error message.
		echo "<p>LibFarm creation failed.</p>";
		echo "<p>" . mysql_error() . "</p>";
	}
?>

<?php mysql_close($connection); ?>