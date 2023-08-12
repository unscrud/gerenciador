package dev.unscrud.gerenciador.acao.empresa;

import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.modelo.Banco;
import dev.unscrud.gerenciador.modelo.Empresa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Editar implements Acao {
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
        Date dataAbertura = null;
        
        try {
            dataAbertura = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(request.getParameter("dataAbertura"));
        } catch (ParseException ex) {
            Logger.getLogger(Editar.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPor(id);
        empresa.setNome(nome);
        empresa.setDataAbertura(dataAbertura);
        
        response.sendRedirect("empresas?acao=listar&empresaEditada="+empresa.getNome());
    }
}
