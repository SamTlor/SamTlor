<table>
    <?php
        include "dbconn.php";
        $dbs = $conn -> query( $query );

        echo "<tr>";
        for ($i = 0; $i < $dbs -> columnCount(); $i++) {
            echo "<th>" . $dbs -> getColumnMeta($i)['name'] . "</th>";
        }
        echo "</tr>";

        while( $row = $dbs -> fetch(PDO :: FETCH_BOTH) ){
            echo "<tr>";
            $count = count($row) / 2;
            for($i = 0; $i < $count; $i++){
                echo "<td>" . $row[$i] . "</td>";
            }
            echo "</tr>";
        }
    ?>
</table>