<?php
	$type = $_POST['Type'];
	$name = $_POST['Name'];
	$email = $_POST['Email'];
	$userpassword = $_POST['Password'];

	require_once (dirname(__FILE__)."/getConnection.php");

	 $object = new Connection();
	 $conn = $object->connect();

	require_once (dirname(__FILE__)."/Command.php");
	require_once (dirname(__FILE__)."/Signup.php");

	$obj = new SqlCommand();
	$obj->createTableUserLognin($conn);
	$ob = new UserSignup();
	if($type == "teacher" || $type == "Teacher" )
		$ob->signupAsTeacher($conn,$name,$email,$userpassword);
	else{
		$ob->signupAsStudent($conn,$name,$email,$userpassword);
	}
	
	
	$obj->createTableforTeacher($conn);

	$conn->close();
?>