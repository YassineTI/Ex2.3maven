/**
 * 
 */
package filesys;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author Yassine
 *
 */
public class FichierTest {

	private String c ;
	private File file;
	private Fichier fichier;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c= "C:\\creerTables.sql";
		file = new File(c);
		fichier = 	new Fichier(file.getAbsolutePath(), (int) file.length());
		System.out.println(file.length());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//c=null;
	}

	/**
	 * Test method for {@link filesys.Fichier#getTaille()}.
	 * @throws Exception 
	 */
	@Test
	public void testGetTaille() throws Exception {
		assertTrue(main.recursif(c, 0) < 2000);
		assertTrue(fichier.getTaille() == 467);
	}
	
	@Test
	public void testFichier() throws Exception {
	assertNotNull("L'instance est créée", fichier);
	}

}
