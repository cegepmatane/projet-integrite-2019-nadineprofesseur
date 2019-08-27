package vue;
import action.ControleurRobot;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Robot;

public class VueRobot extends Scene{

	protected Label valeurNom;
	protected Label valeurCouleur;
	protected Label valeurPoids;
	protected Label valeurTechnologie;
	
	@SuppressWarnings("unused")
	private ControleurRobot controleur = null;	
	
	public VueRobot() {
		super(new GridPane(),400,400);
		GridPane grilleRobot = (GridPane) this.getRoot();

		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new Label("");
		grilleRobot.add(new Label("Nom : "), 0, 0);
		grilleRobot.add(valeurNom, 1, 0);
		
		valeurCouleur = new Label("");
		grilleRobot.add(new Label("Couleur : "), 0, 1);
		grilleRobot.add(valeurCouleur, 1, 1);

		valeurPoids = new Label("");
		grilleRobot.add(new Label("Poids : "), 0, 2);
		grilleRobot.add(valeurPoids, 1, 2);		

		valeurTechnologie = new Label("");
		grilleRobot.add(new Label("Technologie : "), 0, 3);
		grilleRobot.add(valeurTechnologie, 1, 3);				
	}
	
	public void afficherRobot(Robot robot)
	{
		this.valeurNom.setText(robot.getNom());
		this.valeurCouleur.setText(robot.getCouleur());
		this.valeurPoids.setText(robot.getPoids());
		this.valeurTechnologie.setText(robot.getTechnologie());	
	}
	
	
	public void setControleur(ControleurRobot controleur) {
		this.controleur = controleur;
	}

}
