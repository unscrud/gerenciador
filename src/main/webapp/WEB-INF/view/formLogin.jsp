<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/usuarios?acao=logar" var="linkEfetuarLogin" />
<!DOCTYPE html>
<html>
    <head>
        <title>
            Efetuar Login
        </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        <h1>
            Login no Sistema
        </h1>
        
        <form 
            action="${linkEfetuarLogin}"
            method="post"
        >
            <label for="login">Login: </label>
            <input id="login" type="text" name="login" />
            <br />

            <label for="senha">Senha:</label>
            <input id="senha" type="password" name="senha" />
            <br />
            
            <input type="submit" value="Enviar" />
            <br />
            
            <c:if test="${not empty param.msg}">
                * NÃO FOI POSSÍVEL EFETUAR O LOGIN, VERIFIQUE SUAS CREDENCIAIS
            </c:if>
        </form>
    </body>
</html>
