package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import spring.model.Pokemon;

public class PokemonTest {

	@Test
	public void test() {
		Pokemon pikachu = new Pokemon();
		assertEquals("PikaPika", pikachu.saludar());
	}

}
