package Modelo;

public class Logica {

	public String calcularRaices(double a, double b, double c) {
		try {
			
			
			if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
				
				throw new IllegalArgumentException("Los coeficientes deben ser numeros validos (NaN no permitido).");
			}

			if (a == 0) {
				throw new ArithmeticException("a no puede ser 0, (division por cero).");
			}

			double discriminante = b * b - 4 * a * c;
			
			if (Double.isNaN(discriminante)) {
				throw new ArithmeticException("El discriminante no existe.");
			}

			if (discriminante < 0) {
				throw new ArithmeticException("El discriminante es negativo Raices complejas");
			}

			double raiz = Math.sqrt(discriminante);
			double x1 = (-b + raiz) / (2 * a);
			double x2 = (-b - raiz) / (2 * a);


			if (discriminante == 0) {
				return "Raiz doble: x1 = x2 = " + x1;
			}
			return "x1 = " + x1 + ", x2 = " + x2;

		} catch (IllegalArgumentException e) {
			return "Error de parametros: " + e.getMessage();
			
		} catch (ArithmeticException e) {
			return "Error matematico: " + e.getMessage();
		}
	}

	public String calcularRaices(Cuadratica ecuacion) {
		try {
			if (ecuacion == null) {
				throw new NullPointerException("La ecuacion no puede ser nula.");
			}
			return calcularRaices(ecuacion.getA(), ecuacion.getB(), ecuacion.getC());
		} catch (NullPointerException e) {
			return "Error de parametros: " + e.getMessage();
		}
	}
}