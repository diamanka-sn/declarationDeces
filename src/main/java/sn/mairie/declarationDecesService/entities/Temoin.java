package sn.mairie.declarationDecesService.entities;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "temoins")
public class Temoin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTemoin;
	private String nom;
	private String prenom;
	private String typePiece;
	private String numeroPiece;
	private String domicile;
	private String profession;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String lieuNaissance;
	@ManyToMany
	@JoinTable(name = "T_Temoin_declarationNaissance",
	joinColumns = @JoinColumn(name= "idTemoin"),
	inverseJoinColumns = @JoinColumn(name="idDeclaration"))
	private Collection<Declaration> declaration;
}