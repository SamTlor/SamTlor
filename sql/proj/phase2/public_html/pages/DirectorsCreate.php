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
        <h1>Enter the New Director Information</h2>
        <article class="browser">
    <div class="form-element">
    <label><b>Director's Date of Birth</b></label>
    <input type="date" name="Directors_DateofBirth" required />
    </div>
    <div class="form-element">
    <label><b>Director's Nationality</b></label>
    <input type="text" name="Directors_Nationality" required />
    </div>
    <div class="form-element">
    <label><b>Director's LegalName</b></label>
    <input type="text" name="Directors_LegalName" required />
    </div>
    </article>
    </main> 
</form>

<button type="submit" name="register" value="register">Insert Director</button>
<button type="submit" onclick = "location.href = '../admins.php';">Admin Menu</button>

</html>

<?php
    include "../dbconn.php";

    if (isset($_POST['register'])) {
        $Directors_DateofBirth = $_POST['Directors_DateofBirth'];
        $Directors_Nationality = $_POST['Directors_Nationality'];
        $Directors_LegalName = $_POST['Directors_LegalName'];
        $query = $conn->prepare("SELECT * FROM Directors WHERE Directors_ID=:Directors_ID");
        $query->bindParam("Directors_ID", $Directors_ID, PDO::PARAM_STR);
        $query->execute();
        if ($query->rowCount() > 0) {
            echo '<p class="error">This director is already in the database</p>';
        }
        if ($query->rowCount() == 0) {
            $query = $conn->prepare("INSERT INTO Directors( Directors_DateofBirth, Directors_Nationality, Directors_LegalName)Values (:Directors_DateofBirth, :Directors_Nationality, :Directors_LegalName)");
            $query->bindParam("Directors_DateofBirth", $Directors_DateofBirth, PDO::PARAM_STR);
            $query->bindParam("Directors_Nationality", $Directors_Nationality, PDO::PARAM_STR);  
            $query->bindParam("Directors_LegalName", $Directors_LegalName, PDO::PARAM_STR);
            $result = $query->execute();
            if ($result) {
                header("Location: ../admins.php");
            } else {
                echo '<p class="error">Error, Engineers will check it out</p>';
            }
        }
    }
?>