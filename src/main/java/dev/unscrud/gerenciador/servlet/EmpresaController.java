package dev.unscrud.gerenciador.servlet;

import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.util.Constantes;
import dev.unscrud.gerenciador.util.StringUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String parametroAcao = StringUtil
                    .CapitalizarPrimeiraLetra(request.getParameter("acao"));

            String nomeDaClasse = Constantes.ACOES_EMPRESAS + parametroAcao;

            try {
                Class classe = Class.forName(nomeDaClasse);
                Acao acao = (Acao) classe.newInstance();
                acao.executar(request, response);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
