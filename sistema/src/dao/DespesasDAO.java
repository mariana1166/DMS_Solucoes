package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Conectar;
import model.Despesas;

public class DespesasDAO {
private Connection con;
	
	public void inserir(Despesas d){
		con = Conectar.getConectar();				
		//METODO PARA INSERIR DESPESAS
				String sql = "INSERT INTO despesas (tipoDespesa, codFuncionario, nomeFuncionario, descricao, dataEmissao, dataVencimento, valor, tipoPag) "
						                                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				try(PreparedStatement smt = con.prepareStatement(sql)){
					smt.setString(1, d.getCodigo());
					smt.setInt(2, d.getCodFuncionario());
					smt.setString(3, d.getNomeFuncionario());
					smt.setString(4, d.getDescricao());
					smt.setString(5, d.getDataEmissao());
					smt.setString(6, d.getDataVencimento());
					smt.setString(7, d.getValor());
					smt.setString(8, d.getTipoPag());
					smt.executeUpdate();
					smt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Despesa criada com sucesso!");
				}catch(SQLException e) {
					JOptionPane.showMessageDialog(null, "Falha ao criar nova despesa!");
					throw new RuntimeException(e);
					
				}	
	}
	
	public void alterar(Despesas d) {
		con = Conectar.getConectar();
		String sql = "UPDATE despesas SET tipoDespesa = ?, codFuncionario = ?, nomeFuncionario = ?, descricao = ?, dataEmissao = ?, dataVencimento = ?, valor = ?, tipoPag = ? where codigo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setInt(1, d.getCodFuncionario());
			smt.setString(2, d.getNomeFuncionario());
			smt.setString(3, d.getDescricao());
			smt.setString(4, d.getDataEmissao());
			smt.setString(5, d.getDataVencimento());
			smt.setString(6, d.getValor());
			smt.setString(7, d.getTipoPag());
			smt.setString(8, d.getCodigo());
			smt.executeUpdate();
			smt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
		}catch(SQLException e) {
			
		}
	}
	
	public void excluir(Despesas d) {
		con = Conectar.getConectar();
		String sql = "DELETE despesas WHERE codigo = ?";
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a despesa "
				+d.getCodigo()+"?", "Excluir", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			try (PreparedStatement smt = con.prepareStatement(sql)){
				smt.setString(1, d.getCodigo());
				smt.executeUpdate();
				smt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public List<Despesas> listarTodos(){
		con = Conectar.getConectar();
		List<Despesas>lista = new ArrayList<>();
		String sql = "SELECT * FROM despesas ORDER BY codigo";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			ResultSet resultado = smt.executeQuery();
			while(resultado.next()) {
				Despesas d = new Despesas();
				d.setCodigo(resultado.getString("codigo"));
				d.setCodFuncionario(Integer.parseInt(resultado.getString("codFuncionario")));
				d.setNomeFuncionario(resultado.getString("nomeFuncionario"));
				d.setDescricao(resultado.getString("descricao"));
				d.setTipoDespesa(resultado.getString("tipoDespesa"));
				d.setDataEmissao(resultado.getString("dataEmissao"));
				d.setDataVencimento(resultado.getString("dataVencimento"));
				d.setTipoPag(resultado.getString("tipoPag"));
				d.setValor(resultado.getString("valor"));
				lista.add(d);
			}
			smt.close();
			con.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public Despesas BurcarCodigo(String codd){
		con = Conectar.getConectar();
		String sql = "SELECT * FROM Despesas WHERE codigo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			Despesas d = new Despesas();
			smt.setString(1, codd);
			ResultSet resultado = smt.executeQuery();
			if(resultado.next()) {
				d.setCodigo(resultado.getString("codigo"));
				d.setCodFuncionario(Integer.parseInt(resultado.getString("codFuncionario")));
				d.setNomeFuncionario(resultado.getString("nomeFuncionario"));
				d.setDescricao(resultado.getString("descricao"));
				d.setTipoDespesa(resultado.getString("tipoDespesa"));
				d.setDataEmissao(resultado.getString("dataEmissao"));
				d.setDataVencimento(resultado.getString("dataVencimento"));
				d.setTipoPag(resultado.getString("tipoPag"));
				d.setValor(resultado.getString("valor"));			
			}
			smt.close();
			con.close();
			return d;	
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível buscar, erro: "+e);
		}
		return null;		
	}
	
	
}
