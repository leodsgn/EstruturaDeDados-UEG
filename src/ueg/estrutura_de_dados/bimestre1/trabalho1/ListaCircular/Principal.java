package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaCircular;

import java.util.Random;

class Principal{
    public static void main(String[] args){
        Lista lista1 = new Lista();

        Random rand = new Random();

        lista1.inserir(rand.nextInt(100));
        lista1.inserir(rand.nextInt(100));
        lista1.inserir(rand.nextInt(100));
        lista1.inserir(rand.nextInt(100));
        System.out.println("LISTA: " + lista1);

        lista1.inserirNoComeco(9);
        System.out.println("LISTA: " + lista1);

		/*lista1.inserir(7, 3);
		System.out.println("LISTA: " + lista1);

		lista1.excluirNo(3);
		System.out.println("LISTA: " + lista1);*/

//		System.out.println("\nExiste o elemento 3 na lista? " + lista1.pesquisar(3));
//		System.out.println("\nExiste o elemento 10 na lista? " + lista1.pesquisar(9));
    }
}
