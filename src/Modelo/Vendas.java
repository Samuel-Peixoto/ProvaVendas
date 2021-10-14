package Modelo;

public class Vendas {
    private String produtoVendido;
    private String Sim;
    private int quantidadeVendida;
    private int dataDaVenda;
    
    public String getProdutoVendido() {
        return produtoVendido;
    }
    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
    
    public String getSim() {
        return Sim;
    }
    public void setSim(String sim) {
        Sim = sim;
    }
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    public int getDataDaVenda() {
        return dataDaVenda;
    }
    public void setDataDaVenda(int dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

}
