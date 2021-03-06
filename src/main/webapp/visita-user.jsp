<%-- 
    Document   : visita-user
    Created on : 04/10/2018, 18:29:52
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags"%>
<%@taglib prefix="mTags" tagdir="/WEB-INF/tags/" %>
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
                                    <p class="has-text-centered">
                                        <mTags:situacaoAmizade situacao="${situacaoAmizade}" usuario="${visita}" pagina="visita-user"/>                                   
                                    </p>    
                                </div>
                            </div>

                            <aside class="menu">

                                <ul>
                                    <a href="front?action=VisitarPag&id=${sessionScope.visita.id}&pag=user&t=u"><li class="link-ativo">Feed</li></a>
                                    <a href="checkin.jsp"><li>Esteve em...</li></a>
                                    <a href="perfil-user-visitante.jsp"><li>Perfil</li></a>
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
                        <jsp:useBean id="daoU" class="io.github.fernandasj.dao.UsuarioDao"/> 
                        <jsp:useBean id="dao" class="io.github.fernandasj.dao.PublicacaoDao"/>
                        <c:set var="listPublicacoes" scope="page" value="${dao.listar(visita.id)}"/>
                        <c:choose>
                            <c:when test="${not empty listPublicacoes}">
                                <c:forEach var="publicacao" items="${listPublicacoes}">
                                    <c:set var="user" value="${daoU.buscarPorId(publicacao.idUsuario)}"/>  
                                    <div class="card media-box">
                                        <div class="card-content">
                                            <div class="media">
                                                <div class="media-left">
                                                    <figure class="image is-64x64">
                                                        <div class="is-rounded">
                                                            <img src="${user.fotoPerfil}" alt="Placeholder image">
                                                        </div>                                           
                                                    </figure>
                                                </div>
                                                <div class="media-content">
                                                    <p>
                                                        <span class="title is-5">${user.nome}</span>
                                                        <span class="subtitle is-7">${publicacao.datahora}</span>
                                                        <br>
                                                        ${publicacao.texto}
                                                    </p>                                                    
                                                </div>                                  
                                            </div>
                                        </div>


                                        <!-- Comentatio da publicação-->
                                        <jsp:useBean id="daoC" class="io.github.fernandasj.dao.ComentarioDao"/>
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
                                        <form  method="post" action="front?action=Comentar">
                                            <article class="media comentario">
                                                <figure class="media-left image is-48x48">
                                                    <div class="is-rounded">
                                                        <img src="${sessionScope.usuario.fotoPerfil}">
                                                    </div>
                                                </figure>
                                                <div class="media-content">
                                                    <div class="field">
                                                        <p class="control">
                                                            <textarea class="textarea" placeholder="Escreva um comentario..." rows="1" name ="comentario"></textarea>
                                                        </p>
                                                    </div>
                                                    <input type ="hidden" name="idPublicacao" value= ${publicacao.idPublicacao}>
                                                    <input type="hidden" name ="pagina" value="visita-user"/>
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
        </script>                                
    </body>
</html>
