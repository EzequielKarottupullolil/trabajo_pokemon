package spring.model.utilidad.objetos;

import spring.model.entidades.pokemon.Pokemon;
import spring.model.utilidad.efectos.Efecto;

import java.util.ArrayList;

public class Medicina_especial extends Objeto {
    public String toString() {
        return "medicina especial";
    }
    @Override
    public void aplicar(Pokemon pokemon_objetivo) {
        pokemon_objetivo.vaciar_efectos();
    }
}
