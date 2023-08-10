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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Cadastrando nova emrpesa");
        String nome = request.getParameter("nome");
        Empresa empresa = new Empresa(nome);
        
        Banco banco = new Banco();
        banco.adiciona(empresa);
        
        request.setAttribute("nome", empresa.getNome());
        
        response.setContentType("text/html;charset=UTF-8");
        request
            .getRequestDispatcher("/novaEmpresaCriada.jsp")
            .forward(request, response);
    }
}
