/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.spring_mvc_videos034_045.validacionespersonalizadas;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Pedro
 */
public class CPostalMadridValidator implements
        ConstraintValidator<CPostalMadrid, String> {

    private String prefijoCodigoMadrid;

    @Override
    public void initialize(CPostalMadrid elCodigo) {
        prefijoCodigoMadrid = elCodigo.value();
    }

    //valorCP contiene lo que envía el form.
    @Override
    public boolean isValid(String valorCP, ConstraintValidatorContext context) {
        boolean valCodigo;
        
        // Si el valor entrado no es nulo, con el método starsWith guardamos un booleano true si empieza por 28 y false si no lo es
        // El valor 28 viene definido en la @interface CPostalMadrid. Se puso como valor por defecto
        if (valorCP!=null) valCodigo=valorCP.startsWith(prefijoCodigoMadrid);
        else return valCodigo=true;
        // Si el usuario no introduce nada, directamente se devuelve false
        return valCodigo;
    }

    //apartado 5 de https://www.baeldung.com/spring-mvc-custom-validator
}
