package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "element_achat")

public class ElementAchats implements Serializable {
   
	
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    
    @ManyToOne
    @JoinColumn(name = "id_achat")
    private Achats achat;
    
    
    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;

    @Column(name = "quantite")
    private int quantite;

	public ElementAchats() {
		
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Achats getAchat() {
		return achat;
	}

	public void setAchat(Achats achat) {
		this.achat = achat;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public ElementAchats(int id, Achats achat, Produit produit, int quantite) {
		super();
		this.id = id;
		this.achat = achat;
		this.produit = produit;
		this.quantite = quantite;
	}

	public ElementAchats(Achats achat, Produit produit, int quantite) {
		super();
		this.achat = achat;
		this.produit = produit;
		this.quantite = quantite;
	}
    
//    private int prixtotal;
    
	

	

    
}
