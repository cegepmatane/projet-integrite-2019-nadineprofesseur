package action;

import java.util.ArrayList;
import java.util.List;

import donnee.RobotDAO;
import modele.Concepteur;
import modele.Robot;
import vue.NavigateurDesVues;
import vue.VueEditerRobot;
import vue.VueListeRobot;
import vue.VueRobot;

public class ControleurRobot {
	
	private NavigateurDesVues navigateur;
	private VueListeRobot vueListeRobot = null;
	private VueRobot vueRobot = null;
	//private VueAjouterRobot vueAjouterRobot = null;
	private VueEditerRobot vueEditerRobot = null;
	private RobotDAO robotDAO = null;
	
	private ControleurRobot()
	{
		System.out.println("Initialisation du controleur");	
		this.robotDAO = new RobotDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		//this.vueAjouterRobot = navigateur.getVueAjouterRobot();
		this.vueRobot = navigateur.getVueRobot();
		this.vueListeRobot = navigateur.getVueListeRobot();
		this.vueEditerRobot = navigateur.getVueEditerRobot();
						
		//// TEST ////
		Robot robot = new Robot("Dolly", "Grise", "20 kg", "5 juin 2015");
		this.vueRobot.afficherRobot(robot); // Appel de ma fonction avant de la programmer (pour tester à mesure)					
		
		this.navigateur.naviguerVersVueRobot();
		
		/// TEST ///
		List<Robot> listeRobotsTest = robotDAO.listerRobots();
		this.vueListeRobot.afficherListeRobot(listeRobotsTest); // Appel de ma fonction avant de la programmer (pour tester à mesure)
		
		this.navigateur.naviguerVersVueListeRobot();		
				
		//this.navigateur.naviguerVersVueAjouterRobot();
		
		//this.vueEditerRobot.afficherListeDistinction(this.distinctionDAO.listerDistinctions());
		
	}
	
	// SINGLETON DEBUT
	private static ControleurRobot instance = null;
	public static ControleurRobot getInstance()
	{
		if(null == instance) instance = new ControleurRobot();
		return instance;
	}
	// SINGLETON FINI

	
	
	
	
	
	
	//**********************************************************//
	//                                                          //
	//                   NOTIFICATIONS                          //
	//                                                          //
	//**********************************************************//
	
	// Les notifications peuvent être gérées par callback comme ici ou par événement,
	// Mais dans les deux cas les opérations sont divisées dans des fonctions comme ici
	// Pas de code dans un switch - case
	
	public void notifierEnregistrerNouveauRobot()
	{
		System.out.println("ControleurRobot.notifierEnregistrerNouveauRobot()");
		Robot robot = this.navigateur.getVueAjouterRobot().demanderRobot();
		this.robotDAO.ajouterRobot(robot);
		this.vueListeRobot.afficherListeRobot(this.robotDAO.listerRobots()); // TODO optimiser
		this.navigateur.naviguerVersVueListeRobot();
	}
	
	public void notifierEnregistrerRobot()
	{
		System.out.println("ControleurRobot.notifierEnregistrerRobot()");
		Robot robot = this.navigateur.getVueEditerRobot().demanderRobot();
		this.robotDAO.modifierRobot(robot);
		this.vueListeRobot.afficherListeRobot(this.robotDAO.listerRobots()); // TODO optimiser
		this.navigateur.naviguerVersVueListeRobot();		
	}
	
	public void notifierNaviguerAjouterRobot()
	{
		System.out.println("ControleurRobot.notifierNaviguerAjouterRobot()");
		this.navigateur.naviguerVersVueAjouterRobot();
	}
	
	public void notifierNaviguerEditerRobot(int idRobot)
	{
		System.out.println("ControleurRobot.notifierEditerRobot("+idRobot+")");
		// savoir par la vue liste quel numero de robot a ete clique
		this.vueEditerRobot.afficherRobot(this.robotDAO.rapporterRobot(idRobot));
		this.navigateur.naviguerVersVueEditerRobot();
		
		// Debut mockup - echafaud - stub
		List<Concepteur> listeConcepteurs = new ArrayList<Concepteur>();
		Concepteur toto = new Concepteur(); toto.setNom("Toto"); listeConcepteurs.add(toto);
		Concepteur lulu = new Concepteur(); lulu.setNom("Lulu"); listeConcepteurs.add(lulu);
		// Fin mockup
		
		// TEST
		this.vueEditerRobot.afficherListeConcepteurs(listeConcepteurs);
	}
	
	
}
