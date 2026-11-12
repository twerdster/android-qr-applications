<?php require_once("includes/connection.php"); ?>
<?php require_once("includes/functions.php"); ?>


<?php	
	$query="INSERT INTO Person (FirstName, LastName,Specialization,Phone,Fax,Email,WorkerDegree,WorkerType)
	VALUES
	('$_POST[first_name]','$_POST[last_name]','$_POST[specialization]','$_POST[phone]','$_POST[fax]','$_POST[email]','$_POST[degree]','$_POST[type]')";
	
	$result = mysql_query($query, $connection);
	if ($result) {
		// Success!
		header("Location: content.php");
		exit;
	} else {
		// Display error message.
		echo "<p>Person creation failed.</p>";
		echo "<p>" . mysql_error() . "</p>";
	}
?>

<?php mysql_close($connection); ?>