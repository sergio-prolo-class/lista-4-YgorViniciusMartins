package domain.formas;

import domain.FormaGeometrica;
import domain.ObjetoDesenho;
import domain.Ponto;

public class Circulo extends ObjetoDesenho implements FormaGeometrica {
    private double raio; //raio será o tamanho / 2 (tamanho = diâmetro)

    public Circulo(String cor_linha, String cor_preenchimento, Ponto ponto, int tamanho){
        super(cor_linha, cor_preenchimento, ponto, tamanho);
        if(getEhValido()){ //Se for válido
            this.raio = tamanho / 2.0;
        }
    }

    public double getRaio() {
        return this.raio;
    }

    public double getArea(){
        return Math.PI * Math.pow(this.raio, 2);
    }

    public double getPerimetro(){
        return 2 * Math.PI * this.raio;
    }

    @Override
    public void desenha(){

    }
}
