package com.biblioteca.service;

import com.biblioteca.biblioteca.Biblioteca; // O Singleton
import com.biblioteca.biblioteca.LivroFactory;
import com.biblioteca.biblioteca.UsuarioFactory; // O Factory
import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaService {

    // Não injetamos mais o LivroDAO. Usamos o Singleton diretamente.
    private final Biblioteca biblioteca;

    public BibliotecaService() {
        // Obtém a instância única da Biblioteca
        this.biblioteca = Biblioteca.getInstancia();
    }

    // --- Métodos de Livro ---

    public List<Livro> listarLivros() {
        return biblioteca.listarTodosLivros();
    }

    public List<Livro> listarLivrosDisponiveis() {
        return biblioteca.listarTodosLivros().stream()
                .filter(Livro::isDisponivel)
                .collect(Collectors.toList());
    }

    public void cadastrarLivro(String titulo, String autor) {
        // Usando o LivroFactory que você já tinha
        Livro livro = LivroFactory.criarLivro(titulo, autor); 
        biblioteca.adicionarLivro(livro); // Adiciona ao Singleton
        // O Observer será notificado automaticamente pelo método adicionarLivro!
    }

    public void emprestarLivro(int idLivro, int idUsuario) {
        Livro livro = biblioteca.buscarLivroPorId(idLivro);
        Usuario usuario = biblioteca.buscarUsuarioPorId(idUsuario); // Precisamos buscar o usuário

        if (livro != null && livro.isDisponivel() && usuario != null) {
            livro.setDisponivel(false);
            livro.setUsuarioEmprestimo(usuario);
            // (Aqui criaríamos o objeto Emprestimo.java e o salvaríamos
            // na instância da Biblioteca para rastrear multas)
            System.out.println("Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome());
        }
    }

    public void devolverLivro(int idLivro) {
        Livro livro = biblioteca.buscarLivroPorId(idLivro);
        if (livro != null && !livro.isDisponivel()) {
            System.out.println("Livro " + livro.getTitulo() + " devolvido por " + livro.getUsuarioEmprestimo().getNome());
            
            // (Aqui buscaríamos o Emprestimo, setaríamos a data de devolução,
            // calcularíamos a multa usando o Strategy e notificaríamos o usuário)
            
            livro.setDisponivel(true);
            livro.setUsuarioEmprestimo(null);
        }
    }

    // --- Métodos de Usuário (Novos) ---

    /**
     * Novo método para usar o UsuarioFactory.
     */
    public void cadastrarUsuario(String nome, String tipo) {
        // Usa o Factory Method!
        Usuario usuario = UsuarioFactory.criarUsuario(tipo, nome);
        biblioteca.adicionarUsuario(usuario);
    }
    
    public List<Usuario> listarUsuarios() {
        return biblioteca.listarTodosUsuarios();
    }
}