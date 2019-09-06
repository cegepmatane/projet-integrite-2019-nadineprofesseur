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
	private VueEditerConcepteur vueEditerConcepteur = null;

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
		this.vueEditerConcepteur = new VueEditerConcepteur();
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
		return this.vueListeRobot;
	}
	public VueRobot getVueRobot() {
		return this.vueRobot;
	}
	public VueAjouterRobot getVueAjouterRobot() {
		return this.vueAjouterRobot;
	}
	public VueEditerRobot getVueEditerRobot(){
		return this.vueEditerRobot;
	}
	public VueAjouterConcepteur getVueAjouterConcepteur() {
		return this.vueAjouterConcepteur;
	}
	public VueEditerConcepteur getVueEditerConcepteur() {
		return this.vueEditerConcepteur;
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
	public void naviguerVersVueEditerConcepteur()
	{
		stade.setScene(this.vueEditerConcepteur);
		stade.show();				
	}
}
