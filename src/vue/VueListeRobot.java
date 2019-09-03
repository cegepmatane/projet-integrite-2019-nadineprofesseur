package vue;
import java.util.List;

import action.ControleurRobot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Robot;

public class VueListeRobot extends Scene {

	protected GridPane grilleRobots;
	
	private ControleurRobot controleur = null;
	
	private Button actionNaviguerAjouterRobot;
	public VueListeRobot() {
		super(new GridPane(), 400,400);
		grilleRobots = (GridPane) this.getRoot();
		this.actionNaviguerAjouterRobot = new Button("Ajouter un robot");
	}
	
	public void afficherListeRobot(List<Robot> listeRobots)
	{
		this.grilleRobots.getChildren().clear();
		
		int numero = 0;
		this.grilleRobots.add(new Label("Nom"), 0, numero);
		this.grilleRobots.add(new Label("Technologie"), 1, numero);	
		for(Robot robot : listeRobots)
		{
			Button actionEditerRobot = new Button("Editer");
			actionEditerRobot.setUserData(robot.getId());
			actionEditerRobot.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					//System.out.println("user data " + (int)((Button)e.getSource()).getUserData());
					controleur.notifierNaviguerEditerRobot((int)((Button)e.getSource()).getUserData()); 
					// TODO ameliorer ceci pour respecter architecture cible = pas de parametre dans les notifications au controleur
				}});
			numero++;
			System.out.println("user data moment creation "+(int)actionEditerRobot.getUserData());
			this.grilleRobots.add(new Label(robot.getNom()), 0, numero);
			this.grilleRobots.add(new Label(robot.getTechnologie()), 1, numero);			
			this.grilleRobots.add(actionEditerRobot, 2, numero);
		}
		
		this.actionNaviguerAjouterRobot.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierNaviguerAjouterRobot();
			}	
		});
		
		this.grilleRobots.add(this.actionNaviguerAjouterRobot, 1, ++numero);
	}

	public void setControleur(ControleurRobot controleur) {
		this.controleur = controleur;
	}

}
