package model;
import java.io.Serializable;
import java.time.LocalDate;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "produit")
public class Produit implements Serializable {
	@Id
	//@GeneratedValue (strategy = GenerationType.AUTO)
	//@Column(name = "id")
	private int id;
	
	@Column(name = "intitule")
	private String intitule;

	@Column(name = "quantite")
	private int quantite;
	
	@Column(name = "date_exp")
	private LocalDate date_exp;	
	
	@Column(name = "prix")
	private float prix;

	
	protected Produit() {}
	
	
	
	
	public Produit(int id, String intitule, int quantite, LocalDate date_exp, float prix) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.quantite = quantite;
		this.date_exp = date_exp;
		this.prix = prix;
	}



	public Produit(LocalDate date_exp, float prix) {
		super();
		this.date_exp = date_exp;
		this.prix = prix;
	}




	public Produit(String intitule, int quantite, LocalDate date_exp, float prix) {
		super();
		this.intitule = intitule;
		this.quantite = quantite;
		this.date_exp = date_exp;
		this.prix = prix;
	}
	
	public Produit(String intitule) {
		
		this.intitule = intitule;
	}




	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public LocalDate getDate_exp() {
		return date_exp;
	}

	public void setDate_exp(LocalDate date_exp) {
		this.date_exp = date_exp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	
	

	
	
	
	
	
}
