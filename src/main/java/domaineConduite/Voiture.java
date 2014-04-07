package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {
	private static final float TICK_ANGLE_ROTATION = 30;
	private float angleDirection;
	private int coordXEnMetres;
	private int vitesseMetreParSecondes;

	public static final int largeurDomaine = 1000;

	public Voiture(int coordXEnMetres) {
		this(coordXEnMetres, 0);
	}

	public Voiture(int coordXEnMetres, int vitesseMetreParSecondes) {
		this.coordXEnMetres = coordXEnMetres;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
		this.angleDirection = 0;
	}

	public int getCoordXEnMetres() {
		return coordXEnMetres;
	}

	public int getVitesseMetreParSecondes() {
		return vitesseMetreParSecondes;
	}

	public void avancerEnFonctionDeLaVitesse() {
		coordXEnMetres += vitesseMetreParSecondes;
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
		angleDirection += TICK_ANGLE_ROTATION;
	}
	public void tourneAGauche() {
		angleDirection -= TICK_ANGLE_ROTATION;
	}
}
