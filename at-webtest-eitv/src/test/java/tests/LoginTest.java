package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;


public class LoginTest {

    private static WebDriver driver;
    private static final String baseUrlAcesso = "https://www.eitvplay.com.br/signin";


    @BeforeAll
    public static void Setup(){
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void TearDown(){
        driver.close();
    }

    @Test
    @DisplayName("Quando acessar a pagina de login, informar dados de acesso, entao efetua login")
    public void AcessaPlataforma(){
        driver.get(baseUrlAcesso);

        //preencher usuario

        //preencher senha

        //clicar login


    }
}

