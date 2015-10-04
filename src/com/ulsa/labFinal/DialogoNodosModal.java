package com.ulsa.labFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DialogoNodosModal extends JDialog {
	
	private JButton aceptar = null;
	private JButton cancelar = null;
	private LinkedList<Punto> puntos = null;
	private LinkedList<Componentes> componentes = null;
	private DialogoNodosModal d = this;
	private PanelIngresarNumeroPuntos panelIngresar = null;
	private VentanaPrincipal ventana = null;
	private PanelComponentes panel = null;
	
	public DialogoNodosModal(VentanaPrincipal padre, boolean modal, int noPuntos) {
		super(padre, modal);
		this.ventana = padre;
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.puntos = new LinkedList<>();
		this.componentes = new LinkedList<>();
		this.panel = new PanelComponentes(noPuntos);
	// Agregar puntos a la lista
		for (int i = 0; i < noPuntos; i++) {
			this.puntos.add(new Punto("Punto " + (i + 1)));
			
		}
			
		
	// Dibujar los componentes dependiendo del numero de puntos
		for (int i = 0; i < noPuntos; i++) {
			JLabel nodo = new JLabel(this.puntos.get(i).getNombre());
				nodo.setBounds(20, (i * 30 + 30), 100, 20);
			JLabel eX = new JLabel("X:");
				eX.setBounds(130, (i * 30 + 30), 40, 20);
				this.panel.add(eX);
			JTextField x = new JTextField();
				x.setBounds(180, (i * 30 + 30), 100, 20);
				JLabel eY = new JLabel("Y:");
				eY.setBounds(290, (i * 30 + 30), 40, 20);
				this.panel.add(eY);
			JTextField y = new JTextField();
				y.setBounds(340, (i * 30 + 30), 100, 20);
			JLabel pareja = new JLabel("Se une a:");
				pareja.setBounds(450, (i * 30 + 30), 100, 20);
				this.panel.add(pareja);
			JComboBox<String> combo = new JComboBox<>();
				combo.setBounds(550, (i * 30 + 30), 100, 20);
				
			
					for(Punto p : this.puntos) {
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
				this.componentes.add(c);
				this.agregarComponentes(c, this.panel);
		}
		
		this.aceptar = new JButton("Aceptar");
		this.aceptar.setBounds(300, 340, 100, 20);
		this.aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean campoVacio = false;
				for(int i = 0; i < d.getPuntos().size(); i++) {
					if ((d.getComponentes().get(i).getX().getText().equals("")) || 
							(d.getComponentes().get(i).getY().getText().equals(""))) 
						campoVacio = true;
				}
				
				if (campoVacio)
					JOptionPane.showMessageDialog(d, "Por favor llena todos los campos");
				else {
					int indice = 0;
					Punto pAdy = null;
					int x = 0;
					int y = 0;
					for(int i = 0; i < d.getPuntos().size(); i++) {
						indice = d.getComponentes().get(i).getPar().getSelectedIndex();
						pAdy = d.getPuntos().get(indice);
						x = Integer.parseInt(d.getComponentes().get(i).getX().getText());
						y = Integer.parseInt(d.getComponentes().get(i).getY().getText());
						System.out.println(x);
						d.getPuntos().get(i).setPuntoAdy(pAdy);
						d.getPuntos().get(i).setX(x);
						d.getPuntos().get(i).setY(y);
						x = y = 0;
					}
					d.getVentana().setPuntos(d.getPuntos());
					d.getVentana().setExito(1);
					d.dispose();
					
				}
			}
		});
		this.add(aceptar);
		
		this.cancelar = new JButton("Cancelar");
		this.cancelar.setBounds(420, 340, 100, 20);
		this.cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//v.exito = 0;
				d.dispose();
			}
			
		});
		this.add(cancelar);
		
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setBounds(10, 20, 700, 300);
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

	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public LinkedList<Punto> getPuntos() {
		return puntos;
	}

	public void setPuntos(LinkedList<Punto> puntos) {
		this.puntos = puntos;
	}

	public LinkedList<Componentes> getComponentes() {
		return componentes;
	}

	public void setComponentes(LinkedList<Componentes> componentes) {
		this.componentes = componentes;
	}

	public DialogoNodosModal getD() {
		return d;
	}

	public void setD(DialogoNodosModal d) {
		this.d = d;
	}

	public PanelIngresarNumeroPuntos getPanelIngresar() {
		return panelIngresar;
	}

	public void setPanelIngresar(PanelIngresarNumeroPuntos panelIngresar) {
		this.panelIngresar = panelIngresar;
	}

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public PanelComponentes getPanel() {
		return panel;
	}

	public void setPanel(PanelComponentes panel) {
		this.panel = panel;
	}
	
	

}
