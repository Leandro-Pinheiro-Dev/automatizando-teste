package automatizado.teste;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.page.GooglePO;

public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass
    public static void prepararTestes() {
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deveSerPossivelPesquisarNoGoogleOTextoBatataFrita() {

        //googlePage.inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);
        googlePage.pesquisar("Batata Frita");

       //WebDriverWait serve para sincronizar selenium + navegador
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(googlePage.divResultadoPesquisa));

        String resultado = googlePage.ObetrResultadoDaPesquisa();

        assertTrue(resultado.contains("Aproximadamente"));
    }

    @Test
    public void TC002_deveSerPossivelPesquisarNoGoogleOTextoNutella() {

        googlePage.pesquisar("Nutella");

       WebDriverWait wait = new WebDriverWait(driver, 50);
       wait.until(ExpectedConditions.visibilityOf(googlePage.divResultadoPesquisa));

        String resultado = googlePage.ObetrResultadoDaPesquisa();

        assertTrue(resultado.contains("resultados"));
    }
}
