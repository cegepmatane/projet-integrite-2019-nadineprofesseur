package donnee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Concepteur;

public class ConcepteurDAO {

	private Connection connection = null;

	public ConcepteurDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<Concepteur> listerConcepteur()
	{
		List<Concepteur> listeConcepteurs = new ArrayList<Concepteur>();
		
		Statement requeteListeConcepteurs;
		try {
			requeteListeConcepteurs = this.connection.createStatement();
			ResultSet curseurConcepteurs = requeteListeConcepteurs.executeQuery("SELECT * from concepteur");
			
			while(curseurConcepteurs.next())
			{
				Concepteur concepteur = new Concepteur();
				
				String nom = curseurConcepteurs.getString("nom");
				concepteur.setNom(nom);
				
				listeConcepteurs.add(concepteur);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeConcepteurs;
	}
}
