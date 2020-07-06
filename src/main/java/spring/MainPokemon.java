package spring;
import spring.model.entidades.entrenador.Entrenador;
import spring.model.entidades.pokemon.Pokemon_entrenado;
import spring.model.entidades.pokemon.Pokemon_salvaje;
import spring.model.entorno.ciudad.Ciudad;
import spring.model.utilidad.efectos.Efecto;
import spring.model.utilidad.efectos.Paralisis;
import spring.model.utilidad.efectos.Sueño;
import spring.model.utilidad.movimientos.Movimiento;
import spring.model.utilidad.movimientos.Movimiento_curativo;
import spring.model.utilidad.movimientos.Movimiento_dañino;
import spring.model.utilidad.movimientos.Movimiento_especial;
import spring.model.utilidad.objetos.Pokebola;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class MainPokemon {
    public void assertRemaster(Boolean assertion) throws Exception{
        /*Se pasa el assertion por parametro
        y si es false crea una Exception*/
        if(!assertion) throw new Exception("false assertion");
    }
    public void denyRemaster(Boolean deny) throws Exception{
        if(deny) throw new Exception("false deny");
    }
    public static void main(String[] args) throws Exception {
        MainPokemon mainPokemon = new MainPokemon();


        Ciudad ciudad = new Ciudad();
        //Jigglypuff
        Entrenador Ash = new Entrenador("Ash",ciudad);
        ArrayList<Movimiento> movimientos_Jigglypuff = new ArrayList<Movimiento>();
        Efecto sueño = new Sueño();
        Movimiento_especial Canto = new Movimiento_especial("Canto",2 ,sueño);
        Movimiento_curativo Descanso = new Movimiento_curativo("Descanso",50.0,5);
        Movimiento_dañino Destructor = new Movimiento_dañino("Destructor",30.0,10);
        movimientos_Jigglypuff.add(Canto);
        movimientos_Jigglypuff.add(Descanso);
        movimientos_Jigglypuff.add(Destructor);
        Pokemon_entrenado Jigglypuff = new Pokemon_entrenado("Jigglypuff",100.0,403289.0,Ash,movimientos_Jigglypuff);
        Jigglypuff.set_puntosVida(30);
        //end Jigglypuff

        //Pikachu block
        ArrayList<Movimiento> movimientos_pikachu = new ArrayList<Movimiento>();
        Paralisis paralisis = new Paralisis();
        movimientos_pikachu.add(new Movimiento_especial("Impactrueno",0,paralisis));
        movimientos_pikachu.add(new Movimiento_dañino("Amago",30.0,10));
        movimientos_pikachu.add(new Movimiento_dañino("Golpazo",80,1));
        movimientos_pikachu.add(new Movimiento_curativo("Descanso",50,1));

        Pokemon_salvaje Pikachu = new Pokemon_salvaje("Pikachu",80.0,42050.0,movimientos_pikachu,ciudad);
        Pikachu.set_puntosVida(60.0);
        //Pikachu end block
//        Pokemon Meganium = new Pokemon("Meganium",1010042.0,movimientos);

        mainPokemon.assertRemaster(Jigglypuff.get_nivel() == 6);
        mainPokemon.assertRemaster(Pikachu.get_nivel() == 4);
//        mainPokemon.assertRemaster(Meganium.get_nivel() == 7);

        mainPokemon.assertRemaster(Jigglypuff.get_grositud() == 960.0);
        mainPokemon.assertRemaster(Pikachu.get_grositud() == 1200.0);
//        mainPokemon.assertRemaster(Meganium.calcular_grositud() == 960.0);

        //Pikachu usa amago que pega 30 de hp para matar a jigglypuff con 30 hp
        Pikachu.usar_movimiento(1,Jigglypuff);

        mainPokemon.assertRemaster(Jigglypuff.get_puntosVida() == 0);

        //Jigglypuff intenta aplicar un ataque a pikachu
        Jigglypuff.usar_movimiento(0,Pikachu);

        //Pero Pikachu no recibe el ataque debidoa que Jigglypuff tiene 0 puntos de vida
        mainPokemon.denyRemaster(Pikachu.get_puntosVida() < 60.0);
        //Como la vida de Jigglypuff es igual o menor a 0, Pikachu obtiene experiencia
        mainPokemon.assertRemaster(Pikachu.get_experiencia() == 42530.0);

        Pokebola pokebola = new Pokebola();

        Ash.agregar_objeto(pokebola);
        Ash.capturar_pokemon(Jigglypuff);
        mainPokemon.denyRemaster(Ash.tengo_pokemon(Jigglypuff));

    }
}

