package jeu_Motus1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Dictionnaire {
	int tailleMot ;  
	int nbMots      ;  
	ArrayList<String> collectionMots;

	

	public Dictionnaire(int tailleMot, int nbMots, ArrayList<String> collectionMots) {
		super();
		this.tailleMot = tailleMot;
		this.nbMots = nbMots;
		this.collectionMots = collectionMots;
	}

	public ArrayList<String> getCollectionMots() {
		return collectionMots;
	}

	public void setCollectionMots(ArrayList<String> collectionMots) {
		this.collectionMots = collectionMots;
	}

	public boolean ajoutMot(String mot){
        if(mot.length() == this.tailleMot && !this.collectionMots.contains(mot) && mot.matches("[A-Z]+")){
            this.collectionMots.add(mot);
            Collections.sort(this.collectionMots);
            return true;
            }
        else {
        	return false;
        	}
        }
	
	public boolean rechercheMot(String mot) {
		
		return this.collectionMots.contains(mot);
	}
	 public boolean supprimeMot(String mot){
	        if(rechercheMot(mot)){
	            
	            return this.collectionMots.remove(mot);
	        }else {
	            return false;
	        }
	    }
	public int getTailleMot() {
		return tailleMot;
	}
	public void setTailleMot(int tailleMot) {
		this.tailleMot = tailleMot;
	}
	public int getNbMots() {
		return nbMots;
	}
	public void setNbMots(int nbMots) {
		this.nbMots = nbMots;
	}

	@Override
	public String toString() {
		return "Dictionnaire [tailleMot=" + tailleMot + ", nbMots=" + nbMots + ", collectionMots=" + collectionMots
				+ "]";
	}
	
	
	
	

	
	
	
}
