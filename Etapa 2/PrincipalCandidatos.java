import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {
    public static void main(String[] args) {
        Random random = new Random();
        int tamanho = random.nextInt(100) + 1; // Tamanho entre 1 e 100
        Candidato[] candidatos = new Candidato[tamanho];
        String[] nomes = {"Ana", "Bruno", "Carlos", "Diana", "Eduardo", "Fernanda", "Gustavo", "Helena", "Igor", "Juliana"};
        String[] partidos = {"Partido Livre", "PSDB", "PT", "MBL"};

        for (int i = 0; i < tamanho; i++) {
            String nome = nomes[random.nextInt(nomes.length)];
            String partido = partidos[random.nextInt(partidos.length)];
            int intencoesVotos = random.nextInt(1000); // Intenções de voto entre 0 e 999
            candidatos[i] = new Candidato(nome, partido, intencoesVotos);
        }

        System.out.println("Candidatos criados:");
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }

        // Ordenar os candidatos conforme solicitado
        ordenaCandidatos(candidatos);

        // Imprimir candidatos ordenados
        System.out.println("\nCandidatos ordenados:");
        for (Candidato candidato : candidatos) {
            System.out.println(candidato);
        }

        // Pesquisa binária
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o nome do candidato a ser procurado: ");
        String nomeProcurado = scanner.nextLine();
        int posicao = pesquisaBinariaCandidatos(candidatos, nomeProcurado);
        
        if (posicao != -1) {
            System.out.println("Candidato encontrado: " + candidatos[posicao]);
        } else {
            System.out.println("Candidato não encontrado.");
        }

        scanner.close();
    }

    public static void ordenaCandidatos(Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            Candidato chave = candidatos[i];
            int j = i - 1;

            while (j >= 0 && comparaCandidatos(candidatos[j], chave) > 0) {
                candidatos[j + 1] = candidatos[j];
                j--;
            }
            candidatos[j + 1] = chave;
        }
    }

    private static int comparaCandidatos(Candidato c1, Candidato c2) {
        int nomeComparacao = c1.getNome().compareTo(c2.getNome());
        if (nomeComparacao != 0) {
            return nomeComparacao;
        }
        int votosComparacao = Integer.compare(c2.getIntencoesVotos(), c1.getIntencoesVotos());
        if (votosComparacao != 0) {
            return votosComparacao;
        }
        return c1.getPartido().compareTo(c2.getPartido());
    }

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int esquerda = 0;
        int direita = candidatos.length - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            int comparacao = candidatos[meio].getNome().compareTo(nome);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }
}
