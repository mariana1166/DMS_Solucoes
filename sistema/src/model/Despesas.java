package model;

public class Despesas {
	
	    //ATRIBUTOS
		private int codFuncionario ;
		private String codigo, tipoDespesa, nomeFuncionario, descricao, dataEmissao, dataVencimento, valor, tipoPag;
		
		
		
		public Despesas() {
			this.setCodFuncionario(0);
			this.setNomeFuncionario(null);
			this.setCodigo(null);
			this.setTipoDespesa(null);
			this.setDescricao(null);
			this.setDataEmissao(null);
			this.setDataVencimento(null);
			this.setValor(null);
			this.setTipoPag(null);
		}
		//GETS E SETS
		public int getCodFuncionario() {
			return codFuncionario;
		}
		public void setCodFuncionario(int codFuncionario) {
			this.codFuncionario = codFuncionario;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getTipoDespesa() {
			return tipoDespesa;
		}
		public void setTipoDespesa(String tipoDespesa) {
			this.tipoDespesa = tipoDespesa;
		}
		public String getNomeFuncionario() {
			return nomeFuncionario;
		}
		public void setNomeFuncionario(String nomeFuncionario) {
			this.nomeFuncionario = nomeFuncionario;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getDataEmissao() {
			return dataEmissao;
		}
		public void setDataEmissao(String dataEmissao) {
			this.dataEmissao = dataEmissao;
		}
		public String getDataVencimento() {
			return dataVencimento;
		}
		public void setDataVencimento(String dataVencimento) {
			this.dataVencimento = dataVencimento;
		}
		public String getValor() {
			return valor;
		}
		public void setValor(String valor) {
			this.valor = valor;
		}
		public String getTipoPag() {
			return tipoPag;
		}
		public void setTipoPag(String tipoPag) {
			this.tipoPag = tipoPag;
		}
		
}
