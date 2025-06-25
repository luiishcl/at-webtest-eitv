package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {
    private final WebDriver driver;

    //Titulo do Login
    By tituloLogin = By.className("force-form-title");

    //Campo de Email login
    By campoLogin = By.id("session_login");

    //Campo de senha
    By campoSenha = By.id("session_password");

    //Botão Entrar
    By botaoEntrar = By.cssSelector("#session_form > input.col-xs-12.btn.btn-default");

    //Botao Sair
    By botaoSair = By.cssSelector("#header-collapse > ul > a:nth-child(3)");

    //Mensagem Alerta
    By mensagemAlertaLogin = By.className("alert-warning");

    //Construtor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verificaTituloLogin(String tituloLoginEsperado){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginTitulo = wait.until(ExpectedConditions.visibilityOfElementLocated(tituloLogin));

        String tituloLoginEncontrado = loginTitulo.getText();

        assertEquals (tituloLoginEsperado, tituloLoginEncontrado, "O título não confere com o esperado.");
    }

    public void preencheEmail(String email){
        driver.findElement(campoLogin).sendKeys(email);
    }

    public void preencherSenha(String senha){
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void clicarEntrar(){
        driver.findElement(botaoEntrar).click();
    }

    public void verificarSeLogado(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sair = wait.until(ExpectedConditions.visibilityOfElementLocated(botaoSair));

        assertTrue(sair.isDisplayed(), "O botão 'Sair' não está visível. O Login pode ter falhado.");
    }

    public void verificaMensagemAlertaLogin(String alertaEsperado){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemAlertaLogin));

        String alertaEncontrado = alert.getText();

        assertEquals(alertaEsperado, alertaEncontrado, "A mensagem de alerta esta incorreta.");
    }


}
