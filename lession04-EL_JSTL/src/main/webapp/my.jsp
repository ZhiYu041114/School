<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="jakarta.tags.core" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>用户信息展示 - Tomcat 11</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            line-height: 1.6;
            background-color: #f9f9f9;
        }
        .section {
            margin-bottom: 20px;
            padding: 15px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
        }
        .label {
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>
<div class="section">
    <h3>使用JSP表达式：</h3>
    <span class="label">用户名:</span>
    <%= request.getAttribute("username") != null ? request.getAttribute("username") : "未设置" %><br>
    <span class="label">密码:</span>
    <%= request.getAttribute("password") != null ? request.getAttribute("password") : "未设置" %><br>
</div>

<div class="section">
    <h3>使用EL表达式:</h3>
    <span class="label">用户名:</span> ${empty username ? '未设置' : username}<br>
    <span class="label">密码:</span> ${empty password ? '未设置' : password}<br>
</div>

<div class="section">
    <h3>stu对象:</h3>
    <c:choose>
        <c:when test="${empty s}">
            <span>学生对象未设置</span>
        </c:when>
        <c:otherwise>
            <span class="label">ID:</span> ${s.id}<br>
            <span class="label">学号:</span> ${s.num}<br>
            <span class="label">姓名:</span> ${s.name}<br>
        </c:otherwise>
    </c:choose>
</div>

<div class="section">
    <h3>empty 判空:</h3>
    <span class="label">a是否为空:</span> ${empty a}<br>
    <span class="label">b是否为空:</span> ${empty b}<br>
</div>
</body>
</html>