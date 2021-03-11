package tp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tp.data.Produit;

public class StreamApp {
	

	public static void main(String[] args) {

        List<Produit> listeProduits = new ArrayList<>();
        listeProduits.add(new Produit(1,"stylo",1.2,20.0));
        listeProduits.add(new Produit(2,"classeur",3.2,20.0));
        listeProduits.add(new Produit(3,"gomme",2.0,20.0));
        listeProduits.add(new Produit(4,"cahier",4.0,20.0));
        listeProduits.add(new Produit(5,"regle",2.7,20.0));

        System.out.println("liste initiale:");
        for(Produit p : listeProduits) {
        	System.out.println("\t" +p);
        }
        
        //on va enchainer à partir de listeProduits.stream()
        //.sorted ( ... ) avec une lambda pour trier par odre de prix croissant
        //.filter(...) avec une lambda qui filtre les produits prix >=2.5
        //.map (...)  avec une lambda qui va transformer les produits , label en majuscules
        //.collect(Collectors.toList());
        List<Produit> listeProduitsTriesFiltresEtTransformes =
        		listeProduits.stream()
                 .sorted((p1,p2)->(int)(100*(p1.getPrixHt() -p2.getPrixHt())))
                 .filter((p)->p.getPrixHt()>=2.5)
                 .map((p) -> { p.setLabel(p.getLabel().toUpperCase()); return p; })
                 .collect(Collectors.toList());
        
        //exemple de lambda pour .map(...)
        // (p) -> { p.setLabel(p.getLabel().toUpperCase()); return p; }
        
        //afficher la nouvelle liste construite.
        System.out.println("liste triée filtrée et transformée:");
        for(Produit p : listeProduitsTriesFiltresEtTransformes) {
        	System.out.println("\t" +p);
        }
        
       //Version avec affichage direct en fin d'enchainement:
        System.out.println("idem via .forEach():");
        listeProduits.stream()
                 .sorted((p1,p2)->(int)(100*(p1.getPrixHt() -p2.getPrixHt())))
                 .filter((p)->p.getPrixHt()>=2.5)
                 .map((p) -> { p.setLabel(p.getLabel().toUpperCase()); return p; })
                 .forEach( (p) -> System.out.println(p) );
        
        //"moyenne des prix de tous les produits:"
        Double sommePrixHt = listeProduits.stream()
                 .map((p) -> p.getPrixHt())
                 .reduce(0.0 , (x,y) -> x+y);
        System.out.println("moyenne des prixHt de tous les produits:"+sommePrixHt/listeProduits.size());
	}
}
