package domain;

import edu.princeton.cs.algs4.Draw;

public abstract class ObjetoDesenho {
    protected String cor_linha; //Cor da linha de contorno
    protected String cor_preenchimento; // Cor de preenchimento do objeto
    protected String tipo_forma;
    protected Ponto ponto_central; //Ponto central, obtido pelo click do mouse
    protected int tamanho; //Tamanho da figura
    protected boolean preenchido;

    public ObjetoDesenho(String tipo_forma,String cor_linha, String cor_preenchimento, Ponto ponto, int tamanho){
        this.tipo_forma = tipo_forma;
        this.cor_linha = cor_linha;
        this.cor_preenchimento = cor_preenchimento;
        this.ponto_central = ponto;
        this.tamanho = tamanho;
        this.preenchido = !cor_preenchimento.isEmpty();
    }

    public Ponto getPonto_central(){
        return this.ponto_central;
    }

    public String getCor_linha(){
        return this.cor_linha;
    }

    public String getCor_preenchimento(){
        return this.cor_preenchimento;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public boolean getPreenchido(){
        return this.preenchido;
    }

    public Ponto getPontoCentral(){
        return this.ponto_central;
    }

    public String getTipo_forma(){
        return this.tipo_forma;
    }

    public void desenhar(Draw draw, Ponto ponto){}

    public void desenhaBorda(Draw draw, Ponto ponto){}

    public void desenhaBorda(Draw draw, double[] x, double[] y){}
}
