package mapeamento;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		ConectorDB conecta = new ConectorDB(); 
		boolean continua = true;
		char maisoper = 's'; 
		int op, codProd;
		conecta.Dbconnect();
		Scanner sc = new Scanner(System.in);		
		//Utiliza��o da classe Scanner para intera��o com as opera��es CRUDs
		System.out.print("=========== Cadastro de Produtos =========== \n" );
		//Menu em Console para intera��o CRUD
		while(continua) {
			System.out.print("Escolha uma das Op��es: \n");
			System.out.println("1 Exibir Produtos " );
			System.out.println("2 Excluir Produtos " );
			System.out.println("3 Atualizar Produtos " );
			System.out.println("4 Inserir Produtos " );
			System.out.println("5 Abandonar a Opera��o \n" );
			
			op = sc.nextInt(); 
			if(op >= 5) {
				continua = false;
				sc.close();
			} else {
				  switch(op) {			
						case 1:
							conecta.selecionaProduto();
							System.out.print("\n Deseja continuar: s/n ");
							maisoper = sc.next().charAt(0);
							if (maisoper != 's') {
								continua = false;
							}
							break;
						case 2:
							System.out.println("Informe o c�digo do Produto para Excluir: ");
              conecta.excluiProduto(sc.nextInt());   							
							System.out.println("\n Deseja continuar: s/n ");
							maisoper = sc.next().charAt(0);
							if (maisoper != 's') {
								continua = false;
							}
							break;
						case 3: 
							System.out.println("Informe o c�digo do Produto para Alterar: ");
							codProd = sc.nextInt();
							System.out.println("Informe a Altera��o ao Nome do Produto: ");
							conecta.atualizaProduto(sc.next(), codProd);   							
							System.out.println("\n Deseja continuar: s/n ");
							maisoper = sc.next().charAt(0);
							if (maisoper != 's') {
								continua = false;
							}
						case 4:
							System.out.println("Informe o c�digo do Produto : ");
							codProd = sc.nextInt();
							System.out.println("Informe o Nome do Produto: ");
							sc.nextLine();
							String nomeProduto = sc.nextLine();
							Produto p = new Produto(codProd, nomeProduto);
							conecta.inseriProduto(p);   
							//sc.nextLine();
							System.out.println("\n Deseja continuar: s/n ");
							maisoper = sc.next().charAt(0);
							if (maisoper != 's') {
								continua = false;
							}
						default:
	  			}
			 }
			
		}
					
	}

}
