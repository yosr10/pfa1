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
@Table(name = "CRENEAU")
public class Creneau implements Serializable {

	private static final long serialVersionUID = 1L;
 
	@Id
	@Column(name = "CRENEAU_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private Long creneauId;
	
//	@Column(name = "HEURE_DEBUT", unique = true, nullable = false)
//	private Date heureDebut;
//	
//	@Column(name = "HEURE_FIN", unique = true, nullable = false)
//	private Date heureFin;
	@Column(name = "ORDRE", unique = true, nullable = false)
	private int ordre;
	
	@Column(name = "LIBELLE", unique = true, nullable = false)
	private String libelle;
	

	
}
