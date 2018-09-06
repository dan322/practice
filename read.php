<?php
$file = '/home/ann/1.csv';
$arr = [];
if (($handle = fopen($file, "r")) !== FALSE) {
    while (($data = fgetcsv($handle)) !== FALSE) {
       array_push($arr, $data[0]);
    }
    fclose($handle);
}
echo "(" . implode(', ', $arr) . ")\r\n";
?>
