package model;

public class Contrato {
	
	//ATRIBUTOS
	private int  diaFat, diaPag, codCli;
	//private boolean situacao;
	private String obs, codigo, dtInicio, dtVenc, nomeCli, condPag;
	private float valor;
	
	

	//CONSTRUTOR
	public Contrato() {
		this.setCodigo(null);
		this.setCodCli(0);
		this.setNomeCli(null);
		this.setDtInicio(null);
		this.setDtVenc(null);
		this.setDiaFat(0);
		this.setCondPag(null);
		this.setDiaPag(0);
		//this.setSituacao(situacao);
		this.setObs(null);
	}
	
	//GET e SET	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getDtVenc() {
		return dtVenc;
	}

	public void setDtVenc(String dtVenc) {
		this.dtVenc = dtVenc;
	}

	public int getDiaFat() {
		return diaFat;
	}

	public void setDiaFat(int diaFat) {
		this.diaFat = diaFat;
	}

	public String getCondPag() {
		return condPag;
	}

	public void setCondPag(String condPag) {
		this.condPag = condPag;
	}

	public int getDiaPag() {
		return diaPag;
	}

	public void setDiaPag(int diaPag) {
		this.diaPag = diaPag;
	}

	/*public boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}*/

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
