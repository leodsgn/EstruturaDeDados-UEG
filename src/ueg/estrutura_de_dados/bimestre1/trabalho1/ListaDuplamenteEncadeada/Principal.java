package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaDuplamenteEncadeada;

import java.util.Random;

class Principal{
    public static void main(String[] args){
        Lista lista1 = new Lista();
        Lista lista2 = new Lista();
        Random rand = new Random();

        lista1.inserir(rand.nextInt(100));
        lista1.inserir(rand.nextInt(100));
        lista1.inserir(rand.nextInt(100));
        lista1.inserir(rand.nextInt(100));
        System.out.println("LISTA 1: " + lista1);

        System.out.println("\nTotal de nos: " + lista1.totalNos());

        lista1.inserir(5, 4);

        System.out.println("\nLISTA: " + lista1);

        System.out.println("\nTotal de nos: " + lista1.totalNos());

		/*lista1.inserirNoComeco(4);

		System.out.println("\nInserindo no comeco: " + lista1);

		/*System.out.println("\nLISTA 1 EM ORDEM CRESCENTE: ");
		lista1.listarCrescente();

		System.out.println("\nLISTA 1 EM ORDEM DECRESCENTE: ");
		lista1.listarDecrescente();

		System.out.println("\n\n\nLISTA 2 EM ORDEM CRESCENTE: ");
		lista2.listarCrescente();

		System.out.println("\nLISTA 2 EM ORDEM DECRESCENTE: ");
		lista2.listarDecrescente();*/

		/*lista1.excluirNo(4);
		System.out.println("\nApos excluir o no: " + lista1);
		System.out.println("Total de nos: " + lista1.totalNos());

		System.out.println("\nElemento na posicao 2: " + lista1.buscar(2));

		System.out.println("\nExiste o elemento 5 na lista? " + lista1.pesquisar(5));

		lista1.alterar(3, 9);
		System.out.println("\nLista apos alteracao: " + lista1);*/


    }
}