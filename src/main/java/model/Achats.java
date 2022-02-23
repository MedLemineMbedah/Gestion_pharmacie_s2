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
@Table(name = "achat")
public class Achats implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "intitule")
    private String intitule;

    @Column(name = "date")
    private LocalDate date;


	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "id_client") private Clients client;
	 */	 
	
	@Column(name = "id_f")
    private int id_f;


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


	public int getId_f() {
		return id_f;
	}


	public void setId_f(int id_f) {
		this.id_f = id_f;
	}


	public Achats() {
		
	}


	public Achats(int id, String intitule, LocalDate date, int id_f) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.date = date;
		this.id_f = id_f;
	}


	public Achats(String intitule, LocalDate date, int id_f) {
		super();
		this.intitule = intitule;
		this.date = date;
		this.id_f = id_f;
	}


	

}
