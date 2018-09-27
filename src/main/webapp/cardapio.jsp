<%-- 
    Document   : cardapio
    Created on : 18/09/2018, 11:12:19
    Author     : Amanda
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
                                <nav class="level">
                                    <div class="level-left">
                                        <div class="level-item">
                                            <p class="subtitle is-5">
                                                <strong>Cardápio</strong>
                                            </p>
                                        </div>
                                    </div>

                                    <div class="level-right">
                                        <a id="showModal" title="Adicionar prato">
                                            <span class="icon is-medium">
                                                <i class="fas fa-plus-circle"></i>
                                            </span>
                                        </a>
                                    </div>
                                </nav>
                            </div>

                        <!--cardapio-->
                        <jsp:useBean id="dao" class="io.github.fernandasj.dao.ComidaDao"/>
                        <c:forEach var="comida" items="${dao.buscarPorEstabelecimento(8)}">
                            <article class="media item-cardapio">
                                <figure class="media-left">
                                    <p class="image is-128x128">
                                        <img src="https://bulma.io/images/placeholders/128x128.png"/>
                                    </p>
                                </figure>
                                <div class="media-content">
                                    <div class="content">
                                        <p>
                                            <strong>${comida.nome}</strong> <small>Preço: R$ ${comida.preco}</small>
                                            <br>
                                            ${comida.descricao}
                                            <br> 
                                        </p>
                                    </div>
                                    <nav class="level is-mobile">
                                        <div class="level-left">
                                            <p>Nota: ${comida.nota}</p>
                                        </div>
                                    </nav>
                                </div>

                                <div class="media-right">
                                    <div class="level">
                                        <a class="level-item" title="Deletar" href="front?action=DeletarComida&idComida=${comida.idComida}">
                                            <span class="icon is-small"><i class="fas fa-trash-alt"></i></i></span>
                                        </a>
                                    </div>
                                </div>
                            </article>
                        </c:forEach>
                        </div>
                    </div>  
                    <!--MODAL PARA ADICIONAR PRATO NO CARDAPIO-->
                    <div class="modal">
                        <div class="modal-background"></div>
                        <div class="modal-content">
                            <form class="form-cardapio" method="post" action="front?action=CadastroComida">
                                <p class="title is-size-5">Adicionar prato ao cardápio</p>
                                <div class="field is-grouped">
                                    <p class="control is-expanded">
                                        <input class="input is-small" type="text" placeholder="Nome" name="nome">
                                    </p>
                                    <p class="control">
                                        <input class="input is-small" type="text" placeholder="Preço. Ex.: 10.00" name="preco">
                                    </p>
                                </div>

                                <textarea class="textarea" placeholder="Descrição..." rows="2" name="descricao"></textarea>

                                <div class="file is-small file-custom">
                                    <span class="file-name" id="filename"></span>

                                    <label class="file-label">
                                        <input class="file-input" type="file" name="foto" id="file">
                                        <span class="file-cta">
                                            <span class="file-icon">
                                                <i class="fas fa-upload"></i>
                                            </span>
                                            <span class="file-label">
                                                Selecione uma foto…
                                            </span>
                                        </span>
                                    </label>
                                </div>

                                <div class="field">
                                    <div class="control">
                                        <input type="hidden" name="identificador" value="CadastroComida">
                                        <input class="button is-success is-fullwidth" type="submit" value="Adicionar">
                                    </div>
                                </div>    
                            </form>                         
                        </div>
                        <button class="modal-close is-large" aria-label="close"></button>
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
            
            $("#showModal").click(function () {
                $(".modal").addClass("is-active");
            });

            $(".modal-close").click(function () {
                $(".modal").removeClass("is-active");
            });

            var file = document.getElementById("file");
            file.onchange = function () {
                if (file.files.length > 0)
                {

                    document.getElementById('filename').innerHTML = file.files[0].name;

                }
            };

        </script>
    </body>
</html>