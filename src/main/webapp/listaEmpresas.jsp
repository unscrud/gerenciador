<%@page import="java.util.List"%>
<%@page import="dev.unscrud.gerenciador.servlet.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Empresas</h1>
        <%
            List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
            if (empresas == null || empresas.isEmpty()) {
        %>
                <%= "<p>Não existem empresas a serem exibidas</p>" %>
        <%
            } else { 
        %>
        <ol>
            <%
                for( Empresa empresa : empresas){
            %>
            <li> <%= empresa.getNome() %></li>
            <%
                }
            %>
        </ol>
        <%
            }
        %>
    </body>
</html>
