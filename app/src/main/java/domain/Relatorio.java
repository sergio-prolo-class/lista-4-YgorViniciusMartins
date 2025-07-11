package domain;

import java.util.LinkedList;
import java.util.List;

//Esta classe tem como objetivo facilitar a produção das estastíticas da tela, além de armazenar as formas que estão presentes
public class Relatorio {
    private static final List<FormaGeometrica> lista_formas = new LinkedList<>();
    private static final List<ObjetoDesenho> lista_objetos = new LinkedList<>();

    public void nova_forma(FormaGeometrica forma){
        lista_formas.add(forma);
    }

    public void novo_objeto(ObjetoDesenho objeto_desenho){
        lista_objetos.add(objeto_desenho);
    }

    public int getQtdFormas(){
        return lista_formas.size();
    }

    public double getAreaFormas(){ //Caso de polimorfismo, cada forma geométrica possui sua própria forma de calcula sua área
        double area_total = 0;
        for (FormaGeometrica listaForma : lista_formas) {
            area_total += listaForma.getArea();
        }
        return area_total;
    }

    public double getPerimetroFormas(){ //Caso de polimorfismo, cada forma geométrica possui sua própria forma de calcula seu perímetro
        double perimetro_total = 0;
        for (FormaGeometrica listaForma : lista_formas) {
            perimetro_total += listaForma.getPerimetro();
        }
        return perimetro_total;
    }

    public void limpasFormasArmazenadas(){
        lista_formas.clear();
    }

    public List<FormaGeometrica> getLista_formas(){
        return lista_formas;
    }

    public List<ObjetoDesenho> getLista_objetos(){
        return lista_objetos;
    }

    public void limpaListaObjetos(){
        lista_objetos.clear();
    }

    public void limpaListaFormasGeometricas(){
        lista_formas.clear();
    }

    public void limpaListas(){
        limpaListaObjetos();
        limpaListaFormasGeometricas();
    }
}
