package domain;

import static domain.Constantes.*;

public class Ponto {
    private double x; //Posição x com relação a tela do ponto
    private double y; //Posição y com relação a tela do ponto
    private final boolean ehValido;

    public Ponto(double x, double y){
        if(!setX(x) || !setY(y)){
            this.x = -1;
            this.y = -1;
            this.ehValido = false;
        } else {
            this.ehValido = true;
        }
    }

    private boolean setX(double x){
        if(x < 0 || x > ESCALA_X) return false; //Se ponto estiver fora da tela ou parâmetro negativo
        this.x = x;
        return true;
    }

    private boolean setY(double y){
        if(y < 0 || y > ESCALA_Y) return false; //Se ponto estiver fora da tela ou parâmetro negativo
        this.y = y;
        return true;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public boolean getEhValido(){
        return this.ehValido;
    }
}
