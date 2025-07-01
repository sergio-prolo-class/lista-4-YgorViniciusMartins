package domain;

public class ObjetoDesenho {
    protected String cor_linha; //Cor da linha de contorno
    protected String cor_preenchimento; // Cor de preenchimento do objeto
    protected Ponto ponto_central; //Ponto central, obtido pelo click do mouse
    protected int tamanho; //Tamanho da figura
    private final boolean ehValido;

    public ObjetoDesenho(String cor_linha, String cor_preenchimento, Ponto ponto, int tamanho){
        Desenhista desenhista = new Desenhista();
        this.ehValido = ponto.getEhValido() && desenhista.corDisponivel(cor_linha) && desenhista.corDisponivel(cor_preenchimento);
        if(this.ehValido){
            this.ponto_central = ponto;
            this.cor_linha = cor_linha;
            this.cor_preenchimento = cor_preenchimento;
        }
    }

    public boolean getEhValido(){
        return this.ehValido;
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

}
