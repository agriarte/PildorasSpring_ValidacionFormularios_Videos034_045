<%-- 
    Document   : confirmacionRegistroAlumno
    Created on : 12-feb-2024, 19:55:26
    Author     : Pedro
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmaci�n de registro</title>
    </head>
    <body>
        <h1>Confirmaci�n de registro</h1>
        <p>El alumno <strong>${alumnoModelo.nombre} ${alumnoModelo.apellido}</strong> y edad <strong>${alumnoModelo.edad}</strong> a�os se ha registrado con �xito se ha registrado con �xito.</p>
        
        <p>Email: <strong> ${alumnoModelo.email}</strong>.</p>
        
        <p>La asignatura optativa es <strong> ${alumnoModelo.optativa}</strong>.</p>

        <p>La ciudad del alumno es <strong> ${alumnoModelo.ciudadEstudios}</strong>.</p>
        
        <p>C�digo postal <strong> ${alumnoModelo.codigoPostal}</strong>.</p>

        <p>Ha escogido estos idiomas <strong> ${alumnoModelo.idiomasAlumno}</strong>.</p>
    </body>
</html>
