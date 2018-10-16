<%-- 
    Document   : checkin
    Created on : 16/10/2018, 07:02:17
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
                                    <a href="front?action=VisitarPag&id=${sessionScope.visita.id}&pag=user&t=u"><li>Feed</li></a>
                                    <a href="checkin.jsp"><li class="link-ativo">Esteve em...</li></a>
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
                         
                                 
                                    
                         <section class="section">
                               
                              <jsp:useBean id="dao" class="io.github.fernandasj.dao.ChekinDao"/>
                                <jsp:useBean id="daoU" class="io.github.fernandasj.dao.UsuarioDao"/> 
                                <jsp:useBean id="daoE" class="io.github.fernandasj.dao.EstabelecimentoDao"/> 
                                <c:forEach var="c" items="${dao.listar(sessionScope.visita.id)}">
                                <c:set var="u" value="${daoU.buscarPorId(c.consumidor)}"/>  
                                <c:set var="e" value="${daoE.buscarPorId(c.estabelecimento)}"/>  
                        <div class="media-box">
                                

 
                                    <div class="media">
                                  
                                        <figure class="media-left image is-48x48">
                                            <div class="is-rounded">
                                                <img src="${u.fotoPerfil}">
                                            </div>
                                        </figure>
                                        <div class="media-content">
                                            <div class="content">
                                                <p class="is-vcentered">
                                                    <span class="has-text-weight-semibold">${u.nome}</span>
                                                    - esteve no  
                                                    <a class="has-text-link" href="front?action=VisitarPag&id=${e.id}&pag=estbl&t=e">
                                                        ${e.nome}
                                                    </a>
                                                    ${c.datahora}
                                                </p>
                                                <div class="media">
                                                    <div class="media-left image is-64x64">
                                                        <div class="imagem">
                                                            <img src="${e.foto}"/>
                                                        </div>
                                                    </div>
                                                    <div class="media-content">
                                                        <div class="content">
                                                            <p>${e.descricao}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                                      
                                                      
                                    </div>
                             
                        </div>
                                </c:forEach>
                                                          
                            </section>
 
                        </div>
  
                    </div>

                </div>
        </section>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script> 
    </body>
</html>
