package com.biblioteca.singleton;

public class ConexaoSingleton {
    private static ConexaoSingleton instancia;

    private ConexaoSingleton() {
        System.out.println("ConexÃ£o inicializada (simulada)");
    }

    public static ConexaoSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoSingleton();
        }
        return instancia;
    }
}
