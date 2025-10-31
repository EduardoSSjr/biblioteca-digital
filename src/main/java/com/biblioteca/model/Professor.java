package com.biblioteca.model;
import com.biblioteca.emprestimo.ProfessorMulta;

public class Professor extends Usuario {
    public Professor(String nome) {
        super(nome);
        this.multaStrategy = new ProfessorMulta();
        this.tipo = "Professor"; // <<< ADICIONADO
    }
    
    @Override
    public double calcularMulta(long diasAtraso) {
        return this.multaStrategy.calcularMulta(diasAtraso);
    }
}