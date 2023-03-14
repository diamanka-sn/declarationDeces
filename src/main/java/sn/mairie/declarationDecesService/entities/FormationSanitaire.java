package sn.mairie.declarationDecesService.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="formationSanitaire")
@Data
@NoArgsConstructor @AllArgsConstructor @ToString

public class FormationSanitaire {
	@Id
	@GeneratedValue(strategy = (GenerationType.IDENTITY))
	private Long id;
	private String code;
	private String libele;
	private String type;
	@OneToMany(mappedBy = "formationSanitaire")
	private Collection<Declaration> declaration;
}
