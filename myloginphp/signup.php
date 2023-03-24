
<?php

$con=new mysqli("localhost","root","","signupdb");
$st_check=$con->prepare("select * from users where mobile=?");
$st_check->bind_param("s", $_GET["mobile"]);
$st_check->execute();
$rs=$st_check->get_result();
if($rs->num_rows==0)
{
$st=$con->prepare("insert into users values(?,?,?,?)");
$st->bind_param("ssss", $_GET["name"],$_GET["email"],$_GET["mobile"],$_GET["password"]);
$st->execute();
 echo "successful!";
}
else
 echo "User already exists!";
?>
