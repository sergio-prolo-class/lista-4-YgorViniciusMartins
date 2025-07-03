package domain.formas;

import domain.FormaGeometrica;
import domain.ObjetoDesenho;
import domain.Ponto;
import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Pentagono extends ObjetoDesenho implements FormaGeometrica {
    private double raio;
    private static final int NUM_LADOS = 5;

    public Pentagono(String forma, String cor_linha, String cor_preenchimento, Ponto ponto, int tamanho){
        super(forma ,cor_linha, cor_preenchimento, ponto, tamanho);
        this.raio = tamanho/2.0;
    }

    @Override
    public double getArea(){
        return ((5.0/2.0) * Math.pow ((this.getRaio()),2) *Math.sin(72));
    }

    @Override
    public double getPerimetro(){
        return NUM_LADOS * this.getTamanho();
    }

    public double getRaio(){
        return this.raio;
    }

    @Override
    public void desenhar(Draw draw, Ponto ponto) {
        double[] x = new double[NUM_LADOS];
        double[] y = new double[NUM_LADOS];
        for (int i = 0; i < NUM_LADOS; i++) {
            x[i] = ponto.getX() + (this.getRaio() * Math.cos((2 * Math.PI * i)/NUM_LADOS));
            y[i] = ponto.getY() + (this.getRaio() * Math.sin((2 * Math.PI * i)/NUM_LADOS));
        }
        if(!this.getPreenchido()) { //Se não for preenchido
            draw.polygon(x, y);
        } else {
            draw.filledPolygon(x,y);
            desenhaBorda(draw, x, y);
        }
    }

    @Override
    public void desenhaBorda(Draw draw, double[] x, double[] y){
        Color cor = draw.getPenColor();
        draw.setPenColor(Draw.BLACK);
        draw.polygon(x,y);
        draw.setPenColor(cor);
    }
}
