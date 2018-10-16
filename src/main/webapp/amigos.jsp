<%-- 
    Document   : amigos.jsp
    Created on : 06/10/2018, 19:00:24
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                    <a href="FeedPaginas.jsp"><li>Feed páginas</li></a>
                                    <a href="amigos.jsp"><li class="link-ativo">Amigos</li></a>
                                    <a href="seguindo.jsp"><li>Seguindo</li></a>
                                    <a href=""><li>Mensagens</li></a>
                                    <a href="recomendacoes.jsp"><li>Recomendações</li></a>
                                    <a href="minhaPublicacao.jsp"><li>Minhas publicações</li></a>
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
                            <div class="header-pag">
                                <p class="subtitle is-5">
                                    <strong>Amigos</strong>
                                </p>
                            </div>

                            <ct:listaAmigos user="${sessionScope.usuario.id}"/>
                            <c:forEach var="amigo" items="${listaAmigos}">
                                <c:choose>
                                    <c:when test="${amigo.remetente != sessionScope.usuario.id}">
                                        <ct:buscaUsuario user="${amigo.remetente}"/>
                                    </c:when>
                                    <c:otherwise>
                                        <ct:buscaUsuario user="${amigo.destinatario}"/>
                                    </c:otherwise>                   
                                </c:choose>
                                <article class="media amigos-item">
                                    <figure class="media-left">
                                        <p class="image is-98x98">
                                            <img src="${userBuscado.fotoPerfil}">
                                        </p>
                                    </figure>
                                    <div class="media-content">
                                        <div class="content">
                                            <p>
                                                <a href="front?action=VisitarPag&id=${userBuscado.id}&pag=user&t=u">
                                                    <strong>${userBuscado.nome}</strong> 
                                                </a>
                                                <br>
                                                ${userBuscado.descricao}
                                            </p>
                                        </div>
                                    </div>
                                </article>
                            </c:forEach>
                        </div>
                    </div>
                </div>

            </div>

        </section>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
        <script>
            const dropdown = document.querySelector('.dropdown');
            dropdown.addEventListener('click', () => {
                dropdown.classList.toggle('is-active');
            });

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
