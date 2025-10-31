# 📚 Biblioteca Digital – Sistema de Gerenciamento

## 🚀 Visão Geral

Este projeto tem como objetivo **implementar um sistema de gerenciamento de uma biblioteca digital em Java**, aplicando **padrões de projeto de software (GoF)** para resolver problemas recorrentes de design e promover um código mais modular, extensível e manutenível.

A aplicação permite **cadastrar, listar e gerenciar empréstimos de livros**, com uma interface simples desenvolvida com **Thymeleaf** e **Spring Boot**.

---

## 🧩 Tecnologias e Ferramentas Utilizadas

### 🖥️ Backend
- **Java 17+**
- **Spring Boot 3**
  - Spring Web (MVC)
  - Spring Data JPA
  - Spring Boot DevTools
- **Thymeleaf** – Template Engine para renderização de páginas HTML dinâmicas.
- **H2 Database** – Banco de dados em memória, ideal para testes e desenvolvimento.

### 🎨 Frontend
- **HTML5**
- **CSS3**
- **Thymeleaf fragments/layouts** (para componentes reutilizáveis de layout)

### ⚙️ Padrões de Projeto (GoF)
O projeto adota os seguintes padrões de design:

| Padrão | Descrição | Onde é aplicado |
|--------|------------|-----------------|
| **DAO (Data Access Object)** | Isola a lógica de acesso a dados da lógica de negócio. | Repositórios JPA (`LivroRepository`) |
| **MVC (Model-View-Controller)** | Separa responsabilidades entre modelo, visualização e controle. | Estrutura de Controllers, Models e Views |
| **Singleton** | Garante uma única instância da configuração principal. | Configurações Spring Boot e BeanContext |
| **Factory Method (conceitual)** | Facilita a criação de objetos sem expor a lógica de instanciação. | Pode ser estendido em serviços de criação de entidades futuras |

---

## 🗂️ Estrutura de Pastas

biblioteca-digital/
│
├── src/
│ ├── main/
│ │ ├── java/com/exemplo/biblioteca/
│ │ │ ├── controller/ → Controladores MVC (rotas da aplicação)
│ │ │ ├── model/ → Entidades JPA (Livro, Empréstimo, etc.)
│ │ │ ├── repository/ → Interfaces JPA (DAO)
│ │ │ └── service/ → Lógica de negócio (opcional)
│ │ └── resources/
│ │ ├── templates/ → Páginas HTML (Thymeleaf)
│ │ ├── static/ → Arquivos CSS/JS
│ │ └── application.properties
│ └── test/ → Testes unitários
│
├── pom.xml → Gerenciador de dependências Maven
└── README.md → Documentação do projeto

yaml
Copiar código

---

## 🧰 Requisitos do Sistema

| Requisito | Versão Recomendada |
|------------|--------------------|
| Java | 17 ou superior |
| Maven | 3.9+ |
| IDE | IntelliJ IDEA / Eclipse / VS Code com extensão Java |
| Navegador | Qualquer um moderno (Chrome, Edge, Firefox) |

---

## ⚡ Como Executar o Projeto

### 1. Clonar o Repositório
```bash
git clone https://github.com/SEU_USUARIO/biblioteca-digital.git
cd biblioteca-digital
2. Compilar e Rodar o Projeto
Se estiver usando Maven:

bash
Copiar código
mvn spring-boot:run
Ou diretamente pela sua IDE (botão Run Application).

3. Acessar no Navegador
bash
Copiar código
http://localhost:8080
🧠 Funcionalidades Principais
✅ Listar livros cadastrados
✅ Cadastrar novos livros
✅ Registrar empréstimos
✅ Visualizar status dos livros (disponível ou emprestado)
✅ Interface leve e responsiva com Thymeleaf