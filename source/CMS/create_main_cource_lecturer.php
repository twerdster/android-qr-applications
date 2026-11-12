<?php require_once("includes/connection.php"); ?>
<?php require_once("includes/functions.php"); ?>


<?php	
	$query="INSERT INTO MainCourseLecturer (PersonID,CourseNumber)
	VALUES
	('$_POST[person_id]','$_POST[course_number]')";
	
	$result = mysql_query($query, $connection);
	if ($result) {
		// Success!
		header("Location: content.php");
		exit;
	} else {
		// Display error message.
		echo "<p>MainCourseLecturer creation failed.</p>";
		echo "<p>" . mysql_error() . "</p>";
	}
?>

<?php mysql_close($connection); ?>