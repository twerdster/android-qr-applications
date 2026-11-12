<?php require_once("includes/connection.php"); ?>
<?php require_once("includes/functions.php"); ?>


<?php	
	$query="INSERT INTO EducationHour (PersonID,RoomID,LessonType,CourseID,GroupNumber,DayOfWeek,StartTime,EndTime)
	VALUES
	('$_POST[person_id]','$_POST[room_id]','$_POST[type]','$_POST[course_id]','$_POST[group_number]','$_POST[week_day]','$_POST[start_time]','$_POST[end_time]')";
	
	$result = mysql_query($query, $connection);
	if ($result) {
		// Success!
		header("Location: content.php");
		exit;
	} else {
		// Display error message.
		echo "<p>Education Hour creation failed.</p>";
		echo "<p>" . mysql_error() . "</p>";
	}
?>

<?php mysql_close($connection); ?>