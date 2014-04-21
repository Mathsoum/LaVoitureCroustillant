package applicationsimulateur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;

@SuppressWarnings( "serial" )
public class DessinVoiture extends JFrame {
	public static final int TAILLE_FENETRE_EN_PIXEL = 500;
	public static final int POSITION_Y = 200;
	
	private static final int DEMI_LONGUEUR_VOITURE = 20;
	private static final int DEMI_LARGEUR_VOITURE = 10;
	
	private static final Color COULEUR_VOITURE = Color.RED;
	private static final Color COULEUR_PAREBRISE = Color.WHITE;
	private static final Color COULEUR_DEFAUT = Color.BLACK;
	
	private int xPixelVoiture = 0;
	private int yPixelVoiture = 0;

	public DessinVoiture() {
		super();
		this.setTitle( "Simulateur de Voiture" );
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
	
	@Override
	public void paint( Graphics graphics ) {
		super.paint( graphics );
		
		dessinerVoiture( this.xPixelVoiture, graphics );
	}

	public void dessinerVoiture( int xPixelVoiture, Graphics graphics ) {
		dessinerCarosserie( xPixelVoiture, graphics );
		dessinerParebrise( xPixelVoiture, graphics );
		graphics.setColor( COULEUR_DEFAUT );
	}

	private void dessinerCarosserie( int xPixelVoiture, Graphics graphics ) {
		graphics.setColor( COULEUR_VOITURE );
		Polygon carosserie = new Polygon();
		carosserie.addPoint( xPixelVoiture - DEMI_LONGUEUR_VOITURE, yPixelVoiture - DEMI_LARGEUR_VOITURE ); 
		carosserie.addPoint( xPixelVoiture - DEMI_LONGUEUR_VOITURE, yPixelVoiture + DEMI_LARGEUR_VOITURE );
		carosserie.addPoint( xPixelVoiture + DEMI_LONGUEUR_VOITURE, yPixelVoiture + DEMI_LARGEUR_VOITURE );
		carosserie.addPoint( xPixelVoiture + DEMI_LONGUEUR_VOITURE, yPixelVoiture - DEMI_LARGEUR_VOITURE );
		graphics.fillPolygon( carosserie );
	}

	private void dessinerParebrise( int xPixelVoiture, Graphics graphics ) {
		graphics.setColor( COULEUR_PAREBRISE );
		Polygon parebrise = new Polygon();
		parebrise.addPoint( xPixelVoiture, yPixelVoiture - DEMI_LARGEUR_VOITURE );
		parebrise.addPoint( xPixelVoiture, yPixelVoiture + DEMI_LARGEUR_VOITURE );
		parebrise.addPoint( xPixelVoiture + DEMI_LONGUEUR_VOITURE, yPixelVoiture );
		graphics.fillPolygon( parebrise );
	}
}
