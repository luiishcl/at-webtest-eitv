package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.CadastroPage;

import java.time.Duration;

public class CadastroTest {
    private static WebDriver driver;
    private static final String baseUrlCadastro = "https://www.eitvplay.com.br/management/users/new";
    //Variaveis do cadastro
    String nome = "Adebajor Sottre Mendez";
    String email = "email_01@teste.com.br";
    String senha = "123Pass@";


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
    @DisplayName("Quando preencher o cadastro com as informações então cria um novo usuario.")
    public void PreencherCadastro(){


        //Acesso a pagina Cadastro
        driver.get(baseUrlCadastro);

        //Instanciar o page objects
        CadastroPage cadastroPage = new CadastroPage(driver);

        //Preencher campos
        cadastroPage.insereNome(nome);
        cadastroPage.insereEmail(email);
        cadastroPage.insereConfirmacaoEmail(email);
        cadastroPage.insereSenha(senha);
        cadastroPage.insereConfirmacaoSenha(senha);

        //marcar checkbox
        cadastroPage.checkboxCadastro();

        //Clicar em Criar usuario


    }

}
