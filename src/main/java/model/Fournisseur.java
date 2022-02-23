package model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fournisseur")

public class Fournisseur implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
 //   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom_f")
    private String nomf;

    @Column(name = "prenom_f")
    private String prenomf;

    @Column(name = "telephone")
    private int telephone;


	public Fournisseur() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomf() {
		return nomf;
	}

	public void setNomf(String nomf) {
		this.nomf = nomf;
	}

	public String getPrenomf() {
		return prenomf;
	}

	public void setPrenomf(String prenomf) {
		this.prenomf = prenomf;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


	public Fournisseur(int id, String nomf, String prenomf, int telephone) {
		super();
		this.id = id;
		this.nomf = nomf;
		this.prenomf = prenomf;
		this.telephone = telephone;
	}

	public Fournisseur(String nomf, String prenomf, int telephone) {
		super();
		this.nomf = nomf;
		this.prenomf = prenomf;
		this.telephone = telephone;
	
	}
	
    
	
    
    
    
}
