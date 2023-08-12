package dev.unscrud.gerenciador.acao.empresa;

import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.modelo.Banco;
import dev.unscrud.gerenciador.modelo.Empresa;
import dev.unscrud.gerenciador.util.Constantes;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Listar implements Acao {
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
                Banco banco = new Banco();
        List<Empresa> empresas = banco.getEmpresas();
        
        request.setAttribute("empresas", empresas);
        
        request
            .getRequestDispatcher(Constantes.PREFIXO_URL_JSP + "listaEmpresas.jsp")
            .forward(request, response);
    }
}
