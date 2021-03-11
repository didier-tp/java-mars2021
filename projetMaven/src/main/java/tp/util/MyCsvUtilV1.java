package tp.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

import tp.data.Stat;

public class MyCsvUtilV1 {
      public static String writeValuesAsCsvString(Stat statObj){
    	  StringBuilder buffer = new StringBuilder(256);
    	  buffer.append(statObj.getLabel()); buffer.append(";");
    	  buffer.append(statObj.getSomme()); buffer.append(";");
    	  buffer.append(statObj.getMoyenne()); 
    	  /*buffer.append(";");
    	  buffer.append(statObj.getEcartType());*/ 
    	  return buffer.toString();
      }
      
      
      
      
      public static void writeValuesAsCsvFile(List<Stat> col,String fileName){
    	    if(col.isEmpty()) {
    	    	return;//fin fonction sans rien faire
    	    }
    	    try {
				FileOutputStream of = new FileOutputStream(fileName);
				PrintStream ps = new PrintStream(of);
				String ligneEnteteAuFormatCsv= "label;somme;moyenne";
				ps.println(ligneEnteteAuFormatCsv);
				for(Stat obj : col) {
					String ligneValeursAuFormatCsv= writeValuesAsCsvString(obj);
					ps.println(ligneValeursAuFormatCsv);
				}
				ps.close(); of.close();// fermetures dans l'ordre inverse des ouvertures
			} catch (IOException e) {
				e.printStackTrace();
			}
      }
}
