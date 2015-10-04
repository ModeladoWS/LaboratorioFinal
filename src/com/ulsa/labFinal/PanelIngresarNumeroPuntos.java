package com.ulsa.labFinal;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
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
		
		noPuntos = new JLabel("No. Puntos:");
		// falta el setbounds para noPuntos
		noPuntos.setBounds(20, 50, 100, 20);
		this.add(noPuntos);
		SpinnerNumberModel modelo = new SpinnerNumberModel(2, 2, 100, 1);
		spinner = new JSpinner(modelo);
		// falta el setBounds para el spinner
		spinner.setBounds(150, 50, 100, 20);
		this.add(spinner);
		
		agregar = new JButton("Agregar");
		// falta el setbounds para el boton Agregar
		agregar.setBounds(150, 120, 100, 20);
		this.add(agregar);
		
		
	}

	public Border getTitulo() {
		return titulo;
	}

	public void setTitulo(Border titulo) {
		this.titulo = titulo;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public JLabel getNoPuntos() {
		return noPuntos;
	}

	public void setNoPuntos(JLabel noPuntos) {
		this.noPuntos = noPuntos;
	}

	public JButton getAgregar() {
		return agregar;
	}

	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}
	
	

}
