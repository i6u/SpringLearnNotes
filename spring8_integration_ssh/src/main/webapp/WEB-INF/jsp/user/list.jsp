<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/13
  Time: 下午6:55
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
    ${id }--${username}--${password}--${nickname}--${group} <br/>
</s:iterator>
</body>
</html>
