/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.spring_mvc_videos034_045;




import javax.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Pedro
 */
@Controller
public class AlumnoController {
    
    // método que elimina espacios en blanco de las entradas de formulario
    // comprueba la petición del form antes de que le llegue.
    // Esto se usa para evitar que un usuario salte la validación introduciendo varios espacios en blanco
    // StringTrimmerEditor se encarga automaticamente de eliminar espacios en blanco
    @InitBinder
    public void miBinder (WebDataBinder binder){
        StringTrimmerEditor recortaEspacios = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, recortaEspacios);
    }
    

    // El modelo es un objeto que sirve de puente entre el controlador y las vistas.
    // Spring lo crea automáticamente.
    @RequestMapping("/muestraFormulario")
    public String muestraFormulario(Model modelo) {

        Alumno elAlumno = new Alumno();
        // guardar en "modelo" el alumno que queremos viaje entre el formulario de registro y la vista de confirmación
        modelo.addAttribute("alumnoModelo", elAlumno);
        return "indiceMuestraForm";
    }

    @RequestMapping("")
    public String muestraIndice(Model modelo) {

        Alumno elAlumno = new Alumno();
        // guardar en "modelo" el alumno que queremos viaje entre el formulario de registro y la vista de confirmación
        modelo.addAttribute("alumnoModelo", elAlumno);
        return "indiceMuestraForm";
    }

    // ATENCION A LA DECLARACION DEL METODO: La anotación @ModelAttribute("alumnoModelo") se utiliza para indicar a Spring 
    // que debe vincular los datos del formulario a un objeto Alumno y agregar ese objeto al modelo de la vista con el 
    // nombre "alumnoModelo". 
    //    
    // La teoría dice que al incluir Alumno miAlumno como parámetro en el método del controlador, se permite que Spring 
    // realice la vinculación automática de los datos del formulario al objeto Alumno. Luego, se puede acceder a esos 
    // datos en la vista usando el nombre especificado en @ModelAttribute ("alumnoModelo").
    @RequestMapping("procesarFormulario")
    public String procesarFormulario(@Valid @ModelAttribute("alumnoModelo") Alumno miAlumno,
            BindingResult resultadoValidacion) {
        // aquí sorprendamente no hace falta hacer nada para cargar los datos. La magia la hace spring en los 
        // parámetros del método. Tal cual está el return abrirá confirmacionRegistroAlumno.jsp enviando los 
        // datos en ${alumnoModelo.nombre} ${alumnoModelo.apellido} pero antes conviene validar que los datos son correctos

        //Si hay errores volver al la pagina del formulario
        if (resultadoValidacion.hasErrors()) {
            return "indiceMuestraForm";
        } else {
            // Si no hay errores pantalla final con confirmación de los datos introducidos   
            return "confirmacionRegistroAlumno";
        }
    }

}
