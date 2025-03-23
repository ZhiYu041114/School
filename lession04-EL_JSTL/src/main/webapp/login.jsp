<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>  <!-- 建议使用更有意义的标题 -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 50px;
            margin: 0;  /* 添加：移除默认边距 */
        }
        .login-container {
            width: 300px;
            margin: 0 auto;  /* 改进：更标准的居中写法 */
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 5px;  /* 建议：添加圆角提升美观度 */
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;  /* 建议：添加文字颜色 */
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            box-sizing: border-box;  /* 添加：确保宽度计算包含padding */
        }
        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #5fbae9;
            border: none;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;  /* 建议：添加过渡效果 */
        }
        .login-container input[type="submit"]:hover {
            background-color: #4a9ad4;
        }
        .login-container label {
            margin-left: 5px;
            display: block;  /* 建议：使label独占一行 */
        }
        .error-msg {
            color: red;
            display: block;
            text-align: center;
            margin-bottom: 10px;
        }
        .register-link {
            display: block;
            text-align: center;
            margin-top: 10px;
            color: #5fbae9;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>登录</h2>
    <!-- 改进消息显示 -->
    <c:if test="${not empty msg}">
        <span class="error-msg">${msg}</span>
    </c:if>
    <form action="login" method="post">
        <label for="username">用户名:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">密码:</label>
        <input type="password" id="password" name="password" required>

        <label>
            <input type="checkbox" name="rememberMe" value="yes"> 记住我
        </label>

        <input type="submit" value="登录">
        <a class="register-link" href="register">没有账号？注册</a>  <!-- 添加注册页面链接 -->
    </form>
</div>
</body>
</html>