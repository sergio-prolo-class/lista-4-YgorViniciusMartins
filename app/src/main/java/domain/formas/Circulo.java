package domain.formas;

import domain.Desenhista;
import domain.FormaGeometrica;
import domain.ObjetoDesenho;
import domain.Ponto;
import edu.princeton.cs.algs4.Draw;

import java.awt.*;

import static domain.Constantes.*;

public class Circulo extends ObjetoDesenho implements FormaGeometrica {
    private double raio; //raio será o tamanho / 2 (tamanho = diâmetro)

    public Circulo(String forma, String cor_linha, String cor_preenchimento, Ponto ponto, int tamanho){
        super(forma ,cor_linha, cor_preenchimento, ponto, tamanho);
        this.raio = this.getTamanho() / 2.0;
    }

    public Circulo(String forma, Color cor_linha, Color cor_preenchimento, Ponto ponto, int tamanho){
        super(forma ,cor_linha, cor_preenchimento, ponto, tamanho);
        this.raio = this.getTamanho() / 2.0;
    }

    public double getRaio() {
        return this.raio;
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(this.raio, 2);
    }

    @Override
    public double getPerimetro(){
        return 2 * Math.PI * this.raio;
    }

    @Override
    public void desenhar(Draw draw, Ponto ponto){
        if(!this.getPreenchido()){ //Se não for preenchido
            draw.setPenColor(getCor_linha());
            draw.circle(ponto.getX(), ponto.getY(), this.getRaio());
        } else {
            draw.setPenColor(getCor_preenchimento());
            draw.filledCircle(ponto.getX(), ponto.getY(), this.getRaio());
            desenhaBorda(draw,ponto);
        }
    }

    @Override
    public void desenhaBorda(Draw draw, Ponto ponto){
        draw.setPenColor(COLOR_LINHA_DEFAULT);
        draw.circle(ponto.getX(), ponto.getY(), this.getRaio());
    }
}
