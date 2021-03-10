package tp;

public class RacineCarreeApp {

	//java  tp.RacineCarreeApp  81
	
	public static void main(String[] args) {
		try {
			double x = Double.parseDouble(args[0]);
			double y = SousCalcul.racineCarree(x); //si static
			//double y = (new SousCalcul()).racineCarree(x); //si pas static
			System.out.println("racine carrée de " + x + "=" + y);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("il manque un argument au lancement du programme");
			System.err.println("exemple: java  tp.RacineCarreeApp  81");
		}
		catch (NumberFormatException e) {
			System.err.println("l'argument n'est pas numérique (81 ok , abc pas ok)");
		}
		catch (MyArithmeticException e) {
			System.err.println("erreur de calcul : " + e.getMessage());
		}
		catch (Exception e) {
			System.err.println("une exception a eu lieu");
			e.printStackTrace();
		}
		
		//===========
		
		
			try {
				double x=9.0;
				//double x=-9;
				double y = SousCalcul.racineCarree(x);
				System.out.println("y="+y);
			} catch (MyArithmeticException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void main_v1(String[] args) {
		try {
			double x = Double.parseDouble(args[0]);
			double y = Math.sqrt(x);
			System.out.println("racinne carrée de " + x + "=" + y);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("il manque un argument au lancement du programme");
			System.err.println("exemple: java  tp.RacineCarreeApp  81");
		}
		catch (NumberFormatException e) {
			System.err.println("l'argument n'est pas numérique (81 ok , abc pas ok)");
		}
		catch (Exception e) {
			System.err.println("une exception a eu lieu");
			e.printStackTrace();
		}
	}

}
