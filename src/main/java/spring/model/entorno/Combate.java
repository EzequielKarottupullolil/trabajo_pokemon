package spring.model.entorno;

import spring.model.entidades.entrenador.Entrenador;
import spring.model.entidades.pokemon.Pokemon;
import spring.model.entidades.pokemon.Pokemon_entrenado;

import java.util.ArrayList;

public class Combate extends Entorno {
    private ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
    public Combate(ArrayList<Entrenador> entrenadors){
        this.entrenadores = entrenadors;
    }
    public Combate(){

    }

    public void agregar_pokemon_a_Cobate(Pokemon pokemon_objetivo){
        this.pokemones.add(pokemon_objetivo);
    }

    public ArrayList<Pokemon> get_pokemones(){
        return this.pokemones;
    }
    public ArrayList<Pokemon_entrenado> get_pokemones_entrenador(Entrenador entrenador){
        return entrenador.get_pokemones();
    }


}
