package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.Conectar;

public class FuncionarioDAO {
	Funcionario f;
	//METODO PARA INSERIR FUNCIONARIO
	public void inserir(Funcionario f) {
		Connection con = Conectar.getConectar();
		
		String sql = "INSERT INTO funcionario(nome, cpf, cep, rua, numero, bairro, cidade, estado, tel1, tel2, obs) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setString(1, f.getNome());
			smt.setString(2, f.getCpf());
			smt.setString(3, f.getCep());
            smt.setString(4, f.getRua());
            smt.setString(5, f.getNumero());
            smt.setString(6, f.getBairro());
            smt.setString(7, f.getCidade());
            smt.setString(8, f.getEstado());
            smt.setString(9, f.getTel1());
            smt.setString(10, f.getTel2());
            smt.setString(11, f.getObs());
			smt.executeUpdate();
			smt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar!");
			throw new RuntimeException(e);
		}
	}
	
	//METODO PARA ALTERAR FUNCIONARIO
	public void alterar(Funcionario f) {
		Connection con = Conectar.getConectar();
		String sql = "UPDATE cliente SET nome = ?, cpf= ?, cep= ?, rua= ?, numero= ?, bairro= ?, cidade= ?, estado= ?, tel1= ?, tel2= ?, obs= ? where codigo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setString(1, f.getNome());
			smt.setString(2, f.getCpf());
			smt.setString(3, f.getCep());
            smt.setString(4, f.getRua());
            smt.setString(5, f.getNumero());
            smt.setString(6, f.getBairro());
            smt.setString(7, f.getCidade());
            smt.setString(8, f.getEstado());
            smt.setString(9, f.getTel1());
            smt.setString(10, f.getTel2());
            smt.setString(11, f.getObs());
            smt.setInt(12, f.getCodigo());
			smt.executeUpdate();
			smt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
		}catch(SQLException e) {
			
		}
	}
	
	//METODO PARA EXCLUIR FUNCIONARIO
	public void excluir(Funcionario f) {
		Connection con = Conectar.getConectar();
		String sql = "DELETE cliente WHERE codigo = ?";
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o funcionario "
				+f.getNome()+"?", "Excluir", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			try (PreparedStatement smt = con.prepareStatement(sql)){
				smt.setInt(1, f.getCodigo());
				smt.executeUpdate();
				smt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	//LISTAR FUNCIONARIO
	public List<Funcionario> listarTodos(){
		Connection con = Conectar.getConectar();
		List<Funcionario>lista = new ArrayList<>();
		String sql = "SELECT * FROM funcionario ORDER BY codigo";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			ResultSet resultado = smt.executeQuery();
			while(resultado.next()) {
				f = new Funcionario();
				f.setCodigo(resultado.getInt("codigo"));
				f.setNome(resultado.getString("nome"));
				f.setCpf(resultado.getString("cpf"));
				lista.add(f);
			}
			smt.close();
			con.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
}
