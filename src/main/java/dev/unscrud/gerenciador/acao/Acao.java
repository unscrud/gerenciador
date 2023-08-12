package dev.unscrud.gerenciador.acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
    public void executar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException;
}
