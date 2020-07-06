package spring;

import spring.model.entidades.entrenador.Entrenador;
import spring.model.entidades.pokemon.Pokemon_entrenado;
import spring.model.entidades.pokemon.Pokemon_salvaje;
import spring.model.entorno.ciudad.Ciudad;
import spring.model.utilidad.efectos.Confusion;
import spring.model.utilidad.efectos.Paralisis;
import spring.model.utilidad.efectos.Sueño;
import spring.model.utilidad.movimientos.Movimiento;
import spring.model.utilidad.movimientos.Movimiento_curativo;
import spring.model.utilidad.movimientos.Movimiento_dañino;
import spring.model.utilidad.movimientos.Movimiento_especial;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

@SuppressWarnings("ALL")
public class stats_test {
    public static void main(String[] args) {
        Ciudad ciudad_test = new Ciudad();
        //Efectos
        Sueño sueño = new Sueño();
        Paralisis paralisis = new Paralisis();
        Confusion confusion = new Confusion();
        //Movimientos dañino
        Movimiento_dañino Amago = new Movimiento_dañino("Amago",30,10);
        Movimiento_dañino Golpazo = new Movimiento_dañino("Golpazo",80,1);
        Movimiento_dañino Destructor = new Movimiento_dañino("Destructor",30,10);
        Movimiento_dañino Hoja_Afilada = new Movimiento_dañino("Hoja afilada",55,0);
        Movimiento_dañino Placaje = new Movimiento_dañino("Placaje",50,5);
        //Movimientos Curativos
        Movimiento_curativo Descanso = new Movimiento_curativo("Descanso",50,5);
        Movimiento_curativo Sintesis = new Movimiento_curativo("Sintesis",100,4);
        //Movimientos especiales
        Movimiento_especial Impactrueno = new Movimiento_especial("Impactrueno",5,paralisis);
        Movimiento_especial Danza_petalo = new Movimiento_especial("Danza petalo ",3,confusion);
        Movimiento_especial Canto = new Movimiento_especial("Canto ",2,sueño);

        //Pikachu
        ArrayList<Movimiento> movimientos_pikachu = new ArrayList<Movimiento>();
        movimientos_pikachu.add(Impactrueno);
        movimientos_pikachu.add(Amago);
        movimientos_pikachu.add(Golpazo);
        movimientos_pikachu.add(Descanso);
        Pokemon_salvaje Pikachu = new Pokemon_salvaje("Pikachu",80,42050.0,movimientos_pikachu,ciudad_test);
        Pikachu.set_puntosVida(60);
        //Jigglypuff
        ArrayList<Movimiento> movimientos_jigglypuff = new ArrayList<Movimiento>();
        movimientos_jigglypuff.add(Canto);
        movimientos_jigglypuff.add(Descanso);
        movimientos_jigglypuff.add(Destructor);
        Entrenador Ash = new Entrenador("Ash",ciudad_test);
        Pokemon_entrenado Jigglypuff = new Pokemon_entrenado("Jigglypuff",100,403289,Ash,movimientos_jigglypuff);
        Jigglypuff.set_puntosVida(30);
        Ash.agregar_pokemo(Jigglypuff);

        //Meganium
        ArrayList<Movimiento> movimientos_meganium = new ArrayList<Movimiento>();
        movimientos_meganium.add(Danza_petalo);
        movimientos_meganium.add(Sintesis);
        movimientos_meganium.add(Hoja_Afilada);
        movimientos_meganium.add(Placaje);
        Entrenador Misty = new Entrenador("Misty",ciudad_test);
        Pokemon_entrenado Meganium = new Pokemon_entrenado("Meganium",250,1010042,Misty,movimientos_meganium);
        Meganium.set_puntosVida(50);
        Misty.agregar_pokemo(Meganium);

        if(Jigglypuff.get_nivel() != 6) throw new Error("fail");
        if(Pikachu.get_nivel() != 4) throw new Error("fail");
        if(Meganium.get_nivel() != 7) throw new Error("fail");

        if(Jigglypuff.get_grositud() != 960) throw new Error("fail");
        if(Pikachu.get_grositud() != 1200) throw new Error("fail");
        if(Meganium.get_grositud() != 2450) throw new Error("fail");

        Pikachu.usar_movimiento(0,Jigglypuff);
        if(Pikachu.get_experiencia() != 42530) throw new Error("fail");
        if(Jigglypuff.get_puntosVida() != 0) throw new Error("fail");
    }
}
