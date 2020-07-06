package spring.model.utilidad.efectos;

public class Paralisis extends Efecto {

    public Paralisis(){
        this.effect_damage = 30;
    }

    @Override
    public double get_effect_damage() {
        return this.effect_damage;
    }

    @Override
    protected void aplicar_efecto() {

    }
}
