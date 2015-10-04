package com.ulsa.labFinal;

public interface Matriz {
	
	public double[] trasladar(double[] puntoInicial, double[] vectorTraslacion);
	
	public double[] escalar(double[] puntoInicial, int dimension, double k);
	
	public double[] rotar(double[] puntoInicial, double angulo, int dimension);

}
