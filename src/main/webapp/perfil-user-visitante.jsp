<%-- 
    Document   : perfil-user-visitante
    Created on : 11/10/2018, 09:45:39
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
                                    <a href="front?action=VisitarPag&id=${sessionScope.visita.id}&pag=user&t=u"><li>Feed</li></a>
                                    <a href="perfil-user-visitante.jsp"><li class="link-ativo">Perfil</li></a>
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
                                            <span class="has-text-weight-semibold">Profissão:</span> ${sessionScope.visita.profissao}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Telefone:</span> ${sessionScope.visita.telefone}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Nascimento:</span> ${sessionScope.visita.dataNascimento}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Sexo:</span> ${sessionScope.visita.sexo}
                                        </div>
                                    </div>
                                    <div class="columns">
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Rua:</span> ${sessionScope.visita.rua}, ${sessionScope.visita.numeroCasa}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Cidade:</span> ${sessionScope.visita.cidade}
                                        </div>
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">Estado:</span> ${sessionScope.visita.estado}
                                        </div>
                                    </div>
                                    <div class="columns">
                                        <div class="column is-narrow">
                                            <span class="has-text-weight-semibold">CEP:</span> ${sessionScope.visita.cep}
                                        </div>
                                    </div>
                                </div>
                            </div>
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

            const drop = document.querySelector('.drop');
            drop.addEventListener('click', () => {
                drop.classList.toggle('is-active');
            });
        </script>                                
    </body>
</html>
