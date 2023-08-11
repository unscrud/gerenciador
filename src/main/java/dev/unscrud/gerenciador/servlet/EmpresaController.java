package dev.unscrud.gerenciador.servlet;

import dev.unscrud.gerenciador.servico.EmpresaServico;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "empresas", urlPatterns = {"/empresas"})
public class EmpresaController extends HttpServlet {
    private enum TipoAcao {
        LISTAR, BUSCAR, EDITAR, CRIAR, REMOVER;
        
    }
    
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TipoAcao acao = TipoAcao.valueOf( request.getParameter("acao").toUpperCase() );
        
        EmpresaServico empresaServico = new EmpresaServico();
        
        switch (acao) {
            case LISTAR:
                empresaServico.listar(request, response);
                break;
            case BUSCAR:
                System.out.println("Vai buscar");
                
                break;
            case EDITAR:
                System.out.println("Vai editar");
                
                break;
            case CRIAR:
                empresaServico.criar(request, response);
                break;
            case REMOVER:
                System.out.println("Vai remover");
                
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
}
