package com.biblioteca.emprestimo;

public class ProfessorMulta implements MultaStrategy {
    private static final double MULTA_POR_DIA = 1.25; // Ex: 1 real e 25 centavos

    @Override
    public double calcularMulta(long diasAtraso) {
        return diasAtraso * MULTA_POR_DIA;
    }
}