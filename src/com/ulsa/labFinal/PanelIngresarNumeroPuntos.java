package com.ulsa.labFinal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.Border;

public class PanelIngresarNumeroPuntos extends JPanel {
	
	Border titulo = BorderFactory.createTitledBorder("Usuario");

	
	private JSpinner spinner;
	private JLabel noPuntos;
	private JButton agregar;
	
	public PanelIngresarNumeroPuntos() {
		super.setBorder(titulo);
		
		// le ponemos layout null para que los botones se acomoden como nosotrso queremos
		this.setLayout(null);
		
		// Agreguen un Jlabel y un JSpinner aqui
		
		//this.setBounds(10, 10, 350, 100);
		// Para dar tamaño a una ventana se usa setSize, no setBounds
		this.setSize(300, 200);
		
		noPuntos = new JLabel("	No. Puntos :	");
		// falta el setbounds para noPuntos
		this.add(noPuntos);
		spinner = new JSpinner();
		// falta el setBounds para el spinner
		spinner.setValue(30);
		
		this.add(spinner);
		
		agregar = new JButton("Agregar", new ImageIcon("p.PNG"));
		// falta el setbounds para el boton Agregar
		this.add(agregar);
		
		
	}
	

}
