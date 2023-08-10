<%@page import="java.util.List"%>
<%@page import="dev.unscrud.gerenciador.servlet.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Empresas</h1>
        <c:if test="${empty empresas}">
            <p>Não existem empresas a serem exibidas</p>
        </c:if>
        
        <c:if test="${not empty empresas}">
            <ul>
                <c:forEach items="${empresas}" var="empresa">
                    <li>${empresa.nome}</li>
                </c:forEach>
            </ul>
        </c:if>
    </body>
</html>
