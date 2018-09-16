<%-- 
    Document   : home
    Created on : 16/08/2018, 09:10:49
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/custonTags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>SisFood</title>
        <meta charset="utf-8">
        <meta name="viewport" content="whidth: device-width, initial-scale-1.0, maximun-scale-1.0">
        <meta name="description" content="Rede Social voltada para o ramo alimenticio.">
        <meta name="keywords" content="social, media, rede, social, food, alimento">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
    </head>
    <body class="background-gray">
        <header class="navbar is-orange ">
            <div class="container">
                <div class="navbar-brand">
                    <a class="navbar-item">
                        <img src="img/logo2.png" alt="SisFood">
                    </a>
                    <span class="navbar-burger burger" data-target="navbar">
                        <span></span>
                        <span></span>
                        <span></span>
                    </span>  
                </div>
                <div id="navbar" class="navbar-menu">
                    <div class="navbar-end has-text-centered-mobile">
                        <div class="navbar-item">
                            <form method="post" class="search">
                                <div class="field has-addons">
                                    <div class="control">
                                        <input class="input is-small" type="text" placeholder="Search.." name="search">
                                    </div>
                                    <div class="control">
                                        <button class="button is-small" type="submit"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <a class="navbar-item active-link" href="front?action=Logout">
                            <span class="icon">
                                <i class="fas fa-sign-out-alt"></i>
                            </span>
                            <span>
                                Sair
                            </span>
                        </a>
                    </div>

                </div>
            </div>
        </header>

        <section class="section">
            <div class="container ">
                <div class="columns is-3">
                    <div class="column coluna is-3">
                        <div class="fotoperfil">
                            <figure class="image">
                                <img class="is-rounded" src="${sessionScope.usuario.foto}">
                            </figure>
                            <h4 class="has-text-dark has-text-centered has-text-weight-semibold is-size-5">
                                ${sessionScope.usuario.nome}
                            </h4>
                            <h6 class="has-text-grey-light has-text-centered">
                                Descrição do user
                            </h6>
                        </div>
                    </div>

                    <div class="column coluna"></div>
                </div>

            </div>
        </section>

        <script>
            var carousels = bulmaCarousel.attach();

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
