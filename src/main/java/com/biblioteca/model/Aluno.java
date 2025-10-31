package com.biblioteca.model;
import com.biblioteca.emprestimo.AlunoMulta;

public class Aluno extends Usuario {
    public Aluno(String nome) {
        super(nome);
        this.multaStrategy = new AlunoMulta();
        this.tipo = "Aluno"; // <<< ADICIONADO
    }
    
    @Override
    public double calcularMulta(long diasAtraso) {
        return this.multaStrategy.calcularMulta(diasAtraso);
    }
}