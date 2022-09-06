//Classe Produto utilizada para instanciar objetos na tabela produto criada 
//no banco de dados mariadb, cujo nome mapeamento. A tabela produto possui os 
//atributos cod_produto, nome_produto
package mapeamento;
public class Produto {
	private int codProduto;
	private String nomeProduto;
	
		public Produto(int codProduto, String nomeProduto) {
		this.codProduto = codProduto;
		this.nomeProduto = nomeProduto;
	}

		public int getCodProduto() {
			return codProduto;
		}

		public String getNomeProduto() {
			return nomeProduto;
		}
	
	

}
