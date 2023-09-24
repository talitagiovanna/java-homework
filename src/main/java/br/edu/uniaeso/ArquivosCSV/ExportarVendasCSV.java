package br.edu.uniaeso.ArquivosCSV;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExportarVendasCSV {
    public static void main(String[] args) {
        String arquivoCSV = "vendas.csv";
        List<Venda> vendas = new ArrayList<>();

        // Criar algumas vendas de exemplo
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data1 = dateFormat.parse("01/10/2023");
            Date data2 = dateFormat.parse("15/10/2023");

            Venda venda1 = new Venda(data1, 150.0, "Produto A");
            Venda venda2 = new Venda(data2, 200.0, "Produto B");

            vendas.add(venda1);
            vendas.add(venda2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Exportar as vendas para o arquivo CSV
        try (CSVWriter writer = new CSVWriter(new FileWriter(arquivoCSV))) {
            // Escrever cabeçalhos
            writer.writeNext(new String[]{"Data", "Valor", "Produto Vendido"});

            // Escrever as vendas
            for (Venda venda : vendas) {
                String dataStr = dateFormat.format(venda.getData());
                String valorStr = String.valueOf(venda.getValor());
                String produtoVendido = venda.getProdutoVendido();
                writer.writeNext(new String[]{dataStr, valorStr, produtoVendido});
            }

            System.out.println("Vendas exportadas para " + arquivoCSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
