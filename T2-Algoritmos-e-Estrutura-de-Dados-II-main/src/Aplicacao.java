import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Nomes: Brenda Brizola, Isadora Morari, Luana Thurow

public class Aplicacao {
    private static List<Caixa> caixas;
    private static List<List<Integer>> adjList;
    private static int[] dp;
    private static int[] parent;
    private static int maxLength;
    private static int startIndex;

    public static void main(String[] args) {
        caixas = new ArrayList<>();

        // Opção de escolher o arquivo a ser lido
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Digite qual dos testes deseja ler:
                10
                20
                50
                100
                200
                300
                1000
                2000
                10000
                """);
        int escolha = scanner.nextInt();
        String arquivo = "T2-Algoritmos-e-Estrutura-de-Dados-II-main" + "/CasosDeTeste/caixas_" + escolha + ".txt";

        String caminhoAbsoluto = obterCaminhoAbsoluto(arquivo);
        System.out.println("Lendo arquivo: " + caminhoAbsoluto);
        
        lerArquivo(caminhoAbsoluto);
        System.out.println("");

        // Construir o grafo e encontrar a maior sequência
        construirGrafo();
        maxLength = 0;
        startIndex = -1;
        for (int i = 0; i < caixas.size(); i++) {
            int length = dfs(i);
            if (length > maxLength) {
                maxLength = length;
                startIndex = i;
            }
        }
        System.out.println("O comprimento da maior sequencia de caixas aninhadas eh: " + maxLength);

        // Mostrar a sequência de caixas
        if (startIndex != -1) {
            List<Caixa> sequencia = new ArrayList<>();
            for (int i = startIndex; i != -1; i = parent[i]) {
                sequencia.add(caixas.get(i));
            }
            Collections.reverse(sequencia);
            System.out.println("A maior sequencia de caixas aninhadas eh:");
            for (Caixa caixa : sequencia) {
                System.out.println(caixa);
            }
        }
    }

    private static String obterCaminhoAbsoluto(String caminhoRelativo) {
        File file = new File(caminhoRelativo);
        return file.getAbsolutePath();
    }

    public static void lerArquivo(String arquivo) {
        Path caminho = Paths.get(arquivo);
        if (!Files.exists(caminho)) {
            System.err.println("Arquivo não encontrado: " + caminho.toAbsolutePath());
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] medidas = linha.split(" ");
                int altura = Integer.parseInt(medidas[0]);
                int largura = Integer.parseInt(medidas[1]);
                int comprimento = Integer.parseInt(medidas[2]);
                Caixa caixa = new Caixa(comprimento, largura, altura);
                caixas.add(caixa);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + caminho.toAbsolutePath());
            e.printStackTrace();
        }
    }

    public static void construirGrafo() {
        int n = caixas.size();
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adicionando arestas ao grafo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && caixas.get(i).canFitInside(caixas.get(j))) {
                    adjList.get(i).add(j);
                }
            }
        }

        dp = new int[n];
        parent = new int[n];
        Arrays.fill(dp, -1);
        Arrays.fill(parent, -1);
    }

    private static int dfs(int u) {
        if (dp[u] != -1) return dp[u];

        int maxLength = 1;
        for (int v : adjList.get(u)) {
            int length = 1 + dfs(v);
            if (length > maxLength) {
                maxLength = length;
                parent[u] = v;
            }
        }

        return dp[u] = maxLength;
    }

    public List<Caixa> getCaixas() {
        return caixas;
    }
}