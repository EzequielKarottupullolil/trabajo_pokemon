package spring.model.entidades.pokemon;

public class Pokemon {
	protected double experiencia;

	public double get_nivel(){
		return Math.pow(7,this.experiencia);
	}

	public double calcular_grositud(){
		return 1.0;
	}

	public Pokemon(double experiencia){
		this.experiencia = experiencia;
	}
}
