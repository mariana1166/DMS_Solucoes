package model;

public class Baixas {
	
	//ATRIBUTOS
	private String codigo, dataBaixa, codTitulo;
	private float valor, desconto, juros, totalBaixa;

	public Baixas() {
		this.setCodigo(null);
		this.setDataBaixa(null);
		this.setCodTitulo(null);
		this.setValor(0);
		this.setDesconto(0);
		this.setJuros(0);
		this.setTotalBaixa(0);
	}

	//GETS E SETS
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDataBaixa() {
		return dataBaixa;
	}

	public void setDataBaixa(String dataBaixa) {
		this.dataBaixa = dataBaixa;
	}

	public String getCodTitulo() {
		return codTitulo;
	}

	public void setCodTitulo(String codTitulo) {
		this.codTitulo = codTitulo;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public float getJuros() {
		return juros;
	}

	public void setJuros(float juros) {
		this.juros = juros;
	}

	public float getTotalBaixa() {
		return totalBaixa;
	}

	public void setTotalBaixa(float totalBaixa) {
		this.totalBaixa = totalBaixa;
	}


	
	
}
