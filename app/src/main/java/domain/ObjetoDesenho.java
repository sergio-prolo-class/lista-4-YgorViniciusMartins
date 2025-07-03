package domain;

import edu.princeton.cs.algs4.Draw;

import java.awt.*;

import static domain.Constantes.*;

public abstract class ObjetoDesenho {
    protected Color cor_linha; //Cor da linha de contorno
    protected Color cor_preenchimento; // Cor de preenchimento do objeto
    protected String tipo_forma;
    protected Ponto ponto_central; //Ponto central, obtido pelo click do mouse
    protected int tamanho; //Tamanho da figura
    protected boolean preenchido;

    public ObjetoDesenho(String tipo_forma,String cor_linha, String cor_preenchimento, Ponto ponto, int tamanho){
        this.tipo_forma = tipo_forma;
        this.cor_linha = seletorCor(cor_linha);
        this.cor_preenchimento = seletorCor(cor_preenchimento);
        this.ponto_central = ponto;
        this.tamanho = tamanho;
        this.preenchido = !cor_preenchimento.isEmpty();
    }

    public ObjetoDesenho(String tipo_forma,Color cor_linha, Color cor_preenchimento, Ponto ponto, int tamanho){
        this.tipo_forma = tipo_forma;
        this.cor_linha = cor_linha;
        this.cor_preenchimento = cor_preenchimento;
        this.ponto_central = ponto;
        this.tamanho = tamanho;
        this.preenchido = !cor_preenchimento.equals(COLOR_PREENCHIMENTO_DEFAULT);
    }

    public Ponto getPonto_central(){
        return this.ponto_central;
    }

    public Color getCor_linha(){
        return this.cor_linha;
    }

    public Color getCor_preenchimento(){
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

    public Color seletorCor(String pincel){
        Color cor;
        if(pincel.equals(CORES_DISP[0])){ //Preto
            cor = COLORS_DISP[0];
        } else if (pincel.equals(CORES_DISP[1])) { //Verde
            cor = COLORS_DISP[1];
        } else if (pincel.equals(CORES_DISP[2])) { //Azul
            cor = COLORS_DISP[2];
        } else if (pincel.equals(CORES_DISP[3])){ //Vermelho
            cor = COLORS_DISP[3];
        } else {
            cor = COLOR_PREENCHIMENTO_DEFAULT;
        }
        return cor;
    }
}
