package domain;

public class Ponto {
    private double x; //Posição x com relação a tela do ponto
    private double y; //Posição y com relação a tela do ponto
    private boolean ehValido;

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
        Desenhista desenhista = new Desenhista();
        if(x < 0 || x > desenhista.getEscala_x()) return false; //Se ponto estiver fora da tela ou parâmetro negativo
        this.x = x;
        return true;
    }

    private boolean setY(double y){
        Desenhista desenhista = new Desenhista();
        if(y < 0 || y > desenhista.getEscala_y()) return false; //Se ponto estiver fora da tela ou parâmetro negativo
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
