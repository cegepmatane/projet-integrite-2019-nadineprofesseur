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

public class VueEditerConcepteur extends Scene {

	protected TextField valeurNom;
	protected TextField valeurSurnom;
	protected TextField valeurSpecialite;
	protected TextField valeurCourriel;
	
	private ControleurRobot controleur = null;
	protected Button actionEnregistrerConcepteur = null;
	private GridPane grilleConcepteurs = null;
	
	public VueEditerConcepteur()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleConcepteur = new GridPane();
		this.grilleConcepteurs = new GridPane();
		this.actionEnregistrerConcepteur = new Button("Enregistrer");
		
		this.actionEnregistrerConcepteur.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerConcepteur();
				
			}});
		
		// https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html
		valeurNom = new TextField();
		grilleConcepteur.add(new Label("Nom : "), 0, 0);
		grilleConcepteur.add(valeurNom, 1, 0);
		
		valeurSurnom = new TextField("");
		grilleConcepteur.add(new Label("Surnom : "), 0, 1);
		grilleConcepteur.add(valeurSurnom, 1, 1);

		valeurSpecialite = new TextField("");
		grilleConcepteur.add(new Label("Specialite : "), 0, 2);
		grilleConcepteur.add(valeurSpecialite, 1, 2);		

		valeurCourriel = new TextField("");
		grilleConcepteur.add(new Label("Courriel : "), 0, 3);
		grilleConcepteur.add(valeurCourriel, 1, 3);				
	
		// Todo : retirer les textes magiques
		panneau.getChildren().add(new Label("Editer un concepteur")); // Todo : créer un sous-type de Label ou Text pour les titres
		panneau.getChildren().add(grilleConcepteur);
		panneau.getChildren().add(this.actionEnregistrerConcepteur);
		panneau.getChildren().add(grilleConcepteurs);
	}
	
	private int idConcepteur = 0; // solution discutable
	public void afficherConcepteur(Concepteur concepteur)
	{
		this.idConcepteur = concepteur.getId();
		this.valeurNom.setText(concepteur.getNom());
		this.valeurSurnom.setText(concepteur.getSurnom());
		this.valeurSpecialite.setText(concepteur.getSpecialite());
		this.valeurCourriel.setText(concepteur.getCourriel());
	}

	public Concepteur demanderConcepteur()
	{
		Concepteur concepteur = new Concepteur();
		concepteur.setNom(this.valeurNom.getText());
		concepteur.setSurnom(this.valeurSurnom.getText());
		concepteur.setSpecialite(this.valeurSpecialite.getText());
		concepteur.setCourriel(this.valeurCourriel.getText());
		concepteur.setId(this.idConcepteur);
		return concepteur;
	}
	
	public void setControleur(ControleurRobot controleur) {
		this.controleur = controleur;
	}
	

}
