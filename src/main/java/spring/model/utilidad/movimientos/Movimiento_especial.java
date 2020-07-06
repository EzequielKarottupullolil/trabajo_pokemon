package spring.model.utilidad.movimientos;

import spring.model.entidades.pokemon.Pokemon;
import spring.model.utilidad.efectos.Efecto;

public class Movimiento_especial extends Movimiento {
    private Efecto efecto;
    protected double stat;
    public Movimiento_especial(String nombre,int cantidad_usos, Efecto efecto) {
        super(nombre,cantidad_usos);
        this.efecto = efecto;
        this.stat = this.efecto.get_stats();
    }

    @Override
    public void aplicar(Pokemon pokemon_objetivo) {
        if(this.cantidad_usos <= 0) return;
        double vida_total = pokemon_objetivo.get_puntosVida() - this.stat;
        pokemon_objetivo.set_puntosVida(vida_total);
        pokemon_objetivo.set_efecto(this.efecto);
        this.cantidad_usos -= 1;
    }

}
