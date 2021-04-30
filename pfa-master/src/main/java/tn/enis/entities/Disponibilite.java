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
@Table(name = "DISPONIBILITE")
public class Disponibilite implements Serializable {

	@Id
	@Column(name = "DISPONIBILITE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private Long disponibiliteId;

	@Column(name = "JOUR", unique = true, nullable = false)
	private String jour;

	/*@ManyToOne
	@JoinColumn(name = "ENSEIGNANT_ID")
	private Enseignant enseignant;*/
	@ManyToOne
	@JoinColumn(name = "CRENEAU_ID")
	private Creneau creneau;

}
