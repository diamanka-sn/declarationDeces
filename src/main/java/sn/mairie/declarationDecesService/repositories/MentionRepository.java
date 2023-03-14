package sn.mairie.declarationDecesService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.mairie.declarationDecesService.entities.Mention;

public interface MentionRepository extends JpaRepository<Mention, Long>{

}
