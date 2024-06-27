package model;

public class ContasReceber {
	
	    //ATRIBUTOS
		private int codCli ;
		private String codigo, nomeCli, descricao, movimento, contrato, dataEmissao, dataVenc, tipoDoc, dataPag;
		private float valorRecebido, valorReceber, valorTotal ;
		
		//CONSTRUTOR
		public ContasReceber() {
			this.setCodigo(null);
			this.setCodCli(0);
			this.setNomeCli(null);
			this.setDescricao(null);
			this.setMovimento(null);
			this.setContrato(null);
			this.setValorTotal(0);
			this.setDataEmissao(null);
			this.setDataVenc(null);
			this.setTipoDoc(null);
			this.setValorRecebido(0);
			this.setValorReceber(0);
			this.setDataPag(null);
		}
		//GETS E SETS
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
		
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getMovimento() {
			return movimento;
		}
		public void setMovimento(String movimento) {
			this.movimento = movimento;
		}
		public String getContrato() {
			return contrato;
		}
		public void setContrato(String contrato) {
			this.contrato = contrato;
		}
		public float getValorTotal() {
			return valorTotal;
		}
		public void setValorTotal(float valorTotal) {
			this.valorTotal = valorTotal;
		}
		public String getDataEmissao() {
			return dataEmissao;
		}
		public void setDataEmissao(String dataEmissao) {
			this.dataEmissao = dataEmissao;
		}
		public String getDataVenc() {
			return dataVenc;
		}
		public void setDataVenc(String dataVenc) {
			this.dataVenc = dataVenc;
		}
		public String getTipoDoc() {
			return tipoDoc;
		}
		public void setTipoDoc(String tipoDoc) {
			this.tipoDoc = tipoDoc;
		}
		public float getValorRecebido() {
			return valorRecebido;
		}
		public void setValorRecebido(float valorRecebido) {
			this.valorRecebido = valorRecebido;
		}
		public float getValorReceber() {
			return valorReceber;
		}
		public void setValorReceber(float valorReceber) {
			this.valorReceber = valorReceber;
		}
		public String getDataPag() {
			return dataPag;
		}
		public void setDataPag(String dataPag) {
			this.dataPag = dataPag;
		}
		
		
}
