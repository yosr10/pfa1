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
@Table(name = "PARCOURS")
public class Parcours implements Serializable {
	
	

	@Id
	@Column(name="PARCOURS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private long parcoursId;
	
	@Column(name="NOM", unique = false, nullable = true)
	private String nom;
	
	@Column(name="ABBREVIATION", unique = false, nullable = true)
	private String abbreviation;
	
	
	
}
