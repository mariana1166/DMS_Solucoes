package model;

public class Cliente {
	
	//ATRIBUTOS
	private int codigo;
	private String nome;
	private boolean fisico;
	private String cnpj;
	//public Endereco end;
	//public String contato;
	//public String tel1;
	//public String tel2;
	
	
	//METODOS
	
	public Cliente() {
		this.setCodigo(0);
		this.setNome(null);
		this.setCnpj(null);
		this.juridico();
	}
	
	public Cliente(int cod, String nome, String cnpj) {
		this.setCodigo(cod);
		this.setNome(nome);
		this.setCnpj(cnpj);
		this.juridico();
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	public void setCodigo(int cod) {
		this.codigo = cod;
	}
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public boolean getFisico() {
		return this.fisico;
	}
	public void setFisico(boolean fisico) {
		this.fisico=fisico;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public void fisico() {
		this.fisico = true;
	}
	
	public void juridico() {
		this.fisico = false;
	}
		

	
}
