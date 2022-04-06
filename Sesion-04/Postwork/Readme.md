## Postwork Sesión 04

### OBJETIVO
- Agregar manejadores de errores globales para errores generados por el usuario, como datos enviados de forma incorrecta y el uso de métodos HTTP no soportados.
- Permitir al usuario seleccionar el formato del contenido en el que desea recibir las respuestas por parte de los servicios.

### DESARROLLO
1. Agrega un manejador de errores a tu proyecto, usando una clase que extienda de `ResponseEntityExceptionHandler`. Sobreescribe los siguientes métodos:
- handleMethodArgumentNotValid
- handleHttpRequestMethodNotSupported 

2. El manejador anterior deberá regresar como respuesta a los errores objetos de tipo `RespuestaError`, como los vistos durante la sesión.

3. Agrega las siguientes dependencias de Maven en el archivo `pom.xml`, para indicar que se permitirá que el usuario del API indique el formato en el que quiere recibir las respuestas.

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```



