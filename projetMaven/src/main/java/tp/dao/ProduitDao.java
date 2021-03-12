package tp.dao;

import java.util.List;

import tp.data.Produit;

/*
 * DAO = Data Access Object (objet java sp�cialis� dans l'acc�s aux donn�es)
 * avec m�thodes "CRUD" (Create/Cr�er , Rechercher , Update , Delete)
 */
public interface ProduitDao {
     public Produit creerProduit(Produit p); //ajout en memoire ou INSERT INTO
     public List<Produit> rechercherTousProduits(); //SELECT SQL
}
