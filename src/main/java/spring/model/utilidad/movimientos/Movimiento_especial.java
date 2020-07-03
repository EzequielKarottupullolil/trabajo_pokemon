package spring.model.utilidad.movimientos;

import spring.model.utilidad.efectos.Efecto;

public class Movimiento_especial extends Movimiento {
    private Efecto efecto;

    public Movimiento_especial(String nombre, double stat,int cantidad_usos, Efecto efecto) {
        super(nombre, stat,cantidad_usos);
        this.efecto = efecto;
    }

    @Override
    public double get_stats() {
        return super.get_stats();
    }
}
