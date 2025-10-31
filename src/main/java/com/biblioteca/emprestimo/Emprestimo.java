package com.biblioteca.emprestimo;

import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;
import java.time.LocalDate;

public class Emprestimo {

    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        // Vamos definir um padrão de 7 dias para devolução
        this.dataDevolucaoPrevista = this.dataEmprestimo.plusDays(7); 
    }

    public long getDiasAtraso() {
        // Se a data de devolução real não foi setada, não há atraso (ou ainda está emprestado)
        if (dataDevolucaoReal == null) {
            // Poderíamos calcular o atraso parcial, mas vamos focar na devolução
            return 0; 
        }

        // Calcula a diferença de dias
        long dias = java.time.temporal.ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataDevolucaoReal);
        
        // Retorna apenas se for positivo (atrasado)
        return Math.max(0, dias); 
    }
    
    public double calcularMulta() {
        long diasAtraso = getDiasAtraso();
        if (diasAtraso > 0) {
            // Aqui usamos o Padrão Strategy!
            return usuario.calcularMulta(diasAtraso);
        }
        return 0.0;
    }

    // --- Getters e Setters ---
    
    public Livro getLivro() { return livro; }
    public Usuario getUsuario() { return usuario; }
    public LocalDate getDataDevolucaoReal() { return dataDevolucaoReal; }
    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }
}