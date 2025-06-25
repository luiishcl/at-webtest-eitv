package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    String nome = "Perrito Test";
    String email = "email_04@teste.com.br";
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
    public void CriarUsuario() throws InterruptedException {


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

}
