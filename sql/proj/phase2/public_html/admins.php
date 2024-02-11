<?php 
    session_start();
    include "dbconn.php";
    

if (isset($_SESSION['user_id']) && isset($_SESSION['Username'])) {
?>
    <!DOCTYPE html>
    <html>
        <head>
            <title>Administrator Menu</title>
            <h1>Administrator Menu</h1>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        </head>
        <style>
            h1{
                font-size:50px;
                text-align:center;
                padding-top:20px;
                padding-bottom:20px;
                color:#000066;
            }
            footer {
                background-color: #000066;
                padding: 10px;
                text-align: center;
                color: white;
            }
        </style>
            <body>
                <a href = "logout.php">Logout</a>

                <form>
                    <label>Which table do you want to edit, delete, or update?</label>
                    <select id = "table" onchange = "this.form.action = 'pages/' + this.value">
                        <option disabled selected value></option>
                        <option value = "Movies">Movies</option>
                        <option value = "Studios">Studios</option>
                        <option value = "Actors">Actors</option>
                        <option value = "Directors">Directors</option>
                        <option value = "Awarders">Awarders</option>
                        <option value = "Awards">Awards</option>
                    </select>

                    <button type = "submit" onclick="this.form.action = this.form.action + 'Create.php'">Create</button>
                    <button type = "submit" onclick="this.form.action = 'home.php'">Read</button>
                    <button type = "submit" onclick="this.form.action = this.form.action + 'Update.php'">Update</button>
                    <button type = "submit" onclick="this.form.action = this.form.action + 'Delete.php'">Delete</button>
                </form>

                <footer>
                    <p>Insert, Create, Delete, and View Tables using the options above.</p>
                </footer>
            </body>
        </html>
<?php
    } else{
        header("Location: index.php");
    }
?>