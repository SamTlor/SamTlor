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
</style>]

<form method="post" action="" name="signup-form">
    <link rel="stylesheet" href="style.css">
    <main>
        <h1>Enter the New Studio Information</h2>
        <article class="browser">
    <div class="form-element">
    <label><b>Studio's Founded Date</b></label>
    <input type="date" name="Studios_DateFounded" required />
    </div>
    <div class="form-element">
    <label><b>Studio's Trade Name</b></label>
    <input type="text" name="Studios_TradeName" required />
    </div>
    </article>
        </main> 
</form>

<button type="submit" name="register" value="register">Insert Studio</button>
<button type="submit" onclick = "location.href = '../admins.php';">Admin Menu</button>

</html>

<?php
    include "../dbconn.php";


    if (isset($_POST['register'])) {
        $Studios_DateFounded = $_POST['Studios_DateFounded'];
        $Studios_TradeName = $_POST['Studios_TradeName'];
        $query = $conn->prepare("SELECT * FROM Studios WHERE Studios_ID=:Studios_ID");
        $query->bindParam("Studios_ID", $Studios_ID, PDO::PARAM_STR);
        $query->execute();
        if ($query->rowCount() > 0) {
            echo '<p class="error">This studio is already in the database</p>';
        }
        if ($query->rowCount() == 0) {
            $query = $conn->prepare("INSERT INTO Studios( Studios_DateFounded, Studios_TradeName)Values (:Studios_DateFounded, :Studios_TradeName)");
            $query->bindParam("Studios_DateFounded", $Studios_DateFounded, PDO::PARAM_STR);
            $query->bindParam("Studios_TradeName", $Studios_TradeName, PDO::PARAM_STR);  
            $result = $query->execute();
            if ($result) {
                header("Location: ../admins.php");
            } else {
                echo '<p class="error">Error, Engineers will check it out</p>';
            }
        }
    }
?>