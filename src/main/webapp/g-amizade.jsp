<%-- 
    Document   : g-amizade
    Created on : 05/10/2018, 16:53:46
    Author     : Amanda
--%>

<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:set var="situacao" value="${amizadeDao.situacao(sessionScope.usuario.id, usuarios.id)}"></c:set>
    <c:choose>
        <c:when test="${situacao == 'amigo'}">
            <a class="button is-danger">
                <span class="icon is-small">
                    <i class="fas fa-user-slash"></i>
                </span>
                <span>Desfazer Amizade</span>
            </a>
        </c:when>
        <c:when test="${situacao == 'solicitado'}">
            <a class="button is-success" disabled>
                <span class="icon is-small">
                    <i class="fas fa-check"></i>
                </span>
                <span>Amizade Solicitada</span>
            </a>
        </c:when>
        <c:otherwise>
            <a class="button is-info" href="front?action=Amizade&met=adiciona&dest=${usuarios.id}">
                <span class="icon is-small">
                    <i class="fas fa-user-plus"></i>
                </span>
                <span>Adiconar Amigo</span>
            </a>
        </c:otherwise>
    </c:choose>
</html>
