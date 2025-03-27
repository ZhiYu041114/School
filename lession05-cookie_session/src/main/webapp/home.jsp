<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%-- 引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>商品列表</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center; /* 使内容居中 */
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        .book-list {
            width: 100%;
            max-width: 600px; /* 限制商品列表的最大宽度 */
        }
        .book-item {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 15px;
            margin-bottom: 10px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center; /* 使内容居中 */
        }
        .book-item h3 {
            margin: 0 0 10px;
            color: #555;
        }
        .book-item form {
            display: inline-block;
        }
        .book-item input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 8px 16px;
            border-radius: 3px;
            cursor: pointer;
            font-size: 14px;
        }
        .book-item input[type="submit"]:hover {
            background-color: #218838;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
            font-size: 16px;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>商品列表</h1>
<div class="book-list">
    <%-- 遍历书籍列表 --%>
    <c:forEach items="${books}" var="book">
        <div class="book-item">
            <h3>${book.name} - ${book.price}元</h3>
                <%-- 加入购物车表单 --%>
            <form action="books?action=add" method="post">
                <input type="hidden" name="id" value="${book.id}">
                <input type="submit" value="加入购物车">
            </form>
        </div>
    </c:forEach>
</div>
<%-- 查看购物车链接 --%>
<a href="${pageContext.request.contextPath}/cart">查看购物车</a>
</body>
</html>
