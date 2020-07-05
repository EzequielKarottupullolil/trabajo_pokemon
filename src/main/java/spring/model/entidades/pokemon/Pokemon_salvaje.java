package spring.model.entidades.pokemon;

import spring.model.entidades.entrenador.Entrenador;
import spring.model.utilidad.movimientos.Movimiento;

import java.util.ArrayList;

public class Pokemon_salvaje extends Pokemon {
    protected Entrenador entrenador;

    public Pokemon_salvaje(String nombre, double puntos_vida, double experiencia, Entrenador entrenador,ArrayList<Movimiento> movimientos) {
        super(nombre, puntos_vida, experiencia, movimientos);
        this.entrenador = entrenador;
    }
}
