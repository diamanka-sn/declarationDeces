package sn.mairie.declarationDecesService.entities;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "mentions")
public class Mention {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMention;
	private String apposition;
	private String libele;
	@ManyToMany
	@JoinTable(name = "T_mention_declaration",
	joinColumns = @JoinColumn(name= "idMention"),
	inverseJoinColumns = @JoinColumn(name="idDeclaration"))
	private Collection<Declaration> declaration;
	
}

