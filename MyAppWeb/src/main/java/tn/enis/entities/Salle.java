package tn.enis.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "SALLE")
public class Salle implements Serializable {

	@Id
	@Column(name = "SALLE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private long salleId;

	@Column(name = "NUMERO", unique = true, nullable = false)
	private String numero;

	@Column(name = "CAPACITE", unique = false, nullable = true)
	private int capacite;

	@Column(name = "DISPONIBLE")
	private boolean disponible;
	
	@Column(name = "TYPE_SALLE", unique = false, nullable = true)
	private String typeSalle;
	
	@ManyToMany
	@JoinTable(name="SALLE_DEPARTEMENTS", 
    joinColumns=@JoinColumn(name="SALLEID"),
    inverseJoinColumns=@JoinColumn(name="DEPARTEMENT_ID"))
	private Collection<Departement> departements;
	
	

	
}
