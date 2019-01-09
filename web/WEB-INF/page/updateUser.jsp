<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 2019/1/3
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/supperUser/updateUser" method="post"><br>
    昵称:<input type="text" name="userName" value="${user.userName}"><br>
    请输入原密码:<input type="text" name="ouserPassword" value="" onchange="change()"><br>
    请输入新密码: <input type="text" name="userPassword" value="" readonly><br>

    <input type="submit" value="提交">
</form>
</body>
<script type="text/javascript">
    function change() {
        var newPwd = document.getElementsByName("ouserPassword")[0].value;
        alert(newPwd)
        var oldPwd = ${user.userPassword}
        if (newPwd == oldPwd ){
            document.getElementsByName("userPassword")[0].removeAttribute("readonly")
        }
    }

</script>
</html>
