<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
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
                                    <p class="has-text-centered" style="margin-top: .5rem; margin-bottom: .5rem;">
                                        <ct:verificaSeguePagina seguidor="${sessionScope.usuario.id}" pagina="${sessionScope.visita.id}"/>
                                        <c:choose>
                                            <c:when test="${seguePagina == true}">
                                                <a href="front?action=SeguirEstabelecimento&estbl=${sessionScope.visita.descricao}&met=u&pag=resultado-busca" class="button is-small is-danger">
                                                    <span class="icon is-small">
                                                        <i class="fas fa-check"></i>
                                                    </span>
                                                    <span>unfollow</span>
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <a  href="front?action=SeguirEstabelecimento&estbl=${sessionScope.visita.descricao}&met=follow&pag=resultado-busca" class="button is-small is-link">
                                                    <span class="icon is-small">
                                                        <i class="fas fa-check"></i>
                                                    </span>
                                                    <span>follow</span>
                                                </a>
                                            </c:otherwise>
                                        </c:choose>
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
                                            <a href="visita-estbl.jsp"><li>Feed</li></a>
                                            <a href="front?action=VisitarPag&id=${sessionScope.visita.id}&pag=cardapio&t=e"><li>Cardápio</li></a>
                                            <a href="perfil-estbl-visitante.jsp"><li class="link-ativo">Mais Informações</li></a>
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
                        <div class="media-box">
                            <div class="header-pag">
                                <p class="subtitle is-5">
                                    <strong>Perfil</strong>
                                </p>
                            </div>
                            <div style="padding: 15px 30px;">
                                <p class="title is-size-4">${sessionScope.visita.nome}</p>
                                <p class="subtitle is-size-6 has-text-justified">${sessionScope.visita.descricao}</p>
                                <div class="info-perfil">
                                    <div class="columns">
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Categoria:</span> ${sessionScope.visita.categoria}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Telefone:</span> ${sessionScope.visita.telefone}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Abre às:</span> ${sessionScope.visita.horaAbre}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Fecha às:</span> ${sessionScope.visita.horaFecha}
                                        </div>
                                    </div>
                                    <div class="columns">
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Rua:</span> ${sessionScope.visita.rua}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Cidade:</span> ${sessionScope.visita.cidade}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Estado:</span> ${sessionScope.visita.estado}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">CEP:</span> ${sessionScope.visita.cep}
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <section class="section">
                                <article class="">
                                    <div class="subtitle">
                                        <p>Comentários</p>
                                    </div>
                                    <div class="accordion-body">
                                        <!-- COMENTARIOS -->
                                        <ct:listAvaliacoesEstabelecimento idEstabelecimento="${sessionScope.visita.id}"/>
                                        <c:forEach var="avaliacao" items="${avaliacoes}">
                                            <ct:buscaUsuario user="${avaliacao.consumidor}"/>
                                            <article class="media">
                                                <figure class="media-left image is-48x48">
                                                    <div class="is-rounded">
                                                        <img src="${userBuscado.fotoPerfil}">
                                                    </div>
                                                </figure>
                                                <div class="media-content">
                                                    <div class="content">
                                                        <p>
                                                            <c:choose>
                                                                <c:when test="${avaliacao.consumidor != sessionScope.usuario.id}">
                                                                    <a href="front?action=VisitarPag&id=${userBuscado.id}&pag=user&t=u">
                                                                        <span class="title-comentario">${userBuscado.nome}</span>
                                                                    </a>
                                                                    <small>nota: ${avaliacao.nota}</small>  
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <span class="title-comentario">${userBuscado.nome}</span> <small>nota: ${avaliacao.nota}</small>
                                                                </c:otherwise>
                                                            </c:choose>        
                                                            <br>
                                                            ${avaliacao.comentario}
                                                        </p>
                                                    </div>
                                                </div>
                                            </article>
                                        </c:forEach>
                                    </div>
                                </article>
                            </section>  
                        </div>
                    </div>
                </div>
            </div>           

            <!-- MODAL AVALIAR ESTABELECIMENTO-->
            <form id="avaliar" class="form-cardapio modal" method="post" action="front?action=AvaliacaoComida">
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

        </script>
    </body>
</html>
