package spring;

import spring.model.entidades.pokemon.Pokemon;

public class MainPokemon {
    public static void main(String[] args) {
        Pokemon Jigglypuff = new Pokemon(403289.0);
        Pokemon Pikachu = new Pokemon(42050.0);
        Pokemon Meganium = new Pokemon(1010042.0);
        assert Jigglypuff.get_nivel() == 6;
        assert Pikachu.get_nivel() == 4;
        assert Meganium.get_nivel() == 7;


    }
}

