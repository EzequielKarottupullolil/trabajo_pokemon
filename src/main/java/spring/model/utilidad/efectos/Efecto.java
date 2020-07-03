package spring.model.utilidad.efectos;

public abstract class Efecto {
    protected double stat;

    protected abstract void aplicar_efecto();

    public double get_stat(){
        return this.stat;
    }

    public abstract double get_stats();
}
