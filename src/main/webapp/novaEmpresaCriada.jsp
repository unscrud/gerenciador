<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Empresa Criada</title>
    </head>
    <body>
        <h1>Nova Empresa</h1>
        <c:if test="${not empty nome}">
            <p> A empresa ${nome} foi criada com sucesso!</p>
        </c:if>
        <c:if test="${empty nome}">
            <p> Nenhuma empresa foi cadastrada!</p>
        </c:if>
    </body>
</html>
