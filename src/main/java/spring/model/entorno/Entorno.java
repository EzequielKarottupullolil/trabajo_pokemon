package spring.model.entorno;

import spring.model.entidades.entrenador.Entrenador;
import spring.model.entidades.pokemon.Pokemon_salvaje;

import java.util.ArrayList;

public abstract class Entorno {
    protected ArrayList<Pokemon_salvaje> pokemonesSalvajes = new ArrayList<Pokemon_salvaje>();
    protected ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();


    public Boolean esta_el_pokemon(Pokemon_salvaje pokemon){
        return this.pokemonesSalvajes.contains(pokemon);
    }

    public Boolean esta_el_entrenador(Entrenador entrenador){
        return this.entrenadores.contains(entrenador);
    }

    public void agregar_entrenador(Entrenador entrenador){
        /*Agrega un entrenador a la lista entrenadores*/

        //Si existe el entrenador en el entorno la funcion rompe
        if(this.esta_el_entrenador(entrenador)) return;

        this.entrenadores.add(entrenador);
    };
}
