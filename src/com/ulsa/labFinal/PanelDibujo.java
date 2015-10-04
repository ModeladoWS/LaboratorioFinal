package com.ulsa.labFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelDibujo extends JPanel {
	Border titulo = BorderFactory.createTitledBorder("Plano");
	
	public static final int ANCHO = 500;
	public static final int ALTO = 500;
	static int escala = 15;
	
	public PanelDibujo() {
		super.setBorder(titulo);
		this.setSize(900, 600);
		this.setLayout(null);
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	public void repintar(Graphics g) {
		super.paint(g);
	}
	
	private static int ConvertirUnidadesX(double x) {
		double centro = ANCHO / 2.0;
		return  (int)(centro + x * escala);
	}

	private static int ConvertirUnidadesY(double y) {
		double centro = ALTO / 2.0;
		return (int)(centro - y * escala);
	}
}
