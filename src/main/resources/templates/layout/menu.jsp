<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
    <style>
        body {
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
            display: flex;
            justify-content: space-around;
            align-items: center;
            padding: 0;
            list-style: none;
        }
        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .dropdown {
            position: relative;
            display: inline-block;
        }
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }
        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }
        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body>
<ul class="navbar">
    <li><a href="/home">Home</a></li>
    <li class="dropdown">
        <a href="javascript:void(0)" class="dropbtn">Records</a>
        <div class="dropdown-content">
            <a href="/schedule">일정 결과</a>
            <a href="/rank">기록 순위</a>
            <a href="/players">선수 순위</a>
        </div>
    </li>
    <li><a href="/games">경기일정 결과</a></li>
    <li><a href="/center">게임센터</a></li>
    <li><a href="/scoreboard">스코어보드</a></li>
    <li><a href="/tournaments">국제대회</a></li>
    <li><a href="/weather">야구장 날씨</a></li>
</ul>
</body>
</html>

