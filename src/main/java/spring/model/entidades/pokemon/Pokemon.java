package spring.model.entidades.pokemon;

import spring.model.entidades.entrenador.Entrenador;
import spring.model.utilidad.efectos.Efecto;
import spring.model.utilidad.movimientos.Movimiento;
import spring.model.utilidad.movimientos.Movimiento_curativo;
import spring.model.utilidad.movimientos.Movimiento_dañino;
import spring.model.utilidad.movimientos.Movimiento_especial;

import java.util.ArrayList;

public abstract class Pokemon {
	protected double pV_inicial;
	protected double experiencia;
	protected double puntos_vida;
	protected String nombre;
	protected ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
	protected ArrayList<Efecto> efectos = new ArrayList<Efecto>();

	@Override
	public String toString() {
		return "Pokemon{" +
				"nombre='" + nombre + '\'' +
				'}';
	}

	public Pokemon(String nombre, double puntos_vida, double experiencia) {
		this.nombre = nombre;
		this.puntos_vida = puntos_vida;
		this.experiencia = experiencia;
		this.pV_inicial = puntos_vida;
	}


	public double get_grositud(){
		double barbarosidad = 0;
		for (Movimiento movimiento : this.movimientos) {
			double bar_final = 0;
			if(movimiento instanceof Movimiento_dañino) {
				bar_final += movimiento.get_stats() * 2;
			}else{
				bar_final += movimiento.get_stats();
			}
			barbarosidad += bar_final;
		}
		return this.get_nivel()*(barbarosidad);
	}
	public ArrayList<Movimiento> get_movimientos(){
		return  this.movimientos;

	}
	public void set_efecto(Efecto efecto){
		this.efectos.add(efecto);
	}
	public void vaciar_efectos(){
		this.efectos.clear();
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
	public double get_nivel(){
		return Math.floor(Math.pow(this.experiencia,1.0/7));
	}
	public double get_experiencia() {
		return this.experiencia;
	}
	public double get_puntosVida(){
		return this.puntos_vida;
	}
	public double get_pVinicial(){
		return this.pV_inicial;
	}

	public String get_nombre() {
		return this.nombre;
	}

	public ArrayList<Efecto> get_efectos(){
		return this.efectos;
	}

	public boolean es_conveniente(int indice_movimiento, Pokemon pokemon_objetivo){
		Movimiento movimiento = this.movimientos.get(indice_movimiento);
		double mitad_vida = pokemon_objetivo.get_pVinicial() / 2;

		//Si los stats del movimiento superan la vida del pokemon mas 50 regresa false
		if(movimiento.get_stats() > pokemon_objetivo.get_puntosVida() + 50) return false;
		//Si el movimiento es curativo
		if(movimiento instanceof Movimiento_curativo) {
			//Y el pokemon tiene mas de la mita de la vida regresa false
			if (pokemon_objetivo.get_puntosVida() > mitad_vida) return false;
		}
		//Si el movimiento es especial y el pokemon objetivo es mas groso regresa false
		if(movimiento instanceof Movimiento_especial){
			if(pokemon_objetivo.get_grositud() < this.get_grositud()) return false;
			if(!(pokemon_objetivo.estoy_normal())) return false;
		}
		return true;
	}

    public void set_experiencia(int exp) {
		this.experiencia = exp;
    }

    public boolean estoy_normal(){
		return this.efectos.size() < 1;
	}
}
