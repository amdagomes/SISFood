<%-- 
    Document   : visita-estbl
    Created on : 07/10/2018, 13:06:40
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
                                                3,4
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
                                            <a href="visita-estbl.jsp"><li class="link-ativo">Feed</li></a>
                                            <a href="front?action=VisitarPag&id=${sessionScope.visita.id}&pag=cardapio&t=e"><li>Cardápio</li></a>
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

            <!-- MODAL AVALIAR ESTABELECIMENTO-->
            <form id="avaliar" class="form-cardapio modal" method="post" action="front?action=AvaliacaoEstabelecimento">
                <p class="title is-size-5">Avalie e deixe seu comentario</p>
                <input type="hidden" name="idEstabelecimento" value="${sessionScope.visita.id}">
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

            const drop = document.querySelector('.drop');
            drop.addEventListener('click', () => {
                drop.classList.toggle('is-active');
            });

            //exibe o src da imagem
            var file = document.getElementById("arquivo");
            file.onchange = function () {
                if (file.files.length > 0)
                {
                    document.getElementById('nomearquivo').innerHTML = file.files[0].name;
                }
            };

            //altera a foto de exibição do perfil
            $("#arquivo").on('change', function () {
                if (this.files && this.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#foto').attr("src", e.target.result).fadeIn();
                    }
                    reader.readAsDataURL(this.files[0]);
                }
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
