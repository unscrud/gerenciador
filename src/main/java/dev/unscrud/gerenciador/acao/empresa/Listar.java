package dev.unscrud.gerenciador.acao.empresa;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import dev.unscrud.gerenciador.acao.Acao;
import dev.unscrud.gerenciador.modelo.Banco;
import dev.unscrud.gerenciador.modelo.Empresa;
import dev.unscrud.gerenciador.util.Constantes;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Listar implements Acao {
    
    private enum Formatos { JSON, XML }
    
    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
                Banco banco = new Banco();
        List<Empresa> empresas = banco.getEmpresas();
        
        String formato = request.getParameter("format");
        
        if (formato == null) {
            request.setAttribute("empresas", empresas);
            request
                .getRequestDispatcher(Constantes.PREFIXO_URL_JSP + "listaEmpresas.jsp")
                .forward(request, response);
        } else {
            String content = "";
            String contentType = "";
            switch (Formatos.valueOf(formato.toUpperCase())) {
                case JSON:
                    Gson gson = new Gson();
                    content = gson.toJson(empresas);
                    contentType = "application/json";
                    break;
                case XML:
                    XStream xStream = new XStream();
                    xStream.alias("empresa", Empresa.class);
                    content = xStream.toXML(empresas);
                    contentType = "application/xml";
                    break;
            }
            
            response.setContentType(contentType);
            response.getWriter().print(content);
        }
    }
}
