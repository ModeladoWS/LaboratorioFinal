package com.ulsa.labFinal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
		
		JLabel trasladar = new JLabel("	TRASLADAR  : ");
		trasladar.setBounds(20, 15, 100, 35);
		this.add(trasladar);
		
		JButton arriba = new JButton(new ImageIcon("Arriba.png"));
		arriba.setBounds(60, 40, 35, 35);
		this.add(arriba);
		
		JButton izq = new JButton(new ImageIcon("izq.png"));
		izq.setBounds(25, 60, 35, 35);
		this.add(izq);
		
		JButton der = new JButton(new ImageIcon("der.png"));
		der.setBounds(95, 60, 35, 35);		
		this.add(der);
		
		
		JButton abajo = new JButton(new ImageIcon("abajo.png"));
		abajo.setBounds(60, 75, 35, 35);
		this.add(abajo);
		
		
		JLabel zoom = new JLabel("	ZOOM  : ");
		zoom.setBounds(20, 520, 80, 35);
		this.add(zoom);
		
		JButton mas = new JButton(new ImageIcon("mas.png"));
		mas.setBounds(20, 550, 40, 40);
		this.add(mas);
		
		JButton menos = new JButton(new ImageIcon("menos.png"));
		menos.setBounds(60, 550, 40, 40);
		this.add(menos);
	
		JLabel rotarI = new JLabel("	ROTAR  : ");
		rotarI.setBounds(820, 15, 100, 35);
		this.add(rotarI);
		
		JButton rotar = new JButton(new ImageIcon("rotar-izq.png"));
		rotar.setBounds(820, 40, 30, 30);
		this.add(rotar);
			
		JButton rotarDer = new JButton(new ImageIcon("rotar-der.png"));
		rotarDer.setBounds(850, 40, 30, 30);
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
