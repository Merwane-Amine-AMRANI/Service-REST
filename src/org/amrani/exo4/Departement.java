package org.amrani.exo4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 5)
	private String codeDuDepartement;

	@Column(length = 80, nullable = false)
	private String name;

	@OneToMany(mappedBy = "departement")
	private List<Commune> communes = new ArrayList<>();

	public Departement() {
	}

	public Departement(String codeDuDepartement, String name) {
		this.codeDuDepartement = codeDuDepartement;
		this.name = name;
	}

	public void add(Commune commune) {
		this.communes.add(commune);
		commune.setDepartement(this);
	}

	public String getCodeDuDepartement() {
		return codeDuDepartement;
	}

	public void setCodeDuDepartement(String codeDuDepartement) {
		this.codeDuDepartement = codeDuDepartement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Commune> getCommunes() {
		return new ArrayList<>(this.communes);
	}

	public void setCommunes(List<Commune> communes) {
		this.communes = communes;
	}

	@Override
	public String toString() {
		return "Departement [codeDuDepartement=" + codeDuDepartement + ", name=" + name + "]";
	}

}
