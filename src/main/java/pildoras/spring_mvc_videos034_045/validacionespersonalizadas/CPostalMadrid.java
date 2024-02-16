/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pildoras.spring_mvc_videos034_045.validacionespersonalizadas;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Pedro
 */

@Constraint(validatedBy = CPostalMadridValidator.class)// futura clase que contendrá la lógica de la validación
@Target({ ElementType.METHOD, ElementType.FIELD }) // destino de nuestra validación a métodos o campos
@Retention(RetentionPolicy.RUNTIME) // Cuando se va a verificar si la validación se cumple o no. Runtime es es tiempo de ejecución
public @interface CPostalMadrid {
    //definir el código postal por defecto
    public String value() default "28";
    //definir el mensaje de error
    public String message() default "El código postal debe comenzar por 28";
    //definir los grupos
    //en este ejemplo no está implementado. Sirve para obligar al código para que haga validaciones entre grupos de varios campos
    //sin necesidad de enviar el formulario. Aunque no se use, debe ponerse esta línea para evitar errores
    Class<?>[] groups() default {};
    //definir los payloads
    //tampoco está implementado. Se usa para metadatos
    Class<? extends Payload>[] payload() default {};
    
    
}
