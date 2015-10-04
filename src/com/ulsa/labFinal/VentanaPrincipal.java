package com.ulsa.labFinal;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class VentanaPrincipal extends JFrame {
	
	private PanelDibujo panelDibujo = null;
	private PanelIngresarNumeroPuntos panelIngresar = null;
	
	public VentanaPrincipal() {
		
		// Agreguen el PanelIngresarPuntos a la izquierda y 
		// el PanelDibujo a la derecha, como en el dibujito
		
		// Tambien agreguen los botones de: subir, bajar, rotar, acercar y  alejar
		// tambien como en el dibujito
		panelIngresar = new PanelIngresarNumeroPuntos();
		panelIngresar.setLocation(20, 10);
		super.add(panelIngresar);
		
		panelDibujo = new PanelDibujo();
		panelDibujo.setLocation(340, 10);
		super.add(panelDibujo);
	}

}
