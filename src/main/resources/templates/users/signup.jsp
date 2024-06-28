<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <style>
        body {
            font-family: 'Inter', sans-serif;
            background-color: #f0f0f0;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }
        .card {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            margin: 20px;
        }
        .card-content {
            margin-bottom: 20px;
        }
        .label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }
        .input, .button, .header {
            width: 100%;
            box-sizing: border-box;
        }
        .input {
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .input:focus {
            border-color: #007BFF;
            outline: none;
        }
        .button {
            padding: 10px;
            background-color: #007BFF;
            border: none;
            border-radius: 4px;
            color: #fff;
            cursor: pointer;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .link {
            color: #007BFF;
            text-decoration: none;
        }
        .link:hover {
            text-decoration: underline;
        }
        .sign-up {
            text-align: center;
            color: #007BFF;
            text-decoration: none;
        }
        .sign-up:hover {
            text-decoration: underline;
        }
        .header {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border-radius: 5px;
            display: inline-block;
            font-size: 1.2em;
            text-align: center;
        }
        .header img {
            width: 70px;
            border: 1px solid black;
            border-radius: 20px;
            margin-right: 10px;
            vertical-align: middle;
        }
        .form-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .form-row .input {
            margin-bottom: 0;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        let jungbok = false;
        $(function() {
            $("#profile").change(function() {
                let reg = /(.*?)\/(jpg|jpeg|png|gif)$/;
                let f = $(this)[0].files[0];
                if (!f.type.match(reg)) {
                    alert("이미지 파일만 가능합니다");
                    return;
                }
                if (f) {
                    let reader = new FileReader();
                    reader.onload = function(e) {
                        $("#showimg").attr("src", e.target.result);
                    }
                    reader.readAsDataURL(f);
                }
            });

            // 중복 버튼 이벤트
            $("#btncheckid").click(function() {
                if ($("#id").val() == '') {
                    alert("가입할 아이디를 입력해주세요");
                    return;
                }

                $.ajax({
                    type: "get",
                    dataType: "json",
                    url: "/user/idcheck",
                    data: {"searchid": $("#id").val()},
                    success: function(data) {
                        if (data.count == 0) {
                            alert("가입 가능한 아이디입니다");
                            jungbok = true;
                        } else {
                            alert("이미 가입되어있는 아이디입니다");
                            jungbok = false;
                            $("#id").val("");
                        }
                    },
                    error: function(xhr, status, error) {
                        alert("서버와의 통신에 문제가 발생했습니다: " + error);
                        jungbok = false;
                    }
                });
            });

            // 아이디를 입력시 다시 중복확인을 누르도록 중복변수를 초기화
            $("#id").keyup(function() {
                jungbok = false;
            });
        });

        function check() {
            if (!jungbok) {
                alert("아이디 중복확인을 해주세요");
                return false; // false 반환 시 action 실행을 안함
            }
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirm_password').value;
            if (password !== confirmPassword) {
                alert('비밀번호가 일치하지 않습니다');
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-content text-center">
            <div class="header">
                <img src="../image/logo.png" alt="Logo">
                <b>Welcome to our KBO</b>
            </div>
            <h1 style="font-size: 2em; font-weight: bold; margin-top: 10px;">Sign Up</h1>
            <p style="color: #555;">Fill in the details below to create a new account.</p>
        </div>
        <form action="./insert" method="post" enctype="multipart/form-data" onsubmit="return check()">
            <div class="card-content">
                <label for="name" class="label">Name</label>
                <input type="text" id="name" name="name" placeholder="이름을 입력하세요" required class="input">
            </div>
            <div class="card-content">
                <label for="profile" class="label">Profile</label>
                <img src="https://via.placeholder.com/50" alt="Profile Image" id="showimg" style="width: 50px; height: 50px;">
                <div>
                    <input type="file" id="profile" name="profile">
                </div>
            </div>
            <div class="card-content">
                <label for="nickname" class="label">Nickname</label>
                <input type="text" id="nickname" name="nickname" placeholder="닉네임을 입력하세요" required class="input">
            </div>
            <div class="card-content">
                <label for="id" class="label">ID</label>
                <input type="text" id="id" name="userid" placeholder="아이디를 입력하세요" required class="input">
                <button type="button" class="button" id="btncheckid">중복 확인</button>
            </div>
            <div class="card-content">
                <label for="password" class="label">Password</label>
                <input type="password" id="password" name="userpw" placeholder="비밀번호를 입력하세요" required class="input">
            </div>
            <div class="card-content">
                <label for="confirm_password" class="label">Confirm Password</label>
                <input type="password" id="confirm_password" name="confirmpw" placeholder="비밀번호를 다시 입력하세요" required class="input">
            </div>
            <div class="card-content">
                <label for="hp" class="label">Contact Number</label>
                <input type="text" id="hp" name="hp" placeholder="연락처를 입력하세요" required class="input">
            </div>
            <div class="card-content">
                <label for="address" class="label">Address</label>
                <input type="text" id="address" name="address" placeholder="주소를 입력하세요" required class="input">
            </div>
            <div class="card-content">
                <label for="birth" class="label">Birth Date</label>
                <input type="date" id="birth" name="birth" required class="input">
            </div>
            <div class="card-content">
                <label for="email" class="label">Email</label>
                <input type="email" id="email" name="email" placeholder="이메일을 입력하세요" required class="input">
            </div>
            <div class="card-content">
                <button type="submit" class="button">Sign Up</button>
            </div>
        </form>
        <div class="card-content text-center">
            <p>Already have an account? <a href="/" class="sign-up">Sign in</a></p>
        </div>
    </div>
</div>
</body>
</html>
