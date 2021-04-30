package tn.enis.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("serial")
@Entity
@Table(name="NIVEAU")
public class Niveau implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@EqualsAndHashCode.Include
	@Column(name="NIVEAU_ID", unique=true , nullable=false)
	private long niveauId;
	
	@Column(name="NOM", unique=true , nullable=false)
	private String nom;
	
	@Column(name="ABBREVIATION", unique=true , nullable=true)
	private String abbreviation;
	
	@ManyToOne
	@JoinColumn(name="PARCOURS_ID")
	private Parcours parcours;
	
	
}
