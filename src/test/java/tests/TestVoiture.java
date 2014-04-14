package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domaineConduite.Voiture;



public class TestVoiture {
	
	@Test
	public void testGetX(){
		Voiture voiture = new Voiture(20, 20) ;
		
		int xVoiture = voiture.getCoordXEnMetres() ;
		
		assertEquals(20, xVoiture);
		
	}
	
	@Test
	public void testVitesseX() {
		Voiture voiture = new Voiture(20, 30, 150);
		
		assertEquals(150,voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testAccelerer() {
		Voiture voiture = new Voiture(20, 30, 150);
		
		assertEquals(150,voiture.getVitesseMetreParSecondes());
		voiture.accelerer();		
		assertEquals(160,voiture.getVitesseMetreParSecondes());
	}
	@Test
	public void testRalentir() {
		Voiture voiture = new Voiture(20, 30, 150);
		
		assertEquals(150,voiture.getVitesseMetreParSecondes());
		voiture.ralentir();		
		assertEquals(140,voiture.getVitesseMetreParSecondes());
	}
	
	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		Voiture voiture = new Voiture(20, 30, 100);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(120, voiture.getCoordXEnMetres());
	}

	@Test
	public void testAngleDepart() {
		Voiture voiture = new Voiture(20, 30, 100);
		assertEquals(0, voiture.getAngle(), .05);
	}

	@Test
	public void testAngleApresVirageADroite() {
		Voiture voiture = new Voiture(20, 30);
		voiture.tourneADroite();
		assertEquals(-30, voiture.getAngle(), .05);
	}
	
	@Test
	public void testAngleApresVirageAGauche() {
		Voiture voiture = new Voiture(20, 30);
		voiture.tourneAGauche();
		assertEquals(30, voiture.getAngle(), .05);
	}
	
	@Test
	public void testAngleApresPlusieursVirages() {
		Voiture voiture = new Voiture(20, 30);
		voiture.tourneAGauche();
		voiture.tourneAGauche();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		assertEquals(-30, voiture.getAngle(), .05);
	}
	
	@Test
	public void testGetY(){
		Voiture voiture = new Voiture(20, 30) ;
		
		int yVoiture = voiture.getCoordYEnMetres() ;
		
		assertEquals(30, yVoiture);
		
	}
	
	@Test
	public void testMiseAJourPositionSansRotation(){
		Voiture voiture = new Voiture(100, 100, 5) ;
		
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals(105, voiture.getCoordXEnMetres());
		assertEquals(100, voiture.getCoordYEnMetres());
	}
	
	@Test
	public void testMiseAJourPositionRotationGauche(){
		Voiture voiture = new Voiture(100, 100, 5) ;

		voiture.tourneAGauche();
		voiture.tourneAGauche();
		voiture.tourneAGauche();
		
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals(100, voiture.getCoordXEnMetres());
		assertEquals(105, voiture.getCoordYEnMetres());
		
	}
	
	@Test
	public void testMiseAJourPositionRotationDroite(){
		Voiture voiture = new Voiture(100, 100, 5) ;

		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals(100, voiture.getCoordXEnMetres());
		assertEquals(95, voiture.getCoordYEnMetres());
		
	}
	
	@Test
	public void testMiseAJourPositionRotationRetour(){
		Voiture voiture = new Voiture(100, 100, 5) ;

		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals(95, voiture.getCoordXEnMetres());
		assertEquals(100, voiture.getCoordYEnMetres());
		
	}
	
	@Test
	public void testLimiteBassesX() {
		Voiture voiture = new Voiture(0, 500, 5) ;

		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals(0, voiture.getCoordXEnMetres());
		
	}
	
	@Test
	public void testLimiteBassesY() {
		Voiture voiture = new Voiture(500, 0, 5) ;

		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals(0, voiture.getCoordYEnMetres());
		
	}
	
	@Test
	public void testLimiteHautesX() {
		Voiture voiture = new Voiture(1000, 500, 5) ;
		
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals(1000, voiture.getCoordXEnMetres());
	}
	
	@Test
	public void testLimiteHautesY() {
		Voiture voiture = new Voiture(500, 1000, 5) ;

		voiture.tourneAGauche();
		voiture.tourneAGauche();
		voiture.tourneAGauche();
		
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals(1000, voiture.getCoordYEnMetres());
	}
}
