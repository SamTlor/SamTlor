<?php
    session_start();
?>
<html>
    <head>
        <title>Home</title>
        
        <link rel = "stylesheet" href = "style.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<style>
		
		body {
            background-image: url('https://images.pexels.com/photos/10526896/pexels-photo-10526896.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
            background-repeat: no-repeat;
            background-attachment: fixed;  
            background-size: cover;
            color: black;
		}
		</style>

    </head>

    <button type = "submit"><a href = "logout.php">Logout</a></button>
    <button type = "submit"><a href = "queries.php">Queries</a></button>

    <form action = "home.php" method = "post">
        <label>Choose which table you want to display</label>
        <select name = "whichTable">
            <option disabled selected value></option>
            <option value = "Movies">Movies</option>
            <option value = "Studios">Studios</option>
            <option value = "Actors">Actors</option>
            <option value = "Directors">Directors</option>
            <option value = "Awarders">Awarders</option>
            <option value = "Awards">Awards</option>
        </select>
        
        <button type = "submit">submit</button>
    </form>

    </html>

    <?php
        if(isset($_POST['whichTable'])){
            $query = 'SELECT * FROM ' . $_POST['whichTable'];
            include "show_table.php";
        }

        if (isset($_SESSION['user_id'])) {
            if ($_SESSION['user_id'] == 1) {
                echo "<a href = 'admins.php'>Back to admins</a>";
            }
        }
    ?>

