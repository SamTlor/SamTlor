<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    </head>
<style>
main {
  margin: 0;
  padding: 5px;
  background-color: #000066;
  color: #FA9600;
}

main > h1, p, .browser {
  margin: 10px;
  padding: 5px;
}

.browser {
  background: #000066;
}

.browser > h2, p {
  margin: 4px;
  font-size: 90%;
}
</style>
    <form method="post" action="" name="signup-form">
        <link rel="stylesheet" href="style.css">
        <main>
        <h1>Enter the Awarder ID to Delete the Awarder</h2>
        <article class="browser">
        <div class="form-element">
        <label><b>Awarder ID</b></label>
        <input type="text" name="Awarders_ID" required />
        </div>
        </article>
        </main> 
        
    </form>
    
    <button type="submit" name="register" value="register">Delete Awarders</button>
    <button type="submit" onclick = "location.href = '../admins.php';">Admin Menu</button>
</html>

<?php
    include "../dbconn.php";
    if (isset($_POST['register'])) {
        $Awarders_ID = (int) $_POST['Awarders_ID'];

        $query = $conn -> prepare("SELECT * FROM Awarders WHERE Awarders_ID=:Awarders_ID");
        $query -> bindparam("Awarders_ID", $Awarders_ID, PDO::PARAM_STR);
        $query->execute();
        $result = $query->fetch(PDO::FETCH_ASSOC);
        
        if($result){
            $query = $conn->prepare("DELETE FROM Awarders WHERE Awarders_ID=:Awarders_ID");
            $query->bindParam("Awarders_ID", $Awarders_ID, PDO::PARAM_STR);
            $query->execute();
            echo "<p>Awarder sucessfully deleted</p>";
        }
        else {
            echo '<p class = "error">Awarder is not in the database</p>';
        }
    }

?>