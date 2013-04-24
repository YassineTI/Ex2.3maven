package filesys;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    
    //ajouter un fichier de chemin "chemin" dans un repertoire destination
    public String ajouterFichier(String chemin, Repertoire destination) throws IOException{
    	File file = new File(chemin);
    	System.out.println(file.createNewFile());
        return file.getAbsolutePath();
    }
    
    //ajouter un repertoire de chemin "chemin" dans un repertoire destination
    public String ajouterRepertoire(String chemin, Repertoire destination) throws NameAlreadyBoundException{
    	String c = testerPossibiliteAjout(chemin, destination);
    	File file = new File(c);
    	System.out.println(file.mkdir());
        return file.getAbsolutePath();
    }
    
    public String testerPossibiliteAjout(String chemin, Repertoire destination){
    	
    	File file_dest = new File(destination.getNom());
    	try{
			if(!file_dest.exists()){
				throw new FileNotFoundException ("Répertoire introuvable");
		}
			
		}catch (FileNotFoundException e) {
			System.out.println("Répertoire introuvable");
		}
		
    	File[] list = file_dest.listFiles();
    	System.out.println(destination.getNom());
    	
    	
    	//ne pas ajouter une référence null à un répertoire!!!
    	
    		if(chemin != null){
    			
    	
    	//on teste si c'est null avant de creer le File
    	File file = new File(chemin);
    	System.out.println(file.getAbsolutePath());
    	
    	//ne pas ajouter un element de mm nom
    	try{
    		for(File child : list){
    			
    			if(file.equals(child))
        			throw new NameAlreadyBoundException("on ne peut pas ajouter un element de même nom");
        
    		  }
    		}catch (NameAlreadyBoundException e) {
    		System.out.println("on ne peut pas ajouter un element de même nom!!!!    Ce nom existe déja.");
		}
    	
    	//ne pas ajouter un repertoire dans lui mm
    	try{
    		
    		String dest_chem = destination.getNom();
    		if(file.getAbsolutePath().equals(dest_chem))
    			throw new Exception("on ne peut pas ajouter un repertoire dans lui mm!!!");
    	}catch (Exception e) {
    		System.out.println("on ne peut pas ajouter un repertoire dans lui mm!!!");
		}
    		return file.getAbsolutePath();
    }
    		else {
    			System.out.println("on ne peut pas ajouter une référence null à un répertoire!!!");
    			
    			return null;
      		
      		
    		}
    }
    
    public int getTaille()
    {
        int taille = 0;
        //parcours liste
        for (Entite e : arbo)
            taille += e.getTaille();
        return taille;
    }
    
    
    //parcours recursif d'un repertoire pour calculer sa taille
    public int recursif (String chemin,int t)throws Exception{
		int j = 0, i=0;
		int taille = t;
		
		File file = new File(chemin);
		try{
			if(!file.exists()){
				throw new FileNotFoundException ("fichier introuvable");
		}
			
		}catch (FileNotFoundException e) {
			System.out.println("fichier introuvable");
		}
		if(file.isDirectory()){
			
					File[] listfile = file.listFiles();
					Repertoire rep = new Repertoire(chemin);
					for (File child : listfile) {	
					
					
					if(child.isDirectory())
					{
							i++;
							j = recursif(child.getAbsolutePath(),taille);
					}
					
					Fichier f = new Fichier(child.getName(), (int) child.length());
					rep.ajout(f);
					taille = rep.getTaille();
			}		
					if(i!=0)
						System.out.println("La taille totale est : "+ (j+taille));
						else System.out.println("La taille du sous repertoire "+"\""+file.getAbsolutePath()+"\""+" est "+ (j+taille));
		}
		return taille;
		}
	}