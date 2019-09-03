package vue;

import java.io.IOException;

import action.ControleurRobot;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application{
	
	private Stage stade;
	
	private VueListeRobot vueListeRobot = null;
	private VueRobot vueRobot = null;
	private VueAjouterRobot vueAjouterRobot = null;
	private VueEditerRobot vueEditerRobot = null;
	private VueAjouterConcepteur vueAjouterConcepteur = null;

	private ControleurRobot controleur = null;
	
	static private NavigateurDesVues instance = null;
	public NavigateurDesVues() 
	{		
		NavigateurDesVues.instance = this;
		this.vueListeRobot = new VueListeRobot();
		this.vueRobot = new VueRobot();
		this.vueAjouterRobot = new VueAjouterRobot();
		this.vueEditerRobot = new VueEditerRobot();
		try {
			this.vueAjouterConcepteur = new VueAjouterConcepteur();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static public NavigateurDesVues getInstance()
	{
		return instance;
	}

	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		
		this.stade.setScene(null);
		this.stade.show();
	
		this.controleur = ControleurRobot.getInstance();
		this.controleur.activerVues(this);
		this.vueListeRobot.setControleur(controleur);
		this.vueRobot.setControleur(controleur);
		this.vueAjouterRobot.setControleur(controleur);
		this.vueEditerRobot.setControleur(controleur);
		//this.vueAjouterConcepteur.setControleur(controleur);
	}	
	
	public VueListeRobot getVueListeRobot() {
		return vueListeRobot;
	}
	public VueRobot getVueRobot() {
		return vueRobot;
	}
	public VueAjouterRobot getVueAjouterRobot() {
		return vueAjouterRobot;
	}
	public VueEditerRobot getVueEditerRobot(){
		return this.vueEditerRobot;
	}
	public VueAjouterConcepteur getVueAjouterConcepteur() {
		return vueAjouterConcepteur;
	}
	
	
	
	
	public void naviguerVersVueRobot() {
		stade.setScene(this.vueRobot);
		stade.show();
	}
	public void naviguerVersVueListeRobot()
	{
		stade.setScene(this.vueListeRobot);
		stade.show();		
	}
	public void naviguerVersVueAjouterRobot()
	{
		stade.setScene(this.vueAjouterRobot);
		stade.show();				
	}
	public void naviguerVersVueEditerRobot()
	{
		stade.setScene(this.vueEditerRobot);
		stade.show();				
	}
	public void naviguerVersVueAjouterConcepteur()
	{
		stade.setScene(this.vueAjouterConcepteur);
		stade.show();				
	}
}
