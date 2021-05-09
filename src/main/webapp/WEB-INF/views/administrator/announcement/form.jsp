<%--
- form.jsp
-
- Copyright (C) 2012-2021 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="${readonly}">
	<acme:form-textbox code="administrator.announcement.form.label.title" path="title"/>	
	<acme:form-select code="administrator.announcement.form.label.status" path="status">
		<acme:form-option code="INFO" value="INFO" selected="${status == 'INFO'}"/>
		<acme:form-option code="WARNING" value="WARNING" selected="${status == 'WARNING'}"/>
		<acme:form-option code="IMPORTANT" value="IMPORTANT" selected="${status == 'IMPORTANT'}"/>
	</acme:form-select>
	<acme:form-textarea code="administrator.announcement.form.label.text" path="text"/>
	<acme:form-textbox code="administrator.announcement.form.label.info" path="info"/>
	
	<jstl:if test="${!readonly}">
		<acme:form-checkbox code="administrator.announcement.form.label.confirmation" path="confirmation"/>
		<acme:form-submit code="administrator.announcement.form.button.create" action="/administrator/announcement/create"/>
	</jstl:if>
	<acme:form-return code="administrator.announcement.form.button.return"/>
</acme:form>
