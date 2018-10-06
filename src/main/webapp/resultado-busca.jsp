<%-- 
    Document   : resultado-busca
    Created on : 04/10/2018, 10:10:37
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
    <head>
        <title>SisFood</title>
        <meta charset="utf-8">
        <meta name="viewport" content="whidth: device-width, initial-scale-1.0, maximun-scale-1.0">
        <meta name="description" content="Rede Social voltada para o ramo alimenticio.">
        <meta name="keywords" content="social, media, rede, social, food, alimento">
        <link rel="stylesheet" href="css/bulma.css">
        <link rel="stylesheet" href="css/bulma-badge.min.css">
        <script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="background-gray">
        <%@ include file="header.jsp"%>
        <section class="section">
            <div class="container ">
                <div class="columns is-2">
                    <div class="column is-3">
                        <div class="media-box">
                            <div class="fotoperfil">
                                <figure class="image">
                                    <img class="is-rounded" src="${sessionScope.usuario.fotoPerfil}">
                                </figure>
                                <div>
                                    <p class="has-text-dark has-text-centered has-text-weight-semibold is-size-5">
                                        ${sessionScope.usuario.nome}
                                    </p>
                                    <p class="has-text-grey-light has-text-centered">
                                        ${sessionScope.usuario.descricao}
                                    </p>
                                </div>
                            </div>

                            <aside class="menu">
                                <ul>
                                    <a href="front?action=Inicio"><li>Feed</li></a>
                                    <a href=""><li>Menssagens</li></a>
                                    <a href="perfil-usuario.jsp"><li>Editar Perfil</li></a>
                                    <a href="#cria-estbl" rel="modal:open"><li>Criar Página</li></a>
                                    <li>
                                        <p class="menu-label">Minhas páginas</p>
                                        <ul>
                                            <jsp:useBean id="control" class="io.github.fernandasj.controle.GerenciadorEstabelecimento"/>
                                            <c:forEach var="pagina" items="${control.meusEstabelecimentos(sessionScope.usuario.id)}">
                                                <a href="front?action=PaginaEstabelecimento&id=${pagina.id}"><li>${pagina.nome}</li></a>
                                                    </c:forEach>     
                                        </ul>
                                    </li>
                                    <a href="front?action=Logout">
                                        <li class="menu-label">
                                            <span class="icon">
                                                <i class="fas fa-power-off"></i>
                                            </span>
                                            Sair
                                        </li>
                                    </a>
                                </ul>
                            </aside>
                        </div>
                    </div>

                    <div class="column">
                        <div class="media-box">
                            <div class="header-busca">
                                <div class="tabs is-centered is-boxed is-medium">
                                    <ul>
                                        <li id="usuario" class="is-active">
                                            <a>
                                                <span class="icon is-small"><i class="fas fa-user" aria-hidden="true"></i></span>
                                                <span>Usuário</span>
                                            </a>
                                        </li>
                                        <li id="estabelecimento" class="">
                                            <a>
                                                <span class="icon is-small"><i class="fas fa-utensils" aria-hidden="true"></i></span>
                                                <span>Estabelecimentos</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <!--resultado de usuarios-->
                            <div class="r-usuarios block">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.buscaU}">
                                        <c:forEach var="usuarios" items="${sessionScope.buscaU}">
                                            <c:if test="${usuarios.id != sessionScope.usuario.id}">
                                                <article class="media">
                                                    <figure class="media-left">
                                                        <p class="image">
                                                            <img src="${usuarios.fotoPerfil}">
                                                        </p>
                                                    </figure>
                                                    <div class="media-content">
                                                        <div class="content">
                                                            <p>
                                                                <a href="front?action=VisitarPag&id=${usuarios.id}&pag=user&t=u">
                                                                    <strong>${usuarios.nome}</strong> 
                                                                </a>
                                                                <br>
                                                                ${usuarios.descricao}
                                                            </p>
                                                        </div>
                                                    </div>
                                                    <div class="media-right">
                                                        <ct:verificaSituacaoUsuario remetente="${sessionScope.usuario.id}" destinatario="${usuarios.id}"/>
                                                        <c:choose>
                                                            <c:when test="${situacaoAmizade != null}">
                                                                <c:choose>
                                                                    <c:when test="${situacaoAmizade.solicitacao.equals('amigo')}">
                                                                        <a class="button is-small is-danger">
                                                                            <span class="icon is-small">
                                                                                <i class="fas fa-user-slash"></i>
                                                                            </span>
                                                                            <span>Desfazer Amizade</span>
                                                                        </a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <c:choose>
                                                                            <c:when test="${sessionScope.usuario.id == situacaoAmizade.remetente}">
                                                                                <a class="button is-small is-success" disabled>
                                                                                    <span class="icon is-small">
                                                                                        <i class="fas fa-check"></i>
                                                                                    </span>
                                                                                    <span>Amizade Solicitada</span>
                                                                                </a>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <a class="button is-small is-success">
                                                                                    <span>Aceitar</span>
                                                                                </a>
                                                                                <a class="button is-small is-danger">
                                                                                    <span>Recusar</span>
                                                                                </a>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a class="button is-small is-info" href="front?action=Amizade&met=adiciona&dest=${usuarios.id}">
                                                                    <span class="icon is-small">
                                                                        <i class="fas fa-user-plus"></i>
                                                                    </span>
                                                                    <span>Adiconar Amigo</span>
                                                                </a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </article>
                                            </c:if>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="media">
                                            <p>Nenhum usuário foi encontrado :(</p>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>

                            <!--resultado de estabelecimentos-->
                            <div class="r-estabelecimentos none">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.buscaE}">
                                        <c:forEach var="estbl" items="${sessionScope.buscaE}">
                                            <article class="media">
                                                <figure class="media-left">
                                                    <img src="${estbl.foto}"/>
                                                </figure>
                                                <div class="media-content">
                                                    <div class="content">
                                                        <p>
                                                            <a href="front?action=VisitarPag&id=${estbl.id}&pag=estbl&t=e">
                                                                <strong>${estbl.nome}</strong>
                                                            </a>
                                                            <br>
                                                            ${estbl.descricao}
                                                            <br> 
                                                        </p>
                                                    </div>   
                                                </div>

                                                <div class="media-right">
                                                    <div class="level">
                                                        <a class="level-item" title="Editar" href="#${comida.idComida}" rel="modal:open">
                                                            <span class="icon is-small"><i class="fas fa-pencil-alt"></i></span>
                                                        </a>
                                                        <a class="level-item has-text-danger" title="Deletar" href="front?action=DeletarComida&idComida=${comida.idComida}">
                                                            <span class="icon is-small"><i class="fas fa-trash-alt"></i></span>
                                                        </a>
                                                    </div>
                                                </div>
                                            </article>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="media">
                                            <p>Nenhum estabelecimento foi encontrado :(</p>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div> 
                </div>
            </div>
        </section> 

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
        <script>
            const dropdown = document.querySelector('.dropdown');
            dropdown.addEventListener('click', () => {
                dropdown.classList.toggle('is-active');
            });

            var tabUser = document.getElementById("usuario");
            var tabEstbl = document.getElementById("estabelecimento");

            tabUser.onclick = function () {
                $('#usuario').addClass('is-active');
                $('#estabelecimento').removeClass('is-active');

                $('.r-usuarios').addClass('block').removeClass('none');
                $('.r-estabelecimentos').removeClass('block').addClass('none');
            };

            tabEstbl.onclick = function () {
                $('#usuario').removeClass('is-active');
                $('#estabelecimento').addClass('is-active');

                $('.r-usuarios').removeClass('block').addClass('none');
                $('.r-estabelecimentos').addClass('block').removeClass('none');
            };

            document.addEventListener('DOMContentLoaded', () => {

                // Get all "navbar-burger" elements
                const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

                // Check if there are any navbar burgers
                if ($navbarBurgers.length > 0) {

                    // Add a click event on each of them
                    $navbarBurgers.forEach(el => {
                        el.addEventListener('click', () => {

                            // Get the target from the "data-target" attribute
                            const target = el.dataset.target;
                            const $target = document.getElementById(target);

                            // Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"
                            el.classList.toggle('is-active');
                            $target.classList.toggle('is-active');

                        });
                    });
                }

            });

        </script>
    </body>
</html>
