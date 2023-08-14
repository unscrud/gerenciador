package dev.unscrud.gerenciador.servlet;

import dev.unscrud.gerenciador.util.Constantes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "empresas", urlPatterns = {"/empresas"})
public class EmpresaController extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
        boolean usuarioNaoEstaLogado = sessao.getAttribute("usuarioLogado") == null;
        if (usuarioNaoEstaLogado) {
            response.sendRedirect("usuarios?acao=acessar&msg=erro");
        } else {
            PreparaAcao.executar(Constantes.ACOES_EMPRESAS, request,response);
        }
    }
}
