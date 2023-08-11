package dev.unscrud.gerenciador.servico;

import dev.unscrud.gerenciador.modelo.Banco;
import dev.unscrud.gerenciador.modelo.Empresa;
import java.io.IOException;
import java.util.List;
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


    
}
