package tp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tp.data.Produit;
import tp.data.Stat;
import tp.util.MyCsvUtilV1;

public class FileAppV1 {
	
	

	public static void main(String[] args) {
		// lire le fichier produits.csv et remonter le contenu dans une collection de String
		List<String> listeLignes = new ArrayList<>();
		try {
			FileInputStream ifile = new FileInputStream("produits.csv"); 
			//sera recherché à la racine du projet eclipse tpJavaMaven
			
			//BufferedReader dis =  new BufferedReader(new InputStreamReader(ifile));
			Scanner scanner = new Scanner(ifile);
			
			String ligneLue="";
			while (ligneLue!=null) {
				   if(scanner.hasNext()) {
				       ligneLue=scanner.nextLine();//better than .next() if space in value
				   }
				   else ligneLue=null; 
			       //ligneLue = dis.readLine(); // lecture d'une ligne dans le fichier
			      
				   //System.out.println("ligneLue="+ligneLue);
				   
				   //ajouter ligneLue dans listeLignes
			       if(ligneLue!=null)
			    	   listeLignes.add(ligneLue);
			}
			//dis.close();
			scanner.close();
			ifile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		// transformer la liste de lignes lues (List<String>) en liste de produit (List<Produit>)
		List<Produit> listeProduits = new ArrayList<>();
		listeLignes.remove(0);//on ignore la première ligne lue
		for(String ligne : listeLignes  ) {
			String[] parties = ligne.split(";");
			//parties[0] : valeur de l'id , Integer.parseInt()
			//parties[1] : valeur du label , 
			//parties[2] : valeur du prixHt , Double.parseDouble()
			//parties[3] : valeur du tauxTva , Double.parseDouble()	
			Produit produit = new Produit();
			produit.setId(Integer.parseInt(parties[0])); 
			produit.setLabel(parties[1]);
			produit.setPrixHt(Double.parseDouble(parties[2]));
			produit.setTauxTva(Double.parseDouble(parties[3]));
			listeProduits.add(produit);
		}
		// via une boucle for , on calculera la somme des prix
		double prixTotalHt=0.0;
		double prixTotalTtc=0.0;
		for(Produit prod : listeProduits) {
			prixTotalHt+=prod.getPrixHt(); //prixTotal=prixTotal+prod.getPrixHt(); 
			prixTotalTtc+=prod.getPrixHt() * (1+ prod.getTauxTva()/100.0);
		}
		Stat statHt = new Stat();		statHt.setLabel("statHt");
		statHt.setSomme(prixTotalHt);   statHt.setMoyenne(prixTotalHt/listeProduits.size());
		statHt.setEcartType(null);      
		Stat statTtc = new Stat("statTtc",prixTotalTtc,prixTotalTtc/listeProduits.size(),null);
		List<Stat> listeStats = new ArrayList<>();
		listeStats.add(statHt); 	listeStats.add(statTtc); 
		
		MyCsvUtilV1.writeValuesAsCsvFile(listeStats,"stats.csv");
		
		// afficher la somme des prix à l'écran
		System.out.println("prixTotalHt="+prixTotalHt);
	}

}
