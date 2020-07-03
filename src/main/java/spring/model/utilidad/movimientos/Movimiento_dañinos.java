package spring.model.utilidad.movimientos;

public class Movimiento_dañinos extends Movimiento {
    public Movimiento_dañinos(String nombre, double stat, int cantidad_usos){
        super(nombre,cantidad_usos);
        this.stat = stat;
    }

    @Override
    public double get_stats() {
        return super.get_stats() * 2;
    }
}
