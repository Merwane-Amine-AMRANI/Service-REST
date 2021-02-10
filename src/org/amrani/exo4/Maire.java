package org.amrani.exo4;

import java.io.Serializable;
import java.util.Date;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.amrani.type2.Civility;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Maire implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@XmlAttribute
	private int id;

	@Column(length = 80, nullable = false)
	@XmlElement
	private String first_name;

	@Column(length = 80, nullable = false)
	@XmlElement
	private String last_name;

	@Column(length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	@XmlElement
	private Civility civility;

	@Temporal(TemporalType.DATE)
	@XmlElement
	private Date date_of_birth;

	@OneToOne(mappedBy = "maire")
	@JsonbTransient
	@XmlTransient
	private Commune commune;

	public Maire() {
	}

	public Maire(String first_name, String last_name, Civility civility, Date date_of_birth) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.civility = civility;
		this.date_of_birth = new Date(date_of_birth.getTime());
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Civility getCivility() {
		return civility;
	}

	public void setCivility(Civility civility) {
		this.civility = civility;
	}

	public void setCivility(String civility) {
		if (civility.equals("MR")) {
			this.civility = Civility.MR;
		}
		if (civility.equals("MLLE")) {
			this.civility = Civility.MLLE;
		}
		if (civility.equals("MRS")) {
			this.civility = Civility.MRS;
		}

	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	@Override
	public String toString() {
		return "Maire [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", civility=" + civility
				+ ", date_of_birth=" + date_of_birth + "]";
	}

}
