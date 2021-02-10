package org.amrani.exo3;

import javax.json.bind.annotation.JsonbAnnotation;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@JsonbAnnotation
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "nom" })
public class Commune {

	@XmlAttribute(name = "id")
	private long id;

	private String nom;

	public Commune() {
	}

	public Commune(long id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return nom;
	}

	public void setName(String name) {
		this.nom = name;
	}

	@Override
	public String toString() {
		return "Commune [id=" + id + ", name=" + nom + "]";
	}

}
