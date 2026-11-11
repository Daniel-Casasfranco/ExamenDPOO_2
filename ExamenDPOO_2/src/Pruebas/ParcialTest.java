package Pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import Modelo.Cuadratica;
import Modelo.Logica;


public class ParcialTest {

	private Logica parcial;

	@BeforeEach
	public void setUp() {
		parcial = new Logica();
	}

	@AfterEach
	public void breakDown() {}

	@Test
	public void testDosRaicesReales() {
		assertEquals("x1 = 3.0, x2 = 2.0", parcial.calcularRaices(1, -5, 6));
	}

	@Test
	public void testRaizDoble() {
		assertEquals("Raiz doble: x1 = x2 = -1.0", parcial.calcularRaices(1, 2, 1));
	}

	@Test
	public void testRaizDobleCeroSinSignoNegativo() {
		assertEquals("Raiz doble: x1 = x2 = 0.0", parcial.calcularRaices(1, 0, 0));
	}


	@Test
	public void testANaN() {
		assertEquals("Error de parametros: Los coeficientes deben ser numeros validos (NaN no permitido).",
				parcial.calcularRaices(Double.NaN, 1, 1));
	}

	@Test
	public void testBNaN() {
		assertEquals("Error de parametros: Los coeficientes deben ser numeros validos (NaN no permitido).",
				parcial.calcularRaices(1, Double.NaN, 1));
	}

	@Test
	public void testCNaN() {
		assertEquals("Error de parametros: Los coeficientes deben ser numeros validos (NaN no permitido).",
				parcial.calcularRaices(1, 1, Double.NaN));
	}

	@Test
	public void testACero() {
		assertEquals("Error matematico: a no puede ser 0, (division por cero).",
				parcial.calcularRaices(0, 2, 1));
	}


	@Test
	public void testDiscriminanteNaN() {
		assertEquals("Error matematico: El discriminante no existe.",
				parcial.calcularRaices(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
	}

	@Test
	public void testRaicesComplejas() {
		assertEquals("Error matematico: El discriminante es negativo Raices complejas",
				parcial.calcularRaices(1, 0, 1));
	}

	@Test
	public void testConObjetoCuadratica() {
		assertEquals("x1 = 3.0, x2 = 2.0", parcial.calcularRaices(new Cuadratica(1, -5, 6)));
	}

	@Test
	public void testCuadraticaNula() {
		assertEquals("Error de parametros: La ecuacion no puede ser nula.", parcial.calcularRaices((Cuadratica) null));
	}
}
