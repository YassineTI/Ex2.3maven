package filesys;

//import java.io.File;
import java.io.*;
import java.util.Scanner;

public class main {

	/** 
	 * @param args
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		
		System.out.print("Entrer le chemin du fichier/repertoire que vous souhaitez calculer sa taille: ");
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		System.out.println(s);
		
		if(s != null){
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
			else if(file.isDirectory()){
					Repertoire repertoire = new Repertoire(s);
					repertoire.recursif(s,(int)file.length());
				}
		}
		}
		
}	