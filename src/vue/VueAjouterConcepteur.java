package vue;

import java.io.IOException;

import action.ControleurRobot;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import modele.Concepteur;

public class VueAjouterConcepteur extends Scene {

	private ControleurRobot controleur = null;	
	
	public VueAjouterConcepteur() throws IOException {
		super(FXMLLoader.load(VueAjouterConcepteur.class.getResource("ajouter-concepteur.fxml")));	
	}
	
	public void setControleur(ControleurRobot controleur) {
		this.controleur = controleur;
	}
	
	public Concepteur demanderConcepteur()
	{
		Concepteur concepteur = new Concepteur();
		concepteur.setNom(((TextField)this.lookup("#champs-nom")).getText());
		concepteur.setSurnom(((TextField)this.lookup("#champs-surnom")).getText());
		concepteur.setSpecialite(((TextField)this.lookup("#champs-specialite")).getText());
		concepteur.setCourriel(((TextField)this.lookup("#champs-courriel")).getText());
		return concepteur;
	}

}




























/*VBox panneau = (VBox) this.getRoot();
GridPane grilleConcepteur = new GridPane();

this.actionEnregistrerConcepteur = new Button();

TextField valeurNom = new TextField();
grilleConcepteur.add(new Label("Nom : "), 0, 0);
grilleConcepteur.add(valeurNom, 1, 0);

panneau.getChildren().add(grilleConcepteur);
panneau.getChildren().add(this.actionEnregistrerConcepteur);
*/
