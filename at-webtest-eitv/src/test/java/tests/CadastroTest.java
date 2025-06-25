package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CadastroPage;

import java.time.Duration;

public class CadastroTest {
    private static WebDriver driver;
    private static final String baseUrlCadastro = "https://www.eitvplay.com.br/management/users/new";
    private static final Logger logger = LoggerFactory.getLogger(CadastroTest.class);

    //Variaveis do cadastro
    String nome = "Perrito Kan";
    String email = "email_07@teste.com.br";
    String senha = "123Pass@";
    String cadastroTitulo = "CRIAR USUÁRIO";
    String msgEmailErro = "não é válido";
    String msgSenhaErro = "é muito curto (mínimo: 6 caracteres)";
    String msgConfSenhaErro = "não pode ficar em branco, não está de acordo com a confirmação";

    @BeforeEach
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.manage().window().maximize();
        driver.get(baseUrlCadastro);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    @DisplayName("Quando preencher o cadastro com as informações então cria um novo usuario.")
    public void CriarUsuario(){

        //Instanciar o page objects
        CadastroPage cadastroPage = new CadastroPage(driver);

        //Titulo da pagina
        cadastroPage.verificarTituloCadastro(cadastroTitulo);
        logger.info("Validação do título da página de Cadastro concluída com sucesso.");

        //Preencher campos
        cadastroPage.insereNome(nome);
        cadastroPage.insereEmail(email);
        cadastroPage.insereConfirmacaoEmail(email);
        cadastroPage.insereSenha(senha);
        cadastroPage.insereConfirmacaoSenha(senha);
        logger.info("Preenchimento Completo");

        //Vai para final da página
        cadastroPage.scrollFinalPagina();

        //marcar checkbox
        cadastroPage.checkboxCadastro();
        logger.info("Selecionado Checkbox com sucesso.");

        //Clicar em Criar usuario
        cadastroPage.clicarRegistrar();
        logger.info("Cadastro Efetuado.");

        //Assert verificação da mensagem de sucesso
        cadastroPage.verificarMensagem(nome);
        logger.info("Realizacao do Assert nome usuario '{}'.", nome);
    }

    @Test
    @DisplayName("Quando tentar cadastrar com dados inválidos então não sera possivel.")
    public void CadastroInvalido(){
        //Instanciar o page objects
        CadastroPage cadastroPage = new CadastroPage(driver);

        //Preencher dados
        cadastroPage.insereNome("aaa");
        cadastroPage.insereEmail("aaa");
        cadastroPage.insereSenha("aaa");
        logger.info("Preenchido");

        cadastroPage.scrollFinalPagina();
        cadastroPage.checkboxCadastro();
        cadastroPage.clicarRegistrar();
        logger.info("Cadastro iniciando validação");

        cadastroPage.verificarErrosCadastro(msgEmailErro, msgSenhaErro, msgConfSenhaErro);
        logger.info("Validação das mensagens de erro concluida.");

    }

}
