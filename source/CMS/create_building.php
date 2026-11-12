<?php require_once("includes/connection.php"); ?>
<?php require_once("includes/functions.php"); ?>

<?php
	$name = $_POST['name'];
	$faculty = $_POST['faculty'];
?>
<?php	
	$query="INSERT INTO Building (Name, Faculty)
	VALUES
	('{$name}','{$faculty}')";
	
	$result = mysql_query($query, $connection);
	if ($result) {
		// Success!
		header("Location: content.php");
		exit;
	} else {
		// Display error message.
		echo "<p>Building creation failed.</p>";
		echo "<p>" . mysql_error() . "</p>";
	}
?>

<?php mysql_close($connection); ?>