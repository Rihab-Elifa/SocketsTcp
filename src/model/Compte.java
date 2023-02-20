package model;

public class Compte {
	private static int i=0;
	private int id;
	private String nom;
	private float solde;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(Float solde) {
		this.solde = solde;
	}
	public Compte(int id, String nom) {
		super();
		this.id=i++;
		this.nom = nom;
		this.solde = 0;
	}
	public Compte() {
		super();
	}
	
	

}
