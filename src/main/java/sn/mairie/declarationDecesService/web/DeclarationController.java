package sn.mairie.declarationDecesService.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.mairie.declarationDecesService.entities.Declaration;
import sn.mairie.declarationDecesService.services.IDeclarationService;

@RestController
@RequestMapping("/declarations")
public class DeclarationController {
	@Autowired
	IDeclarationService declarationService;
	
	@PostMapping("/create")
	public Declaration save(@RequestBody Declaration declaration) {
		return declarationService.save(declaration);
	}
	@GetMapping("/read")
	public List<Declaration> list() {
		return declarationService.list();
	}
	@DeleteMapping("/delete/{id}")
	public String remove(@PathVariable Long id) {
		return declarationService.remove(id);
	}
	@GetMapping("/research/{id}")
	public Declaration search(@PathVariable Long id) {
		return declarationService.search(id);
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable Long id,@RequestBody Declaration declaration) {
		return declarationService.update(id, declaration);
	}
	
	
}
