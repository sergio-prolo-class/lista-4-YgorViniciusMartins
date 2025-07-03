package domain.formas;

import domain.FormaGeometrica;
import domain.ObjetoDesenho;
import domain.Ponto;
import edu.princeton.cs.algs4.Draw;

import java.awt.*;

import static domain.Constantes.COLOR_LINHA_DEFAULT;

public class Quadrado extends ObjetoDesenho implements FormaGeometrica {

    public Quadrado(String forma, String cor_linha, String cor_preenchimento, Ponto ponto, int tamanho){
        super(forma, cor_linha, cor_preenchimento, ponto, tamanho);
    }

    public Quadrado(String forma, Color cor_linha, Color cor_preenchimento, Ponto ponto, int tamanho){
        super(forma, cor_linha, cor_preenchimento, ponto, tamanho);
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
            draw.setPenColor(getCor_linha());
            draw.square(ponto.getX(), ponto.getY(), getTamanho()/2.0);
        } else {
            draw.setPenColor(getCor_preenchimento());
            draw.filledSquare(ponto.getX(), ponto.getY(), getTamanho()/2.0);
            desenhaBorda(draw, ponto);
        }
    }

    @Override
    public void desenhaBorda(Draw draw, Ponto ponto){
        draw.setPenColor(COLOR_LINHA_DEFAULT);
        draw.square(ponto.getX(), ponto.getY(), getTamanho()/2.0);
    }
}
