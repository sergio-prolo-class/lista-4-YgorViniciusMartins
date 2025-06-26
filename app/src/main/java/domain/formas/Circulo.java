package domain.formas;

import domain.ObjetoDesenho;
import domain.Ponto;

public class Circulo extends ObjetoDesenho {
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
}
