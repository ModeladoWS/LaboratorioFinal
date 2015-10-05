package com.ulsa.labFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class VentanaPrincipal extends JFrame {

	private PanelDibujo panelDibujo = null;
	private PanelIngresarNumeroPuntos panelIngresar = null;
	private LinkedList<Punto> puntos;
	private int exito = 0;

	public VentanaPrincipal() {

		// Agreguen el PanelIngresarPuntos a la izquierda y 
		// el PanelDibujo a la derecha, como en el dibujito

		// Tambien agreguen los botones de: subir, bajar, rotar, acercar y  alejar
		// tambien como en el dibujito
		this.puntos = null;
		panelIngresar = new PanelIngresarNumeroPuntos(this);
		panelIngresar.setLocation(20, 10);
		super.add(panelIngresar);

		panelDibujo = new PanelDibujo(this);
		panelDibujo.setLocation(340, 10);
		super.add(panelDibujo);
		
	}
	
	public void iniciarDibujado(Graphics g) {
		this.panelDibujo.pintarFigura(g, this.puntos);
	}
	
	public LinkedList<Punto> getPuntos() {
		return puntos;
	}


	public void setPuntos(LinkedList<Punto> puntos) {
		this.puntos = puntos;
	}


	public int getExito() {
		return exito;
	}


	public void setExito(int exito) {
		this.exito = exito;
	}

	public PanelDibujo getPanelDibujo() {
		return panelDibujo;
	}

	public void setPanelDibujo(PanelDibujo panelDibujo) {
		this.panelDibujo = panelDibujo;
	}

	public PanelIngresarNumeroPuntos getPanelIngresar() {
		return panelIngresar;
	}

	public void setPanelIngresar(PanelIngresarNumeroPuntos panelIngresar) {
		this.panelIngresar = panelIngresar;
	}

	
	
}
