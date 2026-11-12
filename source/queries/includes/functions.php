<?php
// it will store all basic functions
	
	// query, fetch and json encode
	function fetch_query_and_json_encode($query) {
		$q=mysql_query($query);
		while($e=mysql_fetch_assoc($q))
			$output[]=$e;
		print(json_encode($output));
	}
?>