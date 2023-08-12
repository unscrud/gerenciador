package dev.unscrud.gerenciador.acao.empresa;

import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.modelo.Banco;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Criar implements Acao {
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String nomeEmpresa = request.getParameter("nome");
        Date dataAbertura = null;
        
        try {
            dataAbertura = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(request.getParameter("dataAbertura"));
        } catch (ParseException ex) {
            Logger.getLogger(Criar.class.getName())
                    .log(Level.SEVERE, null, ex);
            throw  new ServletException(ex);
        }

        Banco banco = new Banco();
        banco.adiciona(nomeEmpresa, dataAbertura);

        response.sendRedirect("empresas?acao=listar&empresaCriada="+nomeEmpresa);
    }
}
