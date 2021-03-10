package tp;

public class PorteBattant extends Porte {
     private int angleRotation=0; //0 fermée , 90 degré = ouvert
     
     private void pivoter(int angle) {
    	 this.angleRotation=angle;
    	 System.out.println("porte a 1 battant, angle rotation:"+this.angleRotation);
    	 if(angle==90) System.out.println("  porte a 1 battant maintenant ouverte");
    	 if(angle==0) System.out.println("   porte a 1 battant maintenant fermée");
     }

     @Override
 	public void ouvrir() {
 		this.pivoter(90);//90 degrés
 	}

 	@Override
 	public void fermer() {
 		this.pivoter(0);//0 degré
 	}
      
     
}
