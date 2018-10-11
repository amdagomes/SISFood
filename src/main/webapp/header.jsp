<%--
    Document   : header
    Created on : 18/09/2018, 11:24:10
    Author     : Amanda
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/CustomTags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <header class="navbar is-orange ">
        <div class="container">
            <div class="navbar-brand">
                <a href="front?action=Inicio" class="navbar-item">
                    <img src="img/logo2.png" alt="SisFood">
                </a>
                <a role="button" class="navbar-burger" data-target="navMenu" aria-label="menu" aria-expanded="false">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a> 
            </div>
            <div id="navMenu" class="navbar-menu">
                <div class="navbar-end has-text-centered-mobile">
                    <div class="navbar-item">
                        <form method="post" class="search" action="front?action=Buscar">
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
                    <a href="#cria-estbl" rel="modal:open" class="navbar-item">
                        Criar Página
                    </a>
                    <div class="navbar-item dropdown is-right is-pointer notf">
                        <div class="dropdown-trigger">   
                            <ct:buscaNotificacao user="${sessionScope.usuario.id}" />
                            <c:choose>
                                <c:when test="${notificacoes > 0 }">
                                    <span class="icon is-small badge" data-badge="${notificacoes}" aria-controls="dropdown-menu">
                                        <i class="fa fa-bell" aria-hidden="true"></i>
                                    </span>
                                </c:when>
                                <c:otherwise>
                                    <span class="icon is-small badge" aria-controls="dropdown-menu">
                                        <i class="fa fa-bell" aria-hidden="true"></i>
                                    </span>
                                </c:otherwise>
                            </c:choose>

                        </div>
                        <div class="dropdown-menu" id="dropdown-menu" role="menu">
                            <div class="dropdown-content">
                                <c:choose>
                                    <c:when test="${not empty solicitacoes}">
                                        <c:forEach var="solicitacao" items="${solicitacoes}">
                                            <ct:buscaUsuario user="${solicitacao.remetente}"/>
                                            <div class="dropdown-item">
                                                <article class="media">
                                                    <figure class="media-left">
                                                        <p class="image is-98x98">
                                                            <a href="front?action=VisitarPag&id=${userBuscado.id}&pag=user&t=u">
                                                                <img src="${userBuscado.fotoPerfil}">
                                                            </a>
                                                        </p>
                                                    </figure>
                                                    <div class="media-content">
                                                        <div class="content">
                                                            <p>
                                                                <a href="front?action=VisitarPag&id=${userBuscado.id}&pag=user&t=u">
                                                                    ${userBuscado.nome}
                                                                </a>                                                    
                                                            </p>  
                                                            <a href="front?action=Amizade&met=adiciona&dest=${userBuscado.id}&pag=home" class="button is-small is-success">
                                                                <span>Aceitar</span>
                                                            </a>
                                                            <a href="front?action=Amizade&met=remove&dest=${userBuscado.id}&pag=home" class="button is-small is-danger">
                                                                <span>Recusar</span>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </article>
                                            </div>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <p class="dropdown-item">
                                            Nenhuma notificação nesse momento
                                        </p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <a class="navbar-item" href="front?action=Logout">
                        <span>
                            Sair
                        </span>
                    </a>
                </div>                       
            </div>
        </div>
    </header>
    <form method="post" action="front?action=CadastroEstabelecimento" enctype="multipart/form-data" id="cria-estbl" class="modal">
        <h2 class="has-text-weight-semibold is-size-4" style="margin-bottom: 1rem;">Crie uma página para o seu Estabelecimento</h2>
        <div class="columns">
            <div class="column is-3">
                <div class="field fotoperfil is-centered">
                    <figure class="image is-96x96">
                        <img id="foto" src="img/user.png">
                    </figure>
                    <div class="file has-name">
                        <label class="file-label">
                            <input id="arquivo" class="file-input" type="file" accept="image/*" name="foto">
                            <span class="file-cta">
                                <span class="file-icon">
                                    <i class="fas fa-upload"></i>
                                </span>
                                <span class="file-label">
                                    Escolha uma foto
                                </span>
                            </span>
                            <div id="nomearquivo" class="file-name">

                            </div>
                        </label>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="columns">
                    <div class="column">
                        <div class="field">
                            <label class="label is-left has-text-weight-normal">Nome</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="nome" required>
                            </div>
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label class="label is-left has-text-weight-normal">Categoria</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="categoria" required>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="field">
                    <label class="label is-left has-text-weight-normal">Descrição</label>
                    <div class="control">
                        <textarea class="textarea is-small" type="text" name="descricao" rows="2"></textarea>
                    </div>
                </div>
                <div class="field">
                    <label class="label is-left has-text-weight-normal">Rua</label>
                    <div class="control">
                        <input class="input is-small" type="text" name="rua" required>
                    </div>
                </div>
                <div class="columns">
                    <div class="column">
                        <div class="field">
                            <label class="label is-left has-text-weight-normal">Cidade</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="cidade" required>
                            </div>
                        </div>
                    </div>
                    <div class="column is-narrow">
                        <label class="label is-left has-text-weight-normal">Estado</label>
                        <div class="control">
                            <div class="select is-small">
                                <select name="estado">
                                    <option value="AC">AC</option>
                                    <option value="AL">AL</option>
                                    <option value="AP">AP</option>
                                    <option value="AM">AM</option>
                                    <option value="BA">BA</option>
                                    <option value="CE">CE</option>
                                    <option value="DF">DF</option>
                                    <option value="ES">ES</option>
                                    <option value="GO">GO</option>
                                    <option value="MA">MA</option>
                                    <option value="MT">MT</option>
                                    <option value="MS">MS</option>
                                    <option value="MG">MG</option>
                                    <option value="PA">PA</option>
                                    <option value="PB">PB</option>
                                    <option value="PR">PR</option>
                                    <option value="PE">PE</option>
                                    <option value="PI">PI</option>
                                    <option value="RJ">RJ</option>
                                    <option value="RN">RN</option>
                                    <option value="RS">RS</option>
                                    <option value="RO">RO</option>
                                    <option value="RR">RR</option>
                                    <option value="SC">SC</option>
                                    <option value="SP">SP</option>
                                    <option value="SE">SE</option>
                                    <option value="TO">TO</option>
                                    <option value="ES">ES</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label class="label is-left has-text-weight-normal">CEP</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="cep" required>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="columns">
                    <div class="column">
                        <div class="field">
                            <label class="label is-left has-text-weight-normal">Telefone</label>
                            <div class="control">
                                <input class="input is-small" type="text" name="telefone" required>
                            </div>
                        </div>
                    </div>
                    <div class="column is-2">
                        <div class="field">
                            <label class="label is-left has-text-weight-normal">Abre às</label>
                            <div class="control">
                                <input class="input is-small" type="time" name="horaAbre">
                            </div>
                        </div>
                    </div>
                    <div class="column is-2">
                        <div class="field">
                            <label class="label is-left has-text-weight-normal">Fecha às</label>
                            <div class="control">
                                <input class="input is-small" type="time" name="horaFecha">
                            </div>
                        </div>
                    </div>
                </div>
                <input class="button is-success is-fullwidth" type="submit" value="Criar">
            </div>
        </div>
    </form>
</html>
