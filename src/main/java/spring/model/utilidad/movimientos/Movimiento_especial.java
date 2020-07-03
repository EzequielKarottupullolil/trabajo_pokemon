package spring.model.utilidad.movimientos;

import spring.model.utilidad.efectos.Efecto;

public class Movimiento_especial extends Movimiento {
    private Efecto efecto;
    protected double stat = 30;
    public Movimiento_especial(String nombre,int cantidad_usos, Efecto efecto) {
        super(nombre,cantidad_usos);
        this.efecto = efecto;
        this.stat = this.efecto.get_stat();
    }

    @Override
    public double get_stats() {
        return this.efecto.get_stats();
    }
}
