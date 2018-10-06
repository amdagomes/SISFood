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
                                <a href="#" class="dropdown-item">
                                    Notficação 1
                                </a>
                                <a class="dropdown-item">
                                    Nofiticação 2
                                </a>
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
