package model;

import java.io.Serializable;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    private int type;

    
    public User() {
	}
	
    
    
    public User(String nom, String prenom, String username, String password, int type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public User(int id, String nom, String prenom, String username, String password, int type) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.type = type;
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
	public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
    
	
	
}
