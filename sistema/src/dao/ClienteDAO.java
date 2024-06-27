package dao;

import model.Cliente;
import model.Conectar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDAO {
	
	private Connection con;
	
    	
	public void inserir(Cliente c) {
		con = Conectar.getConectar();
		
		//METODO PARA INSERIR CLIENTE
		String sql = "INSERT INTO cliente (nome,cnpj) VALUES (?,?)";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setString(1, c.getNome());
			//smt.setBoolean(2, c.getFisico());
			smt.setString(2, c.getCnpj());
			smt.executeUpdate();
			smt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar!");
			throw new RuntimeException(e);
			
		}
	}
	
	public void alterar(Cliente c) {
		con = Conectar.getConectar();
		String sql = "UPDATE cliente SET nome = ?, fisico = ?, cnpj = ? where codcli = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setString(1, c.getNome());
			smt.setBoolean(2, c.getFisico());
			smt.setString(3, c.getCnpj());
			smt.setInt(4, c.getCodigo());
			smt.executeUpdate();
			smt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
		}catch(SQLException e) {
			
		}
	}
	
	public void excluir(Cliente c) {
		con = Conectar.getConectar();
		String sql = "DELETE cliente WHERE codcli = ?";
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente "
				+c.getNome()+"?", "Excluir", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			try (PreparedStatement smt = con.prepareStatement(sql)){
				smt.setInt(1, c.getCodigo());
				smt.executeUpdate();
				smt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public List<Cliente> listarTodos(){
		con = Conectar.getConectar();
		List<Cliente>lista = new ArrayList<>();
		String sql = "SELECT * FROM cliente ORDER BY codcli";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			ResultSet resultado = smt.executeQuery();
			while(resultado.next()) {
				Cliente c = new Cliente();
				c.setCodigo(resultado.getInt("codcli"));
				c.setNome(resultado.getString("nome"));
				c.setFisico(resultado.getBoolean("fisico"));
				c.setCnpj(resultado.getString("cnpj"));
				lista.add(c);
			}
			smt.close();
			con.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public Cliente BurcarCodigoCli(String codCli){
		con = Conectar.getConectar();
		String sql = "SELECT * FROM cliente WHERE codcli = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			Cliente c = new Cliente();
			smt.setString(1, codCli);
			ResultSet resultado = smt.executeQuery();
			if(resultado.next()) {
				c.setCodigo(Integer.parseInt(resultado.getString("codcli")));
				c.setNome(resultado.getString("nome"));
			}
			smt.close();
			con.close();
			return c;	
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível buscar, erro: "+e);
		}
		return null;		
	}
}
