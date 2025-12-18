package automatizado.teste;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;


/**
 * Classe responsável pelos testes automatizados
 * da tela de Controle de Produtos.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {

    // Page Object da tela de login
    private static LoginPO loginPage;

    // Page Object da tela de controle de produtos
    private static ControleDeProdutoPO controlleProdutoPage;

    /**
     * Método executado UMA ÚNICA VEZ antes de todos os testes.
     * 
     * Responsável por:
     * - Realizar o login no sistema
     * - Garantir que a navegação chegou corretamente
     *   na tela de Controle de Produtos
     */
    @BeforeClass
    public static void prepararTestes() {

        // Instancia a página de login
        loginPage = new LoginPO(driver);

        // Executa a ação de login no sistema
        loginPage.executarAcaoDeLogar(
            "admin@admin.com",
            "admin@123"
        );

        // Instancia a página de controle de produto
        controlleProdutoPage = new ControleDeProdutoPO(driver);

        // Garante que a tela correta foi carregada
        assertEquals(
            controlleProdutoPage.obterTituloPagina(),
            "Controle de Produtos"
        );
    }

    /**
     * TC0001
     * 
     * Objetivo:
     * Verificar se o modal de cadastro de produto
     * é aberto corretamente ao clicar no botão "Adicionar".
     */
    @Test
    public void TC0001_deveAbrirModalParaCadastrarAoClicarNobotaoCriar() {

        // Clica no botão Adicionar
        controlleProdutoPage.buttonAdicionar.click();

        // TODO: remover clique duplo quando o bug do sistema for corrigido
        // Atualmente o modal só abre no segundo clique
        controlleProdutoPage.buttonAdicionar.click();

        // Captura o título exibido no modal
        String titulo = controlleProdutoPage.tituloModal.getText();

        // Valida se o modal correto foi aberto
        assertEquals("Produto", titulo);

        // Fecha o modal
        controlleProdutoPage.buttonSair.click();

        // TODO: remover clique duplo quando o bug do sistema for corrigido
        controlleProdutoPage.buttonSair.click();
    }

    /*
     * TC0002
     * 
     * ESTE TESTE FOI COMENTADO INTENCIONALMENTE.
     * 
     * Motivo:
     * - Ele valida a mesma regra de negócio do TC0003
     * - Testa apenas um cenário
     * - Foi substituído por uma versão mais completa,
     *   reutilizável e organizada usando o ProdutoBuilder
     * 
     * O TC0003 cobre múltiplos cenários de erro
     * com menos repetição de código.
     */
    // @Test
    // public void TC0002_naoDeveSerPossivelCadastarUmProdutoSemPreencherTodosOsCampos() {
    //
    //     controlleProdutoPage.buttonAdicionar.click();
    //
    //     controlleProdutoPage.cadastrarProduto(
    //         0001,
    //         "Martelo",
    //         15,
    //         " ",
    //         45.50
    //     );
    //
    //     String mensagem = controlleProdutoPage.spanMensagem.getText();
    //
    //     assertEquals(
    //         "Todos os campos são obrigatorios para o cadastro!",
    //         mensagem
    //     );
    // }

    /**
     * TC0003
     * 
     * Objetivo:
     * Garantir que o sistema NÃO permita cadastrar
     * produtos sem preencher todos os campos obrigatórios.
     * 
     * Este teste valida vários cenários utilizando
     * o padrão Builder para evitar repetição de código.
     */
    @Test
    public void TC0003_naoDeveSerPossivelCadastarUmProdutoSemPreencherTodosOsCampos() {

        // Mensagem padrão esperada do sistema
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";

        // Abre o modal de cadastro
        controlleProdutoPage.buttonAdicionar.click();
        // TODO: remover clique duplo quando o bug do sistema for corrigido
        controlleProdutoPage.buttonAdicionar.click();

        // Cria o builder responsável por montar o produto na tela
        ProdutoBuilder produtoBuilder =
            new ProdutoBuilder(controlleProdutoPage);

        // Preenche os dados padrão do produto
        produtoBuilder.builder();

        // Cenário 1: Produto sem código
        produtoBuilder
            .adicionarCodigo("")
            .builder();

        assertEquals(
            mensagem,
            controlleProdutoPage.spanMensagem.getText()
        );

        // Cenário 2: Produto sem quantidade
        produtoBuilder
            .adicionarCodigo("0005")
            .adicionarQuantidade(null)
            .builder();

        assertEquals(
            mensagem,
            controlleProdutoPage.spanMensagem.getText()
        );

        // Cenário 3: Produto sem nome
        produtoBuilder
            .adicionarCodigo("0005")
            .adicionarQuantidade(20)
            .adicionarNome("")
            .builder();

        assertEquals(
            mensagem,
            controlleProdutoPage.spanMensagem.getText()
        );

        // Cenário 4: Produto sem valor
        produtoBuilder
            .adicionarCodigo("0005")
            .adicionarQuantidade(20)
            .adicionarNome("martelo")
            .adicionarValor(null)
            .builder();

        assertEquals(
            mensagem,
            controlleProdutoPage.spanMensagem.getText()
         );
                controlleProdutoPage.buttonSair.click();
    }
 }