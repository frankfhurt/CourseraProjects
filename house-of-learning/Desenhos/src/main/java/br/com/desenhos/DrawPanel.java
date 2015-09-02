package br.com.desenhos;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int i = 0;
		int w1 = 1;

		System.out.printf("\nLargura: %d", width);
		System.out.printf("\nAltura: %d", height);

		// g.drawLine(0, 0, width, height);
		// g.drawLine(0, height, width, 0);

		while (i < 15) {

			g.drawLine(0, 0, width - w1, height / 2);
			g.drawLine(0, height, width - w1, height / 2);
			g.drawLine(width, height, width - w1, height / 2);
			g.drawLine(width, 0, width - w1, height / 2);
			
			w1 = w1 + (width / 15);

			i++;

		}
		// g.drawLine(0, height, width, 0);

	}

}
