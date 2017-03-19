<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作失败</title>
</head>
<body>
<br/>
<p>${message}</p>
<br/>
<p>　　<span id="time">5</span> 秒</p>
</body>
</html>
<script>
    var count=5;
    window.setInterval(hello,1000);
    function hello() {
        if (count==0){
            window.location.href="${pageContext.request.contextPath}/login";
        }
        var time=document.getElementById("time");
        time.innerHTML=count;
        count--;
    }
</script>
