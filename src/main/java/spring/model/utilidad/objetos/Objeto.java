package spring.model.utilidad.objetos;

import spring.model.entidades.pokemon.Pokemon;

public abstract  class  Objeto {
    @Override
    public String toString() {
        return "Objeto";
    }

    public abstract void aplicar(Pokemon pokemon_objetivo);
}
