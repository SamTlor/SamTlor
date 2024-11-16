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
        <h1>Enter Information to Update Chosen Actor</h2>
        <article class="browser">
        <div class = "form-element">
            <label><b>Actor ID</b></label>
            <input type = "text" name="Actors_ID" required />
        </div>
        <div class="form-element">
            <label><b>Actor's DateofBirth</b></label>
            <input type="date" name="Actors_DateofBirth" required />
        </div>
            <div class="form-element">
            <label><b>Actor's Nationality</b></label>
            <input type="text" name="Actors_Nationality" required />
        </div>
        </div>
            <div class="form-element">
            <label><b>Actor's LegalName</b></label>
            <input type="text" name="Actors_LegalName" required />
        </div>
        </article>
        </main>  
    </form>

    <button type="submit" name="register" value="register">Update Actor</button>
    <button type="submit" onclick = "location.href = '../admins.php';">Admin Menu</button>
</html>


<?php
    include "../dbconn.php";

    if (isset($_POST['register'])) {
        $Actors_ID = (int) $_POST['Actors_ID'];
        $Actors_DateofBirth = $_POST['Actors_DateofBirth'];
        $Actors_Nationality = $_POST['Actors_Nationality'];
        $Actors_LegalName = $_POST['Actors_LegalName'];

        $query = $conn->prepare("SELECT * FROM Actors WHERE Actors_ID=:Actors_ID");
        $query->bindparam("Actors_ID", $Actors_ID, PDO::PARAM_STR);
        $query->execute();
        $result = $query->fetch(PDO::FETCH_ASSOC);

        if ($result) {
            $query = $conn->prepare("UPDATE Actors SET Actors_DateofBirth = :Actors_DateofBirth, Actors_Nationality = :Actors_Nationality, Actors_LegalName = :Actors_LegalName WHERE Actors_ID = :Actors_ID");
           
            $query->bindParam("Actors_DateofBirth", $Actors_DateofBirth, PDO::PARAM_STR);
            $query->bindParam("Actors_Nationality", $Actors_Nationality, PDO::PARAM_STR);
            $query->bindParam("Actors_LegalName", $Actors_LegalName, PDO::PARAM_STR);
            $query->bindParam("Actors_ID", $Actors_ID, PDO::PARAM_STR);
            $query->execute();
           
            echo "<p>Actor Updated</p>";
        } else{
            echo "<p class = 'error'>Actor not in database</p>";
        }
    }
?>