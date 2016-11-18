<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 2016/11/17
  Time: 上午1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .pg{
        color: #ffffff;
        border-radius: 5px;
        margin: 5px;
        padding: 5px;
        background: #637dec;
        width: 50px;
        border: 1px solid #ffffff;
        text-align: center;
        align-items:center;
    }
</style>
<pg:pager items="${param.items }" export="curPage=pageNumber" url="${param.url }" maxPageItems="${param.pageSize}">
    <c:forEach items="${param.params }" var="p">
        abs
        ${p }
        <pg:param name="${p }"/>
    </c:forEach>
    <pg:last>
        共${param.items }记录,共${pageNumber }页,
    </pg:last>
    当前第${curPage }页
    <pg:first>
        <a class="pg" href="${pageUrl }">首页</a>
    </pg:first>
    <pg:prev>
        <a class="pg" href="${pageUrl }">上一页</a>
    </pg:prev>
    <pg:pages>
        <c:if test="${curPage eq pageNumber }">
            <a class="pg1">${pageNumber }</a>
        </c:if>
        <c:if test="${curPage ne pageNumber }">
            <a class="pg" href="${pageUrl }">${pageNumber }</a>
        </c:if>
    </pg:pages>
    <pg:next>
        <a class="pg" href="${pageUrl }">下一页</a>
    </pg:next>
    <pg:last>
        <a class="pg" href="${pageUrl }">尾页</a>
    </pg:last>
</pg:pager>
