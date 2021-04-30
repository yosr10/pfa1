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
@Table(name="SEANCE")
public class Seance implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@EqualsAndHashCode.Include
	@Column(name="SEANCE_ID", unique=true, nullable=false)
	private long seanceId;
	
	@Column(name="NUMERO", unique=false, nullable=true)
	private int numero;
	
	@Column(name="JOUR", unique=false, nullable=true)
	private String jour;

	@ManyToOne
	@JoinColumn(name="EMPLOI_ID")
	private Emploi emploi;
	
	@ManyToOne
	@JoinColumn(name="CRENEAU_ID")
	private Creneau creneau;
	
	@ManyToOne
	@JoinColumn(name="MATIERE_ID")
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="SALLE_ID")
	private Salle salle ;
	

	
	
}
