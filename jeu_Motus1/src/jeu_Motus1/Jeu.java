package jeu_Motus1;

import java.util.ArrayList;
import java.util.Random;

public class Jeu {
	static int nbEssais ;
	static int nbEssaisRestants ;
	static int nbPartGagnees ;
	static int nbPartPerdues ;
	static ArrayList <String>motCache ;
	static ArrayList <String> motTrouve;
	ArrayList <String>dictionnaire;
    Random rand;
    
    public Jeu(ArrayList<String> dictionnaire,int nbEssaisRestants) {
        this.dictionnaire = dictionnaire;
        this.rand = new Random();
        this.motCache = new ArrayList<>();
        this.motTrouve = new ArrayList<>();
        int index = this.rand.nextInt(dictionnaire.size());
        motCache.add(dictionnaire.get(index));
        this.nbEssais = 0;
        this.nbEssaisRestants = nbEssaisRestants;
        this.nbPartGagnees = 0;
        this.nbPartPerdues = 0;
    }
    public boolean testMot(String mot) {
        if(mot.length() != motCache.get(0).length() || !mot.matches("[A-Za-z]+")) {
            return false;
        }
        else {
            motTrouve.clear();
            for(int i = 0; i < motCache.get(0).length(); i++) {
                if(motCache.get(0).charAt(i) == mot.charAt(i)) {
                    this.motTrouve.add(String.valueOf(mot.charAt(i)));
                }
                else {
                    this.motTrouve.add("*");
                }
            }
            if(motCache.get(0).equals(mot)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

	
	public static int getNbEssais() {
		return nbEssais;
	}
	public static void setNbEssais(int nbEssais) {
		Jeu.nbEssais = nbEssais;
	}
	public static int getNbEssaisRestants() {
		return nbEssaisRestants;
	}
	public static void setNbEssaisRestants(int nbEssaisRestants) {
		nbEssaisRestants = nbEssaisRestants;
	}
	public static int getNbPartGagnees() {
		return nbPartGagnees;
	}
	public static void setNbPartGagnees(int nbPartGagnees) {
		Jeu.nbPartGagnees = nbPartGagnees;
	}
	public static int getNbPartPerdues() {
		return nbPartPerdues;
	}
	public static void setNbPartPerdues(int nbPartPerdues) {
		Jeu.nbPartPerdues = nbPartPerdues;
	}
	public static ArrayList<String> getMotCache() {
		return motCache;
	}
	public static void setMotCache(ArrayList<String> motCache) {
		Jeu.motCache = motCache;
	}
	public static ArrayList<String> getMotTrouve() {
		return motTrouve;
	}
	public static void setMotTrouve(ArrayList<String> motTrouve) {
		Jeu.motTrouve = motTrouve;
	}
	
	
	
}
