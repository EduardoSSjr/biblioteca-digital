package com.biblioteca.biblioteca;

import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;
import com.biblioteca.notificacao.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 * Padrão Singleton: Garante que exista apenas uma instância da Biblioteca.
 * Requisito do PDF.
 */
public class Biblioteca {

    private static Biblioteca instancia;

    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>(); // <<< ADICIONADO
    
    private final List<Observador> observadores = new ArrayList<>();

    private Biblioteca() {
        // Construtor privado
    }

    public static synchronized Biblioteca getInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    // --- Métodos de Livro ---

    public void adicionarLivro(Livro livro) {
        this.livros.add(livro);
        // Notifica observadores sobre novo livro (Padrão Observer)
        notificarObservadores("Novo livro cadastrado: " + livro.getTitulo());
    }

    public List<Livro> listarTodosLivros() {
        return new ArrayList<>(livros);
    }
    
    public Livro buscarLivroPorId(int id) {
        return livros.stream()
                     .filter(l -> l.getId() == id)
                     .findFirst()
                     .orElse(null);
    }

    // --- MÉTODOS DE USUÁRIO (AQUI ESTÁ A CORREÇÃO) ---
    
    /**
     * Adiciona um usuário à lista (usado pelo UsuarioFactory via Service).
     */
    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        System.out.println("Usuário cadastrado: " + usuario.getNome() + " (ID: " + usuario.getId() + ")");
    }

    /**
     * Lista todos os usuários (usado pelo Service).
     * CORRIGE O ERRO: The method listarTodosUsuarios() is undefined...
     */
    public List<Usuario> listarTodosUsuarios() {
        return new ArrayList<>(usuarios);
    }

    /**
     * Busca um usuário pelo ID (usado pelo Service).
     * CORRIGE O ERRO: The method buscarUsuarioPorId(int) is undefined...
     */
    public Usuario buscarUsuarioPorId(int id) {
        return usuarios.stream()
                       .filter(u -> u.getId() == id)
                       .findFirst()
                       .orElse(null);
    }
    
    // --- Métodos para o Padrão Observer ---
    
    public void adicionarObservador(Observador obs) {
        this.observadores.add(obs);
    }

    public void removerObservador(Observador obs) {
        this.observadores.remove(obs);
    }

    public void notificarObservadores(String mensagem) {
        System.out.println("Notificando " + observadores.size() + " observadores...");
        for (Observador obs : observadores) {
            obs.atualizar(mensagem);
        }
    }
}