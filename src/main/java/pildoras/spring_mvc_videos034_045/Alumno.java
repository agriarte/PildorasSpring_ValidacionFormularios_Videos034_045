/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.spring_mvc_videos034_045;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import pildoras.spring_mvc_videos034_045.validacionespersonalizadas.CPostalMadrid;

/**
 *
 * @author Pedro
 */
public class Alumno {

    @NotBlank
    @Size(min = 2, message = "El nombre debe tener 2 caracteres como mínimo")
    private String nombre;

    private String apellido;
    private String optativa;
    private String ciudadEstudios;
    private String idiomasAlumno;

    
    @Min(value = 18, message = "No se permiten edades menores de 18 años")
    @Max(value = 120, message = "Edad muy elevada")
    private String edad;

    @NotBlank
    @Email
    private String email;

    @Pattern(regexp = "[0-9a-zA-Z]{5}", message = "5 caracteres 0-9 a-z A-Z")
    @CPostalMadrid
    private String codigoPostal;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOptativa() {
        return optativa;
    }

    public void setOptativa(String optativa) {
        this.optativa = optativa;
    }

    public String getCiudadEstudios() {
        return ciudadEstudios;
    }

    public void setCiudadEstudios(String ciudadEstudios) {
        this.ciudadEstudios = ciudadEstudios;
    }

    public String getIdiomasAlumno() {
        return idiomasAlumno;
    }

    public void setIdiomasAlumno(String idiomasAlumno) {
        this.idiomasAlumno = idiomasAlumno;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
