<%@tag import="io.github.fernandasj.modelo.Usuario"%>
<%@tag import="io.github.fernandasj.modelo.SolicitaAmizade"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Verifica a situação de amizade entre os usuários" pageEncoding="UTF-8"%>
<%@attribute name="situacao" required="true" type="SolicitaAmizade"%>
<%@attribute name="usuario" required="true" type="Usuario"%>
<%@attribute name="pagina" required="true"%>

<c:choose>
    <c:when test="${situacao != null}">
        <c:choose>
            <c:when test="${situacao.solicitacao eq 'amigo'}">
                <a href="front?action=Amizade&met=remove&dest=${usuario.id}&pag=${pagina}" class="button is-small is-danger">
                    <span class="icon is-small">
                        <i class="fas fa-user-slash"></i>
                    </span>
                    <span>Desfazer Amizade</span>
                </a>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${sessionScope.usuario.id == situacao.remetente}">
                        <a class="button is-small is-success" disabled>
                            <span class="icon is-small">
                                <i class="fas fa-check"></i>
                            </span>
                            <span>Amizade Solicitada</span>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="front?action=Amizade&met=adiciona&dest=${usuario.id}&pag=${pagina}" class="button is-small is-success">
                            <span>Aceitar</span>
                        </a>
                        <a href="front?action=Amizade&met=remove&dest=${usuario.id}&pag=${pagina}" class="button is-small is-danger">
                            <span>Recusar</span>
                        </a>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </c:when>
    <c:otherwise>
        <a class="button is-small is-info" href="front?action=Amizade&met=solicita&dest=${usuario.id}&pag=${pagina}">
            <span class="icon is-small">
                <i class="fas fa-user-plus"></i>
            </span>
            <span>Adiconar Amigo</span>
        </a>
    </c:otherwise>
</c:choose>