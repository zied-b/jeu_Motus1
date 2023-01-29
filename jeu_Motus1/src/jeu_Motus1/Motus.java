package jeu_Motus1;
import java.util.ArrayList;
import java.util.Scanner;

public class Motus {
	public static void main(String[] args) {
		Scanner sc1= new Scanner(System.in);
		while(!args[0].equals("quitter")) {
		
	     System.out.println("Mode non reconnu, veuillez entrer 'config' ou 'jeu' ou 'quitter'");
		 args[0]=sc1.next();
		 if(!args[0].equals("quitter")){
		 System.out.println("Taille de Mot en Nbre entre 5 et 10 : ");
		 args[1]= sc1.next();
		 
	    Dictionnaire dictionnaire = null;
	    Jeu jeu = null;
	    
	    
	    int tailleMot = Integer.parseInt(args[1]);
        ArrayList<String> mots = new ArrayList<String>();
        Scanner scannerListeMots = new Scanner(new Motus().getClass().getClassLoader().getResourceAsStream("d"+tailleMot+".txt"));
        int i=0;
        while(scannerListeMots.hasNextLine()) {
		    
			String Chain = (String) scannerListeMots.nextLine();
			String[] Mots = Chain.split("[, .?]+");

			for (String mot : Mots) {
				mots.add(mot);
				System.out.println(mot);
				i++;
			}
	        }
	  
	    if(args[0].equals("config")) {
	        
	        dictionnaire = new Dictionnaire(tailleMot, mots.size(), mots);
	        Scanner scanner = new Scanner(System.in);
	        while(true) {
	            
	            System.out.println("Rechercher Mot Tapez 'R'");
	            System.out.println("Ajouter Mot Tapez 'A'");
	            System.out.println("Supprime Mot Tapez 'S'");
	            System.out.println("Pour quitter tapez 'Q'");
	            String mot = scanner.nextLine();
	            if(mot.equals("Q")) {
	            	
	                break;
	            }
	            if(mot.equals("R")) {
	            	System.out.println("Entrez un mot de taille "+tailleMot+" pour 'Rechercher' : ");
	            	String Mot = scanner.nextLine();
	                if(Mot.length()!=tailleMot) {
	                	System.out.println("Cette Mot '"+Mot+" No Valide ! Car length different length de ficher d"+tailleMot+".txt");
	                }else {
	                	if(dictionnaire.rechercheMot(Mot)) {
	                		System.out.println("Cette Mot '"+Mot+"' Dans Fichier d"+tailleMot+".txt");
	                		
	                	}else {
	                		System.out.println("Cette Mot '"+Mot+"' n'est pas Dans Fichier d"+tailleMot+".txt");
	                	}
	            }
	        }
	            if(mot.equals("A")) {
	            	System.out.println("Entrez un mot de taille "+tailleMot+" pour 'Ajouter' : ");
	            	String Mot = scanner.nextLine();
	                if(Mot.length()!=tailleMot) {
	                	System.out.println("Cette Mot '"+Mot+" No Valide ! Car length different length de ficher d"+tailleMot+".txt");
	                }else {
	                	if(dictionnaire.ajoutMot(Mot)) {
	                		System.out.println("Ajouter Valide");
	                	}else {
	                		System.out.println("Ajouter Non Valide");
	                	}
	                }
	            }
	            if(mot.equals("S")) {
	            	System.out.println("Entrez un mot de taille "+tailleMot+" pour 'Supprime' : ");
	            	String Mot = scanner.nextLine();
	                if(Mot.length()!=tailleMot) {
	                	System.out.println("Cette Mot '"+Mot+" No Valide ! Car length different length de ficher d"+tailleMot+".txt");
	                }else {
	                	if(dictionnaire.supprimeMot(Mot)) {
	                		System.out.println("Supprime");
	                	}else {
	                		System.out.println("Non supprime");
	                	}
	                }
	            }
	        }
	            
	        System.out.println("Configuration terminée, voici les mots enregistrés : " + dictionnaire.getCollectionMots());
	    } else if(args[0].equals("jeu")) {
	      
	        Scanner sc =new Scanner(System.in);
	       
	        dictionnaire = new Dictionnaire(tailleMot, mots.size(), mots);
	        System.out.println("Donner Nbre Essais  :");
	        int EssaisRestant = sc.nextInt();
	        jeu = new Jeu(dictionnaire.getCollectionMots(),EssaisRestant);
	        while(jeu.getNbEssaisRestants() > 0) {
	            System.out.println("Entrez un mot de taille " + tailleMot + " :");
	            String mot = sc.next();
	            jeu.nbEssaisRestants-=1;
	            if(jeu.testMot(mot)) {
	                System.out.println("Bravo, vous avez gagné ! Le mot était " + jeu.getMotCache().get(0));
	                break;
	            } else {
	                System.out.println("Désolé, ce n'est pas le mot. Il vous reste " + jeu.getNbEssaisRestants() + " essais. Voici les lettres trouvées : " + jeu.getMotTrouve());
	            }
	            
	           
	            
	        }
	        
	        if(jeu.getNbEssaisRestants() == 0) {
	        	
	            System.out.println("Désolé, vous avez perdu. Le mot était " + jeu.getMotCache().get(0));
	            
	            
	       }
	    }
	        
	   } 
	}
		System.out.println("------------------------- Fin programme -------------------------------------------------");
 }
}
	
