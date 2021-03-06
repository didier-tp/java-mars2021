package tp.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD) //utilisable au dessus d'un field/attribut
@Retention(RetentionPolicy.RUNTIME) //conserv?e dans code compil?
public @interface CsvIgnore {
   //...
}