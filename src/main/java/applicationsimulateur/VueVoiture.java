package applicationsimulateur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import domaineconduite.Voiture;

public class VueVoiture implements Observer {

	private class RotationListener implements KeyListener {
		
		public void keyTyped( KeyEvent e ) {
		}

		public void keyPressed( KeyEvent e ) {
			if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
				voiture.tourneADroite();
			}
			else if ( e.getKeyCode() == KeyEvent.VK_LEFT ) {
				voiture.tourneAGauche();
			}
		}

		public void keyReleased( KeyEvent e ) {
		}
		
	}
	
	private class VitesseListener implements KeyListener {
		public void keyTyped( KeyEvent event ) {
		}

		public void keyPressed( KeyEvent event ) {
			if ( event.getKeyCode() == KeyEvent.VK_UP ) {
				voiture.accelerer();
			}
			else if ( event.getKeyCode() == KeyEvent.VK_DOWN ) {
				voiture.ralentir();
			}
		}

		public void keyReleased( KeyEvent event ) {
		}
		
	}

	private Voiture voiture;
	private DessinVoiture ihm;

	public VueVoiture( Voiture voiture, DessinVoiture ihm ) {
		this( voiture );
		
		this.ihm = ihm;
		ihm.addKeyListener( new RotationListener() );
		ihm.addKeyListener( new VitesseListener() );
	}
	
	public VueVoiture( Voiture voiture ) {
		this.voiture = voiture;
		this.voiture.addObserver( this );
	}
	
	public VueVoiture() {
		
	}

	public void update( Observable unused0, Object unused1 ) {

		int xVoiture = this.voiture.getCoordXEnMetres();
		int xPixelVoiture = this.transformerMetrePixel( xVoiture );
		this.ihm.setXPixelVoiture( xPixelVoiture );
		
		int yVoiture = this.voiture.getCoordYEnMetres();
		int yPixelVoiture = this.transformerMetrePixel( yVoiture );
		this.ihm.setYPixelVoiture( yPixelVoiture );
		
		this.ihm.setAngleVoiture( this.voiture.getAngle() );
		
		this.ihm.repaint();
	}

	public int transformerMetrePixel( int coordonneeXEnMetre ) {
		int ratioDomaineFenetre = Voiture.LIMITE_X_MAX / DessinVoiture.TAILLE_FENETRE_EN_PIXEL;
		int coordonneeXEnPixels = coordonneeXEnMetre / ratioDomaineFenetre;

		return coordonneeXEnPixels;
	}

}
