import java.util.List;

import donnee.ConcepteurDAO;
import modele.Concepteur;
import modele.Robot;
import vue.NavigateurDesVues;

public class App {

	public static void main(String[] parametres) {

		
		Concepteur nadine = new Concepteur();
		nadine.setNom("Nadine");
		nadine.setCourriel("nadineducegep@gmail.com");
		nadine.setIdRobot(1);
		ConcepteurDAO concepteurDAO = new ConcepteurDAO();
		concepteurDAO.ajouterConcepteur(nadine);
		
		NavigateurDesVues.launch(NavigateurDesVues.class, parametres);
		
	}

}
