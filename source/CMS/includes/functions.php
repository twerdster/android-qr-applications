<?php
// it will store all basic functions
	function confirm_query($result_set) {
		if (!$result_set) {
			die("Database query failed: " . mysql_error());
		}
	}
	
	function get_all_subjects() {
		// $connection is not passed so we use globals
		global $connection;
		$query = "SELECT * 
				FROM WebSubjects 
				ORDER BY position ASC";
		$subject_set = mysql_query($query, $connection);
		confirm_query($subject_set);
		return $subject_set;
	}
	
	function get_all_buildings() {	
		global $connection;
		$query = "SELECT * 
				FROM Building 
				ORDER BY Name ASC";
		$set = mysql_query($query, $connection);
		confirm_query($set);
		return $set;
	}
	
	function get_all_staff_members() {
		global $connection;
		$query = "SELECT * 
				FROM Person 
				ORDER BY LastName ASC";
		$set = mysql_query($query, $connection);
		confirm_query($set);
		return $set;
	}
	
	function get_all_courses() {
		global $connection;
		$query = "SELECT * 
				FROM Course 
				ORDER BY Number ASC";
		$set = mysql_query($query, $connection);
		confirm_query($set);
		return $set;
	}
	
	
	function get_all_rooms() {
		global $connection;
		$query = "SELECT * 
				FROM Room 
				ORDER BY BuildingID ASC";
		$set = mysql_query($query, $connection);
		confirm_query($set);
		return $set;
	}
	
	
	function get_pages_for_subject($WebSubjectID) {
		global $connection;
		$query = "SELECT * 
				FROM WebPages 
				WHERE WebSubjectID = {$WebSubjectID} 
				ORDER BY position ASC";
		$page_set = mysql_query($query, $connection);
		confirm_query($page_set);
		return $page_set;
	}

	function get_subject_by_id($subject_id) {
		global $connection;
		$query = "SELECT * ";
		$query .= "FROM WebSubjects ";
		$query .= "WHERE id=" . $subject_id ." ";		// add space before LIMIT
		$query .= "LIMIT 1";		// get only one result
		$result_set = mysql_query($query, $connection);
		confirm_query($result_set);
		//to be sure that we dont get false
		// if no rows are returned, fetch_array will return false
		if ($subject = mysql_fetch_array($result_set)) {
			return $subject;
		} else {
			return NULL;
		}
	}
	
	function get_page_by_id($page_id) {
		global $connection;
		$query = "SELECT * ";
		$query .= "FROM WebPages ";
		$query .= "WHERE id=" . $page_id ." ";
		$query .= "LIMIT 1";
		$result_set = mysql_query($query, $connection);
		confirm_query($result_set);
		// if no rows are returned, fetch_array will return false
		if ($page = mysql_fetch_array($result_set)) {
			return $page;
		} else {
			return NULL;
		}
	}
	
	function find_selected_page() {
		global $sel_subject;
		global $sel_page;
		if (isset($_GET['subj'])) {
			$sel_subject = get_subject_by_id($_GET['subj']);	// get content info
			$sel_page = NULL;
		} elseif (isset($_GET['page'])) {
			$sel_subject = NULL;
			$sel_page = get_page_by_id($_GET['page']);
		} else {
			$sel_subject = NULL;
			$sel_page = NULL;
		}
	}


	function navigation($sel_subject, $sel_page) {
		$output = "<ul class=\"subjects\">";
		//we are going to call content.php with a new params, so we can fill the content area
		$subject_set = get_all_subjects();
		while ($subject = mysql_fetch_array($subject_set)) {
			$output .= "<li";
			if ($subject["id"] == $sel_subject['id']) { $output .= " class=\"selected\""; }		// use bold style for a selected subject
			$output .= "><a href=\"content.php?subj=" . urlencode($subject["id"]) . 
				"\">{$subject["MenuName"]}</a></li>";
			$page_set = get_pages_for_subject($subject["id"]);
			$output .= "<ul class=\"pages\">";
			while ($page = mysql_fetch_array($page_set)) {
				$output .= "<li";
				if ($page["id"] == $sel_page['id']) { $output .= " class=\"selected\""; }		// use bold style for a selected page
				$output .= "><a href=\"content.php?page=" . urlencode($page["id"]) .
					"\">{$page["MenuName"]}</a></li>";
			}
			$output .= "</ul>";
		}
		$output .= "</ul>";
		return $output;
	}
	
	//constant string for qr code. room id will be added to it
	function get_string_for_qr_text() {
		return "Please download QRoom client at https://market.android.com/details?id=technion.ee.softlab.qroom #";
	}
	
?>