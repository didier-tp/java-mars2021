package tp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import tp.data.Produit;

public class LambdaApp {
	
	public static <T> List<T> filtrerListe(List<T> liste , Predicate<T> filterPredicate){
		List<T> listeRes = new ArrayList<T>();
		for(T obj:liste) {
			if(filterPredicate.test(obj)) {
				listeRes.add(obj);
			}
		}
		return listeRes;
	}

	public static void main(String[] args) {

        List<Produit> listeProduits = new ArrayList<>();
        listeProduits.add(new Produit(1,"stylo",1.2,20.0));
        listeProduits.add(new Produit(2,"classeur",3.2,20.0));
        listeProduits.add(new Produit(3,"gomme",2.0,20.0));
        listeProduits.add(new Produit(4,"cahier",4.0,20.0));

        System.out.println("sans tri:");
        for(Produit p : listeProduits) {
        	System.out.println("\t" +p);
        }
        
        //trier par ordre croissant de prix avec une lambda expression avec ? : ou une soustraction
        /*
        Collections.sort(listeProduits, 
		        (p1,p2)->p1.getPrixHt()==p2.getPrixHt()?0:((p1.getPrixHt()<p2.getPrixHt())?-1:1) );
        
        
        Collections.sort(listeProduits, 
         				(Produit p1,Produit p2)->{ return (int)(100*(p1.getPrixHt() -p2.getPrixHt()));} );
        */
        Collections.sort(listeProduits, 
        				(p1,p2)->(int)(100*(p1.getPrixHt() -p2.getPrixHt())));
        
        
        System.out.println("apres tri par prix croissants:");
        for(Produit p : listeProduits) {
        	System.out.println("\t" +p);
        }
        
        //trier par odre alphabétique sur le label avec une lambda expression qui utilise .compareTo() sur la sous partie label
        Collections.sort(listeProduits, 
				(p1,p2)-> p1.getLabel().compareTo(p2.getLabel()));
        
        //afficher
        System.out.println("apres tri par label:");
        for(Produit p : listeProduits) {
        	System.out.println("\t" +p);
        }
        
       //filtrer les produits de prix <=3.0 
       //List<Produit> listeProduitsFiltres = filtrerListe(listeProduits, (p)->p.getPrixHt()<=3.0   );
       
       //filtrer les produits de prix >= 3.0 et <= 3.5 , &&
       List<Produit> listeProduitsFiltres = filtrerListe(listeProduits,
    		         (p)-> p.getPrixHt()>=3.0 && p.getPrixHt()<=3.5 );
        
       /* 
       List<Produit> listeProduitsFiltres = filtrerListe(listeProduits,
               (Produit p)-> { if(p.getPrixHt()>=3.0 && p.getPrixHt()<=3.5) return true; else return false; } );
       */
      //afficher
        System.out.println("apres filtrage");
        for(Produit p : listeProduitsFiltres) {
        	System.out.println("\t" +p);
        }
        
	}

}
