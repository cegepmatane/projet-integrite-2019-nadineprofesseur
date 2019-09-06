package modele;

public class Concepteur {
	
	protected String nom;
	protected String surnom;
	protected String specialite;
	protected String courriel;
	protected int idRobot;
	

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getCourriel() {
		return courriel;
	}
	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	public int getIdRobot() {
		return idRobot;
	}
	public void setIdRobot(int idRobot) {
		this.idRobot = idRobot;
	}
}
