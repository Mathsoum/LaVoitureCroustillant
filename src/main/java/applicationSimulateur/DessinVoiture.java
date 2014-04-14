package applicationSimulateur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;

public class DessinVoiture extends JFrame {

	public static final int TAILLE_FENETRE_EN_PIXEL = 500;
	public static final int POSITION_Y = 200;
	
	private int xPixelVoiture;

	public DessinVoiture() {
		super();
		this.setTitle("Simulateur de Voiture");
		this.setSize(TAILLE_FENETRE_EN_PIXEL, TAILLE_FENETRE_EN_PIXEL);
		this.setVisible(true);
		this.xPixelVoiture = 0;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(this.xPixelVoiture, graphics);

	}

	public void dessinerVoiture(int xPixelVoiture, Graphics graphics) {
		
		
		graphics.setColor(Color.RED);
		Polygon rectangle = new Polygon();
		rectangle.addPoint(xPixelVoiture - 20, POSITION_Y - 10);
		rectangle.addPoint(xPixelVoiture - 20, POSITION_Y + 10);
		rectangle.addPoint(xPixelVoiture + 20, POSITION_Y + 10);
		rectangle.addPoint(xPixelVoiture + 20, POSITION_Y - 10);
		graphics.fillPolygon(rectangle);
		
		graphics.setColor(Color.WHITE);
		Polygon triangle = new Polygon();
		triangle.addPoint(xPixelVoiture, POSITION_Y - 10);
		triangle.addPoint(xPixelVoiture, POSITION_Y + 10);
		triangle.addPoint(xPixelVoiture +20, POSITION_Y);
		graphics.fillPolygon(triangle);
		graphics.setColor(Color.BLACK);

	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}
}
