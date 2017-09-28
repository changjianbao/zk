<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询数据</title>
</head>
<body>
<hr>
<table border="1" cellpadding="0" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>年龄</th>
        <th>姓名</th>
    </tr>
    <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.age}</td>
            <td>${l.name}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>