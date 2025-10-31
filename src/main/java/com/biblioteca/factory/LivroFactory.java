package com.biblioteca.factory;

import com.biblioteca.model.Livro;

public class LivroFactory {
    private static int contador = 1;

    public static Livro criarLivro(String titulo, String autor) {
        Livro livro = new Livro(titulo, autor);
        livro.setId(contador++); // gera o ID automaticamente
        return livro;
    }
}
