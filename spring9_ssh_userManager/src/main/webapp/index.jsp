<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<h2>Hello World!</h2>
<s:if test="#user != null">
    ${user}
</s:if>
</body>
</html>
