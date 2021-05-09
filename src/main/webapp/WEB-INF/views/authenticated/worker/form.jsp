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

<acme:form>
	<acme:form-textarea code="authenticated.worker.worker.form.label.qualifications" path="qualifications"/>
	<acme:form-textarea code="authenticated.worker.worker.form.label.skills" path="skills"/>
	
	<acme:form-submit test="${command == 'create'}" code="authenticated.worker.worker.form.button.create" action="/authenticated/worker/create"/>
	<acme:form-submit test="${command == 'update'}" code="authenticated.worker.worker.form.button.update" action="/authenticated/worker/update"/>
	<acme:form-return code="authenticated.worker.worker.form.button.return"/>
</acme:form>
