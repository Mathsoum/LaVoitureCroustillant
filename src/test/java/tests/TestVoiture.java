package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domaineconduite.Voiture;

public class TestVoiture {
	Voiture voiture;

	@Before
	public void setUp() {
		voiture = new Voiture( 100, 200, 50 );
	}

	@Test
	public void testGetX() {
		assertEquals( 100, voiture.getCoordXEnMetres() );
	}

	@Test
	public void testGetY() {
		assertEquals( 200, voiture.getCoordYEnMetres() );
	}

	@Test
	public void testVitesseX() {
		assertEquals( 50,voiture.getVitesseMetreParSecondes() );
	}

	@Test
	public void testAccelerer() {
		assertEquals( 50,voiture.getVitesseMetreParSecondes() );

		voiture.accelerer();		

		assertEquals( 60,voiture.getVitesseMetreParSecondes() );
	}
	@Test
	public void testRalentir() {
		assertEquals( 50,voiture.getVitesseMetreParSecondes() );

		voiture.ralentir();		

		assertEquals( 40,voiture.getVitesseMetreParSecondes() );
	}

	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals( 150, voiture.getCoordXEnMetres() );
	}

	@Test
	public void testAngleDepart() {
		assertEquals( 0, voiture.getAngle(), .05 );
	}

	@Test
	public void testAngleApresVirageAGauche() {
		voiture.tourneAGauche();

		assertEquals( -30, voiture.getAngle(), .05 );
	}

	@Test
	public void testAngleApresVirageADroite() {
		voiture.tourneADroite();

		assertEquals( 30, voiture.getAngle(), .05 );
	}

	@Test
	public void testAngleApresPlusieursVirages() {
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneAGauche();
		voiture.tourneAGauche();
		voiture.tourneAGauche();

		assertEquals( -30, voiture.getAngle(), .05 );
	}

	@Test
	public void testMiseAJourPositionSansRotation() {
		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals( 150, voiture.getCoordXEnMetres() );
		assertEquals( 200, voiture.getCoordYEnMetres() );
	}

	@Test
	public void testMiseAJourPositionRotationGauche() {
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();

		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals( 100, voiture.getCoordXEnMetres() );
		assertEquals( 250, voiture.getCoordYEnMetres() );
	}

	@Test
	public void testMiseAJourPositionRotationDroite() {
		voiture.tourneAGauche();
		voiture.tourneAGauche();
		voiture.tourneAGauche();

		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals( 100, voiture.getCoordXEnMetres() );
		assertEquals( 150, voiture.getCoordYEnMetres() );
	}

	@Test
	public void testMiseAJourPositionRotationRetour() {
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();

		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals( 50, voiture.getCoordXEnMetres() );
		assertEquals( 200, voiture.getCoordYEnMetres() );
	}

	@Test
	public void testLimiteBassesX() {
		voiture = new Voiture( 0, 500, 5 ) ;

		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();

		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals( 0, voiture.getCoordXEnMetres() );
	}

	@Test
	public void testLimiteBassesY() {
		voiture = new Voiture( 500, 0, 5 ) ;

		voiture.tourneAGauche();
		voiture.tourneAGauche();
		voiture.tourneAGauche();

		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals( 0, voiture.getCoordYEnMetres() );
	}

	@Test
	public void testLimiteHautesX() {
		voiture = new Voiture( 1000, 500, 5 ) ;

		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals( 1000, voiture.getCoordXEnMetres() );
	}

	@Test
	public void testLimiteHautesY() {
		voiture = new Voiture( 500, 1000, 5 ) ;

		voiture.tourneADroite();
		voiture.tourneADroite();
		voiture.tourneADroite();

		voiture.avancerEnFonctionDeLaVitesse();

		assertEquals( 1000, voiture.getCoordYEnMetres() );
	}
}
