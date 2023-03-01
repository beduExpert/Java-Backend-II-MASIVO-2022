## Postwork Sesión 04

### OBJETIVO
- Agregar manejadores de errores globales para errores generados por el usuario, como datos enviados de forma incorrecta y el uso de métodos HTTP no soportados.
- Permitir al usuario seleccionar el formato del contenido en el que desea recibir las respuestas por parte de los servicios.

### DESARROLLO

En esta sesión se utilizan los distintos elementos que proporcionan Spring MVC y Spring Boot para realizar un manejo de errores que ayude a los usuarios de nuestra API a entender los problemas que pueden ocurrir, ya sea que esté enviando algún dato o parámetro incorrecto, o que algo haya salido mal del lado del servidor al momento de realizar el procesamiento de la petición.

Esto también nos permitirá usar los códigos de error definidos en el protocolo HTTP como complemento de los mensajes de respuesta enviados a los usuarios del API.

El postwork se realizará en equipo, los cuales serán formados previamente a la sesión uno.

El propósito de este Postwork es retomar el proyecto del módulo anterior y realizar las modificaciones descritas a continuación. 

1. Agrega un manejador global de excepciones a tu proyecto, usando una clase que extienda de `ResponseEntityExceptionHandler`. Sobreescribe los siguientes métodos:
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

<details>
	<summary>Solución</summary>

1. Agrega el manejador global de excepciones dentro del directorio *handlers*, usando una clase que extienda de `ResponseEntityExceptionHandler`. Sobreescribe los siguientes métodos:
    - handleMethodArgumentNotValid
    - handleHttpRequestMethodNotSupported

    ```java
    @RestControllerAdvice
    public class ManejadorGlobalExcepciones extends ResponseEntityExceptionHandler {

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            Map<String, String> errors = new TreeMap<>();
            for (FieldError error : ex.getBindingResult().getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
                errors.put(error.getObjectName(), error.getDefaultMessage());
            }
            RespuestaError respuestaError = new RespuestaError();
            respuestaError.setErrores(errors);
            respuestaError.setRuta(request.getDescription(false).substring(4));
            return handleExceptionInternal(
                    ex, respuestaError, headers, HttpStatus.BAD_REQUEST, request);
        }

        @Override
        protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

            Map<String, String> errors = new TreeMap<>();

            StringBuilder builder = new StringBuilder();
            builder.append("El método ");
            builder.append(ex.getMethod());
            builder.append(" no está soportado para esta petición. Los métodos soportados son ");

            ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

            errors.put("Error", builder.toString());
            RespuestaError respuestaError = new RespuestaError();
            respuestaError.setErrores(errors);
            respuestaError.setRuta(request.getDescription(false).substring(4));

            return new ResponseEntity<Object>(respuestaError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    ```

2. Crea el modelo de *RespuestaError* con el siguiente código:

    ```java
    public class RespuestaError {
        private final LocalDateTime timestamp = LocalDateTime.now();
        private int estatus;
        private String mensaje;
        private Map<String, String> errores;
        private String ruta;

        public static RespuestaErrorBuilder builder() {
            return new RespuestaErrorBuilder();
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public int getEstatus() {
            return estatus;
        }

        public void setEstatus(int estatus) {
            this.estatus = estatus;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public Map<String, String> getErrores() {
            return errores;
        }

        public void setErrores(Map<String, String> errores) {
            this.errores = errores;
        }

        public String getRuta() {
            return ruta;
        }

        public void setRuta(String ruta) {
            this.ruta = ruta;
        }
    }
    ```

3. Agrega las siguientes dependencias de Maven en el archivo `pom.xml`, para indicar que se permitirá que el usuario del API indique el formato en el que quiere recibir las respuestas.

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    ```

</details>


<br>

[**`Siguiente`** -> sesión 5](../../Sesion-05/)

[**`Regresar`**](../)