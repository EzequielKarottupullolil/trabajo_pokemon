package spring.model.utilidad.objetos;

import spring.model.entidades.pokemon.Pokemon;

public class Medicina extends Objeto {
    public double curacion = 40;
    public String toString() {
        return "Medicina";
    }
    @Override
    public void aplicar(Pokemon pokemon_objetivo) {
        double vida_final = pokemon_objetivo.get_puntosVida() + this.curacion;
        pokemon_objetivo.set_puntosVida(vida_final);
    }
}
