package dev.unscrud.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RemoveEmpresaServlet", urlPatterns = {"/removeEmpresa"})
public class RemoveEmpresaServlet extends HttpServlet {
@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("idDaEmpresa"));
        
        Banco banco = new Banco();
        banco.remove(id);
        
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect("empresas");
    }
}
