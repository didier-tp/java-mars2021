package tp;

import java.lang.reflect.Field;

import tp.data.Produit;

public class IntrospectionApp {

    public static void main(String[] args) {
        String nomClasse="tp.data.Produit";
        //String nomClasse="java.text.SimpleDateFormat";
        try {
            Class c = Class.forName(nomClasse); 
            //c de type java.lang.Class (méta classe)
            //est un objet technique qui décrit 
            //la structure d'une classe java ordinaire

            Field[] tabChamps = c.getDeclaredFields();
            for(Field f : tabChamps) {
                System.out.println("attribut " + f.getName()
                                   + " " + f.getType().getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("------------------");
        try {
            Produit prod = new Produit(999,"produit 999",99.99,20.0);
            Class c = prod.getClass(); 
            //meta description de la classe de l'objet prod


            Field[] tabChamps = c.getDeclaredFields();
            for(Field f : tabChamps) {
                f.setAccessible(true); //pour acceder aux parties privées
                System.out.println("attribut nom=" + f.getName() 
                                   + " type=" + f.getType().getName()
                                  + " valeur=" +f.get(prod).toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}