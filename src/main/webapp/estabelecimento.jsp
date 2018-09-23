<%-- 
    Document   : estabelecimento
    Created on : 18/09/2018, 11:11:30
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
                                            <a href=""><li class="link-ativo">Feed</li></a>
                                            <a href=""><li>Cardápio</li></a>
                                            <a href=""><li>Perfil</li></a>
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
                        <!-- Criar publicação-->
                        <form action="">
                            <div class="media-box">
                                <nav class="breadcrumb has-bullet-separator" aria-label="breadcrumbs">
                                    <ul>
                                        <li class="is-active">
                                            <p class="has-text-weight-semibold">
                                                <a>Criar publicação</a>
                                            </p>
                                        </li>
                                        <li><a>
                                                <div class="file has-name">
                                                    <label class="file-label">
                                                        <input id="file" class="file-input" type="file" accept="image/*" name="foto">
                                                        <span class="file-cta">
                                                            <span class="file-icon">
                                                                <i class="fas fa-camera"></i>
                                                            </span>
                                                        </span>
                                                    </label>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                </nav>
                                <div class="criar-publicacao">
                                    <div class="field">
                                        <p class="control">
                                            <textarea class="textarea" placeholder="Faça uma publicação..." rows="2"></textarea>
                                        </p>
                                    </div>
                                    <div class="level">
                                        <div class="level-left">
                                            <div class="level-item">
                                            </div>
                                        </div>
                                        <div class="level-right">
                                            <div class="level-item">
                                                <input class="button is-orange is-outlined" type="submit" value="Publicar" />
                                            </div>
                                        </div>
                                    </div>
                                </div>   
                        </form>
                    </div>

                    <!-- Publicação -->
                    <div class="card media-box">
                        <div class="card-content">
                            <div class="media">
                                <div class="media-left">
                                    <figure class="image is-64x64">
                                        <img class="is-rounded" src="https://bulma.io/images/placeholders/96x96.png" alt="Placeholder image">
                                    </figure>
                                </div>
                                <div class="media-content">
                                    <p class="title is-5">John Smith</p>
                                    <p class="subtitle is-7">15 de setembro às 23:30</p>
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
                                <figure class="image is-16by9">
                                    <img src="https://bulma.io/images/placeholders/1280x960.png" alt="Placeholder image">
                                </figure>
                            </div>
                            <div class="content">
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porta eros lacus, nec ultricies elit blandit non. Suspendisse pellentesque mauris sit amet dolor blandit rutrum. Nunc in tempus turpis.
                            </div>
                        </div>

                        <!-- Comentatio da publicação-->
                        <div class="comentario">
                            <article class="media">
                                <figure class="media-left">
                                    <p class="image is-48x48">
                                        <img class="is-rounded" src="https://bulma.io/images/placeholders/128x128.png">
                                    </p>
                                </figure>
                                <div class="media-content">
                                    <div class="content">
                                        <p>
                                            <span class="title-comentario">John Smith</span> <small>data/hora</small>
                                            <br>
                                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ornare magna eros, eu pellentesque tortor vestibulum ut. Maecenas non massa sem. Etiam finibus odio quis feugiat facilisis.
                                        </p>
                                    </div>
                                </div>
                            </article>
                        </div>

                        <!-- Escrever comentario-->
                        <article class="media comentario">
                            <figure class="media-left">
                                <p class="image is-48x48">
                                    <img class="is-rounded" src="https://bulma.io/images/placeholders/128x128.png">
                                </p>
                            </figure>
                            <div class="media-content">
                                <div class="field">
                                    <p class="control">
                                        <textarea class="textarea" placeholder="Escreva um comentario..." rows="1"></textarea>
                                    </p>
                                </div>
                            </div>
                            <a href="#" class="button-send">
                                <span class="icon is-large">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x has-text-green"></i>
                                        <i class="fas fa-paper-plane fa-stack-1x"></i>
                                    </span>
                                </span>
                            </a>
                    </div>
                    </article>
                </div>
            </div>

        </div>
    </section>

    <script>
        const dropdown = document.querySelector('.dropdown');
        dropdown.addEventListener('click', () => {
            dropdown.classList.toggle('is-active');
        });

        const drop = document.querySelector('.drop');
        drop.addEventListener('click', () => {
            drop.classList.toggle('is-active');
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