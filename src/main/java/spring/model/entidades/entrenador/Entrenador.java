package spring.model.entidades.entrenador;

import spring.model.entidades.pokemon.Pokemon;
import spring.model.entidades.pokemon.Pokemon_salvaje;
import spring.model.entorno.Entorno;
import spring.model.utilidad.objetos.Objeto;

import java.util.ArrayList;

public class Entrenador {
    protected Entorno entorno;
    protected ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>();
    protected ArrayList<Objeto> objetos = new ArrayList<Objeto>();
    public String nombre;
    public Entrenador(String nombre,Entorno entorno){
        this.nombre = nombre;
        this.entorno = entorno;
        this.entorno.agregar_entrenador(this);
    }

    public boolean puedo_capturar(Pokemon_salvaje pokemon_objetivo){
        double mitad_vida = pokemon_objetivo.get_pVinicial() / 2;
        return !(pokemon_objetivo.get_puntosVida() > mitad_vida);
    }

    public void capturar_pokemon(Pokemon_salvaje pokemon_objetivo){
        if(!this.puedo_capturar(pokemon_objetivo)) return;

//        if()
    }

    public void usar_objeto(int indice_objeto,Pokemon pokemon_objetivo){
        Objeto objeto = this.objetos.get(indice_objeto);
        objeto.aplicar(pokemon_objetivo);
    }
}
