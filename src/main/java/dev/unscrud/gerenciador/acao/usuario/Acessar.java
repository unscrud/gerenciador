package dev.unscrud.gerenciador.acao.usuario;

import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.util.Constantes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Acessar implements Acao {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher(Constantes.PREFIXO_URL_JSP + "formLogin.jsp")
            .forward(request, response);
    }
    
}
