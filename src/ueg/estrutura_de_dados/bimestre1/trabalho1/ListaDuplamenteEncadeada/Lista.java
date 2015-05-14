package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaDuplamenteEncadeada;

class Lista {
    protected No primeiro;
    protected No ultimo;
    protected int qdnos;

    public Lista(){
        primeiro  = ultimo = null;
        qdnos = 0;
    }

    public void excluirLista(){
        if(!estaVazia()){
            primeiro = ultimo = null;
            qdnos = 0;
        }
    }

    public boolean estaVazia(){ return qdnos == 0;	}

    public int totalNos(){ return qdnos; }

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

    //inserir no fim
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

    //inserir em uma posicao determinada
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

    public void excluirNo(int pos){
        if(estaVazia()){
            System.out.println("LISTA VAZIA!");
            //verifica se a posicao é valida
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

    public boolean buscarNo(int pos){
        No aux = primeiro;
        int i = 1;
        if(!estaVazia()){
            if((pos > 0) && (pos <= qdnos)){
                while(i != pos){
                    aux = aux.getProx();
                    i++;
                }
            } else {
                aux = null;
            }
        }
        if(aux == null){
            return false;
        } else {
            return true;
        }
    }

    public int buscarPos(int info){
        No aux = primeiro;
        int i = 1;
        if(!estaVazia()){
            while(aux.getInfo() != info){
                aux = aux.getProx();
                i++;
            }
        }
        return i;
    }

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

    public void alterar(int pos, int info){
        int i = 1;
        No aux = primeiro;
        while(i != pos){
            aux = aux.getProx();
            i++;
        }

        aux.setInfo(info);
    }

    public Lista intercalar(Lista lista1, Lista lista2){
        int i, maiorLista;
        Lista lista3 = new Lista();

        if(lista1.totalNos() < lista2.totalNos()){
            maiorLista = lista2.totalNos();
        } else {
            maiorLista = lista1.totalNos();
        }

        i = 1;

        while(i <= maiorLista){
            if(lista1.buscarNo(i)){
                lista3.inserir(lista1.buscar(i));
            }

            if(lista2.buscarNo(i)){
                lista3.inserir(lista2.buscar(i));
            }

            i++;
        }
        return lista3;
    }

    //Imprime a lista toda
    public String toStringC(){
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

    //Imprime a lista toda
    public String toStringD(){
        if(qdnos == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No aux = ultimo;

        while(aux != null){
            builder.append(aux.getInfo());
            builder.append(",");
            aux = aux.getAnt();
        }

        builder.append("]");
        return builder.toString();
    }

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