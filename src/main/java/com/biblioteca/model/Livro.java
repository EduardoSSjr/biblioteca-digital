package com.biblioteca.model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private boolean disponivel = true;
    private Usuario usuarioEmprestimo;

    public Livro() {} // necessário para Factory e Spring

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public Usuario getUsuarioEmprestimo() { return usuarioEmprestimo; }
    public void setUsuarioEmprestimo(Usuario usuarioEmprestimo) { this.usuarioEmprestimo = usuarioEmprestimo; }
}
