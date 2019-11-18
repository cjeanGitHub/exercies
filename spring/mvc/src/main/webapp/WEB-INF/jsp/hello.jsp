<html>
<%@page isELIgnored="false" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<body>
<h2>Hello World JSP*****!</h2>


<h1>*******${6+9}*********</h1>
hello,${msg2}




<h1>*******${msg}*********</h1>
<h1>*******${msg2}*********</h1>

<h1>**************</h1>

<h1>*******<%=request.getAttribute("msg")%>*********</h1>
<h1>*******<%=request.getAttribute("msg2")%>*********</h1>
</body>
</html>
