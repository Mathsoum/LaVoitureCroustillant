package domaineconduite;

import java.util.Observable;

public class Voiture extends Observable {

	private int coordXEnMetres;
	public static final int LIMITE_X_MIN = 0;
	public static final int LIMITE_X_MAX = 1000;

	private int coordYEnMetres;
	public static final int LIMITE_Y_MIN = 0;
	public static final int LIMITE_Y_MAX = 1000;

	private float angleDirection;
	private static final float ANGLE_DEFAUT = 0f;
	private static final float TICK_ANGLE_ROTATION = 30f;

	private int vitesseMetreParSecondes;
	private static final int VITESSE_DEFAUT = 0;
	private static final int TICK_ACCELERATION = 10;


	public Voiture( int coordXEnMetres, int coordYEnMetres ) {
		this( coordXEnMetres, coordYEnMetres, VITESSE_DEFAUT );
	}

	public Voiture( int coordXEnMetres, int coordYEnMetres, int vitesseMetreParSecondes ) {
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
		this.angleDirection = ANGLE_DEFAUT;
	}

	public int getCoordXEnMetres() {
		return coordXEnMetres;
	}

	public int getCoordYEnMetres() {
		return coordYEnMetres;
	}

	public float getAngle() {
		return angleDirection;
	}

	public void tourneADroite() {
		angleDirection += TICK_ANGLE_ROTATION;
	}
	
	public void tourneAGauche() {
		angleDirection -= TICK_ANGLE_ROTATION;
	}

	public int getVitesseMetreParSecondes() {
		return vitesseMetreParSecondes;
	}

	public void accelerer() {
		vitesseMetreParSecondes += TICK_ACCELERATION;		
	}

	public void ralentir() {
		vitesseMetreParSecondes -= TICK_ACCELERATION;
	}
	
	public void avancerEnFonctionDeLaVitesse() {
		coordXEnMetres += calculerDeltaX();
		verifierLimitesX();
		
		coordYEnMetres += calculerDeltaY();
		verifierLimitesY();

		notificationObservateurs();
	}

	private double calculerDeltaX() {
		return vitesseMetreParSecondes * Math.cos( Math.toRadians( angleDirection ) );
	}

	private double calculerDeltaY() {
		return vitesseMetreParSecondes * Math.sin( Math.toRadians( angleDirection ) );
	}

	private void verifierLimitesX() {
		coordXEnMetres = Math.max( coordXEnMetres, LIMITE_X_MIN );
		coordXEnMetres = Math.min( coordXEnMetres, LIMITE_X_MAX );
	}

	private void verifierLimitesY() {
		coordYEnMetres = Math.max( coordYEnMetres, LIMITE_Y_MIN );
		coordYEnMetres = Math.min( coordYEnMetres, LIMITE_Y_MAX );
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}

}
