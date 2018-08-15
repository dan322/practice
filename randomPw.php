<?php
	$text = "qwertyuiopasdfghjklzxcvbnm ";
	$text_up = 'QAZWSXEDCRFVTGBYHNUJMIKOLP ';
	$len = strlen($text)+1;
	$num = [];
	$total = ceil(rand(1, 3));
	for ($i = 0; $i< $total;$i++) {
		array_push($num, ceil(rand(1, $len)));
	}
	$other = 3 - $total;
	if (!$other) {
		echo implode(' ', $num) . "\n";
		exit;
	}
	array_push($num, '!');
	for ($i=0; $i< $other; $i++) {
		array_push($num, ceil(rand(1, $len)));
	}
	echo implode(' ', $num) . "\n";
?>
