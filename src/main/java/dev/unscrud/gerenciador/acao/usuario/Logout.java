package dev.unscrud.gerenciador.acao.usuario;

import dev.unscrud.gerenciador.acao.Acao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Acao{
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("usuarios?acao=acessar");
    }
}
