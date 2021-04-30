package tn.enis.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="PLAN_ETUDE")
public class PlanEtude implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4605696189580789688L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@EqualsAndHashCode.Include
	@Column(name="PLAN_ETUDE_ID", nullable=false, unique=true)
	private long planEtudeId;
	
	@ManyToOne
	@JoinColumn(name="SEMESTRE_ID")
	private Semestre semestre;
	
	@ManyToOne
	@JoinColumn(name="PARCOURS_ID")
	private Parcours parcours;
	
	@ManyToMany
	@JoinTable(name="PLAN_ETUDE_MATIERES", 
    joinColumns=@JoinColumn(name="PLAN_ETUDE_ID"),
    inverseJoinColumns=@JoinColumn(name="MATIERE_ID"))
	private Collection<Matiere> matieres;
	

	
}
