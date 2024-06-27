package model;

public class Produto {
    private String Id;
    private String material;
    private String detalhes; // Adicionei detalhes como uma propriedade
    private String fornecedor;
    private String marca;
    private double preco_uni;
    private int quantidade;
    
    public Produto() {
		this.setId(null);
		this.setMaterial(null);
		this.setDetalhes(null);
		this.setFornecedor(null);
		this.setMarca(null);
		this.setPreco_uni(0);
		this.setQuantidade(0);
	}

    /*public Produto(String Id, String material, String detalhes, String fornecedor, String marca, double preco_uni, int quantidade) {
        this.Id = Id;
        this.material = material;
        this.detalhes = detalhes;
        this.fornecedor = fornecedor;
        this.marca = marca; // Use o parâmetro detalhes para inicializar marca
        this.preco_uni = preco_uni;
        this.quantidade = quantidade;
    }*/

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco_uni() {
        return preco_uni;
    }

    public void setPreco_uni(double preco_uni) {
        this.preco_uni = preco_uni;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

	public Object getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}
}
