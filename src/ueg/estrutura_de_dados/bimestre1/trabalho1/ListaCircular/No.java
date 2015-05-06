package ueg.estrutura_de_dados.bimestre1.trabalho1.ListaCircular;

class No{
    protected No prox;
    protected int info;

    public No(No prox, int info){
        this.prox = prox;
        this.info = info;
    }

    public No(int info){
        this.info = info;
        prox = null;
    }

    public void setProx(No prox){ this.prox = prox; }
    public No getProx(){ return prox; }

    public void setInfo(int info){ this.info = info; }
    public int getInfo(){ return info; }
}