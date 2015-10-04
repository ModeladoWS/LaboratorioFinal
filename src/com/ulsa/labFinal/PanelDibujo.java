package com.ulsa.labFinal;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelDibujo extends JPanel {
	
	private Border titulo = BorderFactory.createTitledBorder("Plano");
	private LinkedList<Punto> puntos = null;
	static int escala = 15;
	
	private VentanaPrincipal ventana = null;  
	private PanelDibujo pd = this;
	
	public PanelDibujo(VentanaPrincipal v) {
		super.setBorder(titulo);
		this.setSize(900, 600);
		this.setLayout(null);	
		this.ventana = v;
		
		JLabel trasladar = new JLabel("	TRASLADAR  : ");
		trasladar.setBounds(20, 15, 100, 35);
		this.add(trasladar);
		
		JButton arriba = new JButton(new ImageIcon("Arriba.png"));
		arriba.setBounds(60, 40, 35, 35);
		arriba.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pd.puntos != null) {
					Graphics g = pd.getGraphics();
					double[] vTraslacion = {0, 1};
					pd.puntos = (LinkedList<Punto>) pd.trasladarFigura(g, pd.puntos, vTraslacion);
					pd.pintarFigura(g, pd.puntos);
				}
			}
			
		});
		this.add(arriba);
		
		JButton izq = new JButton(new ImageIcon("izq.png"));
		izq.setBounds(25, 60, 35, 35);
		izq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pd.puntos != null) {
					Graphics g = pd.getGraphics();
					double[] vTraslacion = {-1, 0};
					pd.puntos = (LinkedList<Punto>) pd.trasladarFigura(g, pd.puntos, vTraslacion);
					pd.pintarFigura(g, pd.puntos);
				}
			}
			
		});
		this.add(izq);
		
		JButton der = new JButton(new ImageIcon("der.png"));
		der.setBounds(95, 60, 35, 35);
		der.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pd.puntos != null) {
					Graphics g = pd.getGraphics();
					double[] vTraslacion = {1, 0};
					pd.puntos = (LinkedList<Punto>) pd.trasladarFigura(g, pd.puntos, vTraslacion);
					pd.pintarFigura(g, pd.puntos);
				}
			}
			
		});
		this.add(der);
		
		
		JButton abajo = new JButton(new ImageIcon("abajo.png"));
		abajo.setBounds(60, 75, 35, 35);
		abajo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pd.puntos != null) {
					Graphics g = pd.getGraphics();
					double[] vTraslacion = {0, -1};
					pd.puntos = (LinkedList<Punto>) pd.trasladarFigura(g, pd.puntos, vTraslacion);
					pd.pintarFigura(g, pd.puntos);
				}
			}
			
		});
		this.add(abajo);
		
		
		JLabel zoom = new JLabel("	ZOOM  : ");
		zoom.setBounds(20, 520, 80, 35);
		this.add(zoom);
		
		JButton mas = new JButton(new ImageIcon("mas.png"));
		mas.setBounds(20, 550, 40, 40);
		mas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pd.puntos != null) {
					Graphics g = pd.getGraphics();
					double k = 1.1;
					pd.puntos = (LinkedList<Punto>) pd.escalarFigura(g, pd.puntos, k, 2);
					pd.pintarFigura(g, pd.puntos);
				}
			}
			
		});
		this.add(mas);
		
		JButton menos = new JButton(new ImageIcon("menos.png"));
		menos.setBounds(60, 550, 40, 40);
		menos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pd.puntos != null) {
					Graphics g = pd.getGraphics();
					double k = 0.9;
					pd.puntos = (LinkedList<Punto>) pd.escalarFigura(g, pd.puntos, k, 2);
					pd.pintarFigura(g, pd.puntos);
				}
			}
			
		});
		this.add(menos);
	
		JLabel rotarI = new JLabel("	ROTAR  : ");
		rotarI.setBounds(820, 15, 100, 35);
		this.add(rotarI);
		
		JButton rotar = new JButton(new ImageIcon("rotar-izq.png"));
		rotar.setBounds(820, 40, 30, 30);
		rotar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pd.puntos != null) {
					Graphics g = pd.getGraphics();
					double angulo = 9;
					pd.puntos = (LinkedList<Punto>) pd.rotarFigura(g, pd.puntos, angulo, 2);
					pd.pintarFigura(g, pd.puntos);
				}
				
			}
			
		});
		this.add(rotar);
			
		JButton rotarDer = new JButton(new ImageIcon("rotar-der.png"));
		rotarDer.setBounds(850, 40, 30, 30);
		rotarDer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (pd.puntos != null) {
					Graphics g = pd.getGraphics();
					double angulo = -9;
					pd.puntos = (LinkedList<Punto>) pd.rotarFigura(g, pd.puntos, angulo, 2);
					pd.pintarFigura(g, pd.puntos);
				}
			}
			
		});
		this.add(rotarDer);
	}
	
	public void pintarFigura(Graphics g, List<Punto> puntos) {
		super.paint(g);
		this.puntos = (LinkedList<Punto>) puntos;
		for(Punto p : puntos) {
			g.drawLine(toX(p.getX()), toY(p.getY()), toX(p.getPuntoAdy().getX()), toY(p.getPuntoAdy().getY()));
		}
	}
	
	private List<Punto> trasladarFigura(Graphics g, List<Punto> puntos, double[] vTraslacion) {
		Matriz m = new MatrizImpl();
		double[] nP = null;
		for(Punto p : puntos) {
			double[] puntoInicial = {p.getX(), p.getY()};
			nP = m.trasladar(puntoInicial, vTraslacion);
			p.setX(nP[0]);
			p.setY(nP[1]);
		}
		return puntos;
	}
	
	private List<Punto> rotarFigura(Graphics g, List<Punto> puntos, double angulo, int dimension) {
		double[] centro = this.getCentro(puntos);
		double[] vT = {-centro[0], -centro[1]};
		puntos = this.trasladarFigura(g, puntos, vT);
		Matriz m = new MatrizImpl();
		double[] nP = null;
		for(Punto p : puntos) {
			double[] puntoInicial = {p.getX(), p.getY()};
			nP = m.rotar(puntoInicial, angulo, dimension);
			p.setX(nP[0]);
			p.setY(nP[1]);
		}
		vT[0] = centro[0];
		vT[1] = centro[1];
		return this.trasladarFigura(g, puntos, vT);
		
	}
	
	private List<Punto> escalarFigura(Graphics g, List<Punto> puntos, double k, int dimension) {
		double[] centro = this.getCentro(puntos);
		double[] vT = {-centro[0], -centro[1]};
		this.trasladarFigura(g, puntos, vT);
		Matriz m = new MatrizImpl();
		double[] nP = null;
		for(Punto p : puntos) {
			double[] puntoInicial = {p.getX(), p.getY()};
			nP = m.escalar(puntoInicial, dimension, k);
			p.setX(nP[0]);
			p.setY(nP[1]);
		}
		vT[0] = centro[0];
		vT[1] = centro[1];
		return this.trasladarFigura(g, puntos, vT);
	}
	
	private double[] getCentro(List<Punto> puntos) {
		double mayor = puntos.get(0).getX();
		double menor = puntos.get(0).getX();
		double[] centro = new double[2];
		for(Punto p : puntos) {
			if (p.getX() >= mayor)
				mayor = p.getX();
			if (p.getX() < menor)
				menor = p.getX();
		}
		centro[0] = menor + ((mayor - menor) / 2);
		
		mayor = puntos.get(0).getY();
		menor = puntos.get(0).getY();
		for(Punto p : puntos) {
			if (p.getY() >= mayor)
				mayor = p.getY();
			if (p.getY() < menor)
				menor = p.getY();
		}
		centro[1] = menor + ((mayor - menor) / 2);
		
		System.out.println("x: " + centro[0] + " y: " + centro[1]);
		
		return centro;
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
	}
	
	private int toX(double x) {
		double centro = this.getWidth() / 2.0;
		return  (int)(centro + x * escala);
	}

	private  int toY(double y) {
		double centro = this.getHeight() / 2.0;
		return (int)(centro - y * escala);
	}
}
