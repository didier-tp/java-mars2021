package tp;

public abstract class Porte {
	private String couleur;
	public abstract void ouvrir() ;
	public abstract void fermer(); 

	public Porte() {
		super();
	}
	public Porte(String couleur) {
		super();
		this.couleur = couleur;
	}
	
	
	@Override
	public String toString() {
		return "Porte [couleur=" + couleur + "]";
	}
	
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
}
