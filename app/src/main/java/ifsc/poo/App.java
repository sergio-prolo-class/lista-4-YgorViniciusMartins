/*
 * This source file was generated by the Gradle 'init' task
 */
package ifsc.poo;

import domain.Desenhista;
import domain.Ponto;
import domain.Relatorio;
import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import static domain.Constantes.*;

public class App implements DrawListener {
    private static Desenhista desenhista;
    private static final Draw listener = new Draw();

    private static int tamanho_atual;
    private static String forma_atual;
    private static String cor_linha_atual;
    private static String cor_preenchimento_atual;
    private static boolean preenchido; //True => Preenchido, False => Vazado
    private static boolean tecla_pressionada;
    private static Relatorio relatorio;

    public App(){
        tamanho_atual = PASSO;
        forma_atual = FORMA_DEFAULT;
        cor_linha_atual = COR_LINHA_DEFAULT;
        cor_preenchimento_atual = COR_PREENCHIMENTO_DEFAULT;
        preenchido = false;
        tecla_pressionada = false;
        desenhista = new Desenhista(listener);
        listener.addListener(this);
        relatorio = new Relatorio();
    }

    public static void main(String[] args) {
        aplicacao();
    }

    public static void aplicacao(){ //Roda a aplicação
        App app = new App();
    }

    public void setTamanho(int passo){
        if(tamanho_atual + passo < PASSO_MIN || tamanho_atual + passo > PASSO_MAX) return;
        tamanho_atual += passo;
    }

    public void setCorLinha(String cor){
        cor_linha_atual = cor;
    }

    public void setCorLinha(int i){
        cor_linha_atual = CORES_DISP[i];
    }

    public void setCorPreenchimento(int i){
        cor_linha_atual = CORES_DISP[0];
        cor_preenchimento_atual = CORES_DISP[i];
    }

    public void setCorPreenchimento(String cor){
        cor_preenchimento_atual = cor;
    }

    public void setForma(int i){
        forma_atual = FORMAS_DISP[i];
    }

    @Override
    public void mousePressed(double x, double y){ //Responsável por realizar a ação do click
        Ponto ponto = new Ponto(x,y);
        desenhista.desenha(forma_atual, cor_linha_atual ,cor_preenchimento_atual, ponto, tamanho_atual, relatorio);
        desenhista.updateTela();
    }

    @Override
    public void keyTyped(char c){ //Responsávle por lidar com as teclas de letras
        c = Character.toLowerCase(c);
        tecla_pressionada = true;
        switch (c){
            case 'f':
                preenchido = !preenchido;
                if(preenchido){
                    setCorPreenchimento(cor_linha_atual);
                    cor_linha_atual = COR_LINHA_DEFAULT; //Coloca a cor da linha como preta como solicitado
                    System.out.println("Com Preenchimento");
                } else {
                    setCorLinha(cor_preenchimento_atual);
                    cor_preenchimento_atual = COR_PREENCHIMENTO_DEFAULT; //Deixa o objeto vazado
                    System.out.println("Sem Preenchimento");
                }
                break;
            case 'q':
                setTamanho(-PASSO);
                System.out.println("Tamanho: " + tamanho_atual);
                break;
            case 'w':
                setTamanho(PASSO);
                System.out.println("Tamanho: " + tamanho_atual);
                break;
            case 'c':
                desenhista.limpaTela();
                relatorio.limpaListas();
                desenhista.updateTela();
                System.out.println("Tela foi limpa!");
                relatorio.limpasFormasArmazenadas();
                break;
            case 'p':
                System.out.println("Quantidade de formas: " + relatorio.getQtdFormas());
                System.out.println("Perímetro das formas: " + relatorio.getPerimetroFormas());
                System.out.println("Área das formas: " + relatorio.getAreaFormas());
                break;
            default:
        }
    }

    @Override
    public void keyReleased(int keycode){
        tecla_pressionada = false;
    }

    @Override
    public void keyPressed(int keycode){ //Responsável por lidar com as teclas pressionadas
        tecla_pressionada = true;
        switch (keycode){ //Movedor
            case LEFT_KEY: //Esquerda
                desenhista.deslocarDesenhos(relatorio, -PASSO, 0);
                break;
            case UP_KEY: //Cima
                desenhista.deslocarDesenhos(relatorio, 0 , PASSO);
                break;
            case RIGHT_KEY: //Direita
                desenhista.deslocarDesenhos(relatorio, PASSO, 0);
                break;
            case DOWN_KEY: //Baixo
                desenhista.deslocarDesenhos(relatorio, 0, -PASSO);
                break;
        }
        if(keycode >= F1 && keycode <= F4) { //Seletor de formas
            setForma(keycode - F1);
            System.out.println("Figura: " + forma_atual);
        } else if (keycode >= F5 && keycode <= F8) { //Seletor de cores
            if(preenchido){
                setCorPreenchimento(keycode - F5);
                System.out.println("Cor: " + cor_preenchimento_atual);
            } else {
                setCorLinha(keycode - F5);
                System.out.println("Cor: " + cor_linha_atual);
            }
        }
    }
}