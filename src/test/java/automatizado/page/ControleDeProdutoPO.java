package automatizado.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import automatizado.builder.ProdutoBuilder;

public class ControleDeProdutoPO extends BasePO{

    //#region WebElement
    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    public WebElement linkvoltar;

        @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

        @FindBy(id = "codigo")
    public WebElement inputCodigo;
    
            @FindBy(id = "nome")
    public WebElement inputNome;

            @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

            @FindBy(id = "valor")
    public WebElement inputValor;

            @FindBy(id = "data")
    public WebElement inputData;

        @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

        @FindBy(id = "btn-sair")
    public WebElement buttonSair;

            @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    //#endregion WebElement

    //#region Construtor
    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
    }
    //#endregion Construtor

    //#region Metodos

    public void cadastrarProduto(
        int codigo,
        String nome, 
        Integer quantidade, 
        String data, 
        double valor ){

            escrever(inputCodigo, String.valueOf(codigo));
            escrever(inputNome, nome);
            escrever(inputQuantidade, quantidade.toString());
            escrever(inputValor, String.valueOf(valor));
            escrever(inputData, data);

            buttonSalvar.click();
    }
        public void cadastrarProduto(ProdutoBuilder produtoBuilder){

            escrever(inputCodigo, String.valueOf(produtoBuilder.codigo));
            escrever(inputNome, produtoBuilder.nome);
            escrever(inputQuantidade, produtoBuilder.quantidade.toString());
            escrever(inputValor, String.valueOf(produtoBuilder.valor));
            escrever(inputData, produtoBuilder.data);

            buttonSalvar.click();
    }

    //#endregion Metodos
    
}
