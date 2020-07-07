package spring.model.entidades.pokemon;

import spring.model.entidades.entrenador.Entrenador;
import spring.model.utilidad.movimientos.Movimiento;
import spring.model.utilidad.movimientos.Movimiento_curativo;
import spring.model.utilidad.movimientos.Movimiento_especial;

import java.util.ArrayList;

public class Pokemon_entrenado extends Pokemon{
    protected Entrenador entrenador;
    public Pokemon_entrenado(String nombre, double puntos_vida, double experiencia, Entrenador entrenador, ArrayList<Movimiento> movimientos) {
        super(nombre, puntos_vida, experiencia, movimientos);
        this.entrenador = entrenador;
    }
    public Pokemon_entrenado(String nombre,double puntos_vida,double experiencia){
        super(nombre,puntos_vida,experiencia);
    }

    public Pokemon_entrenado(String nombre, double puntos_vida, double experiencia, Entrenador entrenador) {
        super(nombre,puntos_vida,experiencia);
        this.entrenador = entrenador;
    }

    @Override
    public boolean es_conveniente(int indice_movimiento, Pokemon pokemon_objetivo) {
        Movimiento movimiento = this.movimientos.get(indice_movimiento);
        double mitad_vida = pokemon_objetivo.get_pVinicial() / 2;
        //Si el movimiento es mayor a la vida del pokemon + 50 devuelve false
        if(movimiento.get_stats() > pokemon_objetivo.get_puntosVida() + 50) return false;
        //Si el movimiento es una instancia de Movimiento_curativo
        if(movimiento instanceof Movimiento_curativo) {
            //Soy sacrificable(Hay un pokemon mas groso en la lista de pokemones del entrenador) devuelve false
            if(this.soy_sacrificable()) return false;
            //Si estoy medio vivo regresa false
            if (pokemon_objetivo.get_puntosVida() > mitad_vida) return false;
        }
        //Si es un movimiento especial
        if(movimiento instanceof Movimiento_especial){
            //Si no soy el pokemon mas groso devuelve false
            if(pokemon_objetivo.get_grositud() < this.get_grositud()) return false;
            if(pokemon_objetivo.get_efectos().size() > 1) return false;
        }

        return true;
    }
    public Entrenador get_entrenador(){
            return this.entrenador;
    }

    public boolean soy_sacrificable(){
        if(this.entrenador.get_pokemones().size() < 1) return false;

        for (Pokemon_entrenado pokemon_entrenado : this.entrenador.get_pokemones()) {
            //Si el pokemon_entrenado es this siguiente iteracion
            if(pokemon_entrenado == this) continue;
            //Si el pokemon entrenado tiene los putnos de vida menores a 0 siguiente iteracion
            if(pokemon_entrenado.get_puntosVida() < 0 ) continue;
            //Si el pokemon entrenado es mas groso que nosotros devuelve true
            if (pokemon_entrenado.get_grositud() > this.get_grositud()) return true;
        }

        return false;
    }

}
