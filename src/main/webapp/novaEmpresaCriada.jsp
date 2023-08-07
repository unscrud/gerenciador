<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Empresa Criada</title>
    </head>
    <body>
        <h1>Nova Empresa</h1>
        <p> A empresa <%= request.getParameter("nome") %> foi criada com sucesso!</p>
                
    </body>
</html>
