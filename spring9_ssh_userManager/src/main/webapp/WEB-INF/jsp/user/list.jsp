<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/15
  Time: 上午12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user list</title>
</head>
<body>
<s:iterator value="#users">
    ${uid}--${username}<br/>
</s:iterator>
</body>
</html>
