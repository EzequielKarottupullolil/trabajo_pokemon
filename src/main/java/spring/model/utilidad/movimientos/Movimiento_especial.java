package spring.model.utilidad.movimientos;

import spring.model.entidades.pokemon.Pokemon;
import spring.model.utilidad.efectos.Efecto;

public class Movimiento_especial extends Movimiento {
    private Efecto efecto;
    protected double stat;
    public Movimiento_especial(String nombre,int cantidad_usos, Efecto efecto) {
        super(nombre,cantidad_usos);
        this.efecto = efecto;
        this.stat = this.efecto.get_stat();
    }

    @Override
    public double get_stats() {
        return this.efecto.get_stats();
    }

    @Override
    public void aplicar(Pokemon pokemon_objetivo) {
        this.cantidad_usos -= 1;
        double vida_total = pokemon_objetivo.get_puntosVida() - this.stat;
        pokemon_objetivo.set_puntosVida(vida_total);
        pokemon_objetivo.set_efecto(this.efecto);
    }

}
