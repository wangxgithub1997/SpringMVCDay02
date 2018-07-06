<%--
  Created by IntelliJ IDEA.
  User: weidong
  Date: 2018/6/25
  Time: 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js">
    </script>
    <script type="text/javascript">
        function requestDao() {
            $.ajax({
                url: "${pageContext.request.contextPath }/addUser?id=1",
                type: "get",
                success: function (data) {
                    if (data != null) {
                        alert(data);
                    }
                }
            });
        }
    </script>

</head>
<body>
<h1>所有的演示例子</h1>

<h3><a href="/exception?id=1">Controller系统业务错误1</a></h3>
<h3><a href="/exception?id=2">Controller参数错误2</a></h3>

<h3><a href="/exception?id=3">Service业务错误3</a></h3>
<h3><a href="/exception?id=4">Service参数错误4</a></h3>

<h3><a href="/exception?id=5">Dao业务错误5</a></h3>
<h3><a href="/exception?id=6">Dao参数错误6</a></h3>

<h3><a href="/exception?id=7">Controller未知异常</a></h3>



<%--ajax--%>
<button onclick="requestDao()">ajax</button>

</body>
</html>
