
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Ce fichier contient l'entete des pages et il charge les fichiers de bootstrap et jquery -->



<div class="container">
     <div class="row">
          <div class="col-lg-6 col-sm-6">
               <!-- Le titre [FIX] -->
               <h1>Gestion des absences</h1>
          </div>
          <div class="col-lg-6 col-sm-6">               
               <ul class="nav nav-pills pull-right" style="margin-top:20px">
                   <li class="active"><a href="./Logout">Déconnexion (<%out.println(session.getAttribute("username"));%>)</a></li>
               </ul>
          </div>
     </div>
</div>