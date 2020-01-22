<?php


	class SqlCommand{

		function createDatabase($conn){

			    $sql = "Create database ". $DB_NAME;
			    if($conn->query($sql)== TRUE){
			 	    echo "Database has been crated successfully\n";
			    }else{
			 	    echo "Error creating database: ".$conn->error."\n";
			    }
		}


		function createTableUserLognin($conn){
			
		    $sqlCreateTable = "Create table User(
	        Name char(30),
	        Email char(30) UNIQUE,
	        Password char(30),
	        primary key(Name));";
	        $conn->query($sqlCreateTable);
		}

		function createTableforTeacher($conn){

			$sqlCreateTable = "Create table TeacherInfo(
			Id INT(10) AUTO_INCREMENT,
			Name char(30),
			Course char(40),
			Date_ char(30),
			Announcement text,
			primary key(Id));";
			$conn->query($sqlCreateTable);

		}

		
	}


?>