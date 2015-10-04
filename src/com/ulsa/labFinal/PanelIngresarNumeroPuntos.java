package com.ulsa.labFinal;



import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private VentanaPrincipal ventana;
	private PanelIngresarNumeroPuntos panel = this;
	private PanelDibujo panelDibujo = null;
	
	public PanelIngresarNumeroPuntos(VentanaPrincipal v) {
		super.setBorder(titulo);
		this.ventana = v;
		this.setLayout(null);
		this.setSize(300, 200);
		this.panelDibujo = v.getPanelDibujo();
		
		this.noPuntos = new JLabel("No. Puntos:");
		this.noPuntos.setBounds(20, 50, 100, 20);
		this.add(noPuntos);
		
		SpinnerNumberModel modelo = new SpinnerNumberModel(2, 2, 100, 1);
		this.spinner = new JSpinner(modelo);
		this.spinner.setBounds(150, 50, 100, 20);
		this.add(spinner);
		
		this.agregar = new JButton("Agregar");
		this.agregar.setBounds(150, 120, 100, 20);
		this.agregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n = (int) panel.getSpinner().getValue();
				DialogoNodosModal d = new DialogoNodosModal(panel.ventana, true, n);
				if (panel.getVentana().getExito() == 1) {
					System.out.println("Aceptar");
					Graphics g = panel.getVentana().getPanelDibujo().getGraphics();
					panel.getVentana().iniciarDibujado(g);
				}
				else
					System.out.println("No Exito");
			}
			
		});
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

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public PanelIngresarNumeroPuntos getPanel() {
		return panel;
	}

	public void setPanel(PanelIngresarNumeroPuntos panel) {
		this.panel = panel;
	}

	public PanelDibujo getPanelDibujo() {
		return panelDibujo;
	}

	public void setPanelDibujo(PanelDibujo panelDibujo) {
		this.panelDibujo = panelDibujo;
	}
	
	

}
