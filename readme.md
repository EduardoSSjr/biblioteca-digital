-----

# 📚 Biblioteca Digital – Sistema de Gerenciamento (com Padrões GoF)

## 🚀 Visão Geral

Este projeto implementa um sistema de gerenciamento de uma biblioteca digital em Java, com foco principal na aplicação de **padrões de projeto de software (GoF)** clássicos para resolver problemas recorrentes de design, conforme especificado em uma atividade acadêmica.

A aplicação permite **cadastrar livros e usuários (Alunos/Professores), listar ambos e gerenciar empréstimos**, com uma interface web simples desenvolvida com **Spring Boot** e **Thymeleaf**.

-----

## 🧩 Tecnologias e Ferramentas Utilizadas

### 🖥️ Backend

  * **Java 17+**
  * **Spring Boot 3**
      * Spring Web (MVC)
      * Spring Boot DevTools
  * **Thymeleaf** – Template Engine para renderização de páginas HTML dinâmicas.
  * **Banco de Dados em Memória** (via Singleton) – Simula o armazenamento para focar nos padrões.

### 🎨 Frontend

  * **HTML5**
  * **CSS3** (com Bootstrap 5)

-----

## ⚙️ Padrões de Projeto (GoF) Aplicados

O projeto foi refatorado para adotar os seguintes padrões de design, conforme os requisitos da atividade:

| Padrão | Descrição | Onde é aplicado |
| --- | --- | --- |
| **Singleton** | [cite\_start]Garante que a classe `Biblioteca` tenha uma única instância global para gerenciar o estado (livros, usuários). [cite: 14] | `com.biblioteca.biblioteca.Biblioteca.java` |
| **Factory Method** | [cite\_start]Centraliza a criação de diferentes tipos de `Usuario` (Aluno, Professor), permitindo fácil expansão. [cite: 18] | `com.biblioteca.biblioteca.UsuarioFactory.java` |
| **Observer** | [cite\_start]Permite que múltiplos "notificadores" (Email, SMS) "assistam" à biblioteca e reajam a eventos (ex: cadastro de novo livro). [cite: 22] | `com.biblioteca.notificacao.Observador.java` e suas implementações. |
| **Strategy** | [cite\_start]Define uma família de algoritmos para o cálculo de multas, permitindo que cada tipo de usuário tenha sua própria regra. [cite: 27] | `com.biblioteca.emprestimo.MultaStrategy.java` e suas implementações. |
| **MVC** | Padrão arquitetural do Spring Boot, separando `Controllers` (rotas), `Models` (dados) e `Views` (Thymeleaf). | Estrutura geral da aplicação. |

-----

## 🗂️ Estrutura de Pastas

[cite\_start]A estrutura de pacotes foi organizada para refletir os padrões e funcionalidades [cite: 31-52]:

```text
biblioteca-digital/
│
├── src/
│ ├── main/
│ │ ├── java/com/biblioteca/
│ │ │ ├── biblioteca/    → Padrões Singleton e Factories
│ │ │ │   ├── Biblioteca.java
│ │ │ │   ├── UsuarioFactory.java
│ │ │ │   └── LivroFactory.java
│ │ │ ├── controller/    → Controladores MVC (rotas da aplicação)
│ │ │ │   └── LivroController.java
│ │ │ ├── emprestimo/    → Padrão Strategy
│ │ │ │   ├── MultaStrategy.java
│ │ │ │   ├── AlunoMulta.java
│ │ │ │   └── Emprestimo.java
│ │ │ ├── model/         → Entidades (Livro, Usuario, Aluno, etc.)
│ │ │ ├── notificacao/   → Padrão Observer
│ │ │ │   ├── Observador.java
│ │ │ │   ├── NotificadorEmail.java
│ │ │ │   └── NotificadorSMS.java
│ │ │ ├── service/       → Lógica de negócio (orquestrador)
│ │ │ │   └── BibliotecaService.java
│ │ │ └── BibliotecaApplication.java
│ │ └── resources/
│ │ ├── templates/     → Páginas HTML (Thymeleaf)
│ │ └── application.properties
│
├── pom.xml → Gerenciador de dependências Maven
└── README.md → Documentação do projeto
```

-----

## ⚡ Como Executar o Projeto

### 1\. Clonar o Repositório

```bash
git clone https://github.com/SEU_USUARIO/biblioteca-digital.git
cd biblioteca-digital
```

### 2\. Compilar e Rodar o Projeto

Usando Maven (recomendado):

```bash
mvn spring-boot:run
```

Ou diretamente pela sua IDE (botão "Run" no `BibliotecaApplication.java` [file: `eduardossjr/biblioteca-digital/biblioteca-digital-main/src/main/java/com/biblioteca/BibliotecaApplication.java`]).

### 3\. Acessar no Navegador

```bash
http://localhost:8080
```

-----

## 🧠 Funcionalidades Principais

✅ **Usuários:**

  * Cadastrar novos usuários (Aluno ou Professor) - (Padrão **Factory Method**)
  * Listar usuários cadastrados

✅ **Livros:**

  * Cadastrar novos livros - (Padrão **Observer** notifica no console)
  * Listar livros cadastrados e seu status

✅ **Empréstimos:**

  * Registrar empréstimos (associando um usuário a um livro)
  * Registrar devoluções (liberando o livro)
  * (Pronto para) Cálculo de multas via Padrão **Strategy**