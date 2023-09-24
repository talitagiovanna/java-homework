package br.edu.uniaeso.ArquivosCSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class LerArquivoCSV {
    public static void main(String[] args) throws CsvValidationException {
        String arquivoCSV = "alunos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            boolean primeiraLinha = true;

            while ((linha = reader.readNext()) != null) {
                if (primeiraLinha) {
                    // A primeira linha contém os cabeçalhos, então a exibimos separadamente.
                    System.out.println("Cabeçalhos: ");
                    for (String cabecalho : linha) {
                        System.out.print(cabecalho + " ");
                    }
                    System.out.print("\n");
                    primeiraLinha = false;
                } else {
                    // As linhas subsequentes contêm os dados dos alunos.
                    for (String dado : linha) {
                        System.out.print(dado + " ");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
