<%--
  Created by IntelliJ IDEA.
  User: 35140
  Date: 2025/3/31
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Title</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<h2>AJAX请求演示</h2>

<button onclick="sendGet()">点击发送GET请求</button>
<button onclick="sendPost()">点击发送POST请求</button>
<button onclick="sendPut()">点击发送PUT请求</button>
<button onclick="sendDelete()">点击发送DELETE请求</button>
<div id="result"></div>
<script>

    function sendGet() {
        $.ajax({
            url: 'test',
            type: 'GET',
            data: {
                id: 1,
                name: 'zhangsan'
            },
            success: function (data) {
                $('#result').html(data);
            }
        });
    }


    function sendPost() {
        $.ajax({
            url: 'test',
            type: 'POST',
            success: function (data) {
                $('#result').html(data);
            }
        });
    }


    function sendPut() {
        $.ajax({
            url: 'test',
            type: 'PUT',
            success: function (data) {
                $('#result').html(data);
            }
        });
    }


    function sendDelete() {
        $.ajax({
            url: 'test',
            type: 'DELETE',
            success: function (data) {
                $('#result').html(data);
            }
        });
    }

</script>
</body>
</html>