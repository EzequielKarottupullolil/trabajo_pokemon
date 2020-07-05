package spring.model.entidades.pokemon;

import spring.model.entidades.entrenador.Entrenador;
import spring.model.entorno.Entorno;
import spring.model.utilidad.movimientos.Movimiento;

import java.util.ArrayList;

public class Pokemon_salvaje extends Pokemon {
    protected Entorno entorno;
    public Pokemon_salvaje(String nombre, double puntos_vida, double experiencia, ArrayList<Movimiento> movimientos, Entorno entorno) {
        super(nombre, puntos_vida, experiencia, movimientos);
        this.entorno = entorno;
        this.entorno.agregar_pokemon_salvaje(this);
    }
}
