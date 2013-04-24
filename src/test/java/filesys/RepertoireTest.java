/**
 * 
 */
package filesys;

import static org.junit.Assert.*;

import java.io.File;

import javax.naming.NameAlreadyBoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yousra
 *
 */
public class RepertoireTest {

	private String c ;
	private File file;
	private Repertoire repertoire;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c= "C:\\Users\\Yousra\\Documents\\Workspace\\Ex2.3\\filesys\\dossier\\new";
		file = new File(c);
		repertoire = 	new Repertoire(file.getAbsolutePath());
		System.out.println(file.getAbsolutePath());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		c=null;
	}

	/**
	 * Test method for {@link filesys.Repertoire#getTaille()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetTaille() throws Exception {
		assertTrue(repertoire.getTaille() == 0);
		assertTrue(main.recursif(c, 0) == 826);
	}

	/**
	 * Test method for {@link filesys.Repertoire#Repertoire(java.lang.String)}.
	 */
	@Test
	public void testRepertoire() {
		assertNotNull("L'instance est créée", repertoire);
	}

	/**
	 * Test method for {@link filesys.Repertoire#ajout(filesys.Entite)}.
	 * @throws NameAlreadyBoundException 
	 */
	@Test
	public void testAjouterAuRep() throws NameAlreadyBoundException {
		assertEquals("Impossible d'ajouter un element de mm nom", c, repertoire.ajouterAuRep(c, repertoire));
		//assertEquals("Impossible d'ajouter un element de mm nom", c, repertoire.ajouterAuRep(c, repertoire));
	}
//	public void testSetNom() {
//	
//		personne.setNom("nom2");
//		assertEquals("Est ce que nom est correct", "nom2", personne.getNom());
//		
//		}
}
