package dev.unscrud.gerenciador.servlet;

import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.util.StringUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class PreparaAcao {
    public static void executar(String origem, HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String parametroAcao = StringUtil
                .CapitalizarPrimeiraLetra(request.getParameter("acao").toLowerCase());
        
        String nomeDaClasse = origem + parametroAcao;
        
        try {
            Class classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            acao.executar(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PreparaAcao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
