<%@page import="java.util.List"%>
<%@page import="dev.unscrud.gerenciador.servlet.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/removeEmpresa" var="remover" />
<c:url value="/buscaEmpresa" var="editar" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empresas</title>
    </head>
    <body>
        <c:if test="${not empty nome}">
            <h1>Nova Empresa</h1>
            <p> A empresa ${nome} foi criada com sucesso!</p>
        </c:if>
        
        <h1>Lista de Empresas</h1>
        <c:if test="${empty empresas}">
            <p>Não existem empresas a serem exibidas</p>
        </c:if>
        
        <c:if test="${not empty empresas}">
            <ul>
                <c:forEach items="${empresas}" var="empresa">
                    <li>
                        ${empresa.nome}
                        &nbsp;-&nbsp; 
                        <fmt:formatDate 
                            value="${empresa.dataAbertura}"
                            pattern="dd/MM/yyyy"
                        />
                        &nbsp;-&nbsp; <a href="${editar}?idDaEmpresa=${empresa.id}">editar</a>
                        &nbsp;-&nbsp; <a href="${remover}?idDaEmpresa=${empresa.id}">remover</a>
                    </li>
                </c:forEach>
            </ul>
        </c:if>
    </body>
</html>
