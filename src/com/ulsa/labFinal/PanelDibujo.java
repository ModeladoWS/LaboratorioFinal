package com.ulsa.labFinal;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelDibujo extends JPanel {
	Border blackline = BorderFactory.createLineBorder(Color.black);
	
	public PanelDibujo() {
		super.setBorder(blackline);
		
		// No agreguen nada aqui
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
}
