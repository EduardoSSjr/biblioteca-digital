package com.biblioteca.notificacao;

public class NotificadorSMS implements Observador {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("[SMS] Notificação enviada: '" + mensagem + "'");
        // (Aqui entraria a lógica real de envio de SMS)
    }
}