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
@Table(name = "DEPARTEMENT")
public class Departement implements Serializable {

	@Id
	@Column(name = "DEPARTEMENT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private long departementId;

	@Column(name = "NOM", unique = true, nullable = false)
	private String nom;

	@ManyToOne
	@JoinColumn(name = "ETABLISSEMENT_ID")
	private Etablissement etablissement;

	
}
