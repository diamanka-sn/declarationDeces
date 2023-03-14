package sn.mairie.declarationDecesService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.mairie.declarationDecesService.entities.Declaration;
import sn.mairie.declarationDecesService.services.DeclarationService;

@RunWith(SpringRunner.class)
@SpringBootTest
class MicroServiceDeclarationDecesApplicationTests {

	@Autowired
	private DeclarationService declarationService;
	private Declaration declaration;
	Declaration savedDeclaration;

	@BeforeEach
	public void setUp() {
		declaration = new Declaration();
		declaration.setCentre(null);
		declaration.setDate(new Date());
		declaration.setDeclarant(null);
		declaration.setDeclaration("Déclaration de décès");
		declaration.setDefunt(null);
		declaration.setFormationSanitaire(null);
		declaration.setMention(null);
		declaration.setNature("nature");
		declaration.setReference("REF123");
		declaration.setRegistre(null);
		declaration.setScanAt("scan");
		declaration.setTemoin(null);
		declaration.setUtilisateur(null);

		savedDeclaration = declarationService.save(declaration);

	}

	@Test
	public void saveTest() {
		assertNotNull(savedDeclaration.getIdDeclaration());
		assertEquals("Déclaration de décès", savedDeclaration.getDeclaration());
		assertEquals("nature", savedDeclaration.getNature());
		assertEquals("REF123", savedDeclaration.getReference());
		assertEquals("scan", savedDeclaration.getScanAt());

	}

	@Test
	public void testRemoveDeclaration() {
		// Vérification que la déclaration a bien été sauvegardée
		assertNotNull(savedDeclaration.getIdDeclaration());

		// Suppression de la déclaration
		declarationService.remove(savedDeclaration.getIdDeclaration());

		// Vérification que la déclaration a bien été supprimée
		Declaration deletedDeclaration = declarationService.findById(savedDeclaration.getIdDeclaration());
		assertNull(deletedDeclaration);
	}

	@Test
	public void searchTest() {
		Declaration foundDeclaration = declarationService.search(savedDeclaration.getIdDeclaration());
		assertNotNull(foundDeclaration);
		assertEquals("Déclaration de décès", foundDeclaration.getDeclaration());
		assertEquals("nature", foundDeclaration.getNature());
		assertEquals("REF123", foundDeclaration.getReference());
		assertEquals("scan", foundDeclaration.getScanAt());
	}

	@Test
	public void updateTest() {
		Long id = savedDeclaration.getIdDeclaration();

		Declaration declarationToUpdate = new Declaration();
		declarationToUpdate.setIdDeclaration(1L);
		declarationToUpdate.setDate(new Date());
		declarationToUpdate.setDeclaration("Updated Test");
		declarationToUpdate.setReference("REF456");

		declarationService.update(id, declarationToUpdate);

		Declaration result = declarationService.findById(id);

		assertNotNull(result);
		assertEquals("Déclaration de décès", result.getDeclaration());
		assertEquals("nature", result.getNature());
		assertEquals("REF123", result.getReference());
		assertEquals("scan", result.getScanAt());
	}

	@Test
	public void findByIdTest() {
		Long id = savedDeclaration.getIdDeclaration();

		// Récupération de la déclaration par son ID
		Declaration foundDeclaration = declarationService.findById(id);

		// Vérification que la déclaration a été trouvée
		assertNotNull(foundDeclaration);

		// Vérification que les attributs de la déclaration sont corrects
		assertEquals("Déclaration de décès", foundDeclaration.getDeclaration());
		assertEquals("nature", foundDeclaration.getNature());
		assertEquals("REF123", foundDeclaration.getReference());
		assertEquals("scan", foundDeclaration.getScanAt());
	}

	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ "newNature", "newRef", "newScan", "Modification effectuée" },
				// { null, "newRef", "newScan", "Modification echouée" },
				// { "newNature", null, "newScan", "Modification echouée" },
				// { "newNature", "newRef", null, "Modification echouée" }
		});
	}

	@ParameterizedTest
	@MethodSource("data")
	public void testUpdate(String newNature, String newRef, String newScan, String expectedMessage) {
		Declaration newDeclaration = new Declaration();
		newDeclaration.setNature(newNature);
		newDeclaration.setReference(newRef);
		newDeclaration.setScanAt(newScan);

		String message = declarationService.update(declaration.getIdDeclaration(), newDeclaration);
		assertEquals(expectedMessage, message);

	}

}
