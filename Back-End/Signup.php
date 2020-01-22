<?php
	
	class UserSignup{

		function signupAsTeacher($conn,$name, $email,$password){

			 $sqlInsert = "INSERT INTO User(Name,Email,Password)
		 		VALUES('$name','$email','$password');";

		 		if($conn->query($sqlInsert) == true){
		 				echo "successfull"."\n";
		 				echo $name;
		 		}else{
		 				echo "Registration unsuccessfull\n".$conn->error."\n";
		 		}
		}
		function signupAsStudent($conn,$name, $email,$password){

			$sqlCreateTable = "Create table Student_info(
			Id INT(5) AUTO_INCREMENT,
	        Name char(30),
	        Email char(30) UNIQUE,
	        Password char(30),
	        primary key(Id));";
	        $conn->query($sqlCreateTable);

			 $sqlInsert = "INSERT INTO Student_info(Name,Email,Password)
		 		VALUES('$name','$email','$password');";

		 		if($conn->query($sqlInsert) == true){
		 				echo "successfull"."\n";
		 				echo $name;
		 		}else{
		 				echo "Registration unsuccessfull\n".$conn->error."\n";
		 		}
		}

	}


?>