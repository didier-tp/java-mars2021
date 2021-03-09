package tp;

public class AvionV1 {
	
	public static final int TAILLE_MAX=50;
	
	private Personne[] tabElements = new Personne[TAILLE_MAX];
	//en V1, tabElements est un tableau de r�f�rences 
	//sur des futurs objets "Personne"
	
	private int nbElements; //nombre d'�l�ments utilis�s du tableau
	
	public void addElement(Personne p) {
		//on ajoute la r�f�rence p dans le tableau
		//interne priv� tabElements s'il reste de la place
	}
	
	public void afficher() {
		//on affiche nbElements
		//on affiche tous les �l�ments (Personne) r�f�renc�s par le tableau
	}
	
	public void initialiser() {
		//on initialise un jeu de donn�es
		this.addElement(new Personne("pilote" , 45 , 68.8));
		this.addElement(new Personne("hotesse" , 40 , 58.8));
	}
	
	//+ constructeur , + get/Set , ....

}
