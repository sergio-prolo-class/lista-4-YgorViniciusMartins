package domain;
import domain.formas.*;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

//Esta classe tem como objetivo administrar e desenhar os elementos na tela
public class Desenhista implements DrawListener {
    //Constantes
    private final static int escala_x = 625; //Constante para a escala X da tela
    private final static int escala_y = 675; //Constante para a escala y da tela
    private final static int passo_aumento = 10; //Quantidade aumentada/diminuida a cada vez que o usúario pressiona a tecla correspondente
    private final static String cor_linha_default = "preto";
    private final static String cor_preenchimento_default = "";
    private final static String[] cores_disp = {"vermelho", "verde", "azul", "roxo"}; //Cores definidas
    private final static String[] formas_disp = {"circulo", "hexagono", "losango", "pentagono", "quadrado", "trapezio"}; //Formas definidas
    private final static String[] teclas_disp = {"F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F", "Q", "W", "Up", "Left", "Right", "Down", "C", "P"};

    //Variáveis para a base do objeto
    private final static Set<String> cores = new LinkedHashSet<>(); //Set guardando as cores setadas
    private final static Set<String> formas = new LinkedHashSet<>();
    private final static Set<String> teclas = new LinkedHashSet<>();
    private final Draw draw = new Draw(); //Objeto draw para gerenciar assuntos como a tela em si e seus afins

    //Variáveis com relação a configuração atual dos comandos dados pelo usuário
    //Inicializando com valores padrões da aplicação
    private int tamanho_atual = passo_aumento;
    private String forma_atual = formas_disp[0];
    private String cor_linha_atual = cor_linha_default;
    private String cor_preenchimento_atual = cor_preenchimento_default;
    private boolean preenchido = false; //True => Preenchido, False => Vazado
    private boolean tecla_pressionada = false;

    public Desenhista(){
        this.draw.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.draw.setCanvasSize(escala_x, escala_y); //Define o tamanho da janela
        this.draw.setXscale(0, escala_x); //Escala em X
        this.draw.setYscale(0, escala_y); //Escala em Y
        this.draw.enableDoubleBuffering(); //Vi no exemplo do Mello que deixa o desenho de forma mais suave
        cores.addAll(Arrays.asList(cores_disp)); //Adiciona todas as cores no nosso Set
        formas.addAll(Arrays.asList(formas_disp));
        teclas.addAll(Arrays.asList(teclas_disp));
    }

    public void exibeTela(){
        this.draw.addListener(this);
    }

    public int getEscala_x(){
        return escala_x;
    }

    public int getEscala_y(){
        return escala_y;
    }

    public boolean corDisponivel(String cor){
        return cores.contains(cor);
    }

    public boolean setTamanho(int passo){
        if(this.tamanho_atual + passo <= passo_aumento || this.tamanho_atual + passo >= passo_aumento * 10) return false;
        this.tamanho_atual += passo;
        return true;
    }

    public boolean setCorLinha(String cor){
        if(!cores.contains(cor)) return false;
        this.cor_linha_atual = cor;
        return true;
    }

    public boolean setCorPreenchimento(String cor){
        if(!cores.contains(cor)) return false;
        this.cor_preenchimento_atual = cor;
        return true;
    }

    public boolean setForma(int i){
        if(i > 3) return false;
        this.forma_atual = formas_disp[i];
        return true;
    }

    @Override
    public void mousePressed(double x, double y){
        Ponto ponto = new Ponto(x,y);
        desenha(ponto, forma_atual);
    }

    @Override
    public void keyTyped(char c){
        this.tecla_pressionada = true;
        switch (c){
            case 'f':
                this.preenchido = !this.preenchido;
                if(preenchido){
                    setCorPreenchimento(cor_linha_atual);
                    this.cor_linha_atual = cor_linha_default; //Coloca a cor da linha como preta como solicitado
                } else {
                    setCorLinha(cor_preenchimento_atual);
                    this.cor_preenchimento_atual = cor_preenchimento_default; //Deixa o objeto vazado
                }
                break;
            case 'q':
                this.setTamanho(-passo_aumento);
                break;
            case 'w':
                this.setTamanho(passo_aumento);
                break;
            case 'c':
                this.draw.clear();
                break;
            case 'p':
                break;
            default:
                return;
        }
    }

    @Override
    public void keyReleased(int keycode){
        this.tecla_pressionada = false;
    }

    @Override
    public void keyPressed(int keycode){
        this.tecla_pressionada = true;
        switch (keycode){ //Movedor
            case 37: //Esquerda
                break;
            case 38: //Cima
                break;
            case 39: //Direita
                break;
            case 40: //Baixo
                break;
        }
        if(keycode >= 112 && keycode <= 115) { //Seletor de formas
            setForma(keycode - 112);
        } else if (keycode >= 116 && keycode <= 119) { //Seletor de cores
            setForma(keycode - 116);
        }
    }

    public void desenha(Ponto ponto, String forma_atual){
        if(!formas.contains(forma_atual)) return;
        switch (forma_atual) {
            case "circulo":
                Circulo circulo = new Circulo(cor_linha_atual, cor_preenchimento_atual, ponto, tamanho_atual);
                circulo.desenha();
                break;
            case "retangulo":
                break;
        }
    }
}
