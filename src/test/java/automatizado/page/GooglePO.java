package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

    @FindBy(name = "q")
    public WebElement inputPesquisa;

    @FindBy(id = "WebDriverWait")
    public WebElement divResultadoPesquisa;

    /**
     * Construtor para criação da página do Google.
     * @param driver Driver da página do Google.
     */
    public GooglePO(WebDriver driver) {
        super(driver);
    }

    /**
     * Metodo que ira efetuar uma pesquisa no google baseando no texto informado e concluindo com ENTER.
     * @param texto texro a ser pesquisado
     */
    public void pesquisar(String texto){
        inputPesquisa.sendKeys(texto + Keys.ENTER );
    }

    /**
     * Metodo que retorna o resultado aproximado da pesquisa.
     * @return retorna o resultado da pesquisa
     */
    public String ObetrResultadoDaPesquisa(){
        return divResultadoPesquisa.getText();
    }
}
