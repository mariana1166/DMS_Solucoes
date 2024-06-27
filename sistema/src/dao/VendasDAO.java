package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Vendas;
import model.Conectar;


public class VendasDAO {
	  private Connection con;

	    public VendasDAO() {
	        con = Conectar.getConectar();
	    }
    public void inserirVenda(Vendas venda) {
        String sql = "INSERT INTO vendas (cliente, tipo_documento, servico, parcela, dataVenda, dataPagamento, valorVenda, formaPagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, venda.getCodCli());
            pstmt.setString(2, venda.getTipoDocumento());
            pstmt.setString(3, venda.getServico());
            pstmt.setInt(4, venda.getParcela());
            pstmt.setDate(5, new java.sql.Date(venda.getDataVenda().getTime()));
            pstmt.setDate(6, new java.sql.Date(venda.getDataPagamento().getTime()));
            pstmt.setDouble(7, venda.getValorVenda());
            pstmt.setString(8, venda.getFormaPagamento());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vendas> listarVendas() {
        List<Vendas> vendas = new ArrayList<>();
        String sql = "SELECT * FROM vendas";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("Codigo");
                String cliente = rs.getString("Cliente");
                String tipoDocumento = rs.getString("tipo_documento");
                String servico = rs.getString("servico");
                int parcela = rs.getInt("parcela");
                Date dataVenda = rs.getDate("Data_da_Venda");
                Date dataPagamento = rs.getDate("Data_Pagamento");
                double valorVenda = rs.getDouble("Valor_da_Venda");
                String formaPagamento = rs.getString("Forma_Pag");

                Vendas venda = new Vendas(codigo, cliente, tipoDocumento, servico, parcela, dataVenda, dataPagamento, valorVenda, formaPagamento);
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendas;
    }

    public void deletarVenda(int codigo) {
        String sql = "DELETE FROM vendas WHERE Codigo = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
