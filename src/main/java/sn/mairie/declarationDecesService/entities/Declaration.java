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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "declarations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Declaration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDeclaration;
	private Date date;
	private String declaration;
	private String reference;
	private String scanAt;
	private Date dateModification;

	private String nature;

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;

	@OneToOne
	@JoinColumn(name = "idDefunt")
	private Defunt defunt;
	@ManyToOne
	@JoinColumn(name = "idDeclarant")
	private Declarant declarant;

	@ManyToMany
	@JoinTable(name = "T_Temoin_declaration", joinColumns = @JoinColumn(name = "idDeclaration"), inverseJoinColumns = @JoinColumn(name = "idTemoin"))
	private Collection<Temoin> temoin;
	@ManyToOne
	@JoinColumn(name = "idCentre")
	private Centre centre;
	@ManyToOne
	@JoinColumn(name = "idRegistre")
	private Registre registre;

	@ManyToOne
	@JoinColumn(name = "idFormationSanitaire")
	private FormationSanitaire formationSanitaire;
	@ManyToMany
	@JoinTable(name = "T_mention_declaration", joinColumns = @JoinColumn(name = "idDeclaration"), inverseJoinColumns = @JoinColumn(name = "idMention"))
	private Collection<Mention> mention;

}
