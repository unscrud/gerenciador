<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/empresas?acao=criar" var="linkCriarEmpresa" />
<c:url value="/empresas?acao=editar" var="linkEditarEmpresa" />
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:formatDate var="dataFormatada" value="${empresa.dataAbertura}" pattern="yyyy-MM-dd" />
<!DOCTYPE html>
<html>
    <head>
        <title>
            ${not empty empresa ? "Editar empresa" : "Criar Empresa"}
        </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <h1>
            ${not empty empresa ? "Editar empresa" : "Criar Empresa"}
        </h1>
        
        <form 
            action="${not empty empresa ? linkEditarEmpresa : linkCriarEmpresa}"
            method="post"
        >
            <c:if test="${not empty empresa}">
                <input type="hidden" name="id" value="${empresa.id}" />
            </c:if>

            <label for="nome">Nome da Empresa</label>
            <input
                id="nome" type="text" name="nome" 
                value="${not empty empresa ? empresa.nome: ""}" 
            />
            <br />

            <label for="dataAbertura">Data de Abertura</label>
            <input 
                id="dataAbertura" type="date" name="dataAbertura" 
                value="${not empty empresa ? dataFormatada : ""}" 
            />
            <br />
            
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
