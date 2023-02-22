## Postwork Sesión 04

### OBJETIVO
- Agregar manejadores de errores globales para errores generados por el usuario, como datos enviados de forma incorrecta y el uso de métodos HTTP no soportados.
- Permitir al usuario seleccionar el formato del contenido en el que desea recibir las respuestas por parte de los servicios.

### DESARROLLO

En esta sesión se utilizan los distintos elementos que proporcionan Spring MVC y Spring Boot para realizar un manejo de errores que ayude a los usuarios de nuestra API a entender los problemas que pueden ocurrir, ya sea que esté enviando algún dato o parámetro incorrecto, o que algo haya salido mal del lado del servidor al momento de realizar el procesamiento de la petición.

Esto también nos permitirá usar los códigos de error definidos en el protocolo HTTP como complemento de los mensajes de respuesta enviados a los usuarios del API.

**Asegúrate de comprender:**

1. El significado de los códigos de error más comunes en HTTP.
Cómo se implementa un manejador global de errores en Spring Boot.
2. Qué es la negociación de contenido y cómo usarla para regresar la respuesta en el formato apropiado.

**Indicaciones generales**

El propósito de este Postwork es retomar el proyecto del módulo anterior y realizar las modificaciones descritas a continuación. 

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




<br>

[**`Siguiente`** -> sesión 5](../../Sesion-05/)

[**`Regresar`**](../)