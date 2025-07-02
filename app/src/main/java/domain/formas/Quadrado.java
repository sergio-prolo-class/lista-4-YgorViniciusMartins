package domain.formas;

import domain.FormaGeometrica;
import domain.ObjetoDesenho;
import domain.Ponto;
import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Quadrado extends ObjetoDesenho implements FormaGeometrica {

    public Quadrado(String cor_linha, String cor_preenchimento, Ponto ponto, int tamanho){
        super(cor_linha, cor_preenchimento, ponto, tamanho);
        this.tamanho /= 2.0;
    }

    @Override
    public double getPerimetro(){
        return 4 * this.getTamanho();
    }

    @Override
    public double getArea(){
        return Math.pow(this.getTamanho(), 2);
    }

    @Override
    public void desenhar(Draw draw, Ponto ponto){
        if(!this.getPreenchido()){ //Se não for preenchido
            draw.square(ponto.getX(), ponto.getY(), getTamanho());
        } else {
            draw.filledSquare(ponto.getX(), ponto.getY(), getTamanho());
            desenhaBorda(draw, ponto);
        }
    }

    @Override
    public void desenhaBorda(Draw draw, Ponto ponto){
        Color cor = draw.getPenColor();
        draw.setPenColor(Draw.BLACK);
        draw.square(ponto.getX(), ponto.getY(), getTamanho());
        draw.setPenColor(cor);
    }
}
