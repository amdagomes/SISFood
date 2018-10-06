<%-- 
    Document   : visita-user
    Created on : 04/10/2018, 18:29:52
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags"%>
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
                                    <img class="is-rounded" src="${sessionScope.visita.fotoPerfil}">
                                </figure>
                                <div>
                                    <p class="has-text-dark has-text-centered has-text-weight-semibold is-size-5">
                                        ${sessionScope.visita.nome}
                                    </p>
                                    <p class="has-text-grey-light has-text-centered">
                                        ${sessionScope.visita.descricao}
                                    </p>
                                    <br>
                                    <ct:verificaSituacaoUsuario remetente="${sessionScope.usuario.id}" destinatario="${sessionScope.visita.id}"/>
                                    <c:choose>
                                        <c:when test="${situacaoAmizade != null}">
                                            <c:choose>
                                                <c:when test="${situacaoAmizade.solicitacao == 'amigo'}">
                                                    <a href="front?action=Amizade&met=remove&dest=${visita.id}&pag=visita-user" class="button is-small is-danger">
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
                                                            <a href="front?action=Amizade&met=adiciona&dest=${visita.id}&pag=visita-user" class="button is-small is-success">
                                                                <span>Aceitar</span>
                                                            </a>
                                                            <a href="front?action=Amizade&met=remove&dest=${visita.id}&pag=visita-user" class="button is-small is-danger">
                                                                <span>Recusar</span>
                                                            </a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <a class="button is-small is-info" href="front?action=Amizade&met=solicita&dest=${visita.id}&pag=visita-user">
                                                <span class="icon is-small">
                                                    <i class="fas fa-user-plus"></i>
                                                </span>
                                                <span>Adiconar Amigo</span>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>

                            <aside class="menu">

                                <ul>
                                    <a href="front?action=Inicio"><li class="link-ativo">Feed</li></a>
                                    <a href="perfil-usuario.jsp"><li>Perfil</li></a>
                                    <li>
                                        <a href="front?action=Inicio"><p class="menu-label">voltar</p></a>
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

                        <!-- Publicação -->
                        <div class="card media-box">
                            <div class="card-content">
                                <div class="media">
                                    <div class="media-left">
                                        <figure class="image is-64x64">
                                            <img class="is-rounded" src="https://bulma.io/images/placeholders/96x96.png" alt="Placeholder image">
                                        </figure>
                                    </div>
                                    <div class="media-content">
                                        <p class="title is-5">John Smith</p>
                                        <p class="subtitle is-7">15 de setembro às 23:30</p>
                                    </div>
                                    <div class="media-right">
                                        <div class="dropdown drop is-right is-pointer">
                                            <div class="dropdown-trigger">
                                                <span class="icon is-small">
                                                    <i class="fas fa-ellipsis-h"></i>
                                                </span>
                                            </div>
                                            <div class="dropdown-menu" id="dropdown-menu3" role="menu">
                                                <div class="dropdown-content">
                                                    <a href="#" class="dropdown-item">
                                                        Compartilhar
                                                    </a>
                                                    <a href="#" class="dropdown-item">
                                                        Deletar
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-image">
                                    <figure class="image is-16by9">
                                        <img src="https://bulma.io/images/placeholders/1280x960.png" alt="Placeholder image">
                                    </figure>
                                </div>
                                <div class="content">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porta eros lacus, nec ultricies elit blandit non. Suspendisse pellentesque mauris sit amet dolor blandit rutrum. Nunc in tempus turpis.
                                </div>
                            </div>

                            <!-- Comentatio da publicação-->
                            <div class="comentario">
                                <article class="media">
                                    <figure class="media-left">
                                        <p class="image is-48x48">
                                            <img class="is-rounded" src="https://bulma.io/images/placeholders/128x128.png">
                                        </p>
                                    </figure>
                                    <div class="media-content">
                                        <div class="content">
                                            <p>
                                                <span class="title-comentario">John Smith</span> <small>data/hora</small>
                                                <br>
                                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ornare magna eros, eu pellentesque tortor vestibulum ut. Maecenas non massa sem. Etiam finibus odio quis feugiat facilisis.
                                            </p>
                                        </div>
                                    </div>
                                </article>
                            </div>

                            <!-- Escrever comentario-->
                            <article class="media comentario">
                                <figure class="media-left">
                                    <p class="image is-48x48">
                                        <img class="is-rounded" src="https://bulma.io/images/placeholders/128x128.png">
                                    </p>
                                </figure>
                                <div class="media-content">
                                    <div class="field">
                                        <p class="control">
                                            <textarea class="textarea" placeholder="Escreva um comentario..." rows="1"></textarea>
                                        </p>
                                    </div>
                                </div>
                                <a href="#" class="button-send">
                                    <span class="icon is-large">
                                        <span class="fa-stack fa-lg">
                                            <i class="fas fa-circle fa-stack-2x has-text-green"></i>
                                            <i class="fas fa-paper-plane fa-stack-1x"></i>
                                        </span>
                                    </span>
                                </a>
                        </div>
                        </article>
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

            const drop = document.querySelector('.drop');
            drop.addEventListener('click', () => {
                drop.classList.toggle('is-active');
            });
        </script>                                
    </body>
</html>
