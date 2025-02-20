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
    <h1>Enter the New Movie Information</h2>
<article class="browser">
    <div class="form-element">
    <label><b>Movie FilmName</b></label>
    <input type="text" name="Movies_FilmName" required />
    </div>
    <div class="form-element">
    <label><b>Movie Genre</b></label>
    <input type="text" name="Movies_Genre" required />
    </div>
    <div class="form-element">
    <label><b>Movie Gross</b></label>
    <input type="text" name="Movies_Gross" required />
    </div>
    <div class="form-element">
    <label><b>Movie Budget</b></label>
    <input type="text" name="Movies_Budget" required />
    </div>
</article>
</main>
</form>

<button type="submit" name="register" value="register">Insert Movie</button>
<button type="submit" onclick = "location.href = '../admins.php';">Admin Menu</button>
</html>

<?php
    include "../dbconn.php";

    if (isset($_POST['register'])) {
        $Movies_FilmName = $_POST['Movies_FilmName'];
        $Movies_Genre = $_POST['Movies_Genre'];
        $Movies_Gross = (int) $_POST['Movies_Gross'];
        $Movies_Budget = (int) $_POST['Movies_Budget'];

        $query = $conn->prepare("SELECT * FROM Movies WHERE Movies_ID=:Movies_ID");
        $query->bindParam("Movies_ID", $Movies_ID, PDO::PARAM_STR);
        $query->execute();

        if ($query->rowCount() > 0) {
            echo '<p class="error">This movie is already in the database</p>';
        }
        if ($query->rowCount() == 0) {
            $query = $conn->prepare("INSERT INTO Movies( Movies_FilmName, Movies_Genre, Movies_Gross, Movies_Budget)Values (:Movies_FilmName, :Movies_Genre, :Movies_Gross, :Movies_Budget)");
            
            $query->bindParam("Movies_FilmName", $Movies_FilmName, PDO::PARAM_STR);
            $query->bindParam("Movies_Genre", $Movies_Genre, PDO::PARAM_STR);
            $query->bindParam("Movies_Gross", $Movies_Gross, PDO::PARAM_INT);
            $query->bindParam("Movies_Budget", $Movies_Budget, PDO::PARAM_INT);
            $result = $query->execute();
            
            if ($result) {
                header("Location: ../admins.php");
            } else {
                echo '<p class="error">Error, Engineers will check it out</p>';
            }
        }
    }
?>