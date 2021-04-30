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
@Table(name="MATIERE")
public class Matiere implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@EqualsAndHashCode.Include
	@Column(name="MATIERE_ID", nullable=false, unique=true)
	private long matiereId;
	
	@Column(name="NOM", nullable=true, unique=false)
	private String nom;

	@Column(name="DESCRIPTION", nullable=true, unique=false)
	private String description;
	
	@Column(name="TYPE", nullable=false, unique=false)
	private String type;
	
	@Column(name="NOMBRE_HEURE", nullable=false, unique=false)
	private float nombreHeure;
	
	@Column(name="VOLUME_C", nullable=true, unique=false)
	private float volumeC;
	
	@Column(name="VOLUME_TP", nullable=true, unique=false)
	private float volumeTp;
	
	@Column(name="VOLUME_TD", nullable=true, unique=false)
	private float volumeTd;

	@Column(name="CREDIT", nullable=true, unique=false)
	private float credit;
	
	@Column(name="COEFFICIENT", nullable=true, unique=false)
	private int coefficient;
	
	@ManyToOne
	@JoinColumn(name="UNITE_ID")
	private Unite unite;
	
	@ManyToMany
	@JoinTable(name="MATIERE_PLAN_ETUDE", 
    joinColumns=@JoinColumn(name="MATIERE_ID"),
    inverseJoinColumns=@JoinColumn(name="PLAN_ETUDE_ID"))
	private Collection<PlanEtude> plansEtude;
	

}
