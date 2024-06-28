<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sports Page</title>
    <style>
        body {
            font-family: 'Inter', sans-serif;
            margin: 0;
            padding: 0;
            display: grid;
            grid-template-rows: 60px auto 1fr;
            grid-template-columns: 300px 1fr 200px; /* info 부분의 너비를 두 배로 키움 */
            grid-template-areas:
                "header header header"
                "menu menu menu"
                "info main side";
            height: 100vh;
            gap: 10px; /* 간격을 추가하여 겹침 방지 */
        }

        header {
            grid-area: header;
            background-color: #007BFF;
            color: white;
            text-align: center;
            padding: 15px;
            font-size: 1.5em;
        }

        nav {
            grid-area: menu;
            background-color: #333;
            color: white;
            padding: 0;
            box-sizing: border-box;
        }

        .info {
            grid-area: info;
            background-color: #e0e0e0;
            overflow-y: auto;
            padding: 15px;
            box-sizing: border-box;
        }

        main {
            grid-area: main;
            overflow-y: auto;
            padding: 15px;
            box-sizing: border-box;
        }

        .sidebar {
            grid-area: side;
            background-color: #f0f0f0;
            border-left: 1px solid #ccc;
            overflow-y: auto;
            padding: 15px;
            box-sizing: border-box;
        }

        iframe {
            width: 100%;
            height: 100%;
            border: none;
        }

        @media (max-width: 1024px) {
            body {
                grid-template-columns: 150px 1fr 150px;
            }
        }

        @media (max-width: 768px) {
            body {
                grid-template-columns: 1fr;
                grid-template-rows: 60px auto auto auto 1fr;
                grid-template-areas:
                    "header"
                    "menu"
                    "info"
                    "main"
                    "side";
            }
            nav {
                border-right: none;
                border-bottom: 1px solid #ccc;
            }
            .sidebar {
                border-left: none;
                border-top: 1px solid #ccc;
            }
        }
    </style>
</head>
<body>
<header>
    <iframe src="/header"></iframe>
</header>
<nav>
    <iframe src="/menu"></iframe>
</nav>
<div class="info">
    <iframe src="/info"></iframe>
</div>
<main>
    <iframe src="/main"></iframe>
</main>
<div class="sidebar">
    <iframe src="/side"></iframe>
</div>
</body>
</html>
