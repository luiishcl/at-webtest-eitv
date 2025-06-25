package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroPage {

    private WebDriver driver;

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

    public void checkboxCadastro(){
        driver.findElement(checkBoxTerms).click();
        driver.findElement(checkBoxPrivacy).click();
    }

    public void clicarRegistrar(){
        driver.findElement(botaoSubmeter);
    }


    // CONSTRUTOR!
    public CadastroPage (WebDriver driver) {
        this.driver = driver;
    }

}
