package domain;

import domain.formas.*;
import edu.princeton.cs.algs4.Draw;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Desenhista {
    private final int escala_x = 625; //Constante para a escala X da tela
    private final int escala_y = 675; //Constante para a escala y da tela
    private final String[] cores_disp = {"vermeho", "verde", "azul", "roxo"}; //Cores definidas
    private final Set<String> cores = new LinkedHashSet<>(); //Set guardando as cores setadas
    private final Draw draw = new Draw(); //Objeto draw para gerenciar assuntos como a tela em si e seus afins


    public Desenhista(){
        this.draw.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.draw.setCanvasSize(this.escala_x, this.escala_y); //Define o tamanho da janela
        this.draw.setXscale(0, this.escala_x); //Escala em X
        this.draw.setYscale(0, this.escala_y); //Escala em Y
        this.draw.enableDoubleBuffering(); //Vi no exemplo do Mello que deixa o desenho de forma mais suave
        cores.addAll(Arrays.asList(cores_disp)); //Adiciona todas as cores no nosso Set
    }

    public void exibeTela(){
        this.draw.show();
    }

    public void desenhaCirculo(Circulo circulo){

    }

    public void desenhaHexagono(Hexagono hexagono){

    }

    public void desenhaLosango(Losango losango){

    }

    public void desenhaPentagono(Pentagono pentagono){

    }

    public void desenhaQuadrado(Quadrado quadrado){

    }

    public void desenhaTrapezio(Trapezio trapezio){

    }
}
