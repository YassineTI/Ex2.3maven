package filesys;

/**
 * Write a description of class Entite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Entite
{
    // instance variables - replace the example below with your own
    private String nom;

    /**
     * Constructor for objects of class Entite
     */
    public Entite(String parNom)
    {
        // initialise instance variables
       nom = parNom;
    }
    
    public abstract int getTaille();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    
    
}
