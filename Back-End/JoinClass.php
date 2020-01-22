<?php
	$s_name = $_POST['Sname'];
	$course = $_POST['Course'];
	$t_name = $_POST['Tname'];

	require_once (dirname(__FILE__)."/getConnection.php");
	$object = new Connection();
	$conn = $object->connect();
	

	$sqlInsert = "INSERT INTO Student(Student_Name,Teacher_Name,Course)VALUES('$s_name','$course', '$t_name');";

	if($conn->query($sqlInsert) == true){
		echo "Successfully updated";
	}else{
		 	echo $conn->error;
		 }	


?>