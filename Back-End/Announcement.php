<?php
	$name = $_POST['Name'];
	$course = $_POST['Course'];
	$date = $_POST['Date'];
	$anno = $_POST['Anno'];

	$anno = str_replace("'", "\'", $anno);

	require_once (dirname(__FILE__)."/getConnection.php");
	$object = new Connection();
	$conn = $object->connect();

	require_once (dirname(__FILE__)."/Command.php");
	$obj = new SqlCommand();
	$obj->createTableforTeacher($conn);
	

	$sqlInsert = "INSERT INTO TeacherInfo(Name,Course,Date_,Announcement)VALUES('$name','$course', '$date', '$anno');";

	if($conn->query($sqlInsert) == true){
		echo "Thanks";
	}else{
		 	echo $conn->error;
		 }	


?>