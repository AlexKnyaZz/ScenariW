<?php
$servername = "localhost";
$username = "alexknyazz"; // Ваш логин для доступа к базе данных
$password = "myDiplom01"; // Ваш пароль для доступа к базе данных
$dbname = "alexknyazz"; // Имя вашей базы данных

// Создаем подключение к базе данных
$conn = new mysqli($servername, $username, $password, $dbname);

// Проверяем подключение
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Получаем данные из POST-запроса
$login = $_POST['login'];
$password = $_POST['password'];

// Подготавливаем запрос для вставки данных в таблицу users
$sql = "INSERT INTO Users (login, password) VALUES ('$login', '$password')";

// Выполняем запрос
if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>