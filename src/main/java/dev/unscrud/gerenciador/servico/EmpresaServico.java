package dev.unscrud.gerenciador.servico;

import dev.unscrud.gerenciador.modelo.Banco;
import dev.unscrud.gerenciador.modelo.Empresa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpresaServico {

    public void listar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        System.out.println("");
        Banco banco = new Banco();
        List<Empresa> empresas = banco.getEmpresas();
        
        request.setAttribute("empresas", empresas);
        
        request
            .getRequestDispatcher("/listaEmpresas.jsp")
            .forward(request, response);
    }
    
    public void criar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nomeEmpresa = request.getParameter("nome");
        Date dataAbertura = null;
        
        try {
            dataAbertura = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(request.getParameter("dataAbertura"));
        } catch (ParseException ex) {
            Logger.getLogger(EmpresaServico.class.getName())
                    .log(Level.SEVERE, null, ex);
            throw  new ServletException(ex);
        }

        Banco banco = new Banco();
        banco.adiciona(nomeEmpresa, dataAbertura);

        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("empresas?acao=listar&empresaCriada="+nomeEmpresa);
    }
    
    public void buscar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("idDaEmpresa"));
        
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPor(id);

        request.setAttribute("empresa", empresa);
        
        request.getRequestDispatcher("/formEmpresa.jsp")
            .forward(request, response);
    }
    
    public void editar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
        Date dataAbertura = null;
        
        try {
            dataAbertura = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(request.getParameter("dataAbertura"));
        } catch (ParseException ex) {
            Logger.getLogger(EmpresaServico.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPor(id);
        empresa.setNome(nome);
        empresa.setDataAbertura(dataAbertura);
        
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("empresas?acao=listar&empresaEditada="+empresa.getNome());
    }
    public void remover(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("idDaEmpresa"));
        
        Banco banco = new Banco();
        banco.remove(id);
        
        response.setContentType("text/html;charset=UTF-8");
        response.sendRedirect("empresas");
    }
}
