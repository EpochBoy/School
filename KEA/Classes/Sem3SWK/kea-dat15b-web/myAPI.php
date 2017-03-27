<?php
/**
 * Created by PhpStorm.
 * User: coag
 * Date: 24-10-2016
 * Time: 08:34
 */
//require_once 'myLogger.php';

$method = $_SERVER['REQUEST_METHOD'];

if ($method != "GET") {
    echo '{
        "code":"400",
        "msg":"This API will only responde to GET requests"
    }';
    die;
}

if ((!isset($_GET['roomId'])) ||
    (strlen(trim($_GET['roomId'])) == 0)
) {
    echo '{
        "code":"400",
        "msg":"roomId param is missing."
    }';
    die;
}

$roomId = $_GET['roomId'];
$temp = rand(-5, 39);
$units = "C";

echo '{
        "code":"200",
        "msg":"roomId ok I will send you the temp now.",
        "roomId":"' . $roomId . '",
        "temp":"' . $temp . '",
        "units":"' . $units . '"
    }';






