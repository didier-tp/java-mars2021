package tp;

import java.util.ArrayList;
import java.util.List;

public class TestCollectionAppV1SansGeneric {

	public static void main(String[] args) {
		List liste1 = new ArrayList();
		liste1.add("lundi");
		liste1.add("mardi");
		liste1.add("mercredi");
		liste1.add("jeudi");
		liste1.remove("lundi");
		System.out.println("nb elts de liste1="+ liste1.size());
        //liste1.clear();
		
        System.out.println("liste1="+liste1);
	}

}
