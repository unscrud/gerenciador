package dev.unscrud.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuscaEmpresaServlet", urlPatterns = {"/buscaEmpresa"})
public class BuscaEmpresaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("idDaEmpresa"));
        
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPor(id);

        req.setAttribute("empresa", empresa);
        req.setAttribute("dataFormatada", empresa.getDataAberturaFormatada());
        
        req.getRequestDispatcher("/formNovaEmpresa.jsp")
            .forward(req, resp);
    }
}
