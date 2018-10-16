<%-- 
    Document   : recomendacoes
    Created on : 15/10/2018, 22:08:03
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
                                    <a href="amigos.jsp"><li>Amigos</li></a>
                                    <a href="seguindo.jsp"><li>Seguindo</li></a>
                                    <a href=""><li>Mensagens</li></a>
                                    <a href="recomendacoes.jsp"><li class="link-ativo">Recomendações</li></a>
                                    <a href="minhaPublicacao.jsp"><li>Minhas publicações</li></a>
                                    <a href="perfil-usuario.jsp"><li>Editar Perfil</li></a>                                  
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
                                        <li id="comida" class="is-active">
                                            <a>
                                                <span class="icon is-small"><i class="fas fa-utensils" aria-hidden="true"></i></span>
                                                <span>Comida</span>
                                            </a>
                                        </li>
                                        <li id="estbl" class="">
                                            <a>
                                                <span class="icon is-small"><i class="fas fa-store" aria-hidden="true"></i></span>
                                                <span>Estabelecimentos</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <section class="section">

                                <!-- RECOMENDAÇÕES DE COMIDA -->
                                <div class="r-comida block">
                                    <ct:listRecomendacaoComida destinatario="${sessionScope.usuario.id}"/>
                                    <c:set var="listComida" value="${recComida}" scope="page"/>
                                    <c:choose>
                                        <c:when test="${not empty listComida}">
                                            <c:forEach var="recomendacao" items="${listComida}">
                                                <ct:buscaUsuario user="${recomendacao.remetente}"/>
                                                <ct:buscaComida comida="${recomendacao.recomendacao}"/>
                                                <ct:buscaEstabelecimento id="${comidaBuscada.idEstabelecimento}"/>
                                                <div class="media">
                                                    <figure class="media-left image is-48x48">
                                                        <div class="is-rounded">
                                                            <img src="${userBuscado.fotoPerfil}">
                                                        </div>
                                                    </figure>
                                                    <div class="media-content">
                                                        <div class="content">
                                                            <p class="is-vcentered">
                                                                <a class="has-text-weight-semibold" href="front?action=VisitarPag&id=${userBuscado.id}&pag=user&t=u">
                                                                    ${userBuscado.nome}
                                                                </a>
                                                                - recomendou 
                                                                <span class="has-text-weight-semibold">${comidaBuscada.nome}</span> do
                                                                <a class="has-text-link" href="front?action=VisitarPag&id=${estblBuscado.id}&pag=estbl&t=e">
                                                                    ${estblBuscado.nome}
                                                                </a>
                                                            </p>
                                                            <div class="media">
                                                                <div class="media-left image is-64x64">
                                                                    <div class="imagem">
                                                                        <img src="${comidaBuscada.foto}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="media-content">
                                                                    <div class="content">
                                                                        <p>${comidaBuscada.descricao}</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <p>Você não possui recomendações no momento</p>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                                <!-- RECOMENDAÇÕES DE ESTABELECIMENTO -->
                                <div class="r-estabelecimentos none">
                                    <ct:listRecomendacaoEstabelecimento destinatario="${sessionScope.usuario.id}"/>
                                    <c:set var="listEstbl" value="${recEstbl}" scope="page"/>
                                    <c:choose>
                                        <c:when test="${not empty listEstbl}">
                                            <c:forEach var="recomendacao" items="${listEstbl}">
                                                <ct:buscaUsuario user="${recomendacao.remetente}"/>
                                                <ct:buscaEstabelecimento id="${recomendacao.recomendacao}"/>
                                                <div class="media">
                                                    <figure class="media-left image is-48x48">
                                                        <div class="is-rounded">
                                                            <img src="${userBuscado.fotoPerfil}">
                                                        </div>
                                                    </figure>
                                                    <div class="media-content">
                                                        <div class="content">
                                                            <p class="is-vcentered">
                                                                <a class="has-text-weight-semibold" href="front?action=VisitarPag&id=${userBuscado.id}&pag=user&t=u">
                                                                    ${userBuscado.nome}
                                                                </a>
                                                                - recomendou o
                                                                <a class="has-text-link" href="front?action=VisitarPag&id=${estblBuscado.id}&pag=estbl&t=e">
                                                                    ${estblBuscado.nome}
                                                                </a>
                                                            </p>
                                                            <div class="media">
                                                                <div class="media-left image is-64x64">
                                                                    <div class="imagem">
                                                                        <img src="${estblBuscado.foto}"/>
                                                                    </div>
                                                                </div>
                                                                <div class="media-content">
                                                                    <div class="content">
                                                                        <p>${estblBuscado.descricao}</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <p>Você não possui recomendações no momento</p>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
        </section>
                                    
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
        <script>
            var tabComida = document.getElementById("comida");
            var tabEstbl = document.getElementById("estbl");

            tabComida.onclick = function () {
                $('#comida').addClass('is-active');
                $('#estbl').removeClass('is-active');

                $('.r-comida').addClass('block').removeClass('none');
                $('.r-estabelecimentos').removeClass('block').addClass('none');
            };

            tabEstbl.onclick = function () {
                $('#comida').removeClass('is-active');
                $('#estbl').addClass('is-active');

                $('.r-comida').removeClass('block').addClass('none');
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
