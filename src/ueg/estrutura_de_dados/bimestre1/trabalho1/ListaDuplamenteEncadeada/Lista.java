package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaDuplamenteEncadeada;

class Lista {
    protected No primeiro;
    protected No ultimo;
    protected int qdnos;

    /**
     * Construtor da classe lista
     */
    public Lista(){
        primeiro  = ultimo = null;
        qdnos = 0;
    }

    /**
     * Exclui todos os elementos / nós da lista
     */
    public void excluirLista(){
        if(!estaVazia()){
            primeiro = ultimo = null;
            qdnos = 0;
        }
    }

    /**
     * Verifica se a lista possui algum nó / elemento
     * @return true or false
     */
    public boolean estaVazia(){ return qdnos == 0;	}

    /**
     * Apresenta a quantidade total de nós/elementos de uma lista
     * @return qdnos
     */
    public int totalNos(){ return qdnos; }

    /**
     * Insere um novo elemento no início da lista
     * @param info
     */
    public void inserirNoComeco(int info){
        if(qdnos == 0){
            No novo = new No(info);
            primeiro = ultimo = novo;
        } else {
            No novo = new No(primeiro, info);
            primeiro.setAnt(novo);
            primeiro = novo;
        }
        qdnos++;
    }

    /**
     * Insere um novo elemento após o último da lista
     * @param info
     */
    public void inserir(int info){
        if(qdnos == 0){
            inserirNoComeco(info);
        } else {
            No novo = new No(info);
            ultimo.setProx(novo);
            novo.setAnt(ultimo);
            ultimo = novo;
            qdnos++;
        }
    }

    /**
     * Insere um novo elemento em uma posição determinada pelo usuário
     * @param info
     * @param pos
     */
    public void inserir(int info, int pos){
        if(pos == 0){
            inserirNoComeco(info);
        } else if(pos == qdnos){
            inserir(info);
        } else {
            int i = 1;
            No anterior = primeiro;

            while(i != (pos-1)){
                anterior = anterior.getProx();
                i++;
            }

            No proximo = anterior.getProx();
            No novo = new No(info);
            novo.setProx(proximo);
            novo.setAnt(anterior);
            anterior.setProx(novo);
            proximo.setAnt(novo);
            qdnos++;
        }
    }

    /**
     * Insere o elemento/nó da lista numa posição determinada pelo usuário
     * @param pos
     */
    public void excluirNo(int pos){
        if(estaVazia()){
            System.out.println("LISTA VAZIA!");
            //verifica se a posicao � valida
        } else if(pos <= qdnos){
            //remove do comeco
            if(pos == 1){
                primeiro = primeiro.getProx();
                qdnos--;
                if(qdnos == 0){
                    ultimo = null;
                }
                //remove do fim
            } else if(pos == qdnos) {
                No penultimo = ultimo.getAnt();
                penultimo.setProx(null);
                ultimo = penultimo;
                qdnos--;
            } else {
                int i = 1;
                No aux = primeiro;
                while(i != pos){
                    aux = aux.getProx();
                    i++;
                }
                No anterior = aux.getAnt();
                No proximo = aux.getProx();

                anterior.setProx(proximo);
                proximo.setAnt(anterior);
                qdnos--;
            }
        } else {
            System.out.println("POSICAO INVALIDA!");
        }
    }

    /**
     * Busca um determinado valor na posição da lista dada pelo usuário
     * @param pos
     * @return
     */
    public int buscar(int pos){
        No aux = primeiro;
        if(!estaVazia()){
            if((pos > 0) && (pos <= qdnos)){
                int i = 1;
                while(i != pos){
                    aux = aux.getProx();
                    i++;
                }
            }
        }
        return aux.getInfo();
    }

    /**
     * Pesquisa o valor de um nó na lista e retorna se existe esse valor ou não
     * @param info
     * @return true or false
     */
    public boolean pesquisar(int info){
        No aux = primeiro;
        while((aux != null) && (aux.getInfo() != info)){
            aux = aux.getProx();
        }

        if(aux == null){
            return false;
        } else {
            return true;
        }

    }

    /**
     * Altera o valor de um elemento em uma posição dada pelo usuário
     * @param pos
     * @param info
     */
    public void alterar(int pos, int info){
        int i = 1;
        No aux = primeiro;
        while(i != pos){
            aux = aux.getProx();
            i++;
        }

        aux.setInfo(info);
    }

    /**
     * Intercala duas listas (lista 1 e lista 2) e forma a lista 3
     * @param lista1
     * @param lista2
     * @param lista3
     */
    public void intercalar(Lista lista1, Lista lista2, Lista lista3){
		int i, maiorLista;

		if(lista1.totalNos() < lista2.totalNos()){
			maiorLista = lista2.totalNos();
		} else {
			maiorLista = lista1.totalNos();
		}

		i = 1;

		while(i <= maiorLista){

		}
	}

    /**
     * Imprime todos os valores da lista nas dadas posições
     * @return builder.toString()
     */
    public String toString(){
        if(qdnos == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No aux = primeiro;

        while(aux != null){
            builder.append(aux.getInfo());
            builder.append(",");
            aux = aux.getProx();
        }

        builder.append("]");
        return builder.toString();
    }

    /**
     * Organiza a lista do menor para o maior valor referente ao seu nó/elemento
     */
    public void listarCrescente(){
        if(estaVazia()){
            System.out.println("LISTA VAZIA!");
        } else {
            int i = 1;
            No aux = primeiro;
            while(aux != null){
                System.out.println("Posicao " + i + ":" + aux.getInfo());
                aux = aux.getProx();
                i++;
            }
        }
    }

    /**
     * Organiza a lista em ordem decrescente de acordo com os valores de seus elementos/nós
     */
    public void listarDecrescente(){
        if(estaVazia()){
            System.out.println("LISTA VAZIA!");
        } else {
            int i = qdnos;
            No aux = ultimo;
            while(i != 0){
                System.out.println("Posicao " + i + ":" + aux.getInfo());
                aux = aux.getAnt();
                i--;
            }
        }
    }
}