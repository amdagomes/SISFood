<%-- 
    Document   : visita-user
    Created on : 04/10/2018, 18:29:52
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
                                    <a href="FeedPaginas.jsp"><li class="link-ativo">Feed páginas</li></a>
                                    <a href="amigos.jsp"><li>Amigos</li></a>
                                    <a href=""><li>Mensagens</li></a>
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

                        <!-- Publicação -->
                        <jsp:useBean id="daoE" class="io.github.fernandasj.dao.EstabelecimentoDao"/> 
                        <jsp:useBean id="dao" class="io.github.fernandasj.dao.PublicacaoEstabelecimentoDao"/>
                        <c:set var="listPublicacoes" scope="page" value="${dao.listarFeed(sessionScope.usuario.id)}"/>
                        <c:choose>
                            <c:when test="${not empty listPublicacoes}">
                                <c:forEach var="publicacao" items="${dao.listarFeed(sessionScope.usuario.id)}">                         
                                    <c:set var="estab" value="${daoE.buscarPorId(publicacao.idEstabelecimento)}"/>  
                                    <div class="card media-box">
                                        <div class="card-content">
                                            <div class="media">
                                                <div class="media-left">
                                                    <figure class="image is-64x64">
                                                        <img class="is-rounded" src="${estab.foto}" alt="Placeholder image">
                                                    </figure>
                                                </div>

                                                <div class="media-content">
                                                    <p class="title is-5">${estab.nome}</p>
                                                    <p class="subtitle is-7">${publicacao.datahora}</p>
                                                </div>
                                                <div class="media-right">
                                                    <div class="dropdown drop is-right is-pointer">
                                                        <div class="dropdown-trigger">
                                                            <span class="icon is-small">
                                                                <i class="fas fa-ellipsis-h"></i>
                                                            </span>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="card-image">
                                                ${publicacao.texto}
                                            </div>
                                            <div class="content">

                                            </div>
                                        </div>

                                        <!-- Comentatio da publicação-->
                                        <jsp:useBean id="daoC" class="io.github.fernandasj.dao.ComentarioEstabelecimentoDao"/>
                                        <jsp:useBean id="daou" class="io.github.fernandasj.dao.UsuarioDao"/>
                                        <c:forEach var="comentario" items="${daoC.listar(publicacao.idPublicacao)}">
                                            <c:set var="userComentario" value="${daou.buscarPorId(comentario.comentarista)}"/>
                                            <div class="comentario">
                                                <article class="media">
                                                    <figure class="media-left">
                                                        <p class="image is-48x48">
                                                            <img class="is-rounded" src="${userComentario.fotoPerfil}">
                                                        </p>
                                                    </figure>
                                                    <div class="media-content">
                                                        <div class="content">
                                                            <p>
                                                                <span class="title-comentario">${userComentario.nome}</span> <small>${comentario.datahora}</small>
                                                                <br>
                                                                ${comentario.comentario}
                                                            </p>
                                                        </div>
                                                    </div>
                                                </article>
                                            </div>
                                        </c:forEach>

                                        <!-- Escrever comentario-->
                                        <form  method="post" action="front?action=ComentarPubliEstabelecimento">
                                            <article class="media comentario">
                                                <figure class="media-left">
                                                    <p class="image is-48x48">
                                                        <img class="is-rounded" src="${sessionScope.usuario.fotoPerfil}">
                                                    </p>
                                                </figure>
                                                <div class="media-content">
                                                    <div class="field">
                                                        <p class="control">
                                                            <textarea class="textarea" placeholder="Escreva um comentario..." rows="1" name="comentario"></textarea>
                                                            <input type ="hidden" name="idPublicacao" value= ${publicacao.idPublicacao}>
                                                            <input type="hidden" name ="pagina" value="FeedPaginas">
                                                        </p>
                                                    </div>
                                                </div>
                                                <button type="submit">
                                                    <span class="icon is-large">
                                                        <span class="fa-stack fa-lg">
                                                            <i class="fas fa-circle fa-stack-2x has-text-green"></i>
                                                            <i class="fas fa-paper-plane fa-stack-1x"></i>
                                                        </span>

                                                    </span>
                                                </button>
                                            </article>
                                        </form>
                                    </div> 
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <div class="card media-box">
                                    <div class="card-content">
                                        <div class="media">
                                            <p>Não existe publicações no momento</p>
                                        </div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>


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
