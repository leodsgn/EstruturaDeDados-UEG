package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaCircular;

class No{
    protected No prox; // ponteiro para próximo nó
    protected int info; // valor do nó da lista

    /**
     * Construtor do próximo nó
     *
     * @param prox
     * @param info
     */
    public No(No prox, int info){
        this.prox = prox;
        this.info = info;
    }

    /**
     * Construtor do nó atual
     *
     * @param info
     */
    public No(int info){
        this.info = info; // valor do nó da lista
        prox = null; // ponteiro para proximo nó
    }

    /**
     * Insere o endereço do próximo nó
     *
     * @param prox
     */
    public void setProx(No prox){ this.prox = prox; }
    public No getProx(){ return prox; }

    /**
     * Insere valor do próximo nó
     *
     * @param info
     */
    public void setInfo(int info){ this.info = info; }
    public int getInfo(){ return info; }
}