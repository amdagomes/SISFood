<%-- 
    Document   : perfil-estabelecimento
    Created on : 29/09/2018, 16:47:03
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                    <img class="is-rounded" src="${sessionScope.estabelecimento.foto}">
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
                                            <a href="estabelecimento.jsp"><li>Feed</li></a>
                                            <a href="cardapio.jsp"><li>Cardápio</li></a>
                                            <a href="perfil-estabelecimento.jsp"><li class="link-ativo">Perfil</li></a>
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
                                                <strong>Perfil</strong>
                                            </p>
                                        </div>
                                    </div>                                    
                                </div>
                            </div>

                            <form class="media p10" action="front?action=AtualizaPerfilEstbl" method="post" enctype="multipart/form-data">

                                <div class="media-content">
                                    <div class="content" style="padding: 15px 30px;">
                                        <h5 class="subtitle">Dados do Estabelecimento</h5>
                                        <div class="columns">
                                            <div class="column">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Nome</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="hidden" name="id" required value="${sessionScope.estabelecimento.id}">
                                                        <input class="input is-small" type="text" name="nome" required value="${sessionScope.estabelecimento.nome}">
                                                    </div>
                                                </div>    
                                            </div>

                                            <div class="column is-3">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Categoria</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="text" name="categoria" required value="${sessionScope.estabelecimento.categoria}">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="field">
                                            <label class="has-text-weight-normal label is-left">Descrição</label>
                                            <div class="control">
                                                <textarea class="textarea" name="descricao" rows="2">${sessionScope.estabelecimento.descricao}</textarea>
                                            </div>
                                        </div>
                                        <div class="columns">
                                            <div class="column is-3">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Telefone</label>
                                                    <div class="control">
                                                        <input class="input is-small" name="telefone" type="text" value="${sessionScope.estabelecimento.telefone}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="column is-narrow">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-right">Foto</label>
                                                    <div class="file is-small  is-right">
                                                        <label class="file-label">
                                                            <input class="file-input" type="file" name="foto" id="file" >
                                                            <span class="file-cta">
                                                                <span class="file-icon">
                                                                    <i class="fas fa-upload"></i>
                                                                </span>
                                                                <span class="file-label">
                                                                    Selecione…
                                                                </span>
                                                            </span>
                                                            <span class="file-name" id="filename">
                                                                ${sessionScope.estabelecimento.foto}
                                                            </span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="column is-2">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Abre às</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="time" name="horaAbre" value="${sessionScope.estabelecimento.horaAbre}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="column is-2">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Fecha às</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="time" name="horaFecha" value="${sessionScope.estabelecimento.horaFecha}">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="field">
                                            <h5 class="subtitle">Endereço</h5>
                                            <label class="has-text-weight-normal label is-left">Rua</label>
                                            <div class="control">
                                                <input class="input is-small" type="text" name="rua" required value="${sessionScope.estabelecimento.rua}">
                                            </div>
                                        </div>

                                        <div class="field">
                                            <div class="columns">
                                                <div class="column">
                                                    <label class="has-text-weight-normal label is-left">Cidade</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="text" name="cidade" required value="${sessionScope.estabelecimento.cidade}">
                                                    </div>
                                                </div>
                                                <div class="column is-narrow">
                                                    <label class="has-text-weight-normal label is-left">Estado</label>
                                                    <div class="control">
                                                        <input class="input is-small is-uppercase" type="text" name="estado" maxlength="2" value="${sessionScope.estabelecimento.estado}">
                                                    </div>
                                                </div>
                                                <div class="column">
                                                    <label class="has-text-weight-normal label is-left">CEP</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="text" placeholder="Ex.:588815000" name="cep" required value="${sessionScope.estabelecimento.cep}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="columns">
                                                    <div class="column is-6"></div>
                                                    <div class="column">
                                                        <div class="control">
                                                            <input class="button is-fullwidth is-success is-rounded" type="submit" value="Atualizar">
                                                        </div>
                                                    </div>

                                                    <div class="column">
                                                        <div class="control">
                                                            <input class="button is-fullwidth is-danger is-rounded" type="submit" value="Deletar Página">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>    
                                </div>
                            </form>

                        </div>
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

            var file = document.getElementById("file");
            file.onchange = function () {
                if (file.files.length > 0)
                {
                    document.getElementById('filename').innerHTML = file.files[0].name;
                }
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
