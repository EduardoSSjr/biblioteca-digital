package com.biblioteca.service;

import com.biblioteca.dao.LivroDAO;
import com.biblioteca.factory.LivroFactory;
import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    private final LivroDAO livroDAO;

    public BibliotecaService(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }

    public List<Livro> listarLivros() {
        return livroDAO.buscarTodos();
    }

    public List<Livro> listarLivrosDisponiveis() {
        return livroDAO.buscarDisponiveis();
    }

    public void cadastrarLivro(String titulo, String autor) {
        Livro livro = LivroFactory.criarLivro(titulo, autor); // <<< Factory Method aqui
        livroDAO.salvar(livro);
    }

    public void emprestarLivro(int idLivro, String nomeUsuario) {
        Livro livro = livroDAO.buscarPorId(idLivro);
        if (livro != null && livro.isDisponivel()) {
            livro.setDisponivel(false);
            livro.setUsuarioEmprestimo(new Usuario(nomeUsuario));
            livroDAO.atualizar(livro);
        }
    }

    public void devolverLivro(int idLivro) {
        Livro livro = livroDAO.buscarPorId(idLivro);
        if (livro != null && !livro.isDisponivel()) {
            livro.setDisponivel(true);
            livro.setUsuarioEmprestimo(null);
            livroDAO.atualizar(livro);
        }
    }
}
