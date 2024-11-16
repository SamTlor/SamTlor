<html>
	<head>
		<title>Hello from PHP sample DB connection app</title>
		<link rel = "stylesheet" href = "style.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<style>
		h1{
            font-size:50px;
            text-align:center;
            padding-top:20px;
            padding-bottom:20px;
            color:#FFFFFF;
        }	
		body {
		background-image: url('https://images.pexels.com/photos/3709369/pexels-photo-3709369.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
  		background-repeat: no-repeat;
  		background-attachment: fixed;  
  		background-size: cover;
		color: black;
		}
		</style>
	</head>
	<body>
		<h1>BoxOfficeMaxTV+</h1>
		<?php include "project3files/dbconn.php" ?>
		
		<button type = "submit"><a href = "project3files/queries.php">Queries</a></button>
		<button type = "submit"><a href = "project3files/home.php">Home</a></button>

		<div id = "userAsk">
			
			<form action = "project3files/login.php" method = "post">

				<h2>login</h2>
				<?php 
					if (isset($_GET['error'])) {
						echo '<p class = "error">' . $_GET["error"] . '</p>';
					} 
				?>

				<label> Username </label>
				<input type = "text" name = "Username" placeholder = "Username"><br>
				<label> Password </label>
				<input type = "password" name = "password" placeholder = "Password"><br>

				<button type = "submit">Login</button>

			</form>

		</div>

	</body>
</html>