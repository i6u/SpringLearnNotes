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
    <style type="text/css">
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<table border="0px" width="80%" align="center" height="70%">
    <tr>
    <td>uid</td>
    <td>username</td>
    <td>phone</td>
    <td>city</td>
    <td>email</td>
    <td>classroom</td>
    <td>backup</td>
    </tr>
    <s:iterator value="#users.datas">
        <tr height="30px">
        <td>${uid}</td>
        <td>${username}</td>
        <td>${phone}</td>
        <td>${city}</td>
        <td>${email}</td>
        <td>${group.groupName}</td>
        <td><a href="user_del.do?user.uid=${uid}&nowPage=${users.getPagerOffset()}">删除</a></td>
    </tr>

    </s:iterator>
    ${users.getPagerOffset()}
    <tr>
        <td colspan="7">
            <jsp:include page="/inc/pager.jsp">
                <jsp:param value="user_list.action" name="url"/>
                <jsp:param value="${users.totalRecord}" name="items"/>
                <jsp:param value="${users.pagerSize}" name="pageSize"/>
            </jsp:include>
        </td>
    </tr>
</table>



</body>
</html>
