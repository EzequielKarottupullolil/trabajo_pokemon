package spring.model.entidades.pokemon;

import spring.model.utilidad.movimientos.Movimiento;

import java.util.ArrayList;

public class Pokemon {
	protected double experiencia;
	protected String nombre;
	protected ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	public double get_nivel(){
		return Math.floor(Math.pow(this.experiencia,1.0/7));
	}

	public double calcular_grositud(){
		double barbarosidad = 0.0;
		for (Movimiento movimiento : this.get_movimientos()) {
			barbarosidad += movimiento.get_stats();
		}
		return barbarosidad*get_nivel();
	}
	public ArrayList<Movimiento> get_movimientos(){
		return  this.movimientos;
	}

	public Pokemon(String nombre,double experiencia,ArrayList<Movimiento> movimientos){
		this.nombre = nombre;
		this.experiencia = experiencia;
		this.movimientos = movimientos;
	}
}
