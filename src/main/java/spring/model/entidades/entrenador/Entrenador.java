package spring.model.entidades.entrenador;

import spring.model.entidades.pokemon.Pokemon;
import spring.model.entidades.pokemon.Pokemon_entrenado;
import spring.model.entidades.pokemon.Pokemon_salvaje;
import spring.model.entorno.Entorno;
import spring.model.utilidad.efectos.Efecto;
import spring.model.utilidad.movimientos.Movimiento;
import spring.model.utilidad.objetos.Objeto;
import spring.model.utilidad.objetos.Pokebola;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Entrenador {
    protected Entorno entorno;
    protected ArrayList<Pokemon_entrenado> pokemones = new ArrayList<>();
    protected ArrayList<Objeto> objetos = new ArrayList<Objeto>();
    public String nombre;
    public Entrenador(String nombre,Entorno entorno){
        this.nombre = nombre;
        this.entorno = entorno;
        this.entorno.agregar_entrenador(this);
    }
    public Entrenador(String nombre,Entorno entorno,ArrayList<Pokemon_entrenado> pokemones){
        this.nombre = nombre;
        this.entorno = entorno;
        this.pokemones = pokemones;
        this.entorno.agregar_entrenador(this);
    }
    public Entrenador(String nombre,Entorno entorno,ArrayList<Objeto> objetos,ArrayList<Pokemon_entrenado> pokemones){
        this.nombre = nombre;
        this.entorno = entorno;
        this.objetos = objetos;
        this.pokemones = pokemones;
        this.entorno.agregar_entrenador(this);
    }

    public boolean puedo_capturar(Pokemon pokemon_objetivo){
        double mitad_vida = pokemon_objetivo.get_pVinicial() / 2;
        return !(pokemon_objetivo.get_puntosVida() > mitad_vida);
    }

    public void capturar_pokemon(Pokemon pokemon_objetivo){
        /* Intenta capturar un pokemon*/
        //Primero comprueba que tenga mitad de vida
        if(!this.puedo_capturar(pokemon_objetivo)) throw new Error("No puedes capturarlo: Esta medio vivo");
        //Luego que no sea un pokemon_capturado
        if(pokemon_objetivo instanceof Pokemon_entrenado) throw new Error("Este pokemon pertenece a otro jugador");

        //Luego busca una pokebola en nuestros objetos
        Pokebola pokebola = this.get_pokebola();
        if(pokebola == null) throw new Error("No tienes ninguna pokebola");

        //Aplica la pokebola
        pokebola.aplicar(pokemon_objetivo);

        //Guarda las stats del pokemon
        double puntos_vida = pokemon_objetivo.get_pVinicial();
        double experiencia = pokemon_objetivo.get_experiencia();
        ArrayList<Movimiento> movimientos = pokemon_objetivo.get_movimientos();
        String nombre = pokemon_objetivo.get_nombre();

        //Crea un pokemon entrenado con las mismas stats
        Pokemon_entrenado pokemon_entrenado = new Pokemon_entrenado(nombre,puntos_vida,experiencia,this,movimientos);
        pokemon_entrenado.set_puntosVida(pokemon_objetivo.get_puntosVida());
        this.pokemones.add(pokemon_entrenado);

    }

    public Pokebola get_pokebola(){
        /*Recorre la lista de objetos y busca una pokebola*/
        for (Objeto objeto : this.objetos) {
            if(objeto instanceof Pokebola ) return (Pokebola) objeto;
        }
        return null;
    }

    public void usar_objeto(int indice_objeto,Pokemon pokemon_objetivo){
        Objeto objeto = this.objetos.get(indice_objeto);
        objeto.aplicar(pokemon_objetivo);
        this.objetos.remove(objeto);
    }
    public void agregar_objeto(Objeto objeto){
        this.objetos.add(objeto);
    }

    public Boolean tengo_pokemon(Pokemon_entrenado pokemon_objetivo) {
        return this.pokemones.contains(pokemon_objetivo);
    }

    public void agregar_pokemo(Pokemon_entrenado pokemon_objetivo){
        /* Solo agrega pokemones que nos tengan como entrenador*/
        if(pokemon_objetivo.get_entrenador() != this) return;

        this.pokemones.add(pokemon_objetivo);
    }

    public ArrayList<Pokemon_entrenado> get_pokemones(){
        return this.pokemones;
    }

    public ArrayList<Objeto> get_objetos() {
        return this.objetos;
    }
}
