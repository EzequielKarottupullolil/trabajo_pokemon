package spring.model.utilidad.efectos;

@SuppressWarnings("ALL")
public class Sueño extends Efecto{
    public Sueño(){
        this.stat = 50.0;
    }
    @Override
    protected void aplicar_efecto() {

    }

    @Override
    public double get_stats() {
        return 0;
    }
}
