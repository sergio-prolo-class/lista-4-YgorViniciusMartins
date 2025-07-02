package domain;

public final class Constantes {
    //Constantes da tela
    public final static int ESCALA_X = 625; //Constante para a escala X da tela
    public final static int ESCALA_Y = 650; //Constante para a escala y da tela

    //Constantes das teclas para facilitar a legibilidade
    public final static int UP_KEY = 38;
    public final static int DOWN_KEY = 40;
    public final static int RIGHT_KEY = 39;
    public final static int LEFT_KEY = 37;
    public final static int F1 = 112;
    public final static int F4 = 115;
    public final static int F5 = 116;
    public final static int F8 = 119;

    //Constantes contemplando as possibilidades de elementos a sere utilizados
    public final static String[] CORES_DISP = {"Preto", "Verde", "Azul", "Vermelho"}; //Cores definidas
    public final static String[] FORMAS_DISP = {"Circulo", "Losango", "Pentágono", "Quadrado"}; //Formas definidas
    public final static int PASSO_MIN = 10;
    public final static int PASSO_MAX = 150;

    //Constantes de interação com o usuário
    public final static int PASSO = 10; //Quantidade aumentada/diminuida a cada vez que o usúario pressiona a tecla correspondente
    public final static String COR_LINHA_DEFAULT = "Preto"; //Cor Defalut
    public final static String COR_PREENCHIMENTO_DEFAULT = ""; //Cor de preencimento Default
    public final static String FORMA_DEFAULT = FORMAS_DISP[0];

    private Constantes(){}
}
