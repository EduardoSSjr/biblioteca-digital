package com.biblioteca.dao;

import com.biblioteca.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LivroDAO {

    private final List<Livro> livros = new ArrayList<>();

    public void salvar(Livro livro) {
        livros.add(livro);
    }

    public void atualizar(Livro livro) {
        // Lista em memória, nada especial necessário
    }

    public Livro buscarPorId(int id) {
        return livros.stream()
                     .filter(l -> l.getId() == id)
                     .findFirst()
                     .orElse(null);
    }

    public List<Livro> buscarTodos() {
        return new ArrayList<>(livros);
    }

    public List<Livro> buscarDisponiveis() {
        return livros.stream()
                     .filter(Livro::isDisponivel)
                     .collect(Collectors.toList());
    }
}
