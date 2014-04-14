package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {

	public static final int LIMITE_X_MIN = 0;
	public static final int LIMITE_X_MAX = 1000;
	
	public static final int LIMITE_Y_MIN = 0;
	public static final int LIMITE_Y_MAX = 1000;
	
	private static final float TICK_ANGLE_ROTATION = 30;

	private float angleDirection;
	private int coordXEnMetres;
	private int coordYEnMetres;
	private int vitesseMetreParSecondes;

	public Voiture(int coordXEnMetres, int coordYEnMetres) {
		this(coordXEnMetres, coordYEnMetres, 0);
	}

	public Voiture(int coordXEnMetres, int coordYEnMetres, int vitesseMetreParSecondes) {
		this.coordXEnMetres = coordXEnMetres;
		this.coordYEnMetres = coordYEnMetres;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
		this.angleDirection = 0;
	}

	public int getCoordXEnMetres() {
		return coordXEnMetres;
	}

	public int getCoordYEnMetres() {
		return coordYEnMetres;
	}

	public int getVitesseMetreParSecondes() {
		return vitesseMetreParSecondes;
	}

	public void avancerEnFonctionDeLaVitesse() {
		coordXEnMetres += vitesseMetreParSecondes * Math.cos(Math.toRadians(angleDirection));
		coordXEnMetres = Math.max(coordXEnMetres, LIMITE_X_MIN);
		coordXEnMetres = Math.min(coordXEnMetres, LIMITE_X_MAX);
		
		
		coordYEnMetres += vitesseMetreParSecondes * Math.sin(Math.toRadians(angleDirection));
		coordYEnMetres = Math.max(coordYEnMetres, LIMITE_Y_MIN);
		coordYEnMetres = Math.min(coordYEnMetres, LIMITE_Y_MAX);

		notificationObservateurs();
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}

	public float getAngle() {
		return angleDirection;
	}

	public void tourneADroite() {
		angleDirection -= TICK_ANGLE_ROTATION;
	}
	public void tourneAGauche() {
		angleDirection += TICK_ANGLE_ROTATION;
	}
}
