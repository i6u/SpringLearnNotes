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
        body {
            margin:0;
            padding: 10px;
        }
        a{
            text-decoration: none;
        }

    </style>
</head>
<body>
<div class="div1">
    <table border="0px" width="80%">
        <tr>
            <td>gid</td>
            <td>group name</td>
            <td>options</td>
        </tr>
        <s:iterator value="#groups.datas">
            <tr >
            <td>${gid}</td>
            <td>${groupName}<br/></td>
            <td><a href="group_del.do?group.gid=${gid}"> 删除</a></td>
            </tr>
        </s:iterator>
    </table>


    <br/>
    <jsp:include page="/inc/pager.jsp">
        <jsp:param value="group_list.action" name="url"/>
        <jsp:param value="${groups.totalRecord}" name="items"/>
        <jsp:param value="${groups.pagerSize}" name="pageSize"/>
    </jsp:include>
    <button onclick="location='group_addInput.do'">添加</button>
</div>
</body>
</html>
