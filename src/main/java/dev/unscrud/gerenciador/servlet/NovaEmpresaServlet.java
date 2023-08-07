package dev.unscrud.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
        String name = req.getParameter("nome");
        processRequest(req, resp, name);
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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NovaEmpresaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NovaEmpresaServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>The name "+name+" came in the request!</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
