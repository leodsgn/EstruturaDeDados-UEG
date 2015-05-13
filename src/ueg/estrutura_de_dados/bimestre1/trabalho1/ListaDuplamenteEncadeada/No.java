package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaDuplamenteEncadeada;

class No{
    protected No prox; // variável ponteiro para próximo elemento
    protected No ant; // variável ponteiro para o elemento anterior
    protected int info; // variável com o valor do elemento da lista

    /**
     * Construtor de nó da lista
     * @param prox
     * @param info
     */
    public No(No prox, int info){
        this.prox = prox;
        this.info = info;
    }

    /**
     * Atribui valor ao nó atual
     * @param info
     */
    public No(int info){
        this.info = info;
        ant = prox = null;
    }

    /**
     * Aponta para o nó anterior
     * @param ant
     */
    public void setAnt(No ant){ this.ant = ant; }

    /**
     * Retorna o endereço do nó anterior
     * @return ant
     */
    public No getAnt(){ return ant; }

    /**
     * Aponta para o proximo nó
     * @param prox
     */
    public void setProx(No prox){ this.prox = prox;	}

    /**
     * Retorna o endereço do proximo nó
     * @return
     */
    public No getProx(){ return prox; }

    /**
     * Insere valor do no/elemento atual
     * @param info
     */
    public void setInfo(int info){ this.info = info; }

    /**
     * Retorna o valor do no/elemento atual
     * @return info
     */
    public int getInfo(){ return info; }
}