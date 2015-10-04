package com.ulsa.labFinal;
import java.awt.Dimension;

import javax.swing.JPanel;


public class PanelComponentes extends JPanel {
	
	private int tamano = 0;
	
	public PanelComponentes(int n) {
		this.setLayout(null);
		this.tamano = n;
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(560, (this.tamano + 2) * 30);
    }

}
