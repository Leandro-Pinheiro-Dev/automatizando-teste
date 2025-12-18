package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas pagesObejcts.
 * toda as pages devem se herdadas desta classe.
 */
public abstract class BasePO {

/**Driver base que sera usado pelas pages */
    protected WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** Metodo  que retorna o tiutlo da pagina atual*/
    public String obterTituloPagina() {
        return driver.getTitle();
    }

    /**Metedo que sabe escrever em qualquewr WebElement do tipo input e da um TAB ao final.
     * @param input input a qual sera inscrito.
     * @param texto Texto que sera escrito no input.
     */
    public void escrever(WebElement input, Object texto) {
        input.clear();
        input.sendKeys(String.valueOf(texto) + Keys.TAB);
    }
}
