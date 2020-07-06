package spring.model.utilidad.movimientos;

import spring.model.entidades.pokemon.Pokemon;

public abstract class Movimiento {
    @Override
    public String toString() {
        return "Movimiento{" +
                "nombre='" + nombre + '\'' +
                "stat='" + stat + '\''+
                '}';
    }

    protected String nombre;
    protected double stat;
    protected int cantidad_usos;
    public double get_stats() {
        return this.stat;
    }
    public Movimiento(String nombre,int cantidad_usos){
        this.nombre = nombre;
        this.cantidad_usos = cantidad_usos;
    }

    public abstract void aplicar(Pokemon pokemon_objetivo);

    public int get_usos(){
        return this.cantidad_usos;
    }
}
