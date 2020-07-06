package spring.model.utilidad.efectos;

public abstract class Efecto {
    protected double effect_damage;



    protected abstract void aplicar_efecto();

    public double get_effect_damage(){
        return this.effect_damage;
    };
}
