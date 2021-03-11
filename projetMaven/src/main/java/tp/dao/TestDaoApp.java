package tp.dao;

import java.util.List;

import tp.data.Devise;

public class TestDaoApp {
	
	
	public static void main(String[] args) {
	
        DeviseDao deviseDao = null; //DeviseDao est une interface
        deviseDao = new DeviseDaoSimulation();
        Devise deviseDollar = deviseDao.rechercherDevise("USD");
        System.out.println("deviseDollar= "+deviseDollar);
        
        //Tests qui enchaine ajout , recup liste complete
        //modif , recupere via code pour verfier mise à jour
        //suppression
        Devise nouvelleDevise = new Devise("MS","Monnaie Singe",1223445555.0);
        deviseDao.creerDevise(nouvelleDevise); //creer/ajouter/sauvegarder
        
        //Récuperer toute la liste et afficher les devises 1 par 1 (1 par ligne)
        List<Devise> toutesDevises = deviseDao.rechercherToutesDevises();
        for(Devise d : toutesDevises) {
        	System.out.println("\t"+d); // "\t" est une tabulation
        }
        
        Devise deviseAmodifier = nouvelleDevise;
        deviseAmodifier.setNom("Monnaie Singe Reevaluee");
        deviseAmodifier.setChange(3455.666);
        deviseDao.updateDevise(deviseAmodifier);
        
        //...récuper via deviseDao.rechercherDevise la devise de code ="MS"
        //afficher les valeurs
        Devise deviseMS_relue=deviseDao.rechercherDevise("MS");
        System.out.println("deviseMS_relue="+ deviseMS_relue);
        
        //...supprimer la monnaie de code "MS" + eventuelle verification
        deviseDao.supprimerDevise("MS");
        deviseMS_relue=deviseDao.rechercherDevise("MS");
        if(deviseMS_relue==null) {
        	System.out.println("devise MS bien suprimee");
        }
        //toutesDevises = deviseDao.rechercherToutesDevises();
        //System.out.println("toutesDevises apres suppression:"+toutesDevises);
	}

}
