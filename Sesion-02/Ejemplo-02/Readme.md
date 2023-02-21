## Ejemplo 02: Uso del método POST

### OBJETIVO
- Aprender la forma en la que Spring MVC permite recibir objetos complejos (objetos con múltiples atributos de varios tipos)

#### REQUISITOS
- Tener instalado el IDE IntelliJ Idea Community Edition.
- Tener instalada la última versión del JDK 17 u 11.
- Tener instalada la herramienta Postman.

### DESARROLLO

1. Crea un proyecto Maven usando Spring Initializr como lo hiciste en la primera sesión.

2.  Selecciona las siguientes opciones:

    - Grupo: org.bedu.java.backend
    - Artefacto y nombre del proyecto: sesion2-ejemplo2
    - Tipo de proyecto: **Maven Project**
    - Lenguaje: **Java**. 
    - Forma de empaquetar la aplicación: **jar**. 
    - Versión de Java: **17** u **11**.

3. Elige Spring Web como la única dependencia del proyecto.

4. Da clic en `Generate`, descarga y abre el proyecto.

5. El proyecto debe tener el siguiente paquete: `org.bedu.java.backend.sesion2.ejemplo2`.

6. Dentro de ese paquete crea un subpaquete que contendrá los controladores de Spring MVC. Haz clic con el botón derecho del ratón sobre el paquete y en el menú que se muestra selecciona las opciones `New -> Package`. Dale a este nuevo paquete el nombre de `controllers`. 

7. Crea un segundo paquete llamado `model` a la misma altura que el paquete `controllers`. Al final debes tener dos paquetes adicionales:

    ![imagen](img/img_01.png)

8. Dentro del paquete `model` crea una nueva clase llamada "`Saludo`". Esta clase representará el modelo de los datos que regresará el servicio que crearas en un momento. Esta será una clase sencilla que tendrá tres propiedades, las primeas dos de tipo String: `mensaje` y `nombre`, y la tercera será de tipo int: `edad`. Además de estas propiedades la clase debe tener sus métodos `setter` y `getter`:

    ```java
    public class Saludo {
        private String mensaje;
        private String nombre;
        private int edad;

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }
    }
    ```
  
9. En el paquete `controller` crea una nueva clase llamada `SaludoController`. Esta clase implementará los servicios web REST que manejan a los recursos de tipo `Saludo`. Para indicar a Spring que este componente es un servicio REST debemos decorar la case con la anotación `@RestController`:

    ```java
    @RestController
    public class SaludoController {

    }
    ```

10. Esta clase tendrá un solo método o manejador de llamadas, el cual recibirá un parámetro de tipo `Saludo` y regresará también ese mismo recurso de tipo `Saludo` con un mensaje preestablecido.

    ```java
    public Saludo saluda(Saludo saludo){
        return saludo;
    }
    ```

11. Para indicar que este método es un manejador de peticiones debemos indicar qué tipo de operaciones manejará (el verbo HTTP que soportará). Como en este caso solo se usará para crear información, debes usar el verbo POST; En este caso la anotación que se usrá es `@PostMapping` a la cual hay que indicarle la URL de las peticiones que manejará. En este caso será la ruta `saludo`. El método queda de la siguiente forma:

    ```java
    @PostMapping("/saludo")
    public Saludo saluda(Saludo saludo){
        return saludo;
    }
    ```

    Si ejecutas la aplicación de esta forma y luego haces una llamada desde Postman, todo funcionará (no habrá errores, ni excepciones y recibirás ua respuesta); sin embargo, en la respuesta que recibas todos los campos de `Saludo` estarán vacíos. Esto es porque hace falta indicarle a Spring MVC que el parámetro de tipo `Saludo` lo recibirá en el cuerpo de la petición, usando la anotación `@RequestBody`, de esta forma:


    ```java
    @PostMapping("/saludo")
    public Saludo saluda(@RequestBody Saludo saludo){
        return saludo;
    }
    ```

12. Abre postman y crea una nueva petición. Esta deberá ser una petición tipo POST a la URL `http://localhost:8080/saludo`:

    ![imagen](img/img_02.png)

13. En la pestaña `Body` selecciona la opción `Raw` como tipo de petición y `JSON`como formato de la misma:

    ![imagen](img/img_03.png)

14. Coloca el siguiente contenido en el cuerpo de la petición:

    ```json
    {
        "mensaje": "Hola Mundo",
        "nombre": "Beto",
        "edad": 5
    }
    ```

15. Presiona el botón `Send`. Al recibir la repuesta debes obtener el siguiente resultado:

    ![imagen](img/img_04.png)


<br>

[**`Siguiente`** -> reto 02](../Reto-02/)