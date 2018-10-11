<%--
    Document   : header
    Created on : 18/09/2018, 11:24:10
    Author     : Amanda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header class="navbar is-orange ">
        <div class="container">
            <div class="navbar-brand">
                <a class="navbar-item">
                    <img src="img/logo2.png" alt="SisFood">
                </a>
                <a role="button" class="navbar-burger" data-target="navMenu" aria-label="menu" aria-expanded="false">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a> 
            </div>
            <div id="navMenu" class="navbar-menu">
                <div class="navbar-end has-text-centered-mobile">
                    <div class="navbar-item">
                        <form method="post" class="search" action="front?action=Buscar">
                            <div class="field has-addons">
                                <div class="control">
                                    <input class="input is-small" type="text" placeholder="Search.." name="search">
                                </div>
                                <div class="control">
                                    <button class="button is-small" type="submit"><i class="fa fa-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>            
                    <div class="navbar-item dropdown is-right is-pointer notf">
                        <div class="dropdown-trigger">   
                            <ct:buscaNotificacao user="${sessionScope.usuario.id}" />
                            <span class="icon is-small badge" data-badge="${notificacoes}" aria-controls="dropdown-menu">
                                <i class="fa fa-bell" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="dropdown-menu" id="dropdown-menu" role="menu">
                            <div class="dropdown-content">
                                <c:choose>
                                    <c:when test="${not empty solicitacoes}">
                                        <c:forEach var="solicitacao" items="${solicitacoes}">
                                            <ct:buscaUsuario user="${solicitacao.remetente}"/>
                                            <div class="dropdown-item">
                                                <article class="media">
                                                    <figure class="media-left">
                                                        <p class="image is-98x98">
                                                            <a href="front?action=VisitarPag&id=${userBuscado.id}&pag=user&t=u">
                                                                <img src="${userBuscado.fotoPerfil}">
                                                            </a>
                                                        </p>
                                                    </figure>
                                                    <div class="media-content">
                                                        <div class="content">
                                                            <p>
                                                                <a href="front?action=VisitarPag&id=${userBuscado.id}&pag=user&t=u">
                                                                    ${userBuscado.nome}
                                                                </a>                                                    
                                                            </p>  
                                                            <a href="front?action=Amizade&met=adiciona&dest=${userBuscado.id}&pag=home" class="button is-small is-success">
                                                                <span>Aceitar</span>
                                                            </a>
                                                            <a href="front?action=Amizade&met=remove&dest=${userBuscado.id}&pag=home" class="button is-small is-danger">
                                                                <span>Recusar</span>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </article>
                                            </div>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <p class="dropdown-item">
                                            Nenhuma notificação nesse momento
                                        </p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <a class="navbar-item" href="front?action=Logout">
                        <span>
                            Sair
                        </span>
                    </a>
                </div>                       
            </div>
        </div>
    </header>
</html>
