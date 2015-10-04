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
		
		
		JButton arriba = new JButton(new ImageIcon("Arriba.PNG"));
		arriba.setBounds(55, 20, 35, 35);
		this.add(arriba);
		
		JButton izq = new JButton(new ImageIcon("izq.PNG"));
		izq.setBounds(20, 40, 35, 35);
		this.add(izq);
		
		JButton der = new JButton(new ImageIcon("der.PNG"));
		der.setBounds(90, 40, 35, 35);		
		this.add(der);
		
		
		JButton abajo = new JButton(new ImageIcon("abajo.PNG"));
		abajo.setBounds(55, 55, 35, 35);
		this.add(abajo);
		
		
		JButton mas = new JButton(new ImageIcon("mas.PNG"));
		mas.setBounds(20, 550, 40, 40);
		this.add(mas);
		
		JButton menos = new JButton(new ImageIcon("menos.PNG"));
		menos.setBounds(60, 550, 40, 40);
		this.add(menos);
	
		
		JButton rotar = new JButton(new ImageIcon("rotar-izq.PNG"));
		rotar.setBounds(820, 20, 30, 30);
		this.add(rotar);
			
		JButton rotarDer = new JButton(new ImageIcon("rotar-der.PNG"));
		rotarDer.setBounds(850, 20, 30, 30);
		this.add(rotarDer);
			
		
		
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
