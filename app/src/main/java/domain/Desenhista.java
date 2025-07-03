package domain;
import domain.formas.*;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.util.List;

import static domain.Constantes.*;

//Esta classe tem como objetivo administrar e desenhar os elementos na tela
public class Desenhista implements DrawListener {
    private final Draw draw; //Objeto draw para gerenciar assuntos como a tela em si e seus afins

    public Desenhista(Draw draw){
        this.draw = draw;
        this.draw.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.draw.setCanvasSize(ESCALA_X, ESCALA_Y); //Define o tamanho da janela
        this.draw.setXscale(0, ESCALA_X); //Escala em X
        this.draw.setYscale(0, ESCALA_Y); //Escala em Y
        this.draw.enableDoubleBuffering(); //Vi no exemplo do Mello que deixa o desenho de forma mais suave
    }

    public String getFormaDefalut(){ return FORMAS_DISP[0]; }

    public Draw getDraw(){ return draw; }

    public void updateTela(){ draw.show();}

    public void limpaTela(){ draw.clear(); }

    public void desenha(String forma_atual,String cor_linha_atual, String cor_preenchimento_atual, Ponto ponto, int tamanho_atual, Relatorio relatorio){
        if(forma_atual.equals(FORMAS_DISP[0])){ //Circulo
            Circulo circulo = new Circulo(forma_atual, cor_linha_atual, cor_preenchimento_atual, ponto, tamanho_atual);
            circulo.desenhar(this.draw, ponto);
            relatorio.nova_forma(circulo);
            relatorio.novo_objeto(circulo);
        } else if (forma_atual.equals(FORMAS_DISP[1])) { //Pentagono
            Pentagono pentagono = new Pentagono(forma_atual, cor_linha_atual, cor_preenchimento_atual, ponto, tamanho_atual);
            pentagono.desenhar(this.draw, ponto);
            relatorio.nova_forma(pentagono);
            relatorio.novo_objeto(pentagono);
        } else if (forma_atual.equals(FORMAS_DISP[2])) { //Hexagono
            Hexagono hexagono = new Hexagono(forma_atual, cor_linha_atual, cor_preenchimento_atual, ponto, tamanho_atual);
            hexagono.desenhar(this.draw, ponto);
            relatorio.nova_forma(hexagono);
            relatorio.novo_objeto(hexagono);
        } else { //Quadrado
            Quadrado quadrado = new Quadrado(forma_atual, cor_linha_atual, cor_preenchimento_atual, ponto, tamanho_atual);
            quadrado.desenhar(this.draw,ponto);
            relatorio.nova_forma(quadrado);
            relatorio.novo_objeto(quadrado);
        }
    }

    public void desenha(ObjetoDesenho objeto_desenho, Ponto ponto){
        if(objeto_desenho.getTipo_forma().equals(FORMAS_DISP[0])){
            Circulo circulo = new Circulo(objeto_desenho.getTipo_forma(), objeto_desenho.getCor_linha(), objeto_desenho.getCor_preenchimento(), ponto, objeto_desenho.getTamanho());
            circulo.desenhar(this.draw, ponto);
        }else if (objeto_desenho.getTipo_forma().equals(FORMAS_DISP[1])) { //Pentagono
            Pentagono pentagono = new Pentagono(objeto_desenho.getTipo_forma(), objeto_desenho.getCor_linha(), objeto_desenho.getCor_preenchimento(), ponto, objeto_desenho.getTamanho());
            pentagono.desenhar(this.draw, ponto);
        } else if (objeto_desenho.getTipo_forma().equals(FORMAS_DISP[2])) { //Hexagono
            Hexagono hexagono = new Hexagono(objeto_desenho.getTipo_forma(), objeto_desenho.getCor_linha(), objeto_desenho.getCor_preenchimento(), ponto, objeto_desenho.getTamanho());
            hexagono.desenhar(this.draw, ponto);
        } else { //Quadrado
            Quadrado quadrado = new Quadrado(objeto_desenho.getTipo_forma(), objeto_desenho.getCor_linha(), objeto_desenho.getCor_preenchimento(), ponto, objeto_desenho.getTamanho());
            quadrado.desenhar(this.draw,ponto);
        }
    }

    public void deslocarDesenhos(Relatorio relatorio, int x, int y){
        List<ObjetoDesenho> lista_objetos = relatorio.getLista_objetos();
        if(x != 0) {
            for (ObjetoDesenho listaObjeto : lista_objetos) {
                Ponto ponto = listaObjeto.getPontoCentral();
                double x_ant = ponto.getX();
                ponto.setX(x_ant + x);
            }
        } else {
            for (ObjetoDesenho listaObjeto : lista_objetos) {
                Ponto ponto = listaObjeto.getPontoCentral();
                double y_ant = ponto.getY();
                ponto.setY(y_ant + y);
            }
        }
        this.limpaTela();
        for (ObjetoDesenho listaObjeto : lista_objetos) {
            desenha(listaObjeto, listaObjeto.getPontoCentral());
        }
        this.updateTela();
    }
}
