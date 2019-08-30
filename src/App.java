import java.util.List;

import donnee.ConcepteurDAO;
import modele.Concepteur;
import modele.Robot;
import vue.NavigateurDesVues;

public class App {

	public static void main(String[] parametres) {

		ConcepteurDAO accesseurConcepteur =  new ConcepteurDAO();
		Robot robot1 = new Robot("");
		robot1.setId(2);
		List<Concepteur> listeConcepteurs = accesseurConcepteur.listerConcepteursParRobot(robot1);
		for(Concepteur concepteur : listeConcepteurs)
		{
			System.out.println(concepteur.getNom());
		}
		
		NavigateurDesVues.launch(NavigateurDesVues.class, parametres);
		
	}

}
