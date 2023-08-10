package dev.unscrud.gerenciador.servlet;

import java.util.Date;

public class Empresa {
    private Integer id;
    private String nome;
    private Date dataAbertura;

    public Empresa(Integer id, String nome, Date dataAbertura) {
        this.id = id;
        this.nome = nome;
        this.dataAbertura = dataAbertura == null ? new Date() : dataAbertura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
