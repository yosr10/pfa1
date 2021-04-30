package tn.enis.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "ETABLISSEMENT")
public class Etablissement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	@Column(name = "ETABLISSEMENT_ID", unique = true, nullable = false)
	private long etablissementId;

	@Column(name = "NOM", unique = true, nullable = false)
	private String nom;

	@Column(name = "ABBREVIATION", unique = true, nullable = false)
	private String abbreviation;

	@Column(name = "ADRESSE", unique = true, nullable = false)
	private String adresse;
	
	@Column(name = "LOGO", unique = true, nullable = true)
	private String logo;
	
	
	


}
