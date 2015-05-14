package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaCircular;

class Lista{
    protected No primeiro;
    protected No ultimo;
    protected int qdnos;

    public Lista(){
        primeiro = ultimo = null;
        qdnos = 0;
    }

    public boolean estaVazia(){ return qdnos == 0; }

    public int totalNos(){ return qdnos; }

    public void excluirLista(){
        if(!estaVazia()){
            primeiro = ultimo = null;
            qdnos = 0;
        }
    }

    public void inserirNoComeco(int info){
        if(estaVazia()){
            No novo = new No(info);
            primeiro = ultimo = novo;
            novo.setProx(novo);
        } else {
            No novo = new No(info);
            ultimo.setProx(novo);
            novo.setProx(primeiro);
            primeiro = novo;
        }
        qdnos++;
    }

    //insere no fim
    public void inserir(int info){
        if(estaVazia()){
            inserirNoComeco(info);
        } else {
            No novo = new No(info);
            novo.setProx(ultimo.getProx());
            ultimo.setProx(novo);
            ultimo = novo;
            qdnos++;
        }
    }

    //insere na posição indicada
    public void inserir(int info, int pos){
        if(estaVazia()){
            inserirNoComeco(info);
        } else if(pos == qdnos) {
            inserir(info);
        } else {
            int i = 1;
            No aux = primeiro;

            while(i != (pos-1)){
                aux = aux.getProx();
                i++;
            }

            No novo = new No(info);
            novo.setProx(aux.getProx());
            aux.setProx(novo);
            qdnos++;
        }
    }

    public void excluirNo(int pos){
        if(estaVazia()){
            System.out.println("LISTA VAZIA!");
        } else if(pos <= qdnos) {
            if(pos == 1){ //remove do começo
                if(qdnos == 1){
                    primeiro = ultimo = null;
                } else {
                    primeiro = primeiro.getProx();
                    ultimo.setProx(primeiro);
                }
                qdnos--;
            } else if(pos == qdnos) { // remove do fim
                int i = 1;
                No aux = primeiro;
                while(i != (pos-1)){
                    aux = aux.getProx();
                    i++;
                }
                aux.setProx(ultimo.getProx());
                ultimo = aux;
                qdnos--;
            } else {
                int i = 1;
                No aux = primeiro;
                No aux1 = aux.getProx();
                while(i != (pos-1)){
                    aux = aux.getProx();
                    aux1 = aux1.getProx();
                    i++;
                }
                aux.setProx(aux1.getProx());
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
            } else {
                System.out.println("POSICAO INVALIDA!");
            }
        }
        return aux.getInfo();
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

    public boolean pesquisar(int info){
        No aux = primeiro;
        int i = 0;
        while((aux.getInfo() != info) && (aux.getProx() != primeiro)){
            aux = aux.getProx();
            i++;
        }

        if(aux.getInfo() == info){
            return true;
        } else {
            return false;
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
    public String toString(){
        if(qdnos == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No aux = primeiro;
        int i = 0;
        while(i != qdnos){
            builder.append(aux.getInfo());
            builder.append(",");
            aux = aux.getProx();
            i++;
        }

        builder.append("]");
        return builder.toString();
    }

    public void listar(){
        if(estaVazia()){
            System.out.println("LISTA VAZIA!");
        } else {
            int i = 1;
            No aux = primeiro;
            while(i != (qdnos + 1)){
                System.out.println("Posicao " + i + ":" + aux.getInfo());
                aux = aux.getProx();
                i++;
            }
        }
    }
}