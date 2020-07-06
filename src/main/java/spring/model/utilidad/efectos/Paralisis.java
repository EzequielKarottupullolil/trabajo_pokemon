package spring.model.utilidad.efectos;

public class Paralisis extends Efecto {
    protected double stat = 30;

    @Override
    public double get_stats() {
        return this.stat;
    }

    @Override
    protected void aplicar_efecto() {

    }
}
