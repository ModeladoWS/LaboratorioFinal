package com.ulsa.labFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DialogoNodosModal extends JDialog {
	
	JButton aceptar = null;
	JButton cancelar = null;
	LinkedList<Punto> puntos = new LinkedList<>();
	LinkedList<Componentes> componentes = new LinkedList<>();
	DialogoNodosModal d = this;
	PanelIngresarNumeroPuntos panelIngresar = null;
	VentanaPrincipal ventana = null;
	PanelComponentes panel = null;
	
	public DialogoNodosModal(JFrame padre, boolean modal, int noPuntos) {
		super(padre, modal);
		// this.ventana = padre;
		this.d = d;
		this.setSize(700, 420);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		
		this.panel = new PanelComponentes(noPuntos);
	// Agregar puntos a la lista
		for (int i = 0; i < noPuntos; i++) {
			puntos.add(new Punto("Punto " + (i + 1)));
		}
		
	// Dibujar los componentes dependiendo del numero de puntos
		for (int i = 0; i < noPuntos; i++) {
			JLabel nodo = new JLabel(puntos.get(i).getNombre());
				nodo.setBounds(20, (i * 30 + 30), 100, 20);
			JLabel eX = new JLabel("X:");
				eX.setBounds(130, (i * 30 + 30), 40, 20);
				panel.add(eX);
			JTextField x = new JTextField();
				x.setBounds(180, (i * 30 + 30), 100, 20);
				JLabel eY = new JLabel("Y:");
				eY.setBounds(290, (i * 30 + 30), 40, 20);
				panel.add(eY);
			JLabel pareja = new JLabel("Se une a:");
				nodo.setBounds(340, (i * 30 + 30), 100, 20);
			JTextField y = new JTextField();
				y.setBounds(450, (i * 30 + 30), 100, 20);
			JComboBox<String> combo = new JComboBox<>();
				combo.setBounds(550, (i * 30 + 30), 100, 20);
				
			
					for(Punto p : puntos) {
						combo.addItem(p.getNombre());
					}
					if (i != noPuntos - 1)
						combo.setSelectedIndex(i + 1);
					else
						combo.setSelectedIndex(0);
				
				Componentes c = new Componentes();
				c.setNombre(nodo);
				c.setX(x);
				c.setY(y);
				c.setPar(combo);
				componentes.add(c);
				this.agregarComponentes(c, panel);
		}
		
		aceptar = new JButton("Aceptar");
		aceptar.setBounds(300, 340, 100, 20);
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int indice = 0;
				Punto pAdy = null;
				int x = 0;
				int y = 0;
				for(int i = 0; i < puntos.size(); i++) {
					indice = componentes.get(i).getPar().getSelectedIndex();
					pAdy = puntos.get(indice);
					if (! (componentes.get(i).getX().getText().equals("")) && 
							!(componentes.get(i).getY().getText().equals(""))) {
						
						x = Integer.parseInt(componentes.get(i).getX().getText());
						y = Integer.parseInt(componentes.get(i).getY().getText());
						System.out.println(x);
					}
					puntos.get(i).setPuntoAdy(pAdy);
					puntos.get(i).setX(x);
					puntos.get(i).setY(y);
					x = y = 0;
				}
				//ventana.setPuntos = d.puntos;
				// ventana.setExito = 1;
				d.dispose();
				
			}
		});
		this.add(aceptar);
		
		this.cancelar = new JButton("Cancelar");
		cancelar.setBounds(420, 340, 100, 20);
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//v.exito = 0;
				d.dispose();
			}
			
		});
		this.add(cancelar);
		
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setBounds(10, 20, 590, 300);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scroll);
		this.setVisible(true);
	}
	
	private void agregarComponentes(Componentes c, JPanel p) {
		p.add(c.getNombre());
		p.add(c.getX());
		p.add(c.getY());
		p.add(c.getPar());
	}

}
