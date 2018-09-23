<%-- 
    Document   : cardapio-visitante
    Created on : 22/09/2018, 21:39:24
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
                                        Nome Establecimento
                                    </p>
                                    <p class="has-text-grey-light has-text-centered">
                                        descrição...
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
                                </nav>
                            </div>

                            <article class="media item-cardapio">
                                <figure class="media-left">
                                    <p class="image is-128x128">
                                        <img src="https://bulma.io/images/placeholders/128x128.png">
                                    </p>
                                </figure>
                                <div class="media-content">
                                    <div class="content">
                                        <p>
                                            <strong>Nome</strong> <small>Preço: $</small>
                                            <br>
                                            Descrição... Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ornare magna eros, eu pellentesque tortor vestibulum ut. Maecenas non massa sem.
                                            <br> 
                                        </p>
                                    </div>
                                    <nav class="level is-mobile">
                                        <div class="level-left">
                                            <p>Avalie:</p>
                                        </div>
                                        <div class="level-right">
                                            <div class="estrelas">
                                                <input type="radio" id="cm_star-empty" name="fb" value="" checked/>
                                                <label id="star1" for="cm_star-1">
                                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                                </label>
                                                <input type="radio" id="cm_star-1" name="fb" value="1"/>
                                                <label id="star2" for="cm_star-2">
                                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                                </label>
                                                <input type="radio" id="cm_star-2" name="fb" value="2"/>
                                                <label id="star3" for="cm_star-3">
                                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                                </label>
                                                <input type="radio" id="cm_star-3" name="fb" value="3"/>
                                                <label id="star4" for="cm_star-4">
                                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                                </label>
                                                <input type="radio" id="cm_star-4" name="fb" value="4"/>
                                                <label id="star5" for="cm_star-5">
                                                    <span class="icon is-small"><i class="fas fa-star"></i></span>
                                                </label>
                                                <input type="radio" id="cm_star-5" name="fb" value="5"/>
                                            </div>
                                        </div>
                                    </nav>
                                </div>

                                <div class="media-right">
                                    <div class="level">
                                        <a class="level-item" title="Compartilhar">
                                            <span class="icon is-small"><i class="fas fa-share-alt"></i></span>
                                        </a>
                                    </div>
                                </div>

                            </article>

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

