<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="${linkServletNovaEmpresa}" method="post">
            <label for="nome">Nome da Empresa</label>
            <input id="nome" type="text" name="nome" />
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
