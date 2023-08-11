package dev.unscrud.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditaEmpresaServlet", urlPatterns = {"/editaEmpresa"})
public class EditaEmpresaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String nome = req.getParameter("nome");
        Date dataAbertura = null;
        
        try {
            dataAbertura = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(req.getParameter("dataAbertura"));
        } catch (ParseException ex) {
            Logger.getLogger(EditaEmpresaServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPor(id);
        empresa.setNome(nome);
        empresa.setDataAbertura(dataAbertura);

        req.setAttribute("empresaEditada", empresa.getNome());
        
        resp.setContentType("text/html;charset=UTF-8");
        resp.sendRedirect("empresas");
    }
}
