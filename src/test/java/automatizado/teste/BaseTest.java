package automatizado.teste;

//import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste.
 */

public abstract class BaseTest {

    /**Driver do navegador da pagina atual*/
    protected static WebDriver driver;
    /**Caminho base da URL do sistema a ser testado. */
    private static final String URL_BASE = "file:///D:/Users/Leandro%20P%20Santos/Documents/T%C3%A9cnicas%20do%20Teste%20de%20Software/Selenim+Java/TesteLogin/controle-de-produtos/sistema/login.html";
   
   /**Caminho realtivo do driver ao projeto referente ao path */
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.exe";

    /**
     * BeforeClass Metodo para iniciar o driver do navegador antes de qualquer classe de teste.
     */
    @BeforeClass //Roda antes de todos os testes
    public static void iniciar() {

        // Define o caminho do executável do ChromeDriver
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);

        // Inicializa o navegador
        driver = new ChromeDriver();

        // Maximiza a janela
        driver.manage().window();

        // Abre a página inicial
        driver.get(URL_BASE);
    }
    /**
     * AfterClass Metodo para finalizar o driver do navegador depois de qualquer classe de teste.
     */
   // @AfterClass 
    public static void finalizar() {

       if (driver != null) {
          //  driver.quit();
        }
    }
}
