package applicationsimulateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import domaineconduite.Voiture;


public final class SimulateurVoiture {

	public static final int DUREE_UNE_SECONDE_EN_MILLISECONDES = 1000;
	
	private SimulateurVoiture() {
	}

	public static void main(String[] args) {
		DessinVoiture dessinVoiture = new DessinVoiture();
		final Voiture voiture = new Voiture(500,500);
		new VueVoiture(voiture, dessinVoiture);
		
		Timer timerAvancer = new Timer(DUREE_UNE_SECONDE_EN_MILLISECONDES, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				voiture.avancerEnFonctionDeLaVitesse();
			}
		});
		
		timerAvancer.start();
		
		while(true){
			// INFINITE LOOP TO PLAY WITH THE APP
		}
	}
}
