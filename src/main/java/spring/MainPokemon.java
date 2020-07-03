package spring;
import spring.model.entidades.pokemon.Pokemon;
import spring.model.utilidad.efectos.Efecto;
import spring.model.utilidad.movimientos.Movimiento;
import spring.model.utilidad.movimientos.Movimiento_curativo;
import spring.model.utilidad.movimientos.Movimiento_daninos;
import spring.model.utilidad.movimientos.Movimiento_especial;

import java.util.ArrayList;

public class MainPokemon {
    public void assertRemaster(Boolean assertion) throws Exception{
        if(!assertion) throw new Exception("false assertion");
    }
    public static void main(String[] args) throws Exception {
        //Jigglypuff
        ArrayList<Movimiento> movimientos_Jigglypuff = new ArrayList<Movimiento>();
        Efecto efecto = new Efecto();
        Movimiento_especial Canto = new Movimiento_especial("Canto",50,2 ,efecto);
        Movimiento_curativo Descanso = new Movimiento_curativo("Descanso",50.0,5);
        Movimiento_daninos Destructor = new Movimiento_daninos("Destructor",30.0,10);

        movimientos_Jigglypuff.add(Destructor);
        movimientos_Jigglypuff.add(Descanso);
        movimientos_Jigglypuff.add(Canto);
        Pokemon Jigglypuff = new Pokemon("Jigglypuff",403289.0,movimientos_Jigglypuff);
        //Jigglypuff

        ArrayList<Movimiento> movimientos_pikachu = new ArrayList<Movimiento>();
        movimientos_pikachu.add(new Movimiento_especial("Impactrueno",0,5,new Efecto()));
        movimientos_pikachu.add(new Movimiento_daninos("Amago",30.0,10));
        movimientos_pikachu.add(new Movimiento_daninos("Golpazo",80,1));
        movimientos_pikachu.add(new Movimiento_curativo("Descanso",50,1));

        Pokemon Pikachu = new Pokemon("Pikachu",42050.0,movimientos_pikachu);
//        Pokemon Meganium = new Pokemon("Meganium",1010042.0,movimientos);
        MainPokemon mainPokemon = new MainPokemon();

        mainPokemon.assertRemaster(Jigglypuff.get_nivel() == 6);
        mainPokemon.assertRemaster(Pikachu.get_nivel() == 4);
//        mainPokemon.assertRemaster(Meganium.get_nivel() == 7);

        mainPokemon.assertRemaster(Jigglypuff.calcular_grositud() == 960.0);
        System.out.println(Pikachu.calcular_grositud());
        mainPokemon.assertRemaster(Pikachu.calcular_grositud() == 1200.0);
//        mainPokemon.assertRemaster(Meganium.calcular_grositud() == 960.0);



    }
}

