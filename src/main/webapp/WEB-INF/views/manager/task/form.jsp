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
	<acme:form-textbox code="manager.task.form.label.title" path="title"/>
	<acme:form-textbox code="manager.task.form.label.description" path="description"/>
	<acme:form-moment code="manager.task.form.label.initial" path="periodInitial"/>
	<acme:form-moment code="manager.task.form.label.end" path="periodFinal"/>
	<acme:form-double code="manager.task.form.label.workloadInHours" path="workloadInHours"/>
	<acme:form-textbox code="manager.task.form.label.link" path="link"/>
	<acme:form-checkbox code="manager.task.form.label.isPublic" path="isPublic"/>
	
	<acme:form-submit test="${command == 'show'}" 
        code="manager.task.form.button.update" 
        action="/manager/task/update"/>
        
     <acme:form-submit test="${command == 'update'}" 
        code="manager.task.form.button.update" 
        action="/manager/task/update"/>
        
        
        
    <acme:form-submit test="${command == 'update'}" 
        code="manager.task.form.button.delete" 
        action="/manager/task/delete"/>
        
    <acme:form-submit test="${command == 'show'}" 
        code="manager.task.form.button.delete" 
        action="/manager/task/delete"/>
        
    <acme:form-submit test="${command == 'delete'}" 
        code="manager.task.form.button.delete" 
        action="/manager/task/delete"/>
       
       
       
       
    <acme:form-submit test="${command == 'create'}" 
        code="manager.task.form.button.create" 
        action="/manager/task/create"/>

	<acme:form-return code="manager.task.form.button.return"/>
</acme:form>