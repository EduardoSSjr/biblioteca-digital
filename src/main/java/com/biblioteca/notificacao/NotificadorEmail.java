package com.biblioteca.notificacao;

public class NotificadorEmail implements Observador {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("[EMAIL] Notificação enviada: '" + mensagem + "'");
        // (Aqui entraria a lógica real de envio de e-mail)
    }
}