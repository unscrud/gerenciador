package dev.unscrud.gerenciador.acao.empresa;

import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.modelo.Banco;
import dev.unscrud.gerenciador.modelo.Empresa;
import dev.unscrud.gerenciador.util.Constantes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Buscar implements Acao {
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("idDaEmpresa"));
        
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPor(id);

        request.setAttribute("empresa", empresa);
        
        request.getRequestDispatcher(Constantes.PREFIXO_URL_JSP + "formEmpresa.jsp")
            .forward(request, response);
    }
}
