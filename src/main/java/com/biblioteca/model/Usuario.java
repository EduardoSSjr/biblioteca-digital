package com.biblioteca.model;

import com.biblioteca.emprestimo.MultaStrategy;

public abstract class Usuario {
    private int id; // <<< ADICIONADO
    private String nome;
    protected String tipo; // <<< ADICIONADO
    protected MultaStrategy multaStrategy;

    public Usuario(String nome) {
        this.nome = nome;
    }

    // Método abstrato para o Strategy
    public abstract double calcularMulta(long diasAtraso);

    // --- Getters e Setters ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}