package org.amrani.exo4;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Commune implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 8)
	@XmlAttribute
	private String codePostal;

	@Column(length = 80, nullable = false)
	@XmlElement
	private String name;

	@Column(nullable = true)
	@XmlElement
	private int population;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JsonbTransient
	@XmlTransient
	private Maire maire;

	@ManyToOne
	@JsonbTransient
	@XmlTransient
	private Departement departement;

	public Maire getMaire() {
		return maire;
	}

	public void setMaire(Maire maire) {
		this.maire = maire;
	}

	public Commune() {
	}

	public Commune(String codePostal, String name, int pop) {
		this.codePostal = codePostal;
		this.name = name;
		this.population = pop;

	}

	public Commune(String codePostal, String name) {
		this.codePostal = codePostal;
		this.name = name;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeDepartement() {
		return codePostal.substring(0, 2);
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Commune [codePostal=" + codePostal + ", name=" + name + ", maire=" + maire + "]";
	}

	public String print() {
		return "Commune [name=" + name + ", population=" + this.getPopulation() + "]";
	}

}
