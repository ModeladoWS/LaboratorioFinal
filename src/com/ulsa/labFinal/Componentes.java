package com.ulsa.labFinal;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Componentes {
	
	private JLabel nombre;
	private JTextField x;
	private JTextField y;
	private JComboBox par;
	
	public JLabel getNombre() {
		return nombre;
	}
	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}
	public JTextField getX() {
		return x;
	}
	public void setX(JTextField x) {
		this.x = x;
	}
	public JTextField getY() {
		return y;
	}
	public void setY(JTextField y) {
		this.y = y;
	}
	public JComboBox getPar() {
		return par;
	}
	public void setPar(JComboBox par) {
		this.par = par;
	}
	
	
}
