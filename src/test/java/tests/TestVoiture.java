package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domaineConduite.Voiture;



public class TestVoiture {
	
	@Test
	public void testGetX(){
		Voiture voiture = new Voiture(20) ;
		
		int xVoiture = voiture.getCoordXEnMetres() ;
		
		assertEquals(20, xVoiture);
		
	}
	
	@Test
	public void testVitesseX() {
		Voiture voiture = new Voiture(20,150);
		
		assertEquals(150,voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		Voiture voiture = new Voiture(20,100);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(120, voiture.getCoordXEnMetres());
	}

	@Test
	public void testAngleDepart() {
		Voiture voiture = new Voiture(20,100);
		assertTrue(0 == voiture.getAngle());
	}

	@Test
	public void testAngleApresVirageADroite() {
		Voiture voiture = new Voiture(20);
		voiture.tourneADroite();
		assertTrue(30 == voiture.getAngle());
	}
	
	@Test
	public void testAngleApresVirageAGauche() {
		Voiture voiture = new Voiture(20);
		voiture.tourneAGauche();
		assertTrue(-30 == voiture.getAngle());
	}
	
	@Test
	public void testAngleApresPlusieursVirages() {
		Voiture voiture = new Voiture(20);
		voiture.tourneAGauche();
		voiture.tourneAGauche();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		assertTrue(30 == voiture.getAngle());
	}
}
