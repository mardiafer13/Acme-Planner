<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.spam_word.list.label.spanishTranslation" path="spanishTranslation" width="40%"/>
	<acme:list-column code="administrator.spam_word.list.label.englishTranslation" path="englishTranslation" width="40%"/>
	<acme:list-column code="administrator.spam_word.list.label.spamThreshold" path="spamThreshold" width="20%"/>
</acme:list>

