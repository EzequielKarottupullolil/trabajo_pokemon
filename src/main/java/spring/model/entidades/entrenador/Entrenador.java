package spring.model.entidades.entrenador;

import spring.model.entidades.pokemon.Pokemon;
import spring.model.utilidad.objetos.Objeto;

import java.util.ArrayList;

public class Entrenador {
    protected ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
    protected ArrayList<Objeto> objetos = new ArrayList<Objeto>();
    public String nombre;
    public Entrenador(String nombre,ArrayList<Pokemon> pokemones,ArrayList<Objeto> objetos){
        this.pokemones = pokemones;
        this.objetos = objetos;
        this.nombre = nombre;
    }
}
