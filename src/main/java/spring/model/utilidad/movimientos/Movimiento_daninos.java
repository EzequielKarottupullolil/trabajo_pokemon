package spring.model.utilidad.movimientos;

public class Movimiento_daninos extends Movimiento {
    public Movimiento_daninos(String nombre, double stat,int cantidad_usos){
        super(nombre,stat,cantidad_usos);
    }

    @Override
    public double get_stats() {
        return super.get_stats() * 2;
    }
}
