package spring.model.entidades.pokemon;

import spring.model.entidades.entrenador.Entrenador;
import spring.model.utilidad.movimientos.Movimiento;

import java.util.ArrayList;

public class Pokemon_entrenado extends Pokemon{
    protected Entrenador entrenador;
    public Pokemon_entrenado(String nombre, double puntos_vida, double experiencia, Entrenador entrenador, ArrayList<Movimiento> movimientos) {
        super(nombre, puntos_vida, experiencia, movimientos);
        this.entrenador = entrenador;
    }
    public Pokemon_entrenado(String nombre,double puntos_vida,double experiencia){
        super(nombre,puntos_vida,experiencia);
    }

    public Pokemon_entrenado(String nombre, double puntos_vida, double experiencia, Entrenador entrenador) {
        super(nombre,puntos_vida,experiencia);
        this.entrenador = entrenador;
    }

    public Entrenador get_entrenador() {
        return this.entrenador;
    }
}
