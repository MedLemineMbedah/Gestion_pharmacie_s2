package model;

import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Clients implements Serializable{
	
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom_client")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "telephone")
    private int telephone;


 

	
	public Clients() {
		
	}
	
	public Clients(String nom, String prenom, int tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = tel;
		
	}
	public Clients(int id, String nom, String prenom, int tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = tel;
		
	}






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






	public String getPrenom() {
		return prenom;
	}






	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}






	public int getTelephone() {
		return telephone;
	}






	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}







	
	
	
    

}

