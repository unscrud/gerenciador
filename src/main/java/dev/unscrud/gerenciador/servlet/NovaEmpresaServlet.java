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

@WebServlet(name = "NovaEmpresaServlet", urlPatterns = {"/novaEmpresa"})
public class NovaEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        System.out.println("Cadastrando nova emrpesa");
        String nomeEmpresa = request.getParameter("nome");
        Date dataAbertura = null;
        
        try {
            dataAbertura = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(request.getParameter("dataAbertura"));
        } catch (ParseException ex) {
            Logger.getLogger(NovaEmpresaServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
            throw  new ServletException(ex);
        }

        Banco banco = new Banco();
        banco.adiciona(nomeEmpresa, dataAbertura);
        
        request.setAttribute("nome", nomeEmpresa);
        request.setAttribute("data", dataAbertura);

        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("empresas");
//        request
//            .getRequestDispatcher("/empresas")
//            .forward(request, response);
    }
}
