package sn.mairie.declarationDecesService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.mairie.declarationDecesService.entities.Declaration;

public interface DeclarationRepository extends JpaRepository<Declaration, Long> {

}
