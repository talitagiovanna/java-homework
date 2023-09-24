package br.edu.uniaeso.ArquivosCSV;

import java.util.Date;

public class Venda {
    private Date data;
    private double valor;
    private String produtoVendido;

    public Venda(Date data, double valor, String produtoVendido) {
        this.data = data;
        this.valor = valor;
        this.produtoVendido = produtoVendido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
}
