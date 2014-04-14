package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {
	public static final int largeurDomaine = 1000;
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
		coordXEnMetres += vitesseMetreParSecondes;
		if(coordXEnMetres > largeurDomaine) {
			coordXEnMetres = largeurDomaine;
		}
		else if(coordXEnMetres < 0) {
			coordXEnMetres = 0;
		}
		coordXEnMetres += vitesseMetreParSecondes * Math.cos(Math.toRadians(angleDirection));
		coordYEnMetres += vitesseMetreParSecondes * Math.sin(Math.toRadians(angleDirection));
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

	public void accelerer() {
		vitesseMetreParSecondes += 10;		
	}

	public void ralentir() {
		vitesseMetreParSecondes -= 10;
	}
}
