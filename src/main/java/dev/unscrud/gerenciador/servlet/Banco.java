package dev.unscrud.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

class Banco {
    private static List<Empresa> empresas = new ArrayList<>();

    static {
        empresas.add(new Empresa("Caelum"));
        empresas.add(new Empresa("Alura"));
        empresas.add(new Empresa("Google"));
        empresas.add(new Empresa("Microsoft"));
    }
    
    public void adiciona(Empresa empresa) {
        empresas.add(empresa);
    }
    
    public List<Empresa> getEmpresas() {
        return Banco.empresas;
    }
}
