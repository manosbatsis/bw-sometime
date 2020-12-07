<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License. You may obtain a
    copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on
    an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied. See the License for the
    specific language governing permissions and limitations
    under the License.

--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="../includes.jsp" %>
<%-- 
  Copyright 2008-2010 The Board of Regents of the University of Wisconsin System.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
--%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title><spring:message code="application.name"/> - <spring:message code="resource.search"/></title>
<%@ include file="../themes/jasig/head-elements.jsp" %>
</head>

<body>
<%@ include file="../themes/jasig/body-start.jsp" %>
<%@ include file="../login-info.jsp" %>
<div id="content" class="main col">
<div id="status">
<p><spring:message code="search.results.for"/>&nbsp;<i><c:out value="${searchText}"/></i></p>

<ul>
<c:forEach items="${results}" var="delegate">
<li><c:out value="${delegate.displayName}"/>
<form action="<c:url value="/delegate_switch_user"/>" method="post">
<fieldset>
<input type="hidden" name="username" value="${delegate.username }"/>
<input type="submit" value="<spring:message code="log.in"/>" />
<security:csrfInput />
</fieldset>
</form></li>
</c:forEach>
</ul>
<a href="<c:url value="/delegate-search.html"/>">&laquo;<spring:message code="return.to.search.form"/></a>
</div>

</div> <!--  content -->

<%@ include file="../themes/jasig/body-end.jsp" %>
</body>
</html>