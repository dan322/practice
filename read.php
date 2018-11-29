<?php
$file = '/home/ann/1.csv';
$arr = [];
if (($handle = fopen($file, "r")) !== FALSE) {
    while (($data = fgetcsv($handle)) !== FALSE) {
       //array_push($arr, $data[0]);
       array_push($arr, '("'.$data[0] .'", "'.$data[1] .'", 1541669082, {"imei":"If new IMEI is not existing","SO_NUMBER":"If new IMEI is not existing"}, {"code":"221","MESSAGE":"If new IMEI is not existing in Ibase,The field new SN is mandatory."}');
    }
    fclose($handle);
}
echo "(" . implode(', ', $arr) . ")\r\n";
?>
