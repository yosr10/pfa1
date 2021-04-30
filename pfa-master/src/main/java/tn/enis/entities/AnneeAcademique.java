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
@Table(name = "ANNEE_ACADEMIQUE")
public class AnneeAcademique implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	@Column(name = "ANNEE_ID", unique = true, nullable = false)
	private Long anneeId;

	@Column(name = "DEBUT_ANNEE", unique = true, nullable = false)
	private int debutAnnee;

	@Column(name = "FIN_ANNEE", unique = true, nullable = false)
	private int finAnnee;

	@Column(name = "ETAT", unique = false, nullable = true)
	private String etat;

	

	

	

	

}
