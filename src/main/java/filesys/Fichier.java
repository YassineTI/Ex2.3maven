package filesys;

/**
 * Write a description of class Fichier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fichier extends Entite
{
    // instance variables - replace the example below with your own
    private int taille;

    /**
     * Constructor for objects of class Fichier
     */
    public Fichier(String parNom, int parTaille)
    {
        // initialise instance variables
        super(parNom);
        taille = parTaille;
    }
    
    public int getTaille()
    {
        return taille;
    }

}
    
