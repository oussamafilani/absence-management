
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-default" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="admin">Administration</a> 
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
           <!-- <li class="active"><a href="admin">Page Principale</a></li> -->
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Creer Compte/Module <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="createAdmin.jsp">Compte Admin</a></li>
                    <li><a href="createEnseignant.jsp">Compte Enseignant</a></li>
                    <li><a href="creatEtudiant.jsp">Compte Etudiant</a></li>
                    <li class="divider"></li>
                    <li><a href="createModule.jsp">Creer un module</a></li>        
                </ul>
            </li>
        </ul>  
    </div>
</nav>
