package vue;

import java.util.List;

import action.ControleurRobot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Concepteur;
import modele.Robot;

public class VueEditerRobot extends Scene {

	protected TextField valeurNom;
	protected TextField valeurCouleur;
	protected TextField valeurPoids;
	protected TextField valeurTechnologie;
	
	private ControleurRobot controleur = null;
	protected Button actionEnregistrerRobot = null;
	protected Button actionAjouterConcepteur = null;
	
	private int idRobot = 0;
	private GridPane grilleConcepteurs = null;
	
	public VueEditerRobot()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleRobot = new GridPane();
		this.grilleConcepteurs = new GridPane();
		this.actionEnregistrerRobot = new Button("Enregistrer");
		
		this.actionEnregistrerRobot.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerRobot();
				
			}});
		
		this.actionAjouterConcepteur = new Button("Ajouter un concepteur");
		this.actionAjouterConcepteur.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierNaviguerAjouterConcepteur();
			}});

		
		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleRobot.add(new Label("Nom : "), 0, 0);
		grilleRobot.add(valeurNom, 1, 0);
		
		valeurCouleur = new TextField("");
		grilleRobot.add(new Label("Couleur : "), 0, 1);
		grilleRobot.add(valeurCouleur, 1, 1);

		valeurPoids = new TextField("");
		grilleRobot.add(new Label("Poids : "), 0, 2);
		grilleRobot.add(valeurPoids, 1, 2);		

		valeurTechnologie = new TextField("");
		grilleRobot.add(new Label("Technologie : "), 0, 3);
		grilleRobot.add(valeurTechnologie, 1, 3);				
	
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Editer un robot")); // Todo : cr�er un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleRobot);
		panneau.getChildren().add(this.actionEnregistrerRobot);
		panneau.getChildren().add(this.actionAjouterConcepteur);
		panneau.getChildren().add(grilleConcepteurs);
	}
	
	public void afficherRobot(Robot robot)
	{
		this.idRobot = robot.getId();
		this.valeurNom.setText(robot.getNom());
		this.valeurCouleur.setText(robot.getCouleur());
		this.valeurPoids.setText(robot.getPoids());
		this.valeurTechnologie.setText(robot.getTechnologie());
	}
		
	public Robot demanderRobot()
	{
		Robot robot = new Robot(this.valeurNom.getText(), 
								this.valeurCouleur.getText(), 
								this.valeurPoids.getText(), 
								this.valeurTechnologie.getText());
		robot.setId(idRobot);
		return robot;
	}
	
	public void setControleur(ControleurRobot controleur) {
		this.controleur = controleur;
	}
	
	
	public void afficherListeConcepteurs(List<Concepteur> listeConcepteurs)
	{
		//this.grilleConcepteurs.add(new Label("test"), 0, 0);
		this.grilleConcepteurs.getChildren().clear();
		int rangee = 0;
		for(Concepteur concepteur : listeConcepteurs)
		{
			Button actionEditerConcepteur = new Button("Editer");
			actionEditerConcepteur.setUserData(concepteur.getId());
			actionEditerConcepteur.setOnAction(evenement -> {
				System.out.println("actionEditerConcepteur.evenement");
				int id = (int)((Button)evenement.getSource()).getUserData();	
				this.controleur.notifierNaviguerEditerConcepteur(id);
			});
			
			//System.out.println(concepteur.getNom());
			this.grilleConcepteurs.add(new Label(concepteur.getNom()), 0, rangee);
			this.grilleConcepteurs.add(actionEditerConcepteur, 1, rangee++);
		}
	}

}
