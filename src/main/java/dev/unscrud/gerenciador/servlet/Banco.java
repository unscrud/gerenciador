package dev.unscrud.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Banco {
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
}
