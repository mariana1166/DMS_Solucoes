package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Conectar;
import model.Baixas;

public class BaixasCPDAO {
private Connection con;
	
	public void inserir(Baixas bcp){
		con = Conectar.getConectar();				
		//METODO PARA INSERIR CONTAS A PAGAR
				String sql = "INSERT INTO baixasCP (dataBaixa, codTitulo, valor, desconto, juros, totalBaixa) "
						                                 + "VALUES (?, ?, ?, ?, ?, ?)";
				try(PreparedStatement smt = con.prepareStatement(sql)){
					smt.setString(1, bcp.getDataBaixa());
					smt.setString(2, bcp.getCodTitulo());
					smt.setFloat(3, bcp.getValor());
					smt.setFloat(4, bcp.getDesconto());
					smt.setFloat(5, bcp.getJuros());
					smt.setFloat(6, bcp.getTotalBaixa());
					smt.executeUpdate();
					smt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Baixa cadastrada com sucesso!");
				}catch(SQLException e) {
					JOptionPane.showMessageDialog(null, "Não foi possível baixar!");
					throw new RuntimeException(e);
					
				}	
	}
	
	
	public void excluir(Baixas bcp) {
		con = Conectar.getConectar();
		String sql = "DELETE BaixasCP WHERE codigo = ?";
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a baixa "
				+bcp.getCodigo()+"?", "Excluir", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			try (PreparedStatement smt = con.prepareStatement(sql)){
				smt.setString(1, bcp.getCodigo());
				smt.executeUpdate();
				smt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public List<Baixas> listarTodos(String codTitulo){
		con = Conectar.getConectar();
		List<Baixas>lista = new ArrayList<>();
		String sql = "SELECT * FROM BaixasCP WHERE codTitulo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setString(1, codTitulo);
			ResultSet resultado = smt.executeQuery();
			while(resultado.next()) {
				Baixas bcp = new Baixas();
				bcp.setCodigo(resultado.getString("codigo"));
				bcp.setDataBaixa(resultado.getString("dataBaixa"));
				bcp.setCodTitulo(resultado.getString("codTitulo"));
				bcp.setValor(resultado.getFloat("valor"));
				bcp.setDesconto(resultado.getFloat("desconto"));
				bcp.setJuros(resultado.getFloat("juros"));
				bcp.setTotalBaixa(resultado.getFloat("totalBaixa"));
				lista.add(bcp);
			}
			smt.close();
			con.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public List<Baixas> somarBaixas(String codTitulo){
		con = Conectar.getConectar();
		List<Baixas>lista = new ArrayList<>();
		String sql = "SELECT * FROM BaixasCP WHERE codTitulo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setString(1, codTitulo);
			ResultSet resultado = smt.executeQuery();
			while(resultado.next()) {
				Baixas bcp = new Baixas();
				bcp.setCodigo(resultado.getString("codigo"));
				bcp.setTotalBaixa(resultado.getFloat("totalBaixa"));
				lista.add(bcp);
			}
			smt.close();
			con.close();
			return lista;
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	/*
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
				cr.setValorTotal(resultado.getString("valorTotal"));
				cr.setValorRecebido(resultado.getString("valorRecebido"));
				cr.setValorReceber(resultado.getString("valorReceber"));
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
	*/
}
