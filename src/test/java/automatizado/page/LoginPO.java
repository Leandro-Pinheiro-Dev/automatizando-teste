package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    //#region Região dos WebElements
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;
    
    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(css = "form>div.alert>span")
    public WebElement spanMensagem;

    //#endregion Região dos WebElements

    //#region Construtor
    /**
     * Construtor padrão para criação de uma nova instância da página de login.
     * @param driver Driver da pagina de login
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }
     
    //#endregion Construtor

    //#region Metodos
    /**
     * Metodo que obtem a mensagem disparada na tela
     * @return  texto da mensagem
     */
    public String ObterMensagem(){
        return this.spanMensagem.getText();
    }

    /**
     * Método que tenta executar a ação de logar no sistema.
     * @param email E-mail para tentativa de login
     * @param senha Senha para tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha) {
        this.escrever(this.inputEmail, email);
        this.escrever(this.inputSenha, senha);
        this.buttonEntrar.click();
    }

    //#endregion Metodos
}
