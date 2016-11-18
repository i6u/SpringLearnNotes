<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/16
  Time: 上午9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>add user</title>
</head>
<body>
<s:if test="#user == null">
    <h1>add user</h1>
    <s:form action="user_add.do" method="POST">
        <s:textfield label="用户名" name="user.username"/>
        <s:fielderror name="username"/>
        <s:select list="#groups" listKey="gid" listValue="groupName" name="user.group.gid" label="选择组"/>
        <s:submit value="提交"/>
    </s:form>
</s:if>
<s:else>
    <h1>update user</h1>
    <s:form action="user_update.do" method="POST">
        `${old.username}`
        <s:textfield label="用户名" name="old.username"/>
        <s:fielderror name="username"/>
        <s:select list="#groups" listKey="gid" listValue="groupName" name="user.group.gid" label="选择组"/>
        <s:submit value="提交"/>
    </s:form>
</s:else>
</body>
</html>
