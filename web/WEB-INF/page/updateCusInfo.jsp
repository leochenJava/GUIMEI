<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <form action="/customer/doUpdateById">
       <label>编号</label>
       <input type="text" name="id" readonly value="${cus.id}"/><br>
        <label>姓名</label>
       <input type="text" name="cusName"  value="${cus.cusName}"/><br>
        <label>昵称</label>
       <input type="text" name="id" readonly value="${cus.cusLoginName}"/><br>
        <label>请输入原密码</label>
       <input type="text" name="ocusPwd"  value="" onchange="change()"/><br>
       <label>请输入新密码</label>
       <input type="text" name="cusPassword"  readonly value=""/><br>
       <input type="submit" value="提交">
   </form>
</body>
<script type="text/javascript">
    function change() {
        var oldPwd = document.getElementsByName("ocusPwd")[0].value;
        alert(oldPwd)
        var pwd = ${cus.cusPassword}
        if(oldPwd==pwd){
            document.getElementsByName("cusPassword")[0].removeAttribute("readonly");
        }
    }
</script>
</html>
