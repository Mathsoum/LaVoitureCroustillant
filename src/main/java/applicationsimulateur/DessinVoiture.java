package applicationsimulateur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

@SuppressWarnings( "serial" )
public class DessinVoiture extends JFrame {
	public static final int TAILLE_FENETRE_EN_PIXEL = 500;
	public static final String TITRE_FENETRE = "Simulateur de Voiture";
	public static final int POSITION_Y = 200;
	
	private static final int DEMI_LONGUEUR_VOITURE = 20;
	private static final int DEMI_LARGEUR_VOITURE = 10;
	
	private static final Color COULEUR_VOITURE = Color.RED;
	private static final Color COULEUR_PAREBRISE = Color.WHITE;
	private static final Color COULEUR_DEFAUT = Color.BLACK;
	
	private int xPixelVoiture = 0;
	private int yPixelVoiture = 0;
	private float angleVoiture = 0;

	public DessinVoiture() {
		super();
		this.setTitle( TITRE_FENETRE );
		this.setSize( TAILLE_FENETRE_EN_PIXEL, TAILLE_FENETRE_EN_PIXEL );
		this.setVisible( true );
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setXPixelVoiture( int xPixelVoiture ) {
		this.xPixelVoiture = xPixelVoiture;
	}
	public void setYPixelVoiture( int yPixelVoiture ) {
		this.yPixelVoiture = yPixelVoiture;
	}
	public void setAngleVoiture( float angleVoiture ) {
		this.angleVoiture = angleVoiture;
	}
	
	@Override
	public void paint( Graphics graphics ) {
		super.paint( graphics );
		dessinerVoiture(graphics);
	}

	public void dessinerVoiture(Graphics graphics ) {
		setTitle(TITRE_FENETRE 
				+ " - x,y = " + xPixelVoiture + "," + yPixelVoiture 
				+ " - Direction : " + angleVoiture);
		dessinerCarosserie(graphics );
		dessinerParebrise(graphics );
		graphics.setColor( COULEUR_DEFAUT );
	}

	private Point2D rotation(Point2D p, float angle) {
		float teta = (float) Math.toRadians( -angle );
		Point2D pPrime = new Point2D.Float();
		pPrime.setLocation(
				p.getX() * Math.cos( teta ) + (p.getY() * Math.sin( teta )),
				- p.getX() * Math.sin( teta ) + (p.getY() * Math.cos( teta )));
		return pPrime;
	}
	private void dessinerCarosserie(Graphics graphics ) {
		graphics.setColor( COULEUR_VOITURE );
		Polygon carosserie = new Polygon();
		
		Point2D p1 = new Point2D.Float();
		p1.setLocation(- DEMI_LONGUEUR_VOITURE, - DEMI_LARGEUR_VOITURE);
		p1 = rotation(p1, angleVoiture);
		carosserie.addPoint((int)(xPixelVoiture + p1.getX()), (int)(yPixelVoiture + p1.getY()));
		
		Point2D p2 = new Point2D.Float();
		p2.setLocation(- DEMI_LONGUEUR_VOITURE, DEMI_LARGEUR_VOITURE);
		p2 = rotation(p2, angleVoiture);
		carosserie.addPoint((int)(xPixelVoiture + p2.getX()), (int)(yPixelVoiture + p2.getY()));
		
		Point2D p3 = new Point2D.Float();
		p3.setLocation(DEMI_LONGUEUR_VOITURE, DEMI_LARGEUR_VOITURE);
		p3 = rotation(p3, angleVoiture);
		carosserie.addPoint((int)(xPixelVoiture + p3.getX()), (int)(yPixelVoiture + p3.getY()));
		
		Point2D p4 = new Point2D.Float();
		p4.setLocation(DEMI_LONGUEUR_VOITURE, - DEMI_LARGEUR_VOITURE);
		p4 = rotation(p4, angleVoiture);
		carosserie.addPoint((int)(xPixelVoiture + p4.getX()), (int)(yPixelVoiture + p4.getY()));

		graphics.fillPolygon( carosserie );
	}

	private void dessinerParebrise(Graphics graphics ) {
		graphics.setColor( COULEUR_PAREBRISE );
		
		Polygon parebrise = new Polygon();
		
		Point2D p1 = new Point2D.Float();
		p1.setLocation(0, - DEMI_LARGEUR_VOITURE);
		p1 = rotation(p1, angleVoiture);
		parebrise.addPoint((int)(xPixelVoiture + p1.getX()), (int)(yPixelVoiture + p1.getY()));
		
		Point2D p2 = new Point2D.Float();
		p2.setLocation(0, DEMI_LARGEUR_VOITURE);
		p2 = rotation(p2, angleVoiture);
		parebrise.addPoint((int)(xPixelVoiture + p2.getX()), (int)(yPixelVoiture + p2.getY()));
		
		Point2D p3 = new Point2D.Float();
		p3.setLocation(DEMI_LONGUEUR_VOITURE, 0);
		p3 = rotation(p3, angleVoiture);
		parebrise.addPoint((int)(xPixelVoiture + p3.getX()), (int)(yPixelVoiture + p3.getY()));

		graphics.fillPolygon( parebrise );
	}
}
