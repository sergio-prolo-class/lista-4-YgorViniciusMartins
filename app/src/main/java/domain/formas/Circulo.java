package domain.formas;

import domain.Desenhista;
import domain.FormaGeometrica;
import domain.ObjetoDesenho;
import domain.Ponto;
import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Circulo extends ObjetoDesenho implements FormaGeometrica {
    private double raio; //raio será o tamanho / 2 (tamanho = diâmetro)

    public Circulo(String forma, String cor_linha, String cor_preenchimento, Ponto ponto, int tamanho){
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
            draw.circle(ponto.getX(), ponto.getY(), this.getRaio());
        } else {
            draw.filledCircle(ponto.getX(), ponto.getY(), this.getRaio());
            desenhaBorda(draw,ponto);
        }
    }

    @Override
    public void desenhaBorda(Draw draw, Ponto ponto){
        Color cor = draw.getPenColor();
        draw.setPenColor(Draw.BLACK);
        draw.circle(ponto.getX(), ponto.getY(), this.getRaio());
        draw.setPenColor(cor);
    }
}
