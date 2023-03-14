package sn.mairie.declarationDecesService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.mairie.declarationDecesService.entities.Declarant;

public interface DeclarantRepository extends JpaRepository<Declarant, Long>{

}
