package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Concepteur;
import modele.Robot;

public class ConcepteurDAO {

	private Connection connection = null;

	public ConcepteurDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();
	}
	
	public List<Concepteur> listerConcepteurs()
	{
		List<Concepteur> listeConcepteurs = new ArrayList<Concepteur>();
		
		Statement requeteListeConcepteurs;
		try {
			requeteListeConcepteurs = this.connection.createStatement();
			ResultSet curseurConcepteurs = requeteListeConcepteurs.executeQuery("SELECT * from concepteur"); // chaine magique
			
			while(curseurConcepteurs.next())
			{
				Concepteur concepteur = new Concepteur();
				
				String nom = curseurConcepteurs.getString("nom");
				String surnom = curseurConcepteurs.getString("surnom");
				String specialite = curseurConcepteurs.getString("specialite");
				String courriel = curseurConcepteurs.getString("courriel");
				concepteur.setNom(nom);
				concepteur.setSurnom(surnom);
				concepteur.setSpecialite(specialite);
				concepteur.setCourriel(courriel);
				
				listeConcepteurs.add(concepteur);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeConcepteurs;
	}
	public List<Concepteur> listerConcepteursParRobot(Robot robot)
	{
		System.out.println("ConcepteurDAO.listerConcepteursParRobot(robot)");
		List<Concepteur> listeConcepteurs = new ArrayList<Concepteur>();
		
		Statement requeteListeConcepteurs;
		try {
			requeteListeConcepteurs = this.connection.createStatement();
			ResultSet curseurConcepteurs = requeteListeConcepteurs.executeQuery("SELECT * from concepteur WHERE id_robot = " + robot.getId());
			System.out.println("SELECT * from concepteur WHERE id_robot = " + robot.getId());
			while(curseurConcepteurs.next())
			{
				Concepteur concepteur = new Concepteur();
				
				int id = Integer.parseInt(curseurConcepteurs.getString("id"));
				String nom = curseurConcepteurs.getString("nom");
				String surnom = curseurConcepteurs.getString("surnom");
				String specialite = curseurConcepteurs.getString("specialite");
				String courriel = curseurConcepteurs.getString("courriel");
				concepteur.setId(id);
				concepteur.setNom(nom);
				concepteur.setSurnom(surnom);
				concepteur.setSpecialite(specialite);
				concepteur.setCourriel(courriel);
				
				listeConcepteurs.add(concepteur);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeConcepteurs;
	}
	
	public void ajouterConcepteur(Concepteur concepteur)
	{
		System.out.println("ConcepteurDAO.ajouterConcepteur(Concepteur concepteur)");
		try {
			PreparedStatement requeteAjouterConcepteur = connection.prepareStatement("INSERT into concepteur(nom, surnom, specialite, courriel, id_robot) VALUES(?,?,?,?,?)");
			requeteAjouterConcepteur.setString(1, concepteur.getNom());
			requeteAjouterConcepteur.setString(2, concepteur.getSurnom());
			requeteAjouterConcepteur.setString(3, concepteur.getSpecialite());
			requeteAjouterConcepteur.setString(4, concepteur.getCourriel());
			requeteAjouterConcepteur.setInt(5, concepteur.getIdRobot());
			
			requeteAjouterConcepteur.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Concepteur rapporterConcepteur(int id)
	{
		System.out.println("ConcepteurDAO.rapporterConcepteur("+id+")");
		Concepteur concepteur = new Concepteur();
		
		try {
			
			Statement requete = connection.createStatement();
			ResultSet curseurConcepteurs = requete.executeQuery("SELECT * FROM concepteur WHERE id = " + id);
			curseurConcepteurs.next();
			String nom = curseurConcepteurs.getString("nom");
			String surnom = curseurConcepteurs.getString("surnom");
			String specialite = curseurConcepteurs.getString("specialite");
			String courriel = curseurConcepteurs.getString("courriel");
			concepteur.setId(id);
			concepteur.setNom(nom);
			concepteur.setSurnom(surnom);
			concepteur.setSpecialite(specialite);
			concepteur.setCourriel(courriel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return concepteur;
	}
}
