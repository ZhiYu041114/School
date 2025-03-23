<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="jakarta.tags.core" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>学生列表 - Tomcat 11</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f9f9f9;
        }
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<h2>学生列表</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>学号</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty studentList}">
            <tr>
                <td colspan="2">暂无学生数据</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="student" items="${studentList}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.num}</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
</body>
</html>