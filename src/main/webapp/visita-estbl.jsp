<%-- 
    Document   : visita-estbl
    Created on : 07/10/2018, 13:06:40
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
                                    <img class="is-rounded" src="${sessionScope.visita.foto}">
                                </figure>
                                <div>
                                    <p class="has-text-dark has-text-centered has-text-weight-semibold is-size-5">
                                        ${sessionScope.visita.nome}
                                    </p>
                                    <p class="has-text-grey-light has-text-centered">
                                        ${sessionScope.visita.descricao}
                                    </p>
                                    <p class="has-text-centered">
                                        <a href="#avaliar" rel="modal:open">Avalie!</a>
                                    </p>
                                </div>
                            </div>
                            <div class="level is-small">
                                <div class="level-item has-text-centered">
                                    <div>
                                        <p class="is-size-6 has-text-weight-semibold">                                            
                                            <span class="icon is-small">
                                                ${sessionScope.visita.nota}
                                                <i class="fas fa-star"></i>
                                            </span>
                                        </p>
                                        <p class="heading">Nota</p>                    
                                    </div>
                                </div>
                                <div class="level-item has-text-centered">
                                    <div>
                                        <p class="is-size-6 has-text-weight-semibold">${sessionScope.visita.categoria}</p>
                                        <p class="heading">Categoria</p>                    
                                    </div>
                                </div>
                            </div>
                            <aside class="menu">             
                                <ul>
                                    <a href="front?action=Inicio"><li>Inicio</li></a>
                                    <li>
                                        <p class="menu-label">Estabelecimento</p>
                                        <ul>
                                            <a href="visita-estbl.jsp"><li class="link-ativo">Feed</li></a>
                                            <a href="front?action=VisitarPag&id=${sessionScope.visita.id}&pag=cardapio&t=e"><li>Cardápio</li></a>
                                            <a href="perfil-estbl-visitante.jsp"><li>Mais Informações</li></a>
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

                        <!-- Publicação -->
                        <jsp:useBean id="daoE" class="io.github.fernandasj.dao.EstabelecimentoDao"/> 
                        <jsp:useBean id="dao" class="io.github.fernandasj.dao.PublicacaoEstabelecimentoDao"/>

                        <c:forEach var="publicacao" items="${dao.listar(sessionScope.visita.id)}">
                            <c:set var="estab" value="${daoE.buscarPorId(publicacao.idEstabelecimento)}"/>  

                            <div class="card media-box">
                                <div class="card-content">
                                    <div class="media">
                                        <div class="media-left">
                                            <figure class="image is-64x64">
                                                <div class="is-rounded">
                                                    <img src="${estab.foto}">
                                                </div>
                                            </figure>
                                        </div>
                                        <div class="media-content">
                                            <p class="title is-5"> ${estab.nome}</p>
                                            <p class="subtitle is-7">${publicacao.datahora}</p>
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

                                    </div>
                                    <div class="content">
                                        ${publicacao.texto}
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
                                                <p class="is-rounded">
                                                    <img src="${userComentario.fotoPerfil}">
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
                                        <figure class="media-left image is-48x48">
                                            <div class="is-rounded">
                                                <img src="${sessionScope.usuario.fotoPerfil}">
                                            </div>
                                        </figure>
                                        <div class="media-content">
                                            <div class="field">
                                                <p class="control">
                                                    <textarea class="textarea" placeholder="Escreva um comentario..." rows="1" name="comentario"></textarea>
                                                </p>
                                                <input type ="hidden" name="idPublicacao" value= ${publicacao.idPublicacao}>
                                                <input type="hidden" name ="pagina" value="visita-estbl">
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

            <!-- MODAL AVALIAR ESTABELECIMENTO-->
            <form id="avaliar" class="form-cardapio modal" method="post" action="front?action=AvaliacaoEstabelecimento">
                <p class="title is-size-5">Avalie e deixe seu comentario</p>
                <input type="hidden" name="idEstabelecimento" value="${sessionScope.visita.id}">
                <input type="hidden" name="pagina" value="visita-estbl">
                <div class="field is-grouped">
                    <div class="level is-mobile">
                        <div class="level-left">
                            <p>Dê sua nota: </p>
                        </div>
                        <div class="level-right">
                            <div class="estrelas">
                                <input type="radio" id="cm_star-empty" name="nota" value="" checked/>
                                <label id="star1" for="cm_star-1">
                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                </label>
                                <input type="radio" id="cm_star-1" name="nota" value="1"/>
                                <label id="star2" for="cm_star-2">
                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                </label>
                                <input type="radio" id="cm_star-2" name="nota" value="2"/>
                                <label id="star3" for="cm_star-3">
                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                </label>
                                <input type="radio" id="cm_star-3" name="nota" value="3"/>
                                <label id="star4" for="cm_star-4">
                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                </label>
                                <input type="radio" id="cm_star-4" name="nota" value="4"/>
                                <label id="star5" for="cm_star-5">
                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                </label>
                                <input type="radio" id="cm_star-5" name="nota" value="5"/>
                            </div>
                        </div>
                    </div>

                </div>

                <textarea class="textarea"  rows="2" name="comentario" placeholder="Comente..."></textarea>

                <div class="field bt-margin-top">
                    <div class="control">
                        <input class="button is-success is-fullwidth" type="submit" value="Avaliar">
                    </div>
                </div>    
            </form>                              
        </section>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
        <script>
            const dropdown = document.querySelector('.dropdown');
            dropdown.addEventListener('click', () => {
                dropdown.classList.toggle('is-active');
            });
            $(function () {
                $('.estrelas input').click(function () {
                    var valor = $(this).attr('value');
                    for (var i = 0; i <= 5; i++) {
                        if (i <= valor) {
                            $('#star' + i).addClass("gold");
                        } else {
                            $('#star' + i).removeClass("gold");
                        }
                    }
                });
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
