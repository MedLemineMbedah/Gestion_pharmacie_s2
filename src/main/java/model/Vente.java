package model;

import java.io.Serializable; 
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vente")
public class Vente implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "intitule")
    private String intitule;

    @Column(name = "date_v")
    private LocalDate date;


	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "id_client") private Clients client;
	 */	 
	
	@Column(name = "id_client")
    private int id_client;

	 



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	

	


public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


public Vente(String intitule, LocalDate date, int id_client) {
		super();
		this.intitule = intitule;
		this.date = date;
		this.id_client = id_client;
	}


public Vente(int id, String intitule, LocalDate date, int id_client) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.date = date;
		this.id_client = id_client;
	}


public Vente() {
	
}


}
