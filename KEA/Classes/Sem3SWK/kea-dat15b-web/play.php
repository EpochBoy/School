<h1>This is h1 in html.</h1>

<?php
/*
echo 'Hello world!';
$x = 5;
echo $x;
$x = "Alice";
echo $x;
$name = "Alice" . " Bob";
echo "<br>" . $name;

echo "3alice" * 5;//80


$name1 = "Alice";
$name2 = 'Alice';
$price = 100;

echo 'The name is $price=' . $price . '$.';
echo "The name is\n \$price=$price \$.";


if(3>5){
    echo 'YES';
}else{
    echo 'NO';
}


if(2>3){
    echo "YES 1";
}elseif(3==="3"){
    echo "YES 3==3";
} else{
    echo "NO";
}
$num = 7;

switch ($num){
    case 7: echo "yes 7 is the num";
        break;
    default: echo "nice";
}
*/
echo "love this shit<br>";
/*
$a = array();

$v1=(true AND false);
$v2=(true OR false);
$v3=(true and false);
$v4=(true or false);
$v5=(TRUE or FALSE);
$v6=(TRUE && FALSE);
$v7=(TRUE || FALSE);
$v8=(TRUE & FALSE);
$v9=(TRUE | FALSE);

$a['true AND false'] = $v1;
$a['true OR false'] = $v2;
$a['true and false'] = $v3;
$a['true or false'] = $v4;
$a['TRUE or FALSE'] = $v5;
$a['TRUE && FALSE'] = $v6;
$a['TRUE || FALSE'] = $v7;
$a['TRUE & FALSE'] = $v8;
$a['TRUE | FALSE'] = $v9;

var_dump($a);


$b =  array(0, 2, 3);
for($i=0; $i<count($b); $i++){
    echo "$b[$i]<br>";
}

$c =  array(
    'a'=>0,
    'b'=>2,
    'c'=>3,
    0=>'alice'
);

foreach ($c as $key){
    echo "$key<br>";
}
*/
/*
$b =  array(0, 2, 3);
foreach($b as $val){
    echo "$val<br>";
}



$arr = array(
    'a'=>array(
        'x'=>1,
        'y'=>2,
        'z'=>3,
    ),
    'b'=>array(
        'aa'=>10,
        'bb'=>20,
        'cc'=>30,
    ),
    'c'=>array(
        'xx'=>11,
        'yy'=>22,
        'zz'=>33,
    )
);

$salary = 0;
foreach ($arr as $depart){
    foreach ($depart as $money){
        $salary += $money;
    }
}
echo "Total is $salary";
*/



/*
global $country;
const country="DK";
function methodSmth($name){
    global $country;
    $country= country;
    echo "Hi $name. And I am from $country.";
}

methodSmth("alice");
echo $country;
*/

var_dump($_POST);
$name = $_POST['navn'];
$country = $_POST['land'];
$pass = $_POST['pass'];
//echo $pass;
if($pass=="123"){
    methodSmth($name, $country);
} else{
    echo "Not allowed here.";
}

function methodSmth($name, $country){
    echo "Hi $name. And I am from $country.";
}
?>