package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaDuplamenteEncadeada;

class No{
    protected No prox;
    protected No ant;
    protected int info;

    //Construtor para inserir no inicio da lista
    public No(No prox, int info){
        this.prox = prox;
        this.info = info;
    }

    public No(int info){
        this.info = info;
        ant = prox = null;
    }

    public void setAnt(No ant){ this.ant = ant; }
    public No getAnt(){ return ant; }

    public void setProx(No prox){ this.prox = prox;	}
    public No getProx(){ return prox; }

    public void setInfo(int info){ this.info = info; }
    public int getInfo(){ return info; }
}