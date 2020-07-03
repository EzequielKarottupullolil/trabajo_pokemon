package spring.model.utilidad.movimientos;

public abstract class Movimiento {
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
}
