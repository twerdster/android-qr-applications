<?php require_once("includes/connection.php"); ?>
<?php require_once("includes/functions.php"); ?>


<?php	
	$query="INSERT INTO ReceptionHour (PersonID,RoomID,CourseID,DayOfWeek,StartTime,EndTime)
	VALUES
	('$_POST[person_id]','$_POST[room_id]','$_POST[course_id]','$_POST[week_day]','$_POST[start_time]','$_POST[end_time]')";
	
	$result = mysql_query($query, $connection);
	if ($result) {
		// Success!
		header("Location: content.php");
		exit;
	} else {
		// Display error message.
		echo "<p>Reception Hour creation failed.</p>";
		echo "<p>" . mysql_error() . "</p>";
	}
?>

<?php mysql_close($connection); ?>