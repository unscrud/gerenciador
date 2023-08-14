package dev.unscrud.gerenciador.acao.usuario;

import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.modelo.Banco;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logar implements Acao{

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Banco banco = new Banco();
        boolean usuarioExiste = banco.verificaSeUsuárioESenhaConferem(login,senha);
        
        if (usuarioExiste){
            response.sendRedirect("empresas?acao=listar");
        } else {
            response.sendRedirect("usuarios?acao=acessar&msg=erro");
        }
    }
    
}
