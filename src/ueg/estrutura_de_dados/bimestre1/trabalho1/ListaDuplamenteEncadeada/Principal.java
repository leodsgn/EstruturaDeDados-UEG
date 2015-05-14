package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaDuplamenteEncadeada;

import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

class Principal{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        Hashtable<String, Lista> listas = new Hashtable<String, Lista>();

        Random rand = new Random();

        System.out.println("=============================================");
        System.out.println("                    Menu:                    ");
        System.out.println("---------------------------------------------");
        System.out.println(" 1. Criar lista");
        System.out.println(" 2. Inserir elemento");
        System.out.println(" 3. Excluir elemento");
        System.out.println(" 4. Buscar elemento");
        System.out.println(" 5. Pesquisar elemento");
        System.out.println(" 6. Alterar um no da lista");
        System.out.println(" 7. Intercalar listas");
        System.out.println(" 8. Verificar se lista esta vazia");
        System.out.println(" 9. Destruir lista");
        System.out.println(" 10. Listar elementos em ordem crescente");
        System.out.println(" 11. Listar elementos em ordem decrescente");
        System.out.println(" 12. Imprimir lista em ordem crescente");
        System.out.println(" 13. Imprimir lista em ordem decrescente");
        System.out.println("=============================================");



        int qdeListas = 1;
        char l = 'c';
        String nome = null;

        do{
            System.out.print("\nDigite a opcao desejada: ");
            int opcao = teclado.nextInt();
            switch(opcao){
                //Criar lista
                case 1:
                    listas.put("lista"+qdeListas, new Lista());
                    qdeListas++;
                    System.out.println("Lista criada!");
                    break;

                //Inserir elemento
                case 2:
                    teclado.nextLine();
                    System.out.print("\nDigite qual lista voce deseja alterar: ");
                    nome = teclado.nextLine();

                    Lista umaLista = listas.get(nome);
                    int numero = 0;

                    System.out.println("\nEscolha: ");
                    System.out.println("1- Inserir numeros manualmente");
                    System.out.println("2- Inserir numeros aleatorios");
                    int n = teclado.nextInt();
                    if(n == 1){
                        System.out.print("Digite o numero que voce deseja inserir: ");
                        numero = teclado.nextInt();

                        umaLista.inserir(numero);
                        System.out.println("Numero inserido!");
                    } else if(n == 2){
                        System.out.print("\nQuantos numeros voce deseja inserir? ");
                        n = teclado.nextInt();
                        for(int i = 0; i < n; i++){
                            umaLista.inserir(rand.nextInt(100));
                        }
                        System.out.println("Numeros inseridos!");
                    }
                    break;

                //Excluir elemento
                case 3:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);
                    System.out.println("Lista: " + umaLista);

                    System.out.print("Digite a posicao do elemento que voce deseja excluir: ");
                    numero = teclado.nextInt();

                    umaLista.excluirNo(numero);
                    System.out.println("Elemento excluido!");
                    break;

                //Buscar elemento
                case 4:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista na qual voce deseja realizar a busca: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    System.out.print("Digite a posicao do elemento que voce deseja buscar: ");
                    numero = teclado.nextInt();

                    int num = umaLista.buscar(numero);
                    System.out.println("Resultado da busca: " + num);
                    break;

                //Pesquisar elemento
                case 5:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista na qual voce deseja realizar a pesquisa: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    System.out.print("Digite o elemento que deseja pesquisar: ");
                    numero = teclado.nextInt();

                    if(umaLista.pesquisar(numero)){
                        System.out.println("\"" + numero + "\"" + " existe na lista e sua posicao e: " + umaLista.buscarPos(numero));
                    } else {
                        System.out.println("\"" + numero + "\"" + " nao existe na lista");
                    }

                    break;

                //Alterar um no da lista
                case 6:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    System.out.println("Lista: " + umaLista.toStringC());

                    System.out.print("Digite a posicao que voce deseja alterar: ");
                    int posicao = teclado.nextInt();

                    System.out.print("Digite o novo elemento: ");
                    int elemento = teclado.nextInt();

                    umaLista.alterar(posicao, elemento);
                    System.out.println("Elemento alterado!");
                    break;

                //Intercalar listas
                case 7:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da primeira lista: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    System.out.print("Digite o nome da segunda lista: ");
                    nome = teclado.nextLine();
                    Lista outraLista = listas.get(nome);

                    Lista listaIntercalada = umaLista.intercalar(umaLista, outraLista);

                    System.out.println("Lista intercalada: " + listaIntercalada);
                    break;

                //Verificar se lista esta vazia
                case 8:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    if(umaLista.estaVazia()){
                        System.out.println("Lista esta vazia!");
                    } else {
                        System.out.println("Lista nao esta vazia!");
                    }
                    break;

                //Destruir lista
                case 9:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    umaLista.excluirLista();
                    System.out.println("Lista excluida!");
                    break;

                //Listar elementos em ordem crescente
                case 10:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    System.out.println("\nNome da lista: " + nome + ": ");
                    umaLista.listarCrescente();
                    break;

                //Listar elementos em ordem decrescente
                case 11:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    System.out.println("\nNome da lista: " + nome + ": ");
                    umaLista.listarDecrescente();
                    break;

                //Imprimir lista em ordem crescente
                case 12:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    System.out.println(nome + ": " + umaLista.toStringC());
                    break;

                //Imprimir lista em ordem decrescente
                case 13:
                    teclado.nextLine();
                    System.out.print("\nDigite o nome da lista: ");
                    nome = teclado.nextLine();
                    umaLista = listas.get(nome);

                    System.out.println(nome + ": " + umaLista.toStringD());
                    break;
                default: System.out.println("Opcao invalida!");
            }

            System.out.print("\n\nDeseja escolher outra opcao? (-s -n) ");
            l = teclado.next().charAt(0);
        } while(l == 's');


    }
}

