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
	Border titulo = BorderFactory.createTitledBorder(null,"Plano");
	
	public static final int ANCHO = 500;
	public static final int ALTO = 500;
	static int escala = 15;
	
	public PanelDibujo() {
		super.setBorder(blackline);
		
		// No agreguen nada aqui :)
	}
	
	@Override
	public void paint(Graphics g){

		Graphics2D g2 = (Graphics2D) g;

		//Plano cartesiano
		g2.drawLine(ConvertirUnidadesX(-50),ConvertirUnidadesY(0),ConvertirUnidadesX(50),ConvertirUnidadesY(0));
		g2.drawLine(ConvertirUnidadesX(0),ConvertirUnidadesY(-50),ConvertirUnidadesX(0),ConvertirUnidadesY(50));

	
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
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
