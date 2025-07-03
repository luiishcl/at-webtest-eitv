package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

import java.time.Duration;


public class LoginTest {

    private static WebDriver driver;
    private static final String baseUrlAcesso = "https://www.eitvplay.com.br/signin";
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    //Variaveis do Login
    String email = "[email]";
    String senha = "[senha]";
    String loginTitulo = "ENTRAR";
    String loginAlerta = "Verifique os dados informados.";


    @BeforeEach
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.manage().window().maximize();
        driver.get(baseUrlAcesso);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    @DisplayName("Quando acessar a pagina de login, informar dados corretos de acesso, entao efetua login")
    public void EfetuaLogin(){

        //Instanciar Page objects
        LoginPage loginPage = new LoginPage(driver);

        //Verifica titulo da Pagina de Login
        loginPage.verificaTituloLogin(loginTitulo);
        logger.info("Validação do título da página de Login concluída com sucesso.");

        //preencher usuario
        loginPage.preencheEmail(email);
        logger.info("Email preenchido");

        //preencher senha
        loginPage.preencherSenha(senha);
        logger.info("Senha preenchida");

        //clicar login
        loginPage.clicarEntrar();
        logger.info("Botao entrar pressionado");

        //Assert Verificar se esta logado com sucesso
        loginPage.verificarSeLogado();
        logger.info("Login realizado com sucesso.");

    }

    @Test
    @DisplayName("Quando tentar logar sem informar os campos, então exibe uma mensagem de alerta.")
    public void LoginSemDados(){

        //Instanciar Page objects
        LoginPage loginPage = new LoginPage(driver);

        //clicar login
        loginPage.clicarEntrar();

        //verificar mensagem alerta
        loginPage.verificaMensagemAlertaLogin(loginAlerta);
        logger.info("Mensagem de alerta verificada.");
    }
}

