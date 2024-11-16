<?php 
    session_start();
    include "dbconn.php";

    if (isset($_POST['Username']) && isset($_POST['password'])) {

        function validate($data) {
            $data = trim($data);
            $data = stripslashes($data);
            $data = htmlspecialchars($data);
            return $data;
        }

        $Username = validate($_POST['Username']);
        $password = validate($_POST['password']);

        if (empty($Username)) {
            header("Location: ../project3.php?error=Username is required");
            exit();
        }
        if (empty($password)) {
            header("Location: ../project3.php?error=Password is required");
            exit();
        }


        $result = $conn -> query("SELECT * FROM users WHERE Username = '$Username' AND password = '$password'");
        $result = $result->fetch(PDO::FETCH_BOTH);


        if(!$result){
            header('Location: ../project3.php?error= Username password combination is wrong!');
            exit();
        } else{
            $_SESSION['user_id'] = $result['id'];
            $_SESSION['Username'] = $result['Username'];

            if($_SESSION['user_id'] == 1){
                header("Location: admins.php");
                exit();
            } else {
                header("Location: home.php");
                exit();
            }
        }

    }
?>