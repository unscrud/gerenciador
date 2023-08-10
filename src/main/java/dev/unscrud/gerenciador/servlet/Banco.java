package dev.unscrud.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

class Banco {
    private static List<Empresa> empresas = new ArrayList<>();

    static {
        empresas.add(new Empresa("Caelum", null));
        empresas.add(new Empresa("Alura", null));
        empresas.add(new Empresa("Google", null));
        empresas.add(new Empresa("Microsoft", null));
    }
    
    public void adiciona(Empresa empresa) {
        empresas.add(empresa);
    }
    
    public List<Empresa> getEmpresas() {
        return Banco.empresas;
    }
}
