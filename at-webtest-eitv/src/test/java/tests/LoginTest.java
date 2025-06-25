package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    String email = "luishchagas@gmail.com";
    String senha = "123Pass@";


    @BeforeAll
    public static void Setup(){
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void TearDown(){
        //driver.close();
    }

    @Test
    @DisplayName("Quando acessar a pagina de login, informar dados corretos de acesso, entao efetua login")
    public void EfetuaLogin(){

        //Acesso a pagina
        driver.get(baseUrlAcesso);

        //Instanciar Page objects
        LoginPage loginPage = new LoginPage(driver);

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
}

