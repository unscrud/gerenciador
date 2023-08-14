package dev.unscrud.gerenciador.servlet;

import dev.unscrud.gerenciador.util.Constantes;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "usuarios", urlPatterns = {"/usuarios"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PreparaAcao.executar(Constantes.ACOES_USUARIOS, request,response);

    }

}
