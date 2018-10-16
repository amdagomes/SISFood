<%-- 
    Document   : estabelecimento
    Created on : 18/09/2018, 11:11:30
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
        <link rel="stylesheet" href="css/bulma-badge.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
        <link rel="stylesheet" href="css/style.css">
        <script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
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
                                    <div class="is-rounded">
                                        <img src="${sessionScope.estabelecimento.foto}">
                                    </div>
                                   
                                </figure>
                                <div>
                                    <p class="has-text-dark has-text-centered has-text-weight-semibold is-size-5">
                                        ${sessionScope.estabelecimento.nome}
                                    </p>
                                    <p class="has-text-grey-light has-text-centered">
                                        ${sessionScope.estabelecimento.descricao}
                                    </p>
                                </div>
                            </div>

                            <aside class="menu">

                                <ul>
                                    <a href="front?action=Inicio"><li>Inicio</li></a>
                                    <li>
                                        <p class="menu-label">MINHA PÁGINA</p>
                                        <ul>
                                            <a href="estabelecimento.jsp"><li class="link-ativo">Feed</li></a>
                                            <a href="cardapio.jsp"><li>Cardápio</li></a>
                                            <a href="perfil-estabelecimento.jsp"><li>Perfil</li></a>
                                        </ul>
                                    </li>
                                    <a href="front?action=Logout"><li class="menu-label">
                                            <span class="icon">
                                                <i class="fas fa-power-off"></i>
                                            </span>
                                            Sair
                                        </li></a>
                                </ul>

                            </aside>
                        </div>
                    </div>

                    <div class="column">

                        <!-- Criar publicação-->
                        <form  method="post" action="front?action=PublicarEstabelecimento">
                            <div class="media-box">
                                <nav class="breadcrumb has-bullet-separator" aria-label="breadcrumbs">
                                    <ul>
                                        <li class="is-active">
                                            <p class="has-text-weight-semibold">
                                                <a>Criar publicação</a>
                                            </p>
                                        </li>                                       
                                    </ul>
                                </nav>
                                <div class="criar-publicacao">
                                    <input type="hidden" name="idEstabelecimento" value="${sessionScope.estabelecimento.id}"/>
                                    <div class="field">
                                        <p class="control">
                                            <textarea class="textarea" placeholder="Faça uma publicação..." rows="2" name="texto" required="required"></textarea>
                                             <input type="hidden" name ="pagina" value="estabelecimento">
                                        </p>
                                    </div>
                                    <div class="level">
                                        <div class="level-left">
                                            <div class="level-item">
                                            </div>
                                        </div>
                                        <div class="level-right">
                                            <div class="level-item">
                                                <input class="button is-orange is-outlined" type="submit" value="Publicar" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>


                        <!-- Publicação -->
                        <jsp:useBean id="daoE" class="io.github.fernandasj.dao.EstabelecimentoDao"/> 
                        <jsp:useBean id="dao" class="io.github.fernandasj.dao.PublicacaoEstabelecimentoDao"/>

                        <c:forEach var="publicacao" items="${dao.listar(sessionScope.estabelecimento.id)}">
                            <c:set var="estab" value="${daoE.buscarPorId(publicacao.idEstabelecimento)}"/>  

                            <div class="card media-box">
                                <div class="card-content">
                                    <div class="media">
                                        <div class="media-left">
                                            <figure class="image is-64x64">
                                                <div class="is-rounded">
                                                    <img src="${estab.foto}" alt="Placeholder image">
                                                </div>                                               
                                            </figure>
                                        </div>
                                        <div class="media-content">
                                            <p>
                                                <span class="title is-5">${estab.nome}</span>
                                                <span class="subtitle is-7">${publicacao.datahora}</span>
                                                <br>
                                                ${publicacao.texto}
                                            </p>                                 
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
                                                        <a title="excluir"href="front?action=DeletarPublicacaoEstbl&idPublicacao=${publicacao.idPublicacao}" class="dropdown-item">
                                                            Deletar
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div> 

                                <!-- Comentatio da publicação-->
                                <jsp:useBean id="daoC" class="io.github.fernandasj.dao.ComentarioEstabelecimentoDao"/>
                                <jsp:useBean id="daoU" class="io.github.fernandasj.dao.UsuarioDao"/>


                                <c:forEach var="comentario" items="${daoC.listar(publicacao.idPublicacao)}">
                                    <c:set var="userComentario" value="${daoU.buscarPorId(comentario.comentarista)}"/>


                                    <div class="comentario">
                                        <article class="media">
                                            <figure class="media-left image is-48x48">
                                                <div class="is-rounded">
                                                    <img src="${userComentario.fotoPerfil}">
                                                </div>
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
                                        <figure class="media-left image is-48x48">
                                            <div class="is-rounded">
                                                <img src="${sessionScope.estabelecimento.foto}">
                                            </div>
                                        </figure>
                                        <div class="media-content">
                                            <div class="field">
                                                <p class="control">
                                                    <textarea class="textarea" placeholder="Escreva um comentario..." rows="1" name="comentario"></textarea>
                                                </p>
                                                <input type ="hidden" name="idPublicacao" value= ${publicacao.idPublicacao}>
                                                <input type="hidden" name ="pagina" value="estabelecimento">

                                            </div>

                                        </div>
                                        <button type="submit" class="button">
                                            <span class="icon is-large">
                                                <span class="fa-stack fa-lg">
                                                    <i class="fas fa-paper-plane fa-stack-1x"></i>
                                                </span>
                                            </span>
                                        </button>
                                    </article>
                                </form>
                            </div>
                        </c:forEach> 
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

            const drop = document.querySelector('.drop');
            drop.addEventListener('click', () => {
                drop.classList.toggle('is-active');
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
