package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Conectar;
import model.ContasPagar;

public class ContasPagarDAO {
private Connection con;
	
	public void inserir(ContasPagar cp){
		con = Conectar.getConectar();				
		//METODO PARA INSERIR CONTAS A PAGAR
				String sql = "INSERT INTO contasPagar (codigo, codCli, nomeCli, tipoDoc, descricao, movimento, valorTotal, valorPago, valorPagar, dataEmissao, dataVenc, dataPag) "
						                                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				try(PreparedStatement smt = con.prepareStatement(sql)){
					smt.setString(1, cp.getCodigo());
					smt.setInt(2, cp.getCodRecebedor());
					smt.setString(3, cp.getNomeRecebedor());
					smt.setString(4, cp.getTipoDoc());
					smt.setString(5, cp.getDescricao());
					smt.setString(6, cp.getMovimento());
					smt.setFloat(7, cp.getValorTotal());
					smt.setFloat(8, cp.getValorPago());
					smt.setFloat(9, cp.getValorPagar());
					smt.setString(10, cp.getDataEmissao());
					smt.setString(11, cp.getDataVenc());
					smt.setString(12, cp.getDataPag());
					smt.executeUpdate();
					smt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Titulo cadastrado com sucesso!");
				}catch(SQLException e) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar!");
					throw new RuntimeException(e);
					
				}	
	}
	
	public void alterar(ContasPagar cp) {
		con = Conectar.getConectar();
		String sql = "UPDATE contasPagar SET codCli = ?, tipoDoc = ?, descricao = ?, movimento = ?, valorTotal = ?, valorPago = ?, valorPagar = ?, dataEmissao = ?, dataVenc = ?, dataPag = ? where codigo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setInt(1, cp.getCodRecebedor());
			smt.setString(2, cp.getTipoDoc());
			smt.setString(3, cp.getDescricao());
			smt.setString(4, cp.getMovimento());
			smt.setFloat(5, cp.getValorTotal());
			smt.setFloat(6, cp.getValorPago());
			smt.setFloat(7, cp.getValorPagar());
			smt.setString(8, cp.getDataEmissao());
			smt.setString(9, cp.getDataVenc());
			smt.setString(10, cp.getDataPag());
			smt.setString(11, cp.getCodigo());
			smt.executeUpdate();
			smt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar!"+e);	
		}
	}
	
	public void excluir(ContasPagar cp) {
		con = Conectar.getConectar();
		String sql = "DELETE ContasPagar WHERE codigo = ?";
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o título "
				+cp.getCodigo()+"?", "Excluir", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			try (PreparedStatement smt = con.prepareStatement(sql)){
				smt.setString(1, cp.getCodigo());
				smt.executeUpdate();
				smt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public List<ContasPagar> listarTodos(){
		con = Conectar.getConectar();
		List<ContasPagar>lista = new ArrayList<>();
		String sql = "SELECT * FROM ContasPagar ORDER BY codigo";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			ResultSet resultado = smt.executeQuery();
			while(resultado.next()) {
				ContasPagar cp = new ContasPagar();
				cp.setCodigo(resultado.getString("codigo"));
				cp.setCodRecebedor(Integer.parseInt(resultado.getString("codCli")));
				cp.setDataEmissao(resultado.getString("dataEmissao"));
				cp.setDataVenc(resultado.getString("dataVenc"));
				cp.setValorPagar(Float.parseFloat(resultado.getString("valorPagar")));
				lista.add(cp);
			}
			smt.close();
			con.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public ContasPagar BurcarCodigo(String codcp){
		con = Conectar.getConectar();
		String sql = "SELECT * FROM ContasPagar WHERE codigo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			ContasPagar cp = new ContasPagar();
			smt.setString(1, codcp);
			ResultSet resultado = smt.executeQuery();
			if(resultado.next()) {
				cp.setCodigo(resultado.getString("codigo"));
				cp.setCodRecebedor(Integer.parseInt(resultado.getString("codCli")));
				cp.setNomeRecebedor(resultado.getString("nomeCli"));
				cp.setTipoDoc(resultado.getString("tipoDoc"));
				cp.setDescricao(resultado.getString("descricao"));
				cp.setMovimento(resultado.getString("movimento"));
				cp.setValorTotal(Float.parseFloat(resultado.getString("valorTotal")));
				cp.setValorPago(resultado.getFloat("valorPago"));
				cp.setValorPagar(Float.parseFloat(resultado.getString("valorPagar")));
				cp.setDataEmissao(resultado.getString("dataEmissao"));
				cp.setDataVenc(resultado.getString("dataVenc"));
				cp.setDataPag(resultado.getString("dataPag"));
				//cp.setInativar(resultado.getString("inativar"));				
			}
			smt.close();
			con.close();
			return cp;	
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível buscar, erro: "+e);
		}
		return null;		
	}
	
	
}
