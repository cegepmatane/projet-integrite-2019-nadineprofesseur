package vue;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class VueAjouterConcepteur extends Scene {

	public VueAjouterConcepteur() throws IOException {
		super(FXMLLoader.load(VueAjouterConcepteur.class.getResource("ajouter-concepteur.fxml")));
		
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
