<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%-- 声明核心标签库 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- 引入Bootstrap CSS --%>
<link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">

<html>
<head>
    <title>购物车 - 在线书店</title>
    <style>
        /* 自定义容器样式 */
        .cart-container {
            max-width: 800px;
            margin: 2rem auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        /* 书籍项样式 */
        .book-item {
            padding: 1rem;
            border-bottom: 1px solid #eee;
            transition: background 0.3s;
        }
        .book-item:hover {
            background: #f8f9fa;
        }
    </style>
</head>
<body class="bg-light">
<%-- 购物车主容器 --%>
<div class="cart-container">
    <%-- 标题部分 --%>
    <h1 class="mb-4 text-center">
        <svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="currentColor" class="bi bi-cart3" viewBox="0 0 16 16">
            <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
        </svg>
        我的购物车
    </h1>

    <%-- 空购物车提示 --%>
    <c:if test="${empty cart}">
        <div class="alert alert-info text-center">
            购物车空空如也，<a href="/books" class="alert-link">去选购商品</a>
        </div>
    </c:if>

    <%-- 书籍列表 --%>
    <c:if test="${not empty cart}">
        <div class="list-group">
            <c:forEach items="${cart}" var="book">
                <%-- 单个书籍项 --%>
                <div class="book-item list-group-item">
                    <div class="d-flex justify-content-between align-items-center">
                        <div>
                            <h5 class="mb-1">${book.name}</h5>
                            <small class="text-muted">图书名称</small>
                        </div>
                        <span class="badge bg-primary rounded-pill">￥${book.price}</span>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>

<%-- 引入Bootstrap JS --%>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>