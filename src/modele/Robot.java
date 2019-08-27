package modele;

public class Robot {

	protected int id;
	protected String nom;
	protected String couleur;
	protected String poids;
	protected String technologie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Robot(String nom) {
		super();
		this.nom = nom;
	}
	public Robot(String nom, String couleur) {
		super();
		this.nom = nom;
		this.couleur = couleur;
	}
	public Robot(String nom, String couleur, String poids) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.poids = poids;
	}
	public Robot(String nom, String couleur, String poids, String naissance) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.poids = poids;
		this.technologie = naissance;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getTechnologie() {
		return technologie;
	}
	public void setTechnologie(String naissance) {
		this.technologie = naissance;
	}
	public String getPoids() {
		return poids;
	}
	public void setPoids(String poids) {
		this.poids = poids;
	}
	
}
