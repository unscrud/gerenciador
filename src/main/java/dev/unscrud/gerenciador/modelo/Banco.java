package dev.unscrud.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class Banco {
    private static final List<Empresa> empresas = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Banco.empresas.add(new Empresa(Banco.chaveSequencial++, "Caelum", null));
        Banco.empresas.add(new Empresa(Banco.chaveSequencial++, "Alura", null));
        Banco.empresas.add(new Empresa(Banco.chaveSequencial++, "Google", null));
        Banco.empresas.add(new Empresa(Banco.chaveSequencial++, "Microsoft", null));
    }
    
    public void adiciona(String nomeEmpresa, Date dataAbertura) {
        empresas.add(new Empresa(Banco.chaveSequencial++, nomeEmpresa, dataAbertura));
    }
    
    public List<Empresa> getEmpresas() {
        return Banco.empresas;
    }

    public void remove(Integer id) {
        Predicate<Empresa> condicao = empresa -> empresa.getId() == id;
        Banco.empresas.removeIf(condicao);
    }

    public Empresa buscaEmpresaPor(Integer id) {
        return Banco.empresas.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
