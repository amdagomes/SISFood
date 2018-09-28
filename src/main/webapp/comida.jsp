<%-- 
    Document   : cardapio
    Created on : 18/09/2018, 11:12:19
    Author     : fernada
--%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
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
                                    <a href=""><li>Inicio</li></a>
                                    <li>
                                        <p class="menu-label">Nome do estabelecimento</p>
                                        <ul>
                                            <a href=""><li>Feed</li></a>
                                            <a href=""><li class="link-ativo">Cardápio</li></a>
                                            <a href=""><li>Mais Informações</li></a>
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
                            <div class="cardapio">
                                <div class="level">
                                    <div class="level-left">
                                        <div class="level-item">
                                            <p class="subtitle is-5">
                                                <strong>Editar Comida</strong>
                                            </p>
                                        </div>
                                    </div>                                    
                                </div>
                            </div>

                            <!--EDITAR PRATO NO CARDAPIO-->
                            
                            <form class="media p10" method="post" action="front?action=AtualizarComida">
                                <div class="media-left">
                                    <div class="field fotoperfil is-left">
                                        <figure class="image ">
                                            <img id="fotoperfil" src="">
                                        </figure>
                                        <div class="file has-name">
                                            <label class="file-label">
                                                <input id="file" class="file-input" type="file" accept="image/*" name="foto">
                                                <span class="file-cta">
                                                    <span class="file-icon">
                                                        <i class="fas fa-upload"></i>
                                                    </span>
                                                    <span class="file-label">
                                                        Escolha uma foto
                                                    </span>
                                                </span>
                                                <div id="filename" class="file-name">
                                                    
                                                </div>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                                              
                                <div class="media-content">
                                    <div class="content">
                                        <div class="columns">
                                            <div class="column">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Nome</label>
                                                    <div class="control">
                                                        <input type="hidden" name="idComida" value="${comida.idComida}"/>
                                                        <input class="input is-small" type="text" name="nome" required value="${comida.nome}">
                                                    </div>
                                                </div>    
                                            </div>

                                            <div class="column is-narrow">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Preço</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="text" name="preco" required value="${comida.preco}">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="field">
                                            <label class="has-text-weight-normal label is-left">Descrição</label>
                                            <div class="control">
                                                <textarea class="textarea" name="descricao" rows="2">${comida.descricao}</textarea>
                                            </div>
                                        </div>
                                    </div>                                   

                                    <div class="field">
                                        <div class="control">
                                            <input type="hidden" name="identificador" value="CadastroComida">
                                            <input class="button is-success is-fullwidth" type="submit" value="Editar">
                                        </div>
                                    </div>
                            </div>
                        </form>                         
                    </div>
                </div>            
            </div>
        </section>
        <script
            src="https://code.jquery.com/jquery-2.2.4.min.js"
            integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
            crossorigin="anonymous">
        </script>
        <script>
            const dropdown = document.querySelector('.dropdown');
            dropdown.addEventListener('click', () => {
                dropdown.classList.toggle('is-active');
            });

            var file = document.getElementById("file");
            file.onchange = function () {
                if (file.files.length > 0) {
                    document.getElementById('filename').innerHTML = file.files[0].name;
                }
            };

        </script>
    </body>
</html>