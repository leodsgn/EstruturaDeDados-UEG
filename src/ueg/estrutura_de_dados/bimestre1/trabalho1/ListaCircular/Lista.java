package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaCircular;


class Lista {
    protected No primeiro; /** primeiro nó da lista */
    protected No ultimo; /** último nó da lista */
    protected int qdnos; /** Quantidade de nós */

    /**
     * Construtor da classe lista sendo inicializado com valores nulos e nenhum n�
     */
    public Lista() {
        primeiro = ultimo = null;
        qdnos = 0;
    }

    /**
     * Verifica se a quantidade de nós na lista é igual a 0.
     *
     * @return true ou false
     */
    public boolean estaVazia() {
        return qdnos == 0;
    }

    /**
     * Verifica quantos nós tem na lista atual
     *
     * @return quantidade de nós.
     */
    public int totalNos() {
        return qdnos;
    }

    /**
     * Atribui valores nulos a lista e a quantidade de n�s a 0 (exclui a lista de certa forma).
     */
    public void excluirLista() {
        if (!estaVazia()) {
            primeiro = ultimo = null;
            qdnos = 0;
        }
    }

    /**
     * Insere valor no começo da lista atual com o parametro 'info'
     *
     * @param info
     */
    public void inserirNoComeco(int info) {
        if (estaVazia()) {
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

    /**
     *Insere novo nó na lista na última posição (sequencialmente).
     *
     * @param info
     */
    public void inserir(int info) {
        if (estaVazia()) {
            inserirNoComeco(info);
        } else {
            No novo = new No(info);
            novo.setProx(ultimo.getProx());
            ultimo.setProx(novo);
            ultimo = novo;
            qdnos++;
        }
    }

    /**
     * Insere novo nó na posição indicada
     *
     * @param info
     * @param pos
     */
    public void inserir(int info, int pos) {
        if (estaVazia()) {
            inserirNoComeco(info);
        } else if (pos == qdnos) {
            inserir(info);
        } else {
            int i = 1;
            No aux = primeiro;

            while (i != (pos - 1)) {
                aux = aux.getProx();
                i++;
            }

            No novo = new No(info);
            novo.setProx(aux.getProx());
            aux.setProx(novo);
            qdnos++;
        }
    }

    /**
     * Exclui nó na posição selecionada.
     *
     * @param pos
     */
    public void excluirNo(int pos) {
        if (estaVazia()) {
            System.out.println("LISTA VAZIA!");
        } else if (pos <= qdnos) {
            if (pos == 1) { //remove do começo
                if (qdnos == 1) {
                    primeiro = ultimo = null;
                } else {
                    primeiro = primeiro.getProx();
                    ultimo.setProx(primeiro);
                }
                qdnos--;
            } else if (pos == qdnos) { // remove do fim
                int i = 1;
                No aux = primeiro;
                while (i != (pos - 1)) {
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
                while (i != (pos - 1)) {
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


    /**
     * Busca dados da posição selecionada pelo parâmetro 'pos'
     * @param pos
     * @return info da posição
     */
    public int buscar(int pos) {
        No aux = primeiro;
        if (!estaVazia()) {
            if ((pos > 0) && (pos <= qdnos)) {
                int i = 1;
                while (i != pos) {
                    aux = aux.getProx();
                    i++;
                }
            } else {
                System.out.println("POSICAO INVALIDA!");
            }
        }
        return aux.getInfo();
    }

    /**
     * Pesquisa dada info na lista e verifica se existe.
     * @param info
     * @return true ou false, baseado na existencia da info.
     */
    public boolean pesquisar(int info) {
        No aux = primeiro;
        while ((aux.getInfo() != info) && (aux.getProx() != primeiro)) {
            aux = aux.getProx();
        }

        if (aux.getInfo() == info) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Altera info da posição da lista.
     * @param pos
     * @param info
     */
    public void alterar(int pos, int info) {
        int i = 1;
        No aux = primeiro;
        while (i != pos) {
            aux = aux.getProx();
            i++;
        }
        aux.setInfo(info);
    }

    /**
     * Se a lista for vazia escreve '[]'.
     * Se conter valores na listas, imprime esses valores. ex.: [x][y]..[n]
     *
     * @return Valores da lista.
     */
    public String toString() {
        if (qdnos == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        No aux = primeiro;

        while (aux.getProx() != primeiro) {
            builder.append(aux.getInfo());
            builder.append(",");
            aux = aux.getProx();
        }

        builder.append("]");
        return builder.toString();
    }

    /**
     * Imprime a lista.
     */
    public void listar() {
        if (estaVazia()) {
            System.out.println("LISTA VAZIA!");
        } else {
            int i = 1;
            No aux = primeiro;
            while (aux.getProx() != primeiro) {
                System.out.println("Posicao " + i + ":" + aux.getInfo());
                aux = aux.getProx();
                i++;
            }
        }
    }
}
