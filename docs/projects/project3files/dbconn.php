<?php

	# These setting are stored in the .htaccess file
	$servername = $_SERVER['SAMPLE_SERVER'];
	$Username = $_SERVER['SAMPLE_USER'];
	$password = $_SERVER['SAMPLE_PASS'];
	$dbname = $_SERVER['SAMPLE_DB'];

	#echo "<br/>Database name: $dbname <br/>Username: $Username<br/>";
	try {
		$conn = new PDO("mysql:host=$servername;dbname=$dbname", $Username, $password);
		// set the PDO error mode to exception
		$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	} catch(PDOException $e) {
		echo "<p/>Connection failed: " . $e->getMessage();
	}

?>  