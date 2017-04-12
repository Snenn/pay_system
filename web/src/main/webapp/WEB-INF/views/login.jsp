<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles"   uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"     uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="e"       uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ include file="/resourses/include/begin-html.jsp" %>
<e:url value="/j_spring_security_check" var="loginUrl" />
<form class="form-horizontal" method="post"  action="${loginUrl}">

<fieldset>

<img src="../../resourses/images/logo.png" width="30%" style="margin-left: 35%; margin-top: 5%">

    </fieldset>
</form>
    <%@ include file="/resourses/include/end-html.jsp" %>
