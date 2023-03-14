package sn.mairie.declarationDecesService.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor @AllArgsConstructor @Data @ToString
@Table(name = "defunts")
public class Defunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30, name="nom")
	private String nom;
	private String prenom;
	private String typePiece;
	//@Size(max=16)
	private String numeroPiece;
	private String profession;
	private String adresse;
	@Temporal(TemporalType.DATE)
	private Date dateNaiss;
	private String lieuNaiss;
	private String nomPere;
	private String nomMere;
	
	@OneToOne(mappedBy = "defunt")
	private Declaration declaration;
}
