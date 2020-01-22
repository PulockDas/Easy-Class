<?php
	$type = $_POST['Type'];
	$email = $_POST['Email'];
	$password = $_POST['Password'];

	require_once (dirname(__FILE__)."/getConnection.php");
	$object = new Connection();
	$conn = $object->connect();

	$sql1 = "SELECT * FROM User WHERE Email ='$email' and Password = '$password';";
	$sql2 = "SELECT * FROM Student_info WHERE Email ='$email' and Password = '$password';";
	if($type == "Teacher")
		$result = $conn->query($sql1);
	else
		$result = $conn->query($sql2);

	if($result->num_rows == 1){
		$row = $result->fetch_assoc();
			if($row['Email'] == $email && $row['Password'] == $password){
			echo "Welcome"."\n";
			echo $row['Name'];
		}
	}else{
		echo "please insert valid email and password"."\n";
	}

?>