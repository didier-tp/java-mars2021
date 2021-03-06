package tp.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import tp.calcul.Calculateur;

/*
 * NB : Les traces System.out.println("...") ne sont placées ici
 *      que pour des raisons pédagogiques  : MONTRER LES INSTANCIATIONS AUTOMATIQUES EFFECTUEES PAR JUNIT4
 *      ==> SURTOUT PAS de System.out.println("...") SUR UN VRAI PROJET d'entreprise
 *      mais logger.debug() ou logger.trace() à la place.
 */


public class TestCalculateur {
	
	private static Calculateur calculateur; //composant à tester
	
	public TestCalculateur() {
		System.out.println("instance de TestCalculateur construite:" + this);
		//NB si méthode toString() pas recodée sur Calculateur et TestCalculateur
		//la version par défaut affiche type et référence mémoire de l'instance
	}
	
	@BeforeClass
	public static void initCalculateur() {
		calculateur = new Calculateur();
		System.out.println("instance de Calculateur inialisée:" + calculateur);
	}
	
	@Test
	public void testTva() {
		double tvaCalculee = calculateur.tva(200.0,20.0);
		System.out.println("tva calculee:" + tvaCalculee + " via instance " + calculateur);
		Assert.assertEquals(40.0,tvaCalculee,0.000001);
	}
	
	@Test
    public void testTtc() {
    	double ttcCalcule = calculateur.ttc(200.0,20.0);
    	System.out.println("ttc calcule:" + ttcCalcule + " via instance " + calculateur);
		Assert.assertEquals(240.0,ttcCalcule,0.000001);
	}

}
