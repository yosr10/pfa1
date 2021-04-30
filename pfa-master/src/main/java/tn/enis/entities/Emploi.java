package tn.enis.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name="EMPLOI")
public class Emploi implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@EqualsAndHashCode.Include
	@Column(name="EMPLOI_ID",unique=true, nullable=false)
	private long emploiId;
	
	@Column(name="VERSION",unique=false, nullable=true)
	private String version;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEBUT",unique=false, nullable=true)
	private Date dateDebut;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FIN",unique=false, nullable=true)
	private Date dateFin;

	@ManyToOne
	@JoinColumn(name="ANNEE_ID")
	private AnneeAcademique anneeAcademique;
	
	@ManyToOne
	@JoinColumn(name="SEMESTRE_ID")
	private Semestre semestre;

	@ManyToOne
	@JoinColumn(name="GROUPE_ID")
	private Groupe groupe;

	

}
