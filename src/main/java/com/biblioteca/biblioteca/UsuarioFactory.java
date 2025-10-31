package com.biblioteca.biblioteca;

import com.biblioteca.model.Aluno;
import com.biblioteca.model.Professor;
import com.biblioteca.model.Usuario;

public class UsuarioFactory {
    
    private static int contadorId = 1; // <<< ADICIONADO

    public static Usuario criarUsuario(String tipo, String nome) {
        Usuario usuario;
        
        if ("ALUNO".equalsIgnoreCase(tipo)) {
            usuario = new Aluno(nome);
        } else if ("PROFESSOR".equalsIgnoreCase(tipo)) {
            usuario = new Professor(nome);
        } else {
            throw new IllegalArgumentException("Tipo de usuário desconhecido.");
        }
        
        usuario.setId(contadorId++); // <<< ADICIONADO
        return usuario;
    }
}