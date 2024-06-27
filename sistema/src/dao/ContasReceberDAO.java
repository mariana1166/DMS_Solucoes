package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Conectar;
import model.ContasReceber;

public class ContasReceberDAO {
private Connection con;
	
	public void inserir(ContasReceber cr){
		con = Conectar.getConectar();				
		//METODO PARA INSERIR CONTAS A RECEBER
				String sql = "INSERT INTO contasReceber (codigo, codCli, nomeCli, tipoDoc, descricao, movimento, contrato, valorTotal, valorRecebido, valorReceber, dataEmissao, dataVenc, dataPag) "
						                                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
				try(PreparedStatement smt = con.prepareStatement(sql)){
					smt.setString(1, cr.getCodigo());
					smt.setInt(2, cr.getCodCli());
					smt.setString(3, cr.getNomeCli());
					smt.setString(4, cr.getTipoDoc());
					smt.setString(5, cr.getDescricao());
					smt.setString(6, cr.getMovimento());
					smt.setString(7, cr.getContrato());
					smt.setFloat(8, cr.getValorTotal());
					smt.setFloat(9, cr.getValorRecebido());
					smt.setFloat(10, cr.getValorReceber());
					smt.setString(11, cr.getDataEmissao());
					smt.setString(12, cr.getDataVenc());
					smt.setString(13, cr.getDataPag());
					smt.executeUpdate();
					smt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Titulo cadastrado com sucesso!");
				}catch(SQLException e) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar!");
					throw new RuntimeException(e);
					
				}	
	}
	
	public void alterar(ContasReceber cr) {
		con = Conectar.getConectar();
		String sql = "UPDATE contasReceber SET codCli = ?, tipoDoc = ?, descricao = ?, movimento = ?, contrato = ?, valorTotal = ?, valorRecebido = ?, valorReceber = ?, dataEmissao = ?, dataVenc = ?, dataPag = ? where codigo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setInt(1, cr.getCodCli());
			smt.setString(2, cr.getTipoDoc());
			smt.setString(3, cr.getDescricao());
			smt.setString(4, cr.getMovimento());
			smt.setString(5, cr.getContrato());
			smt.setFloat(6, cr.getValorTotal());
			smt.setFloat(7, cr.getValorRecebido());
			smt.setFloat(8, cr.getValorReceber());
			smt.setString(9, cr.getDataEmissao());
			smt.setString(10, cr.getDataVenc());
			smt.setString(11, cr.getDataPag());
			smt.setString(12, cr.getCodigo());
			smt.executeUpdate();
			smt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
		}catch(SQLException e) {
			
		}
	}
	
	public void excluir(ContasReceber cr) {
		con = Conectar.getConectar();
		String sql = "DELETE contasReceber WHERE codigo = ?";
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o título "
				+cr.getCodigo()+"?", "Excluir", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			try (PreparedStatement smt = con.prepareStatement(sql)){
				smt.setString(1, cr.getCodigo());
				smt.executeUpdate();
				smt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public List<ContasReceber> listarTodos(){
		con = Conectar.getConectar();
		List<ContasReceber>lista = new ArrayList<>();
		String sql = "SELECT * FROM contasReceber ORDER BY codigo";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			ResultSet resultado = smt.executeQuery();
			while(resultado.next()) {
				ContasReceber cr = new ContasReceber();
				cr.setCodigo(resultado.getString("codigo"));
				cr.setCodCli(Integer.parseInt(resultado.getString("codCli")));
				cr.setDataEmissao(resultado.getString("dataEmissao"));
				cr.setDataVenc(resultado.getString("dataVenc"));
				cr.setValorReceber(Float.parseFloat(resultado.getString("valorReceber")));
				lista.add(cr);
			}
			smt.close();
			con.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public ContasReceber BurcarCodigo(String codCR){
		con = Conectar.getConectar();
		String sql = "SELECT * FROM contasReceber WHERE codigo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			ContasReceber cr = new ContasReceber();
			smt.setString(1, codCR);
			ResultSet resultado = smt.executeQuery();
			if(resultado.next()) {
				cr.setCodigo(resultado.getString("codigo"));
				cr.setCodCli(Integer.parseInt(resultado.getString("codCli")));
				cr.setNomeCli(resultado.getString("nomeCli"));
				cr.setTipoDoc(resultado.getString("tipoDoc"));
				cr.setDescricao(resultado.getString("descricao"));
				cr.setMovimento(resultado.getString("movimento"));
				cr.setContrato(resultado.getString("contrato"));
				cr.setValorTotal(Float.parseFloat(resultado.getString("valorTotal")));
				cr.setValorRecebido(Float.parseFloat(resultado.getString("valorRecebido")));
				cr.setValorReceber(Float.parseFloat(resultado.getString("valorReceber")));
				cr.setDataEmissao(resultado.getString("dataEmissao"));
				cr.setDataVenc(resultado.getString("dataVenc"));
				cr.setDataPag(resultado.getString("dataPag"));
				//cr.setInativar(resultado.getString("inativar"));				
			}
			smt.close();
			con.close();
			return cr;	
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível buscar, erro: "+e);
		}
		return null;		
	}
	
	
}
