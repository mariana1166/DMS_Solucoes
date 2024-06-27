package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Conectar;
import model.Contrato;




public class ContratoDAO {
	private Connection con;
	
	public void inserir(Contrato c){
		con = Conectar.getConectar();				
		//METODO PARA INSERIR CLIENTE
				String sql = "INSERT INTO contrato (codigo, dtInicio, dtVenc, diaFat, condPag, diaPag, obs, codCli, nomeCli, valor) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
				try(PreparedStatement smt = con.prepareStatement(sql)){
					smt.setString(1, c.getCodigo());
					smt.setString(2, c.getDtInicio());
					smt.setString(3, c.getDtVenc());
					smt.setInt(4, c.getDiaFat());
					smt.setString(5, c.getCondPag());
					smt.setInt(6, c.getDiaPag());
					//smt.setBoolean(7, c.getSituacao());
					smt.setString(7, c.getObs());
					smt.setInt(8, c.getCodCli());
					smt.setString(9,c.getNomeCli());
					smt.setFloat(10,c.getValor());
					smt.executeUpdate();
					smt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Contrato cadastrado com sucesso!");
				}catch(SQLException e) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar!");
					throw new RuntimeException(e);
					
				}	
	}
	
	public void alterar(Contrato c) {
		con = Conectar.getConectar();
		String sql = "UPDATE contrato SET dtInicio = ?, dtVenc = ?, diaFat = ?, condPag = ?, diaPag = ?, obs = ?, codCli = ?, valor =?, nomeCli = ? "
				+ "where codigo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			smt.setString(1, c.getDtInicio());
			smt.setString(2, c.getDtVenc());
			smt.setInt(3, c.getDiaFat());
			smt.setString(4, c.getCondPag());
			smt.setInt(5, c.getDiaPag());
			//smt.setBoolean(7, c.getSituacao());
			smt.setString(6, c.getObs());
			smt.setInt(7, c.getCodCli());
			smt.setString(8,c.getNomeCli());
			smt.setFloat(9,c.getValor());
			smt.setString(10, c.getCodigo());
			smt.executeUpdate();
			smt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Falha ao alterar! "+e);
		}
	}
	
	public void excluir(Contrato c) {
		con = Conectar.getConectar();
		String sql = "DELETE contrato WHERE codigo = ?";
		int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o contrato "
				+c.getCodigo()+"?", "Excluir", JOptionPane.YES_NO_OPTION);
		if(opcao == JOptionPane.YES_OPTION) {
			try (PreparedStatement smt = con.prepareStatement(sql)){
				smt.setString(1, c.getCodigo());
				smt.executeUpdate();
				smt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public List<Contrato> listarTodos(){
		con = Conectar.getConectar();
		List<Contrato>lista = new ArrayList<>();
		String sql = "SELECT * FROM contrato ORDER BY codigo";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			ResultSet resultado = smt.executeQuery();
			while(resultado.next()) {
				Contrato c = new Contrato();
				c.setCodigo(resultado.getString("codigo"));
				c.setCodCli(resultado.getInt("codCli"));
				c.setNomeCli(resultado.getString("nomeCli"));
				c.setDtInicio(resultado.getString("dtInicio"));
				c.setDtVenc(resultado.getString("dtVenc"));
				c.setDiaFat(resultado.getInt("diaFat"));
				c.setCondPag(resultado.getString("condPag"));
				c.setDiaPag(resultado.getInt("diaPag"));
				c.setValor(resultado.getFloat("valor"));
			    //c.setSituacao(resultado.getBoolean("situacao"));
			    //c.setObs(resultado.getString("obs"));
				lista.add(c);
			}
			smt.close();
			con.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public Contrato BurcarCodigo(String codigo){
		con = Conectar.getConectar();
		String sql = "SELECT * FROM contrato WHERE codigo = ?";
		try(PreparedStatement smt = con.prepareStatement(sql)){
			Contrato c = new Contrato();
			smt.setString(1, codigo);
			ResultSet resultado = smt.executeQuery();
			if(resultado.next()) {
				c.setCodigo(resultado.getString("codigo"));
				c.setCodCli(Integer.parseInt(resultado.getString("codCli")));
				c.setNomeCli(resultado.getString("nomeCli"));
				c.setCondPag(resultado.getString("condPag"));
				c.setDiaFat(Integer.parseInt(resultado.getString("diaFat")));
				c.setDiaPag(Integer.parseInt(resultado.getString("diaPag")));
				c.setDtInicio(resultado.getString("dtInicio"));
				c.setDtVenc(resultado.getString("dtVenc"));
				c.setObs(resultado.getString("obs"));
				c.setValor(resultado.getFloat("valor"));
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
