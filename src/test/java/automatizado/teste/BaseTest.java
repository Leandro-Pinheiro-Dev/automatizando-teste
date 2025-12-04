package automatizado.teste;

//import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected static WebDriver driver;

    private static final String URL_BASE = "https://www.google.com/";
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver.exe";

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

   // @AfterClass 
    //@BeforeClass //Roda depois de todos os testes
    public static void finalizar() {

       if (driver != null) {
          //  driver.quit();
        }
    }
}
