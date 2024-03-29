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
 * @author Yassine
 *
 */
public class RepertoireTest {

	private String c , c2, c3;
	private File file;
	private Repertoire repertoire;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c= "C:\\Users\\Yassine\\Documents\\Workspace\\Ex2.3\\filesys\\dossier\\new";
		c2= "C:\\Users\\Yassine\\Documents\\Workspace\\Ex2.3\\filesys\\dossier\\new\\Fichier.java";
		c3= "C:\\Users\\Yassine\\Documents\\Workspace\\Ex2.3\\filesys\\dossier\\new\\test.txt";
		file = new File(c);
		repertoire = 	new Repertoire(file.getAbsolutePath());
		//System.out.println(file.getAbsolutePath());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//c=null;
	}

	/**
	 * Test method for {@link filesys.Repertoire#getTaille()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetTaille() throws Exception {
		assertTrue(repertoire.getTaille() == 0);
		assertTrue(repertoire.recursif(c, 0) == 826);
	}

	/**
	 * Test method for {@link filesys.Repertoire#Repertoire(java.lang.String)}.
	 */
	@Test
	public void testRepertoire() {
		//assertNotNull("L'instance est cr��e", repertoire);
	}

	/**
	 * Test method for {@link filesys.Repertoire#ajout(filesys.Entite)}.
	 * @throws NameAlreadyBoundException 
	 */
	@Test
	public void testerPossibiliteAjout() throws NameAlreadyBoundException {
		assertEquals("Impossible d'ajouter un element de mm nom", c2, repertoire.testerPossibiliteAjout(c2, repertoire));
		assertEquals("Impossible d'ajouter un repertoire dans lui m�me", c, repertoire.testerPossibiliteAjout(c, repertoire));
		assertEquals("Impossible d'ajouter une ref null", null, repertoire.testerPossibiliteAjout(null, repertoire));
	}
}
