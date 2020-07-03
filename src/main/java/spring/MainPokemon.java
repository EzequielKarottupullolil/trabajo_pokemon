package spring;
import spring.model.entidades.pokemon.Pokemon;
import spring.model.utilidad.efectos.Efecto;
import spring.model.utilidad.efectos.Paralisis;
import spring.model.utilidad.efectos.Sueño;
import spring.model.utilidad.movimientos.Movimiento;
import spring.model.utilidad.movimientos.Movimiento_curativo;
import spring.model.utilidad.movimientos.Movimiento_dañinos;
import spring.model.utilidad.movimientos.Movimiento_especial;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class MainPokemon {
    public void assertRemaster(Boolean assertion) throws Exception{
        if(!assertion) throw new Exception("false assertion");
    }
    public static void main(String[] args) throws Exception {
        //Jigglypuff
        ArrayList<Movimiento> movimientos_Jigglypuff = new ArrayList<Movimiento>();
        Efecto sueño = new Sueño();
        Movimiento_especial Canto = new Movimiento_especial("Canto",2 ,sueño);
        Movimiento_curativo Descanso = new Movimiento_curativo("Descanso",50.0,5);
        Movimiento_dañinos Destructor = new Movimiento_dañinos("Destructor",30.0,10);
        movimientos_Jigglypuff.add(Canto);
        movimientos_Jigglypuff.add(Descanso);
        movimientos_Jigglypuff.add(Destructor);
        Pokemon Jigglypuff = new Pokemon("Jigglypuff",403289.0,movimientos_Jigglypuff);
        //end Jigglypuff

        //Pikachu block
        ArrayList<Movimiento> movimientos_pikachu = new ArrayList<Movimiento>();
        Paralisis paralisis = new Paralisis();
        movimientos_pikachu.add(new Movimiento_especial("Impactrueno",0,paralisis));
        movimientos_pikachu.add(new Movimiento_dañinos("Amago",30.0,10));
        movimientos_pikachu.add(new Movimiento_dañinos("Golpazo",80,1));
        movimientos_pikachu.add(new Movimiento_curativo("Descanso",50,1));

        Pokemon Pikachu = new Pokemon("Pikachu",42050.0,movimientos_pikachu);
        //Pikachu end block
//        Pokemon Meganium = new Pokemon("Meganium",1010042.0,movimientos);
        MainPokemon mainPokemon = new MainPokemon();

        mainPokemon.assertRemaster(Jigglypuff.get_nivel() == 6);
        mainPokemon.assertRemaster(Pikachu.get_nivel() == 4);
//        mainPokemon.assertRemaster(Meganium.get_nivel() == 7);
        System.out.println(Jigglypuff.calcular_grositud());

        mainPokemon.assertRemaster(Jigglypuff.calcular_grositud() == 960.0);

        mainPokemon.assertRemaster(Pikachu.calcular_grositud() == 1200.0);
//        mainPokemon.assertRemaster(Meganium.calcular_grositud() == 960.0);



    }
}

