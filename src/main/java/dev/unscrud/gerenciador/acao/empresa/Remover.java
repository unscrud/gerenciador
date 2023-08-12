package dev.unscrud.gerenciador.acao.empresa;

import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.modelo.Banco;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Remover implements Acao {
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            Integer id = Integer.valueOf(request.getParameter("idDaEmpresa"));
        
        Banco banco = new Banco();
        banco.remove(id);
        
        response.sendRedirect("empresas?acao=listar");
    }
}
