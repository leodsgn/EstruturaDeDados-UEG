package ueg.estrutura_de_dados.bimestre2.Trabalho_TorreDeHanoi;

import java.util.Scanner;

/**
 * Created by @leodsgn on 12/06/15.
 */
public class Main {
    // método main para restar o programa!
    public static void main(String[] args) {

        int n; // número de discos

        // recebe o nú	mero de discos digitado pelo usuário
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o número de discos: ");
        n = entrada.nextInt();

        // executa o algoritmo iterativo das Torres de Hanói
        TorreDeHanoi.hanoi(n);

    }
}
