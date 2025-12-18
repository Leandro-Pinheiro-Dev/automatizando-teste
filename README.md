# 🧪 Projeto de Testes Automatizados com **Java + Selenium + JUnit**

Este projeto tem como objetivo demonstrar a implementação de **testes automatizados funcionais** utilizando **Java**, **Selenium WebDriver**, **JUnit** e o padrão de arquitetura **Page Object Model (POM)**.

A aplicação automatizada contempla dois fluxos principais:

* 🔐 **Login no sistema**
* 📦 **Controle de Produto** (cadastro, validações e interações)

A estrutura foi pensada para ser **organizada, reutilizável e de fácil manutenção**, seguindo boas práticas de automação de testes.

---

## 📁 **Estrutura do Projeto**

```
AUTOMATIZADO
├── .vscode/
│   ├── launch.json
│   └── settings.json
│
├── src/
│   └── test/
│       └── java/
│           └── automatizado/
│               ├── construtor/
│               │   └── ProdutoBuilder.java
│               │
│               ├── pagina/
│               │   ├── BasePO.java
│               │   ├── ControleDeProdutoPO.java
│               │   ├── GooglePO.java
│               │   └── LoginPO.java
│               │
│               ├── recurso/
│               │   └── chromedriver.exe
│               │
│               └── teste/
│                   ├── BaseTest.java
│                   ├── ControleDeProdutoTest.java
│                   ├── GoogleTest.java
│                   └── LoginTest.java
│
├── target/
│
├── README.md
├── .txt
└── pom.xml
```

---

## 🧱 **Explicação das Pastas e Arquivos**

### **📁 construtor/** — *Builder Pattern*

Contém classes responsáveis pela construção de objetos usados nos testes.

* `ProdutoBuilder.java`: facilita a criação de produtos com dados válidos ou customizados, tornando os testes mais legíveis e organizados.

---

### **📁 pagina/** — *Page Objects (POM)*

Cada classe representa uma página real da aplicação, encapsulando elementos e ações.

* `BasePO.java`: classe base para todos os Page Objects, contendo métodos e atributos comuns.
* `LoginPO.java`: representa a página de login, com ações como preencher usuário, senha e efetuar login.
* `ControleDeProdutoPO.java`: representa a página de controle de produtos, contendo ações como cadastrar, validar campos e interagir com a listagem.
* `GooglePO.java`: utilizado como exemplo didático de automação de busca.

Esse padrão reduz duplicação de código e melhora a manutenção dos testes.

---

### **📁 recurso/**

Contém recursos necessários para execução da automação.

* `chromedriver.exe`: driver responsável por permitir que o Selenium controle o navegador Google Chrome.

---

### **📁 teste/** — *Casos de Teste*

Contém os cenários de teste automatizados.

* `BaseTest.java`: responsável por inicializar e finalizar o WebDriver, além das configurações globais dos testes.
* `LoginTest.java`: contém os testes relacionados ao fluxo de login, validando autenticação com dados válidos e inválidos.
* `ControleDeProdutoTest.java`: valida os fluxos do controle de produtos, utilizando o `ProdutoBuilder` e os métodos do Page Object.
* `GoogleTest.java`: exemplo de teste de busca utilizando o Google.

---

## 🔐 **Fluxo Automatizado de Login**

1. O navegador é iniciado pelo `BaseTest`.
2. A página de login é carregada.
3. A classe `LoginPO` é instanciada.
4. Os campos de usuário e senha são preenchidos.
5. A ação de login é executada.
6. O teste valida se o acesso foi realizado com sucesso ou se a mensagem de erro foi exibida.

---

## 📦 **Fluxo Automatizado de Controle de Produto**

1. O sistema é acessado após login válido.
2. A página de controle de produto é aberta.
3. Um produto é criado utilizando o `ProdutoBuilder`.
4. Os dados do produto são preenchidos na tela.
5. O cadastro é realizado.
6. O teste valida mensagens, campos obrigatórios ou a presença do produto na listagem.

---

## 🚀 **Como executar o projeto**

### ✔️ **Pré-requisitos**

* Java JDK 11 ou superior
* Maven instalado
* Google Chrome instalado
* ChromeDriver compatível com a versão do Chrome

---

### ✔️ **Executar os testes**

Pela IDE:

* Execute as classes de teste anotadas com `@Test`

Via Maven:

```bash
mvn test
```

---

## 🧪 **Exemplo de Caso de Teste (Login)**

```java
@Test
public void deveRealizarLoginComUsuarioValido() {
    loginPage.preencherUsuario("admin");
    loginPage.preencherSenha("123456");
    loginPage.clicarEmEntrar();

    assertTrue(loginPage.usuarioLogadoComSucesso());
}
```

---

## 🧩 **Tecnologias Utilizadas**

* **Java 17+**
* **Selenium WebDriver**
* **JUnit 4**
* **Page Object Model (POM)**
* **Builder Pattern**
* **ChromeDriver**
* **Maven**

---

## 📌 **Observações Finais**

Este projeto pode ser facilmente expandido para novos módulos da aplicação, mantendo a separação de responsabilidades e boas práticas de automação de testes.
