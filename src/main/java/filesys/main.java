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
		// TODO Auto-generated method stub

		//String chemin = "C:\\Users\\Yousra\\Documents\\Workspace\\Ex2.3\\filesys\\dossier\\new2";
		
		System.out.print("Entrer le chemin du fichier/repertoire que vous souhaitez calculer sa taille: ");
		Scanner sc = new Scanner(System.in);
		
		//File file = new File(chemin);
		//System.out.println(file.mkdir());
		String s = sc.nextLine();
		System.out.println(s);
		
		File file = new File(s);
		if(file.isFile()){
			Entite fichier = new Fichier(s, (int)file.length());
			System.out.println("la taille du fichier localisé dans "+s+" est : "+fichier.getTaille());
		}
		else if(file.isDirectory())
			recursif(s,0);
			
		
//		
//		File f = null;
//	      String[] paths;
//	            
//	      try{      
//	         // create new file
//	         f = new File("c:/test");
//	                                 
//	         // array of files and directory
//	         paths = f.list();
//	            
//	         // for each name in the path array
//	         for(String path:paths)
//	         {
//	            // prints filename and directory name
//	            System.out.println(path);
//	         }
//	      }catch(Exception e){
//	         // if any error occurs
//	         e.printStackTrace();
//	      }
		
		
		
//		File f = null;
//	      String path;
//	      boolean bool = false;
//	      
//	      try{
//	         // create new file
//	         f = new File("C:\\Users\\Yousra\\Documents\\Workspace\\Ex2.3\\filesys\\dossier");
//	            
//	         // true if the file path is directory, else false
//	         bool = f.isDirectory();
//	         
//	         // get the path
//	         path = f.getPath();
//	         
//	         // prints
//	         System.out.println(path+" is directory? "+ bool);
//	               
//	         // create new file
//	         f = new File("c:/test.txt");
//	         
//	         // true if the file path is directory, else false
//	         bool = f.isDirectory();
//	         
//	         // get the path
//	         path = f.getPath();
//	         
//	         // prints
//	         System.out.println(path+" is directory? "+bool);
//	         
//	      }catch(Exception e){
//	         // if any error occurs
//	         e.printStackTrace();
//	      }
//		
		
		
		
		
		
		
		
		
		
		
		
		
//		int taille = 1;
//		String chemin = "C:\\Users\\Yousra\\Documents\\Workspace\\Ex2.3\\filesys\\dossier";
//		
//			
//		//String chemin = "Fichier.ctxt";
//		File file = new File(chemin);
////		String path2 = file.getAbsolutePath();
////		System.out.println("path is : "+path2);
//		//file.createNewFile();
//		if(file.isFile())
//		{
//		Entite fichier = new Fichier(chemin, (int) file.length());
//		
//		taille = fichier.getTaille();
//		}
//		else if(file.isDirectory())
//		{
//			System.out.println(" is a directory ");
//			//if(file.canRead()){
//				if(file != null)
//			{
//				File[] listfile = file.listFiles();
//			//System.out.println(" it's a directory ");
//			
//			//if(listfile != null)
//			//System.out.println("nooot  nuuuuuuuuuuulllllll");
//			Repertoire rep = new Repertoire(chemin);
//			for (File child : listfile) {
//				Fichier f = new Fichier(child.getName(), (int) child.length());
//				rep.ajout(f);
//				//System.out.println("2.la taille du fichier est : "+ taille);
//			taille = rep.getTaille();
//			
//			}
//			//}
//			
//			
//			
//			
//			//Entite en;// = new Repertoire(chemin); 
//			// = new Repertoire(child);
////			Repertoire rep = new Repertoire(chemin);
////			for (String child : listfile) {
////				System.out.println("2.la taille du fichier est : "+ taille);
////				//Fichier rep = new Fichier(child, (int) child.length());
////				//en = new Repertoire(child);
////				//rep.ajout(en);
////			taille = rep.getTaille();
//			//System.out.println("la taille du fichier est : "+ taille);
//			}
//		}
//		System.out.println("la taille du fichier est : "+ taille);
//		
//	}

	}
	
	
	public static int recursif (String chemin,int t)throws Exception{
		int j = 0;
		int taille = t;
		//String chemin = "C:\\Users\\Yousra\\Documents\\Workspace\\Ex2.3\\filesys\\dossier";
		
		
		File file = new File(chemin);
		//
		try{
			if(!file.exists()){
				throw new FileNotFoundException ("fichier introuvable");
		}
			
		}catch (FileNotFoundException e) {
			System.out.println("fichier introuvable");
			e.printStackTrace();
		}
			
		//}
		
		if(file.isDirectory()){
			//try{
			//if(file != null)
			//{
				//System.out.println("dossier vide");//throw new Exception("dossier vide");
//			}catch (Exception e) {
//				System.out.println("dossier vide");
//				e.printStackTrace();
//			}
			
					File[] listfile = file.listFiles();
					Repertoire rep = new Repertoire(chemin);
					for (File child : listfile) {	
					
					
					if(child.isDirectory())
					{
							
							//System.out.println("dans repertoire : la taille du fichier est : "+taille);
							j = recursif(child.getAbsolutePath(),taille);
							//System.out.println("j : "+ j);
							//System.out.println("taille de recursif "+ j);
							
					}

					Fichier f = new Fichier(child.getName(), (int) child.length());
					rep.ajout(f);
					//laboureur
					taille = rep.getTaille();
					//System.out.println("taille = rep.getTaille() : "+ rep.getTaille());
					
					System.out.println("le else    "+child.getAbsolutePath());
			}		
					
					System.out.println("derniere ligne la taille du fichier est : "+ (j+taille));


				
		
			
		
		//throw new Exception("yaa ilaaaaaaaaaaahi");
//		}catch (NullPointerException e) {
//			e.printStackTrace();
//			System.out.println("nulllPOinterException!!");
//		}
//		catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("apparemment le chemin est incorrect ou le fichier n'existe pas!!");
//		}
		//}
		}
		return taille;
		}}
		
		
		
		
	
	
//public static void recursif(String chemin){	
//	int i = 0;
//	int taille = 1;
//	//String chemin = "C:\\Users\\Yousra\\Documents\\Workspace\\Ex2.3\\filesys\\dossier";
//	
//	File file = new File(chemin);
//	File[] listfile = file.listFiles();
//	
//	if(listfile != null){
//		
//		for (File child : listfile) {
//			
//			if(child.isDirectory())
//		{
//			//System.out.println(" is a directory ");
//			
//				Repertoire rep = new Repertoire(child.getAbsolutePath());
//				System.out.println(++i);
//				System.out.println(child.getAbsolutePath());
//				chemin = child.getAbsolutePath();
//				
//				
//				
//				Fichier f = new Fichier(child.getName(), (int) child.length());
//				rep.ajout(f);
//				taille = rep.getTaille();recursif(chemin);
//				//System.out.println("la taille du fichier est : "+ taille);
//		}
//			
//			else if(child.isFile())
//		{
//				Entite fichier = new Fichier(chemin, (int) child.length());
//				
//				taille = fichier.getTaille();
//			//System.out.println("la taille du fichier est : "+ taille);
//			}
//			System.out.println("la taille du fichier est : "+ taille);
//		}
//		
//	}
//	//else 
//	//
//	
//}
//}

// throw new Exception("The input path is not a file : " /*+ path*/);
