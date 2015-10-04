package com.ulsa.labFinal;

public class Punto {
	
	private String nombre;
	private double x;
	private double y;
	private Punto puntoAdy;
	
	public Punto(String n) {
		this.nombre = n;
	}
	
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Punto getPuntoAdy() {
		return puntoAdy;
	}
	public void setPuntoAdy(Punto puntoAdy) {
		this.puntoAdy = puntoAdy;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
