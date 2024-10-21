import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
    private char[][] labirinto;

    public void criaLabirinto(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linha;
            int linhas = 0;
            int colunas = 0;
    
            // Determina o tamanho do labirinto
            while ((linha = br.readLine()) != null) {
                linhas++;
                colunas = Math.max(colunas, linha.length());
            }
    
            labirinto = new char[linhas][colunas];
    
            // Reinicia o BufferedReader
            br.close();
            BufferedReader br2 = new BufferedReader(new FileReader(filename));
    
            // Preenche o labirinto com os dados do arquivo
            int row = 0;
            while ((linha = br2.readLine()) != null) {
                char[] chars = linha.toCharArray();
                for (int col = 0; col < colunas; col++) {
                    if (row == 0 && col == 0) {
                        labirinto[row][col] = ' '; // Define a entrada como espaço em branco
                    } else if (col < chars.length) {
                        labirinto[row][col] = chars[col];
                    } else {
                        labirinto[row][col] = ' '; // Preenche com espaços em branco se necessário
                    }
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public boolean percorreLabirinto() {
        return percorreLabirinto(0, 0);
    }

    private boolean percorreLabirinto(int linha, int coluna) {
        // Verifica se a posição atual é válida
        if (linha < 0 || coluna < 0 || linha >= labirinto.length || coluna >= labirinto[linha].length || labirinto[linha][coluna] == 'X' || labirinto[linha][coluna] == 'V') {
            return false;
        }
    
        // Condição de saída: chegou ao destino
        if (labirinto[linha][coluna] == 'D') {
            return true;
        }
    
        // Marca a posição como visitada
        labirinto[linha][coluna] = 'V';
    
        // Explora as quatro direções possíveis
        boolean found = percorreLabirinto(linha + 1, coluna) || // Baixo
                       percorreLabirinto(linha - 1, coluna) || // Cima
                       percorreLabirinto(linha, coluna + 1) || // Direita
                       percorreLabirinto(linha, coluna - 1);   // Esquerda
    
        // Desmarca a posição antes de retornar
        labirinto[linha][coluna] = ' ';
    
        return found;
    }

    public static void main(String[] args) {
        Labirinto lab = new Labirinto();
        lab.criaLabirinto("labirinto.txt");
        boolean temSaida = lab.percorreLabirinto();
        if (temSaida) {
            System.out.println("Existe pelo menos uma saída no labirinto.");
        } else {
            System.out.println("Não há saída no labirinto.");
        }
    }
}

