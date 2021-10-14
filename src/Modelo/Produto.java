package Modelo;

public class Produto {
    private String nome;
    private String codigo;
    private int quantidadeEmEstoque;
    private double valor;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double d) {
        this.valor = d;
    }   
}
