package mapeamento;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//classe ConectorDB com o método para conexão ao banco mariadb, a qual é utilizada nos 
//métodos CRUD, também implementados nesta classe.

public class ConectorDB {
	Connection con = null;
  //o funcionamento do método Dbconnect requer a biblioteca mysql-connector-java (jdbc) 
	//inserida no projeto. 
	public void Dbconnect() { 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://localhost/mapeamento", "root", ""); 
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void inseriProduto(Produto p) { 
		String sqlcmd = "insert into produto values (?,?)";
		try {
			PreparedStatement pst;
			pst = con.prepareStatement(sqlcmd);
			pst.setInt(1, p.getCodProduto());
			pst.setString(2, p.getNomeProduto()); 
			pst.executeUpdate(); 
			System.out.println("Produto Cadastrado");
		} catch (SQLException ex) {
			System.out.println("Produto NÃO foi Cadastrado " + ex);
		}
	}
	
	public void selecionaProduto() {
		String sqlcmd = "SELECT cod_produto, nome_produto FROM produto";
		try {
			PreparedStatement pst;
			pst = con.prepareStatement(sqlcmd);
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				int codigo = rst.getInt("cod_produto");
				String nome = rst.getString(2);
				System.out.printf("Código Produto %d: %s \n",codigo, nome);
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao Consultar Produto " + ex);
		}
				
	}
	
	public void atualizaProduto(String nomeProduto, int codProduto) {
		String sqlcmd = "UPDATE produto SET nome_produto=? WHERE cod_produto=?";
    try {
    	PreparedStatement pst;
			pst = con.prepareStatement(sqlcmd);
			pst.setString(1, nomeProduto);
			pst.setInt(2, codProduto );
			
			int ret = pst.executeUpdate();
			if(ret > 0){
				System.out.println(String.format("Linhas afetadas %d", ret));
				System.out.printf("Registro alterado: %d: %s",codProduto, nomeProduto);
			}else{
				System.out.println("Não foi possível alterar o Registro de Produto");
			}
    } catch (SQLException se) {
    	System.out.println("Erro ao Altualizar Produto " + se);
    }
	}
	
	public void excluiProduto(int codProduto) {
		String sqlcmd = "DELETE FROM produto WHERE cod_produto=?";
    try {
    	PreparedStatement pst;
   		pst = con.prepareStatement(sqlcmd);
			pst.setInt(1, codProduto);
			
			int ret = pst.executeUpdate();
			if(ret > 0){
				System.out.printf("Produto Excluido: %d: ",codProduto);
			}else{
				System.out.println("Não foi possível Excluir o Registro de Produto");
			}
		
	  } catch (SQLException se) {
	  	System.out.println("Erro ao Excluir Produto " + se);
	  }
	  	
	  }
}
