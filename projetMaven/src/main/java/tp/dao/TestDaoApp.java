package tp.dao;

import java.util.List;

import tp.data.Devise;

public class TestDaoApp {
	
	
	public static void main(String[] args) {
		testCRUD_complet("MS",true);
		//testCRUD_complet("MS2",false);
		//testElementaire();
	}
	
	public static void testElementaire() {
		 DeviseDao deviseDao = null; //DeviseDao est une interface
	     deviseDao = new DeviseDaoJdbc();
	     
	   //R�cuperer toute la liste et afficher les devises 1 par 1 (1 par ligne)
	        List<Devise> toutesDevises = deviseDao.rechercherToutesDevises();
	        for(Devise d : toutesDevises) {
	        	System.out.println("\t"+d); // "\t" est une tabulation
	        }
	}
	
	
	public static void testCRUD_complet(String pk , boolean suppression) {
		if(pk==null) pk = "MS" ; //code de la nouvelle monnaie ajout�e
		//suppression = true si suppression � la fin
		
        DeviseDao deviseDao = null; //DeviseDao est une interface
        //deviseDao = new DeviseDaoSimulation();
        deviseDao = new DeviseDaoJdbc();
        Devise deviseDollar = deviseDao.rechercherDevise("USD");
        System.out.println("deviseDollar= "+deviseDollar);
        
        //Tests qui enchaine ajout , recup liste complete
        //modif , recupere via code pour verfier mise � jour
        //suppression
        Devise nouvelleDevise = new Devise(pk,"Monnaie Singe",1223445555.0);
        deviseDao.creerDevise(nouvelleDevise); //creer/ajouter/sauvegarder
        
        //R�cuperer toute la liste et afficher les devises 1 par 1 (1 par ligne)
        List<Devise> toutesDevises = deviseDao.rechercherToutesDevises();
        for(Devise d : toutesDevises) {
        	System.out.println("\t"+d); // "\t" est une tabulation
        }
        
        Devise deviseAmodifier = nouvelleDevise;
        deviseAmodifier.setNom("Monnaie Singe Reevaluee");
        deviseAmodifier.setChange(3455.666);
        deviseDao.updateDevise(deviseAmodifier);
        
        //...r�cuper via deviseDao.rechercherDevise la devise de code pk="MS"
        //afficher les valeurs
        Devise deviseMS_relue=deviseDao.rechercherDevise(pk);
        System.out.println("deviseMS_relue="+ deviseMS_relue);
        
        if(suppression) {
	        //...supprimer la monnaie de code pk="MS" + eventuelle verification
	        deviseDao.supprimerDevise(pk);
	        deviseMS_relue=deviseDao.rechercherDevise(pk);
	        if(deviseMS_relue==null) {
	        	System.out.println("devise MS bien suprimee");
	        }
        }
        
        //toutesDevises = deviseDao.rechercherToutesDevises();
        //System.out.println("toutesDevises apres suppression:"+toutesDevises);
	}

}
