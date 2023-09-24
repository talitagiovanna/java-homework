package br.edu.uniaeso.ArquivoTexto;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class LerArquivoCSV {

    public static void main(String[] args) {
        String nomeArquivo = "dados.csv";

        try {
            // Abre o arquivo CSV para leitura
            Reader arquivoLeitura = new FileReader(nomeArquivo);

            // Cria um CSVParser usando o formato padrão (vírgula como delimitador)
            CSVParser csvParser = new CSVParser(arquivoLeitura, CSVFormat.DEFAULT);

            // Itera pelas linhas do arquivo CSV e exibe os campos
            for (CSVRecord csvRecord : csvParser) {
                for (String campo : csvRecord) {
                    System.out.print(campo + "\t"); // \t para separar os campos por tabulação
                }

                System.out.println(); // Nova linha para cada registro
            }

            // Fecha o CSVParser e o arquivo de leitura
            csvParser.close();
            arquivoLeitura.close();
        } catch (IOException e) {
            // Captura exceções de E/S (IOException) e imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
    
}
