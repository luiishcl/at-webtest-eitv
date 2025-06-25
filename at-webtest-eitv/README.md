# Projeto de Automação de Login e Cadastro de usuario

## Esse projeto de automação utiliza Java, Gradle, Junit5, Selenium e Hamcrest

# 🧪 Projeto de Testes Automatizados – EITV

Este repositório contém um conjunto de testes automatizados utilizando **Java**, **Selenium WebDriver** e **JUnit 5**, com estrutura baseada em **Page Object Model**. O projeto cobre cenários de teste da aplicação EITV, com foco nas funcionalidades de **login** e **cadastro de usuários**.

---

## 🚀 Tecnologias Utilizadas

- Java 17
- Selenium WebDriver 4.25.0
- JUnit Jupiter (JUnit 5)
- WebDriverManager 5.8.0
- Gradle
- SLF4J + Logback (logs)
- Estrutura Page Object Model (POM)

---

## 🗂 Estrutura do Projeto

```plaintext
📁 src
 ┣ 📁 main           → Não utilizado
 ┣ 📁 test
 ┃ ┣ 📁 java/pages   → Page Objects
 ┃ ┗ 📁 java/tests   → Testes Automatizados
📄 build.gradle      → Gerenciador de dependências (Gradle)
📄 README.md

````
---
## ⚙️ Requisitos

- Java 17 ou superior
- Gradle (ou o wrapper ./gradlew)
- Navegador Microsoft Edge
- Acesso à internet (para WebDriverManager baixar os drivers)

---
## ▶️ Como Executar os Testes

```bash
./gradlew clean test
```
Ou Windows (cmd)
```cmd
gradlew.bat clean test
```
---

## ✅ Funcionalidades Testadas
### 🔐 Login
- Login com credenciais válidas
- Login com dados inválidos
- Campos obrigatórios vazios

### 👤 Cadastro
- Cadastro com dados válidos
- Mensagens de erro: e-mail inválido, senha fraca, senha não confirmada
- Validação do título da tela
- Mensagem de sucesso com nome dinâmico

---

## 📈 Próximas Melhorias
- Adição de testes BDD com Cucumber
- Geração de relatórios
- Integração contínua com GitHub Actions
- Testes em múltiplos navegadores

---
## 👨‍💻 Autor
**Luis Henrique**  
🔗 [GitHub](https://github.com/luiishcl)  
🔗 [LinkedIn](https://www.linkedin.com/in/luishchagas/)

---

## 🛡️ Licença

Este projeto está sob a licença MIT.  
Veja o arquivo [LICENSE](LICENSE) para mais detalhes.