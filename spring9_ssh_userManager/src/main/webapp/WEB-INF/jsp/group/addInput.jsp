<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/15
  Time: 下午11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>group add</title>
</head>
<body>
<h2>add group</h2>
<s:form action="group_add" method="post">
    <s:label value="组名称:"/>
    <s:textfield name="group.groupName"/>
    <s:submit label="添加组"/>
</s:form>

</body>
</html>
