package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //ordenar os teste sem ser de forma aleatoria, NAME_ASCENDING nome de forma crescente 
public class LoginTest extends BaseTest {
    
    private static LoginPO loginPage;

    @BeforeClass
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {

        loginPage.executarAcaoDeLogar("", "");
        String mensagem = loginPage.ObterMensagem();

        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {

        loginPage.executarAcaoDeLogar("Teste", "");
        String mensagem = loginPage.ObterMensagem();

        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {

       loginPage. executarAcaoDeLogar("", "Teste");
        String mensagem = loginPage.ObterMensagem();

        assertEquals("Informe usuário e senha, os campos não podem ser brancos.", mensagem);
    }
        @Test
    public void TC004_naoDeveLogarNoSistemaComEmailESenhaIncorreta() {

       loginPage. executarAcaoDeLogar("Teste", "Teste");
        String mensagem = loginPage.ObterMensagem();

        assertEquals("E-mail ou senha inválidos", mensagem);
    }
            @Test
    public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta() {

       loginPage. executarAcaoDeLogar("admin@admin.com", "Teste");
        String mensagem = loginPage.ObterMensagem();

        assertEquals("E-mail ou senha inválidos", mensagem);
    }
                @Test
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta() {

       loginPage. executarAcaoDeLogar("Aadmin@admin.com", "admin@123");
        String mensagem = loginPage.ObterMensagem();

        assertEquals("E-mail ou senha inválidos", mensagem);
    }
                    @Test
    public void TC007_DeveLogarNoSistemaComEmailESenhaCorretas() {

       loginPage. executarAcaoDeLogar("admin@admin.com", "admin@123");
       
        assertEquals("Controle de Produtos", loginPage.obterTituloPagina());
    }
}
