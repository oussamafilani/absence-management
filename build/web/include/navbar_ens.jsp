

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Enseignement</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li class="active"><a href="module?id=<%=session.getAttribute("id")%>">Modules &amp; Seances</a></li>
            <li><a href="creatSeance?id=<%=session.getAttribute("id")%>">Creation d'une seance</a></li>
            <li><a href="gestAb?id=<%=session.getAttribute("id")%>">Gestion des Absences</a></li>
            <li><a href="listAb?id=<%=session.getAttribute("id")%>">Listes des absences</a></li>
        </ul>       
    </div>
</nav>