// this is a php code which runs with eval() command

echo "<br>Add Person:<br><br>

<form action=\"create_person.php\" method=\"post\">
<table border=\"0\">

<tr>
<td>First Name:</td>
<td><input type=\"text\" name=\"first_name\" /></td>
</tr>

<tr>
<td>Last Name:</td>
<td><input type=\"text\" name=\"last_name\" /></td>
</tr>

<tr>
<td>Specialization:</td>
<td><input type=\"text\" name=\"specialization\" /></td>
</tr>

<tr>
<td>Phone Number:</td>
<td><input type=\"text\" name=\"phone\" /></td>
</tr>

<tr>
<td>Fax Number:</td>
<td><input type=\"text\" name=\"fax\" /></td>
</tr>

<tr>
<td>Email</td>
<td><input type=\"text\" name=\"email\" /></td>
</tr>

<tr>
<td>Degree:</td>
<td><input type=\"text\" name=\"degree\" /></td>
</tr>

<tr>
<td>Type:</td>
<td>
Lecturer:<input type=\"radio\" value=\"l\" name=\"type\" checked=\"yes\">&nbsp;
Lecture Assistant:<input type=\"radio\" value=\"t\" name=\"type\">&nbsp;
Workshop Assistant:<input type=\"radio\" value=\"w\" name=\"type\">&nbsp;
</td>
</tr>

</table> 
<br>
<input type=\"submit\" />
</form>";