import java.util.List;

import donnee.ConcepteurDAO;
import modele.Concepteur;
import vue.NavigateurDesVues;

public class App {

	public static void main(String[] parametres) {

		ConcepteurDAO accesseurConcepteur =  new ConcepteurDAO();
		List<Concepteur> listeConcepteurs = accesseurConcepteur.listerConcepteur();
		for(Concepteur concepteur : listeConcepteurs)
		{
			System.out.println(concepteur.getNom());
		}
		
		NavigateurDesVues.launch(NavigateurDesVues.class, parametres);
		
	}

}
