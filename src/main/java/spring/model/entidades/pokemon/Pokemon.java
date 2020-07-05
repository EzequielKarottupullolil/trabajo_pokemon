package spring.model.entidades.pokemon;

import spring.model.utilidad.movimientos.Movimiento;

import java.util.ArrayList;

public class Pokemon {
	protected double pV_inicial;
	protected double experiencia;
	protected double puntos_vida;
	protected String nombre;
	protected ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	public double get_nivel(){
		return Math.floor(Math.pow(this.experiencia,1.0/7));
	}

	public double calcular_grositud(){
		double barbarosidad = 0.0;
		for (Movimiento movimiento : this.movimientos) {
			barbarosidad += movimiento.get_stats();
		}
		return this.get_nivel()*(barbarosidad);
	}
	public ArrayList<Movimiento> get_movimientos(){
		return  this.movimientos;
	}
	public double get_puntosVida(){
		return this.puntos_vida;
	}

	public void set_puntosVida(double cant){
		this.puntos_vida = cant;
	}

	public void usar_movimiento(Integer indice_movimiento,Pokemon pokemon_objetivo){
		if(this.puntos_vida <= 0) return;
		Movimiento movimiento = this.movimientos.get(indice_movimiento);
		movimiento.aplicar(pokemon_objetivo);
		if(pokemon_objetivo.get_puntosVida() <= 0) this.experiencia += 480;

	}
	public Pokemon(String nombre,double puntos_vida,double experiencia,ArrayList<Movimiento> movimientos){
		this.nombre = nombre;
		this.experiencia = experiencia;
		this.movimientos = movimientos;
		this.puntos_vida = puntos_vida;
		this.pV_inicial = puntos_vida;
	}

	public double get_experiencia() {
		return this.experiencia;
	}

	public double getpV_inicial(){
		return this.pV_inicial;
	}
}
