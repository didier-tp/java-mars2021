package tp;

public class SousCalcul {

	public static double racineCarree(double x) throws MyArithmeticException{
		if(x>=0)
			return Math.sqrt(x);
		else
			throw new MyArithmeticException("racine carree interdite sur valeur negative");
	}

}
