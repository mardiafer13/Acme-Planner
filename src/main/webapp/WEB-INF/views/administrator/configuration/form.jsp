<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="administrator.configuration.form.label.spamWords" path="spamWords" />
	<acme:form-double code="administrator.configuration.form.label.spamThreshold" path="spamThreshold" />
	<acme:form-submit test="${command == 'show' }"
	 code="administrator.spam_word.form.button.update"
	 action="/administrator/configuration/update"/>
	 
	  <acme:form-submit test="${command == 'update' }"
	 code="administrator.spam_word.form.button.update"
	 action="/administrator/configuration/update"/>
	 
	 <acme:form-return code="administrator.spam_word.form.button.return" />
</acme:form>