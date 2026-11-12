<?php require_once("includes/connection.php"); ?>
<?php require_once("includes/functions.php"); ?>
<?php find_selected_page(); ?>
<?php include("includes/header.php"); ?>
<table id="structure">
	<tr>
		<td id="navigation">
			<?php echo navigation($sel_subject, $sel_page); ?>
		</td>
		<td id="page">
		<?php if (!is_null($sel_subject)) { // subject selected ?>
			<h2><?php echo $sel_subject['MenuName']; ?></h2>
		<?php } elseif (!is_null($sel_page)) { // page selected ?>
			
			<div class="page-content">
				<?php //echo $sel_page['Content']; ?>
				<?php eval( $sel_page['Content']); // will run the code which exist in the db ?> 
			</div>
		<?php } else { // nothing selected ?>
			<h2>Select a subject or page to edit</h2>
		<?php } ?>
		</td>
	</tr>
</table>
<?php include("includes/footer.php"); ?>