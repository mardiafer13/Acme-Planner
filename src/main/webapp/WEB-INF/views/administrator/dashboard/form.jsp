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

<h2>
	<acme:message code="administrator.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">
		
	<%-- Parte de entregable inicio--%>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-public-task"/>
		</th>
		<td>
			<acme:print value="${numberPublicTask}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-private-task"/>
		</th>
		<td>
			<acme:print value="${numberPrivateTask}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-final-task"/>
		</th>
		<td>
			<acme:print value="${numberFinalTask}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.number-no-final-task"/>
		</th>
		<td>
			<acme:print value="${numberNoFinalTask}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.average-duration-tasks"/>
		</th>
		<td>
			<acme:print value="${averageDurationPeriodTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviation-duration-tasks"/>
		</th>
		<td>
			<acme:print value="${deviationDurationPeriodTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minimum-duration-tasks"/>
		</th>
		<td>
			<acme:print value="${minimumDurationPeriodTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maximum-duration-tasks"/>
		</th>
		<td>
			<acme:print value="${maximumDurationPeriodTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.average-workload-tasks"/>
		</th>
		<td>
			<acme:print value="${averageWorkloadTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.deviation-workload-tasks"/>
		</th>
		<td>
			<acme:print value="${deviationWorkloadTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minimum-workload-tasks"/>
		</th>
		<td>
			<acme:print value="${minimumWorkloadTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maximum-workload-tasks"/>
		</th>
		<td>
			<acme:print value="${maximumWorkloadTasks}"/>
		</td>
	</tr>
	<%-- Parte de entregable fin--%>
	
	
</table>




