package donnee;

public interface RobotSQL {
	
	public static final String SQL_LISTER_ROBOTS = "SELECT * FROM robot";
	public static final String SQL_AJOUTER_ROBOT = "INSERT into robot(nom, couleur, poids, technologie) VALUES(?,?,?,?)";
	public static final String SQL_MODIFIER_ROBOT = "UPDATE robot SET nom = ?, couleur = ?, poids = ?, technologie = ? WHERE id = ?";
	public static final String SQL_RAPPORTER_ROBOT = "SELECT * FROM robot WHERE id = ?";

}
