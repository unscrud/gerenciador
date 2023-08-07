package dev.unscrud.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NovaEmpresaServlet", urlPatterns = {"/novaEmpresa"})
public class NovaEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastrando nova emrpesa");
        String nome = req.getParameter("nome");
        Empresa empresa = new Empresa();
        empresa.setNome(nome);
        
        Banco banco = new Banco();
        banco.adiciona(empresa);
        
        processRequest(req, resp, nome);
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param name
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String name)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request
            .getRequestDispatcher("/novaEmpresaCriada.jsp")
            .forward(request, response);
    }

}
