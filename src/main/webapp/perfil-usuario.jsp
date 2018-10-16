<%-- 
    Document   : perfil-usuario
    Created on : 23/09/2018, 11:18:17
    Author     : Amanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags"%>
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
                                    <a href="amigos.jsp"><li>Amigos</li></a>
                                    <a href="seguindo.jsp"><li>Seguindo</li></a>
                                    <a href=""><li>Mensagens</li></a>
                                    <a href="recomendacoes.jsp"><li>Recomendações</li></a>
                                    <a href="minhaPublicacao.jsp"><li>Minhas publicações</li></a>
                                    <a href="perfil-usuario.jsp"><li class="link-ativo">Editar Perfil</li></a>
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

                            <form class="media p10" action="front?action=AtualizaPerfil" method="post" enctype="multipart/form-data">
                                <div class="media-left">
                                    <div class="field fotoperfil is-centered">
                                        <figure class="image ">
                                            <img id="fotoperfil" src="${sessionScope.usuario.fotoPerfil}">
                                        </figure>
                                        <div class="file has-name">
                                            <label class="file-label">
                                                <input id="file" class="file-input" type="file" accept="image/*" name="fotoPerfil">
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
                                        <h5 class="subtitle">Dados Pessoais</h5>
                                        <div class="columns">
                                            <div class="column">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Nome</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="hidden" name="id" required value="${sessionScope.usuario.id}">
                                                        <input class="input is-small" type="text" name="nome" required value="${sessionScope.usuario.nome}">
                                                    </div>
                                                </div>    
                                            </div>

                                            <div class="column is-narrow">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Data nascimento</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="date" name="dataNascimento" required value="${sessionScope.usuario.dataNascimento}">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="field">
                                            <label class="has-text-weight-normal label is-left">Descrição</label>
                                            <div class="control">
                                                <textarea class="textarea" name="descricao" rows="2">${sessionScope.usuario.descricao}</textarea>
                                            </div>
                                        </div>
                                        <div class="columns">
                                            <div class="column">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Telefone</label>
                                                    <div class="control">
                                                        <input class="input is-small" name="telefone" type="text" value="${sessionScope.usuario.telefone}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="column">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Profissão</label>
                                                    <div class="control">
                                                        <input class="input is-small" name="profissao" type="text" value="${sessionScope.usuario.profissao}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="column">
                                                <div class="field">
                                                    <label class="has-text-weight-normal label is-left">Sexo</label>
                                                    <div class="control">
                                                        <div class="select is-small">
                                                            <select name="sexo">
                                                                <c:if test="${sessionScope.usuario.sexo == 'Feminino'}">
                                                                    <option value="Feminino" selected>Feminino</option>
                                                                    <option value="Masculino">Masculino</option>
                                                                </c:if>
                                                                <c:if test="${sessionScope.usuario.sexo == 'Masculino'}">
                                                                    <option value="Feminino">Feminino</option>
                                                                    <option value="Masculino" selected>Masculino</option>
                                                                </c:if>
                                                            </select>
                                                        </div>         
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="field">
                                            <h5 class="subtitle">Endereço</h5>
                                            <label class="has-text-weight-normal label is-left">Rua/nº</label>
                                            <div class="control">
                                                <div class="columns is-gapless">
                                                    <div class="column is-10">
                                                        <input class="input is-small" type="text" name="rua" required value="${sessionScope.usuario.rua}">
                                                    </div>
                                                    <div class="column">
                                                        <input class="input is-small" type="text" placeholder="nº" name="numeroCasa" value="${sessionScope.usuario.numeroCasa}">
                                                    </div>
                                                </div>   
                                            </div>
                                        </div>

                                        <div class="field">
                                            <div class="columns">
                                                <div class="column">
                                                    <label class="has-text-weight-normal label is-left">Cidade</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="text" name="cidade" required value="${sessionScope.usuario.cidade}">
                                                    </div>
                                                </div>
                                                <div class="column is-narrow">
                                                    <label class="has-text-weight-normal label is-left">Estado</label>
                                                    <div class="control">
                                                        <input class="input is-small is-uppercase" type="text" name="estado" maxlength="2" value="${sessionScope.usuario.estado}">
                                                    </div>
                                                </div>
                                                <div class="column">
                                                    <label class="has-text-weight-normal label is-left">CEP</label>
                                                    <div class="control">
                                                        <input class="input is-small" type="text" placeholder="Ex.:588815000" name="cep" required value="${sessionScope.usuario.cep}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="field">
                                                <h5 class="subtitle">Conta</h5>
                                                <label class="has-text-weight-normal  label is-left">Email</label>
                                                <div class="control has-icons-left has-icons-right">
                                                    <input class="input is-small" type="email" readonly name="email" value="${sessionScope.usuario.email}">
                                                    <span class="icon is-small is-left">
                                                        <i class="fas fa-user"></i>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="field">
                                                <label class="has-text-weight-normal  label">Senha</label>
                                                <p class="control has-icons-left">
                                                    <input class="input is-small" type="password" name ="senha" required value="${sessionScope.usuario.senha}">
                                                    <span class="icon is-small is-left">
                                                        <i class="fas fa-lock"></i>
                                                    </span>
                                                </p>
                                            </div>
                                            <div class="field">
                                                <p class="control">
                                                    <input class="button is-success is-fullwidth is-rounded" type="submit" value="Atualizar">
                                                </p>
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

        <%@ include file="cadastrar-estabelecimento.jsp"%>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
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

            //altera a foto de exibição de criar pagina
            $("#file").on('change', function () {
                if (this.files && this.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#fotoperfil').attr("src", e.target.result).fadeIn();
                    }
                    reader.readAsDataURL(this.files[0]);
                }
            });

            //exibe o src da imagem de criar pagina
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