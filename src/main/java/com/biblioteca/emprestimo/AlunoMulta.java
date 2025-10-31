package com.biblioteca.emprestimo;

public class AlunoMulta implements MultaStrategy {
    private static final double MULTA_POR_DIA = 0.50; // Ex: 50 centavos

    @Override
    public double calcularMulta(long diasAtraso) {
        return diasAtraso * MULTA_POR_DIA;
    }
}