package spring.model.utilidad.movimientos;

import spring.model.entidades.pokemon.Pokemon;

public class Movimiento_curativo extends Movimiento {
    public Movimiento_curativo(String nombre, double stat,int cantidad_usos) {
        super(nombre,cantidad_usos);
        this.stat = stat;
    }

    @Override
    public void aplicar(Pokemon pokemon_objetivo) {
        if(this.cantidad_usos <= 0) return;
        double vida_final = pokemon_objetivo.get_puntosVida() + this.stat;
        pokemon_objetivo.set_puntosVida(vida_final);
        this.cantidad_usos -= 1;
    }
}
