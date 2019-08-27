package donnee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Robot;

public class RobotDAO implements RobotSQL{
		
	private Connection connection = null;
	
	public RobotDAO()
	{
		this.connection = BaseDeDonnees.getInstance().getConnection();		
	}
	
	@SuppressWarnings("unused")
	private List<Robot> simulerListerRobots()
	{
		List<Robot> listeRobotsTest = new ArrayList<Robot>();
		listeRobotsTest.add(new Robot("Dolly", "Grise", "20 kg", "5 juin 2015"));
		listeRobotsTest.add(new Robot("Molly", "Rousse", "20 kg", "5 mai 2016"));
		listeRobotsTest.add(new Robot("Arthurus", "Noire", "20 kg", "5 mars 2017"));
		listeRobotsTest.add(new Robot("Cheese", "Jaune", "20 kg", "5 septembre 2015"));
		return listeRobotsTest;
	}	
	
	public List<Robot> listerRobots()
	{

		List<Robot> listeRobots =  new ArrayList<Robot>();			
		Statement requeteListeRobots;
		try {
			requeteListeRobots = connection.createStatement();
			ResultSet curseurListeRobots = requeteListeRobots.executeQuery(RobotSQL.SQL_LISTER_ROBOTS);
			while(curseurListeRobots.next())
			{
				int id = curseurListeRobots.getInt("id");
				String nom = curseurListeRobots.getString("nom");
				String couleur = curseurListeRobots.getString("couleur");
				String poids = curseurListeRobots.getString("poids");
				String technologie = curseurListeRobots.getString("technologie");
				System.out.println("Robot " + nom + " née le " + technologie + " : " + poids + "kg " + couleur);
				Robot robot = new Robot(nom, couleur, poids, technologie);
				robot.setId(id);
				listeRobots.add(robot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//return this.simulerListerRobots();
		return listeRobots;
	}
	
	public void ajouterRobot(Robot robot)
	{
		System.out.println("RobotDAO.ajouterRobot()");
		try {
			PreparedStatement requeteAjouterRobot = connection.prepareStatement(SQL_AJOUTER_ROBOT);
			requeteAjouterRobot.setString(1, robot.getNom());
			requeteAjouterRobot.setString(2, robot.getCouleur());
			requeteAjouterRobot.setString(3, robot.getPoids());
			requeteAjouterRobot.setString(4, robot.getTechnologie());
			
			System.out.println("SQL : " + SQL_AJOUTER_ROBOT);
			requeteAjouterRobot.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modifierRobot(Robot robot)
	{
		System.out.println("RobotDAO.modifierRobot()");
		try {
			PreparedStatement requeteModifierRobot = connection.prepareStatement(SQL_MODIFIER_ROBOT);
			requeteModifierRobot.setString(1, robot.getNom());
			requeteModifierRobot.setString(2, robot.getCouleur());
			requeteModifierRobot.setString(3, robot.getPoids());
			requeteModifierRobot.setString(4, robot.getTechnologie());
			requeteModifierRobot.setInt(5, robot.getId());
			
			System.out.println("SQL : " + SQL_MODIFIER_ROBOT);
			requeteModifierRobot.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Robot rapporterRobot(int idRobot)
	{
		PreparedStatement requeteRobot;
		try {
			requeteRobot = connection.prepareStatement(SQL_RAPPORTER_ROBOT);
			requeteRobot.setInt(1, idRobot);
			System.out.println(SQL_RAPPORTER_ROBOT);
			ResultSet curseurRobot = requeteRobot.executeQuery();
			curseurRobot.next();
			int id = curseurRobot.getInt("id");
			String nom = curseurRobot.getString("nom");
			String couleur = curseurRobot.getString("couleur");
			String poids = curseurRobot.getString("poids");
			String technologie = curseurRobot.getString("technologie");
			System.out.println("Robot " + nom + " née le " + technologie + " : " + poids + "kg " + couleur);
			Robot robot = new Robot(nom, couleur, poids, technologie);
			robot.setId(id);
			return robot;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
