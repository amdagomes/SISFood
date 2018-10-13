<%-- 
    Document   : home
    Created on : 16/08/2018, 09:10:49
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
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
                                    <a href="front?action=Inicio"><li>Feed</li></a>
                                    <a href="FeedPaginas.jsp"><li>Feed páginas</li></a>
                                    <a href=""><li>Menssagens</li></a>
                                    <a href="minhaPublicacao.jsp"><li class="link-ativo">Minhas publicações</li></a>
                                    <a href="perfil-usuario.jsp"><li>Editar Perfil</li></a>
                                    <a href="#cria-estbl" rel="modal:open"><li>Criar Página</li></a>
                                    <li>
                                        <p class="menu-label">Minhas páginas</p>
                                        <ul>
                                            <jsp:useBean id="control" class="io.github.fernandasj.controle.GerenciadorEstabelecimento"/>
                                            <c:forEach var="pagina" items="${control.meusEstabelecimentos(sessionScope.usuario.id)}">
                                                <a href="front?action=PaginaEstabelecimento&id=${pagina.id}"><li>${pagina.nome}</li></a>
                                                    </c:forEach>     
                                        </ul>
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
                        <!-- Criar publicação-->
                        <form  method="post" action="front?action=Publicar">
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
                                            <textarea class="textarea" placeholder="Faça uma publicação..." rows="2" name="texto" required="required"></textarea>
                                        </p>
                                    </div>
                                    <div class="level">
                                        <div class="level-left">
                                            <div class="level-item">
                                            </div>
                                        </div>
                                        <div class="level-right">
                                            <div class="level-item">
                                                <input class="button is-orange" type="submit" value="Publicar" />
                                            </div>
                                        </div>
                                    </div>
                                </div>   
                        </form>
                    </div>

                    <!-- Publicação -->
                    <jsp:useBean id="daoU" class="io.github.fernandasj.dao.UsuarioDao"/> 
                    <jsp:useBean id="dao" class="io.github.fernandasj.dao.PublicacaoDao"/>

                    <c:forEach var="publicacao" items="${dao.listar(sessionScope.usuario.id)}">
                        <c:set var="user" value="${daoU.buscarPorId(publicacao.idUsuario)}"/>  

                        <div class="card media-box">
                            <div class="card-content">
                                <div class="media">
                                    <div class="media-left">
                                        <figure class="image is-64x64">
                                            <div class="is-rounded">
                                                <img src="${user.fotoPerfil}">
                                            </div>                                  
                                        </figure>
                                    </div>
                                    <div class="media-content">
                                        <p class="title is-5">${user.nome}</p>
                                        <p class="subtitle is-7">${publicacao.datahora}</p>
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


                                                    <a title="excluir"href="front?action=DeletarPublicacao&idPublicacao=${publicacao.idPublicacao}" class="dropdown-item">
                                                        Deletar
                                                    </a>



                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="card-image" >
                                    <p>
                                        ${publicacao.texto}
                                    </p>
                                </div>

                                <div class="content">

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
                                                <textarea class="textarea" placeholder="Escreva um comentario..." rows="1" required="required" name="comentario"></textarea>
                                            </p>
                                        </div>
                                        <input type ="hidden" name="idPublicacao" value= ${publicacao.idPublicacao}>
                                        <input type="hidden" name ="pagina" value="minhaPublicacao">

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

                </div>


            </div>

        </div>

    </section>


    <%@ include file="cadastrar-estabelecimento.jsp"%>

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
