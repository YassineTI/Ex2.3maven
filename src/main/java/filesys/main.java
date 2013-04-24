package filesys;

//import java.io.File;
import java.io.*;
import java.util.Scanner;

public class main {

	/** 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.print("Entrer le chemin du fichier/repertoire que vous souhaitez calculer sa taille: ");
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		System.out.println(s);
		
		
		File file = new File(s);
		try{
			if(!file.exists()){
				throw new FileNotFoundException ("fichier introuvable");
		}
			
		}catch (FileNotFoundException e) {
			System.out.println("fichier introuvable");
		}
		
		if(file.isFile()){
			Entite fichier = new Fichier(s, (int)file.length());
			System.out.println("la taille du fichier localisé dans "+s+" est : "+fichier.getTaille());
		}
		else if(file.isDirectory())
			recursif(s,(int)file.length());

	}
	
	
	public static int recursif (String chemin,int t)throws Exception{
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