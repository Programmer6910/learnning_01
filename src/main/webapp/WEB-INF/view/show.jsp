<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/4/14
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息展示</title>
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
</head>
<script type="text/javascript">
    window.onload=function(){
        document.getElementById("bt").onclick=click;
        function click(){
            console.log($("#user").text());
            $.ajax({
                url:"getInfor.do",
                data:{
                    name:$("#user").text()
            },
                dataType:"json",
                type:"post",
                success:function (resp){
                    console.log(resp);
                    $("#telePhone").text(resp.telePhone);
                }
            })
        }
    }

</script>
<body>
<form>
    <ul>
        <li>用户姓名:<span id="user">${userName}</span></li>
        <li><input type="button" id="bt" value="查询号码"></li>
        <li>手机号码：<span id="telePhone"></span></li>
    </ul>
</form>
</body>
</html>
