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
@Table(name = "element_vente")

public class ElementVente implements Serializable {
   
	
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    
    @ManyToOne
    @JoinColumn(name = "id_vente")
    private Vente vente;
    
    
    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;

    @Column(name = "quantite")
    private int quantite;
    
//    private int prixtotal;
    

	
	public ElementVente() {}
	
	


//	public ElementVente(Long id, Long id_vente, Long id_produit) {
//		super();
//		this.id = id;
//		this.id_vente = id_vente;
//		this.id_produit = id_produit;
//	}

	public ElementVente(Vente vente, Produit id_produit) {
		super();
		this.vente = vente;
		this.produit = id_produit;
	}
	
	
	

	public ElementVente(Vente vente, Produit id_produit, int qte ) {
		super();
		this.vente = vente;
		this.produit = id_produit;
		this.quantite = qte;
	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public ElementVente(int id_vente, int qte, int prixtotal) {
//		super();
//		this.id_vente = id_vente;
//		this.quantite = qte;
//	    this.prixtotal = prixtotal;
//	}




	



	



	public Produit getProduit() {
		return produit;
	}




	public Vente getVente() {
		return vente;
	}




	public void setVente(Vente vente) {
		this.vente = vente;
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




	




	

    
}
