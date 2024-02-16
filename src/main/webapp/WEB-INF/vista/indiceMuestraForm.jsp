<%-- 
   PASOS PARA VALIDACION DE FORMULARIO:

    https://www.javatpoint.com/spring-mvc-validation

    1- añadir dependencia hibernate-validator 6.2.5 en MAVEN. De la v7 en adelante hasta la última a 
        fecha de hoy 8.0.1.Final no funciona en este ejemplo(ni con imports de jakarta ni javax).

        <dependency>
            <groupId>org.hibernate.validator</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>6.2.5.Final</version>
        </dependency>

    2- añadir mediante anotaciones en la clase del objeto las propiedades que serán validadas y el mensaje:
       ejemplos: @NotNull, @Size(min=2, max=30), @Min(18)
       Precaución con la importación, debe ser de import javax.validation.constraints.* y no de jakarta
    3- Especificar validación en el controlador con BindingResult y hasErrors()
    4- Especificar mensaje error en el formulario <form:errors...
    
    Nota1: el mensaje personalizado de edad en messages properties no funciona.
    Nota2: la validación personalizada del codigo postal está basada en https://www.baeldung.com/spring-mvc-custom-validator
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Formulario de registro</title>
    </head>
    <body>
        <h1>Formulario con MVC Form Tags</h1>
        <!-- action es el método del controlador que se llamará al enviar -->
        <!-- el modelAttribute es el identificador cuando se crea el attribute en el controlador -->
        <form:form action="procesarFormulario" modelAttribute="alumnoModelo">

            <!-- el path ha de coincider con los atributos de la clase Alumno (nombre,apellido) -->
            <!-- las mvc tags cuando carga la página llama a los getters y cuando envía a los setters -->
            Nombre: <form:input path="nombre" />
            <form:errors path="nombre"/>
            <br><br>
            Apellidos: <form:input path="apellido" />
            <br><br>
            Asignaturas optativas:<br>
            <form:select path="optativa">
                <form:option value="Diseño"/>
                <form:option value="Karate"/>
                <form:option value="Comercio"/>
                <form:option value="Fútbol"/>
            </form:select>
            <br><br>
            <input type="submit" value="Enviar" />           
        </form:form>



        <br><!-- Repetición del formulario con selección multiple y más campos-->

        <h1>Formulario repetido (multiple="true")</h1>
        <!-- action es el método del controlador que se llamará al enviar -->
        <!-- el modelAttribute es el identificador cuando se crea el attribute en el controlador -->
        <form:form action="procesarFormulario" modelAttribute="alumnoModelo">

            <!-- el path ha de coincider con los atributos de la clase Alumno (nombre,apellido) -->
            <!-- las mvc tags cuando carga la pÃ¡gina llama a los getters y cuando envÃ­a a los setters -->
            Nombre: <form:input path="nombre" />
            <form:errors path="nombre"/>
            <br><br>
            Apellidos: <form:input path="apellido" />
            <br><br>
            Asignaturas optativas:<br>
            <form:select path="optativa" multiple="true">
                <form:option value="Diseño"/>
                <form:option value="Karate"/>
                <form:option value="Comercio"/>
                <form:option value="Fútbol"/>
            </form:select>
            <br><br>
            <p>Ciudad</p>
            Barcelona<form:radiobutton path="ciudadEstudios" value="Barcelona"/>
            Madrid<form:radiobutton path="ciudadEstudios" value="Madrid"/>
            Santiago<form:radiobutton path="ciudadEstudios" value="Santiago"/>
            Huesca<form:radiobutton path="ciudadEstudios" value="Huesca"/>
            <br><br>
            <p>Idiomas</p>
            Inglés<form:checkbox  path="idiomasAlumno" value="Inglés"/>
            Francés<form:checkbox  path="idiomasAlumno" value="Francés"/>
            Chino<form:checkbox  path="idiomasAlumno" value="Chino"/>
            <br><br>
            Edad: <form:input path="edad" />
            <form:errors path="edad" style="color:red"/>
            <br><br>
            E-mail: <form:input path="email" />
            <form:errors path="email" style="color:red"/>
            <br><br>
            Codigo Postal: <form:input path="codigoPostal" />
            <form:errors path="codigoPostal" style="color:red"/>
            <br><br>

            <input type="submit" value="Enviar" />           
        </form:form>
    </body>
</html>
