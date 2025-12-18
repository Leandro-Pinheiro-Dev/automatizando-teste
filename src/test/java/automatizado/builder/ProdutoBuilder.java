package automatizado.builder;

import automatizado.page.ControleDeProdutoPO;

/**
 * Classe que sabe construit ou adicionar algum produto na tela
 */

public class ProdutoBuilder {

    public String codigo = "00001";
    public String nome = "Produto Padrao";
    public Integer quantidade = 1;
    public Double valor = 1.0;
    public String data = "17/12/2025";

    private ControleDeProdutoPO controleDeProdutoPO ;

    /**construtor do ProdutoBuilder que recebe a pagina de controle de produto */
    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO ){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    /**Metod que sabe adicinar um codigo ao Bulder 
     * @param codigo codigo que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
    */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }
     /**Metod que sabe adicinar um nome ao Bulder 
     * @param nome nome que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
    */
        public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }
    /**Metod que sabe adicinar um quantidade ao Bulder 
     * @param quantidade quantidade que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
    */
        public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return this;
    }
    /**Metod que sabe adicinar um valor ao Bulder 
     * @param valor valor que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
    */
        public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return this;
    }
    /**Metod que sabe adicinar um data ao Bulder 
     * @param data data que sera adicionado
     * @return retorna a propria classe ProdutoBuilder
    */
        public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

/**
 * Metodo que constroi o produto , ou seja, adiciona o produto pela tela de cadastro de produto.
*/
    public void builder(){

        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, String.valueOf(codigo));
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade,(quantidade != null ) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor,(valor != null ) ?  String.valueOf(valor) : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

            controleDeProdutoPO.buttonSalvar.click();
    }
}
