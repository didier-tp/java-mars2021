package tp;

public class AvionV1 {
	
	public static final int TAILLE_MAX=50;
	
	private Personne[] tabElements = new Personne[TAILLE_MAX];
	//en V1, tabElements est un tableau de références 
	//sur des futurs objets "Personne"
	
	private int nbElements; //nombre d'éléments utilisés du tableau
	
	public void addElement(Personne p) {
		//on ajoute la référence p dans le tableau
		//interne privé tabElements s'il reste de la place
	}
	
	public void afficher() {
		//on affiche nbElements
		//on affiche tous les éléments (Personne) référencés par le tableau
	}
	
	public void initialiser() {
		//on initialise un jeu de données
		this.addElement(new Personne("pilote" , 45 , 68.8));
		this.addElement(new Personne("hotesse" , 40 , 58.8));
	}
	
	//+ constructeur , + get/Set , ....

}
