package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação de novas Page Objects.
 * Todas as páginas devem herdar desta classe.
 */
public abstract class BasePO {

    /**
     * Driver base que será utilizado pelas páginas.
     */
    protected WebDriver driver;

    /**
     * Construtor base que inicializa o PageFactory para localizar elementos.
     *
     * @param driver Driver da página atual.
     */
    protected BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
