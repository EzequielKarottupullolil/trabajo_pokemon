package spring;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
import spring.model.utilidad.objetos.Medicina;
import spring.model.utilidad.objetos.Medicina_especial;
import spring.model.utilidad.objetos.Pokebola;

import javax.swing.*;
import java.util.ArrayList;

public class Objetos_test {
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
        ciudad_test.agregar_pokemon_salvaje(Pikachu);
        ciudad_test.agregar_entrenador(Ash);
        ciudad_test.agregar_entrenador(Misty);

        //Usar una pokebola sobre Jigglypuff debería producir un error porque no es salvaje.
        Pokebola pokebola = new Pokebola();
        Misty.agregar_objeto(pokebola);

        try{
            Misty.capturar_pokemon(Jigglypuff);
        }catch (Error e){
            System.out.println(e.toString());
        }
        //Usar una pokebola sobre Pikachu no debería surtir efecto por no estar medio muerto.
        try{
            Misty.capturar_pokemon(Pikachu);
        }catch (Error e){
            System.out.println(e.toString());
        }
        //Si Pikachu tiene un HP actual de 40 y Ash usa una pokebola, lo atrapa y deja de ser salvaje para
        //tener a Ash como entrenador.
        Pikachu.set_puntosVida(40);
        Ash.agregar_objeto(pokebola);
        Ash.capturar_pokemon(Pikachu);
        if(ciudad_test.get_pokemones_salvajes().contains(Pikachu)) throw new Error("fail");
        Pokemon_entrenado Pikachu_de_ash = Ash.get_pokemones().get(1);

        //Si se usa una medicina sobre Pikachu, queda con su HP igual a su Máximo HP
        Medicina medicina = new Medicina();
        Ash.agregar_objeto(medicina);
        Ash.usar_objeto(1,Pikachu_de_ash);
        if(Pikachu_de_ash.get_puntosVida() != Pikachu_de_ash.get_pVinicial()) throw new Error("fail");
//        Si se usa una medicina sobre Jigglypuff, queda con 70 hps.
        Ash.agregar_objeto(medicina);
        Ash.usar_objeto(1,Jigglypuff);
        if(Jigglypuff.get_puntosVida() != 70) throw new Error("fail");

        //Pikachu usa impactrueno por lo que Jigglypuff tendra paralisis
        Pikachu_de_ash.usar_movimiento(0,Jigglypuff);
        if(Jigglypuff.get_efectos().size() < 1) throw new Error("fail");

        //Ash usa medicina especial en Jigglypuff por lo que paralisis deja de efectuar
        Medicina_especial medicina_especial = new Medicina_especial();
        Ash.agregar_objeto(medicina_especial);
        Ash.usar_objeto(1,Jigglypuff);
        if(Jigglypuff.get_efectos().size() > 1) throw new Error("fail");
    }
}
