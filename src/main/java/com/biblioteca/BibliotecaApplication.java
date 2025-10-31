package com.biblioteca;

// Imports necessários
import com.biblioteca.biblioteca.Biblioteca;
import com.biblioteca.notificacao.NotificadorEmail;
import com.biblioteca.notificacao.NotificadorSMS;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BibliotecaApplication {
    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    /**
     * Este Bean é executado na inicialização.
     * Usamos ele para registrar nossos Observadores no Singleton da Biblioteca.
     */
    @Bean
    public CommandLineRunner registrarObservadores() {
        return args -> {
            System.out.println("--- Registrando Observadores ---");
            Biblioteca bib = Biblioteca.getInstancia();
            
            bib.adicionarObservador(new NotificadorEmail());
            bib.adicionarObservador(new NotificadorSMS());
            
            System.out.println("Observadores registrados com sucesso.");
            System.out.println("---------------------------------");
        };
    }
}