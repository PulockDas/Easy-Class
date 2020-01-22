<?php

	require_once (dirname(__FILE__)."/getConnection.php");
	$object = new Connection();
	$conn = $object->connect();

	$sql = "SELECT * FROM TeacherInfo ;";
	$result = $conn->query($sql);

	if($result->num_rows > 0){
		while ($row = $result->fetch_assoc()) {
				echo $row['Name']."-".$row['Course']."-".$row['Date_']."-".$row['Announcement']."\n";
				}
			}

?>