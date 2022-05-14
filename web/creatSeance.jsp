

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Metier.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="container">
            <%@include file="include/header.jsp" %>
            <%@include file="include/navbar_ens.jsp" %>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4>Creation d'une seance</h4>
                        </div>
                        <div class="panel-body">
                        <form method="post" action="creatSeance"> 
                            <input type="hidden" name="idU1" value="<%=session.getAttribute("id")%>"/>
                           <div class="form-group">
                                <label for="name">Module *</label>
                                <select name="module" class="form-control">
                                    <% ArrayList<Module> modules = (ArrayList<Module>)session.getAttribute("modules"); %>
                                    <% for(Module m: modules){ %>
                                        <option value="<%=m.getIntitule_module() %>">
                                            <%out.println(m.getIntitule_module()); %>
                                        </option>
                                    <%}%>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="subject">Date *</label>
                                <input class="form-control" name="date_sea" placeholder="Date Seance" type="date" required/>
                            </div>
                            <div class="form-group">
                                <label for="subject">Heure debut *</label>
                                <input class="form-control" name="heure_deb" placeholder="Heure debut" type="time" required/>
                            </div>
                            <div class="form-group">
                                <label for="name">Heure fin *</label>
                                <input class="form-control" name="heure_fin" placeholder="Heure fin" type="time" required/>
                            </div>
                            <div class="form-group">
                                <label for="name">Type *</label>
                                <select name="type_sea" class="form-control">
                                    <option value="Cours" >Cours</option>
                                    <option value="TD" >TD</option>
                                    <option value="TP" >TP</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <input name="submit" type="submit" class="btn btn-primary" value="Inserer" />
                                <input name="cancel" type="reset" class="btn btn-default" value="Cancel" />
                            </div>
                        </form>        
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <%if(request.getAttribute("msg") !=null){%>
                        <%if(request.getAttribute("msg").equals("bien insertion")){%>
                            <div class="alert alert-success" role="alert">
                                    bien insertion!
                            </div>
                        <%}
                        else if(request.getAttribute("msg").equals("pas insertion")){%>
                            <div class="alert alert-danger" role="alert">
                                   update échoue!
                            </div>
                        <%}
                    }%>
                </div>
            </div>                        
        </div>
    </body>
</html>
