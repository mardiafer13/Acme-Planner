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

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.task.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.task.form.label.description" path="description"/>
	<acme:form-textbox code="authenticated.task.form.label.initial" path="periodInitial"/>
	<acme:form-textbox code="authenticated.task.form.label.end" path="periodFinal"/>
	<acme:form-textbox code="authenticated.task.form.label.workload" path="workloadInHours"/>
	<acme:form-textbox code="authenticated.task.form.label.link" path="link"/>	

	<acme:form-return code="administrator.announcement.form.button.return"/>
</acme:form>
