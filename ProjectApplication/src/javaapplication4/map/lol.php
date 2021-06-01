<?php
$servername = "localhost:3306";
$username = "root";
$password = "";
$dbname = "site";


 function get_all_locations(){
    $con=mysqli_connect ("localhost:3306", 'root', '','site');
    if (!$con) {
        die('Not connected : ' . mysqli_connect_error());
    }
    // update location with location_status if admin location_status.
    $sqldata = mysqli_query($con,"
    SELECT * FROM `site`
  ");

    $rows = array();
    while($r = mysqli_fetch_assoc($sqldata)) {
        $rows[] = $r;

    }
  $indexed = array_map('array_values', $rows);
  //  $array = array_filter($indexed);

    echo json_encode($indexed);
    if (!$rows) {
        return null;
    }
}


?>