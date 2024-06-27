package model;

import java.util.Date;

public class Vendas {
    private int codigo;
    private int codCli;
    private String nomeCli;
    private String tipoDocumento;
    private String servico;
    private int parcela;
    private String dataVenda;
    private String dataPagamento;
    private double valorVenda;
    private String formaPagamento;
    private int quantidade;
    
    public Vendas() {
		this.setCodigo(0);
		this.setCodCli(0);
		this.setNomeCli(null);
		this.setTipoDocumento(null);
		this.setServico(null);
		this.setParcela(0);
		this.setDataVenda(null);
		this.setDataPagamento(null);
		this.setValorVenda(0);
		this.setFormaPagamento(null);
		this.setQuantidade(0);
	}

   /* public ModelVendas(int codigo, String cliente, String tipoDocumento, String servico, int parcela, Date dataVenda, Date dataPagamento, double valorVenda, String formaPagamento) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.tipoDocumento = tipoDocumento;
        this.servico = servico;
        this.parcela = parcela;
        this.dataVenda = dataVenda;
        this.dataPagamento = dataPagamento;
        this.valorVenda = valorVenda;
        this.formaPagamento = formaPagamento;
    }*/

    public Vendas(int int1, String string, int int2, double double1, double double2) {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    public int getCodCli() {
		return codCli;
	}

	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
    
}
