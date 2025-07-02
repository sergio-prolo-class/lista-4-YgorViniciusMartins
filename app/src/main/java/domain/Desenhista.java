package domain;
import domain.formas.*;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import static domain.Constantes.*;

//Esta classe tem como objetivo administrar e desenhar os elementos na tela
public class Desenhista implements DrawListener {
    private final Draw draw; //Objeto draw para gerenciar assuntos como a tela em si e seus afins

    public Desenhista(Draw draw){
        this.draw = draw;
        this.draw.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.draw.setCanvasSize(ESCALA_X, ESCALA_Y); //Define o tamanho da janela
        this.draw.setXscale(0, ESCALA_X); //Escala em X
        this.draw.setYscale(0, ESCALA_Y); //Escala em Y
        this.draw.enableDoubleBuffering(); //Vi no exemplo do Mello que deixa o desenho de forma mais suave
    }

    public String getFormaDefalut(){ return FORMAS_DISP[0]; }

    public Draw getDraw(){ return draw; }

    public void updateTela(){ draw.show();}

    public void limpaTela(){ draw.clear(); }

    public void desenha(String forma_atual,String cor_linha_atual, String cor_preenchimento_atual, Ponto ponto, int tamanho_atual){
        if(forma_atual.equals(FORMAS_DISP[0])){ //Circulo
            Circulo circulo = new Circulo(cor_linha_atual, cor_preenchimento_atual, ponto, tamanho_atual);
            circulo.desenhar(this.draw, ponto);
        } else if (forma_atual.equals(FORMAS_DISP[1])) {

        } else if (forma_atual.equals(FORMAS_DISP[2])) {

        } else {
            Quadrado quadrado = new Quadrado(cor_linha_atual, cor_preenchimento_atual, ponto, tamanho_atual);
            quadrado.desenhar(this.draw,ponto);
        }
    }
}
