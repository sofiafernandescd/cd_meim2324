package mqproducer;

import java.util.Date;

public class Sale {

    public final Date data;
    public final String codigoProduto;
    public final String categoria;
    public final String nomeProduto;
    public final int quantidade;
    public final double precoUnitario;
    public final double total;
    public final double iva;

    Sale(Date data, String codigoProduto, String categoria, String nomeProduto, int quantidade, double precoUnitario, double total, double iva) {
        this.data = data;
        this.codigoProduto = codigoProduto;
        this.categoria = categoria;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.total = total;
        this.iva = iva;
    }

}
