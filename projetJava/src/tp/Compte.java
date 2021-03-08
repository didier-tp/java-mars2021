package tp;

public class Compte {
	// Attributs privés:
	private String numero;
	private float solde;
	// Accesseurs:
	public String getNumero() { return numero;}
	public void setNumero(String numero) { this.numero = numero; }
	public float getSolde() { return solde; }
	public void setSolde(float solde) { this.solde = solde; }
	// Méthodes :
	public Compte() { numero="0"; solde=0; } // constructeur par défaut
	
	
	public Compte(String numero, float solde) {
		super();
		this.numero = numero;
		this.solde = solde;
	}
	
	public void debiter(float montant) { solde = solde - montant; }
	public void crediter(float montant) { solde = solde + montant; }
	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", solde=" + solde + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + Float.floatToIntBits(solde);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (Float.floatToIntBits(solde) != Float.floatToIntBits(other.solde))
			return false;
		return true;
	}

	
	
	
}
