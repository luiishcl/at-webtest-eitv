package pages;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroPage {

    private final WebDriver driver;

    //Titulo da pagina
    By tituloCadastro = By.cssSelector("#main_content > div > div.col-layout.col-layout-offcanvas.col-content > div > div.row > div.col-md-12 > h1");

    //Campo preencher nome
    By campoPreenchimentoNome = By.id("user_name");

    //Campo preencher email
    By campoPreenchimentoEmail = By.id("user_email");

    //Campo preencer confirmar email
    By campoPreenchimentoEmailConf = By.id("user_email_confirmation");

    //Campo preencher Password
    By campoPreenchimentoPass = By.id("user_password");

    //Campo preencher confirmar password
    By campoPreenchimentoPassConf = By.id("user_password_confirmation");

    //selecionar check box final
    By checkBoxTerms = By.id("checkbox_terms");
    By checkBoxPrivacy = By.id("checkbox_privacy");

    //clicar botão criar usuario
    By botaoSubmeter = By.id("button_submit");

    //Mensagem cadastro com sucesso
    //Composicao: "Usuário "Nome Usuario" criado. E-mail enviado com instruções de verificação."
    By mensagemCadastroSucesso = By.className("alert-success");


    // CONSTRUTOR!
    public CadastroPage (WebDriver driver) {
        this.driver = driver;
    }


    public void insereNome(String nomeUsuario){
        driver.findElement(campoPreenchimentoNome).sendKeys(nomeUsuario);
    }

    public void insereEmail(String emailUsuario){
        driver.findElement(campoPreenchimentoEmail).sendKeys(emailUsuario);
    }

    public void insereConfirmacaoEmail(String emailUsuarioConf){
        driver.findElement(campoPreenchimentoEmailConf).sendKeys(emailUsuarioConf);
    }

    public void insereSenha(String senhaUsuario){
        driver.findElement(campoPreenchimentoPass).sendKeys(senhaUsuario);
    }

    public void insereConfirmacaoSenha(String senhaUsuarioConf){
        driver.findElement(campoPreenchimentoPassConf).sendKeys(senhaUsuarioConf);
    }

    public void checkboxCadastro() throws InterruptedException {

        driver.findElement(checkBoxTerms).click();
        driver.findElement(checkBoxPrivacy).click();

    }

    public void scrollFinalPagina(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void clicarRegistrar(){
        driver.findElement(botaoSubmeter).click();
    }

    public void verificarMensagem(String nome){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensagemElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemCadastroSucesso));

        String mensagemEsperada = "Usuário \"" + nome + "\" criado. E-mail enviado com instruções de verificação.";
        String mensagemEncontrada = mensagemElement.getText();

                //driver.findElement(mensagemCadastroSucesso).getText();


        assertEquals (mensagemEsperada, mensagemEncontrada, "Mensagem de sucesso não confere para o usuario: " + nome);
    }

}
