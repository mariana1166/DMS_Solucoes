package model;

public class ContasPagar {
	
	    //ATRIBUTOS
		private int codRecebedor ;
		private String codigo, nomeRecebedor, descricao, movimento, dataEmissao, dataVenc, tipoDoc;
		private String dataPag;
		private float valorPago, valorPagar, valorTotal;
		
		//CONSTRUTOR
		public ContasPagar() {
			this.setCodigo(null);
			this.setCodRecebedor(0);
			this.setNomeRecebedor(null);
			this.setDescricao(null);
			this.setMovimento(null);
			this.setValorTotal(0);
			this.setDataEmissao(null);
			this.setDataVenc(null);
			this.setTipoDoc(null);
			this.setValorPago(0);
			this.setValorPagar(0);
			this.setDataPag(null);
		}
		//GETS E SETS
		public int getCodRecebedor() {
			return codRecebedor;
		}
		public void setCodRecebedor(int codRecebedor) {
			this.codRecebedor = codRecebedor;
		}
		
		public String getNomeRecebedor() {
			return nomeRecebedor;
		}
		public void setNomeRecebedor(String nomeRecebedor) {
			this.nomeRecebedor = nomeRecebedor;
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
		public float getValorPago() {
			return valorPago;
		}
		public void setValorPago(float valorPago) {
			this.valorPago = valorPago;
		}
		public float getValorPagar() {
			return valorPagar;
		}
		public void setValorPagar(float valorPagar) {
			this.valorPagar = valorPagar;
		}
		public String getDataPag() {
			return dataPag;
		}
		public void setDataPag(String dataPag) {
			this.dataPag = dataPag;
		}
		
		
}
