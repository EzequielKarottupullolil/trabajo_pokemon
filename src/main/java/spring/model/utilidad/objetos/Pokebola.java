package spring.model.utilidad.objetos;

import spring.model.entidades.pokemon.Pokemon;
import spring.model.entidades.pokemon.Pokemon_salvaje;

public class Pokebola extends Objeto {
    @Override
    public String toString() {
        return "pokebola";
    }

    @Override
    public void aplicar(Pokemon pokemon_objetivo) {
        /*Borra el pokemon del entorno */
        if(!(pokemon_objetivo instanceof Pokemon_salvaje)) return;
        double mitad_vida = pokemon_objetivo.get_pVinicial() / 2;
        if(pokemon_objetivo.get_puntosVida() > mitad_vida) return;
         ((Pokemon_salvaje) pokemon_objetivo).get_entorno().quitar_pokemon_salvaje((Pokemon_salvaje) pokemon_objetivo);

    }
}
