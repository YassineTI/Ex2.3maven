package filesys;
import java.io.File;
import java.util.*;

import javax.naming.NameAlreadyBoundException;

/**
 * Write a description of class Repertoire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Repertoire extends Entite
{
    // instance variables - replace the example below with your own
    private ArrayList<Entite> arbo;

    /**
     * Constructor for objects of class Repertoire
     */
    public Repertoire(String parNom)
    {
        // initialise instance variables
        super(parNom);
        arbo = new ArrayList<Entite>();
    }
    
    
    public void ajout(Entite uneEntite)
    {
    	
        arbo.add(uneEntite);
    }
    
    public String ajouterAuRep(String chemin, Repertoire destination) throws NameAlreadyBoundException{
    	File file = new File(chemin);
    	
    	//ne pas ajouter une référence null à un répertoire!!!
    	try{
    		if(chemin == null)
    			throw new NullPointerException("on ne peut pas ajouter une référence null à un répertoire!!!");
    	}catch (NullPointerException e) {
			e.printStackTrace();
		}
    	
    	//ne pas ajouter un element de mm nom
    	try{
    		if(file.exists())
    			throw new NameAlreadyBoundException("on ne peut pas ajouter un element de mm nom");
    	}catch (NameAlreadyBoundException e) {
			e.printStackTrace();
		}
    	
    	//ne pas ajouter un repertoire dans lui mm
    	try{
    		//File parent = file.getParentFile();
    		String dest_chem = destination.getNom();
    		if(file.getAbsolutePath().equals(dest_chem))
    			throw new Exception("on ne peut pas ajouter un repertoire dans lui mm!!!");
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
        System.out.println(file.mkdir());
        return file.getAbsolutePath();
    }
    
    public int getTaille()
    {
        int taille = 0;
        //parcours liste
        for (Entite e : arbo)
            taille += e.getTaille();
        return taille;
    }
    
    


}
