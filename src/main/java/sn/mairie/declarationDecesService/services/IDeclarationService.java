package sn.mairie.declarationDecesService.services;

import java.util.List;

import sn.mairie.declarationDecesService.entities.Declaration;


public interface IDeclarationService {
	public Declaration save(Declaration declaration);
	
	public List<Declaration> list();
	
	public String remove(Long id);
	
	public Declaration search(Long id);
	
	public String update(Long id,Declaration declaration);

}
