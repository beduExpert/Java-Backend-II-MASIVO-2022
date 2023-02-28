## Reto 01: Generación de documentación para POST

### OBJETIVO

- Documentar los parámetros que se envían en el cuerpo de una petición POST.
- Generar un documento HTML con la documentación para poder distribuirlo.

#### REQUISITOS
- Tener instalado el IDE IntelliJ Idea Community Edition con el plugin de Lombok activado.
- Tener instalada la última versión del JDK 11 o 17.


### DESARROLLO
- Entra al sitio de <a href="https://start.spring.io/" target="_blank">Spring Initializr</a>. Ahí verás una sola página dividida en dos secciones. Comienza llenando la información de la sección del lado izquierdo. Selecciona:

- En la ventana que se abre selecciona las siguientes opciones:
    - Grupo, artefacto y nombre del proyecto.
    - Tipo de proyecto: **Maven Project**.
    - Lenguaje: **Java**.
    - Forma de empaquetar la aplicación: **jar**.
    - Versión de Java: **11** o **17**.

- En la sección de la derecha (las dependencias) presiona el botón `Add dependencies` y en la ventana que se abre busca la dependencia `Spring Web`, `Spring Rest Docs`, y `Lombok`.
- Crea los subpaquetes: `controllers` y `model`.
- Crea una clase `Cliente`, con las anotaciones `@Data`y `@Builder`, y los siguientes atributos:
    - private Long id;
    - private String nombre;
    - private String correoContacto;
    - private int numeroEmpleados;
    - private String direccion;
- Crea un servicio Rest `ClienteController` e implementa el siguiente método:

    ```java
    @PostMapping
    public ResponseEntity<Void> creaCliente(@RequestBody Cliente cliente) {

    }
    ```

- Crea una clase de prueba `ClienteControllerTest` que verifique las operación.
- Genera la documentación de la petición usando el método `requestFields` y el método `fieldWithPath`.

</br>

<details>
	<summary>Solución</summary>

1. Entra al sitio de <a href="https://start.spring.io/" target="_blank">Spring Initializr</a>. Ahí verás una sola página dividida en dos secciones. Comienza llenando la información de la sección del lado izquierdo. Selecciona:

2. En la ventana que se abre selecciona las siguientes opciones:
    - Grupo, artefacto y nombre del proyecto.
    - Tipo de proyecto: **Maven Project**.
    - Lenguaje: **Java**.
    - Forma de empaquetar la aplicación: **jar**.
    - Versión de Java: **11** o **17**.

3. En la sección de la derecha (las dependencias) presiona el botón `Add dependencies` y en la ventana que se abre busca la dependencia `Spring Web`, `Spring Rest Docs`, y `Lombok`.

4. Dale un nombre y una ubicación al proyecto y presiona el botón *Generate*.

5. En el proyecto que se acaba de crear debes tener el siguiente paquete `org.bedu.java.backend.sesion8.reto1`. Dentro crea los subpaquetes: `controllers` y `model`.

6. Dentro del paquete `model` crea una clase llamada `Cliente` de la siguiente forma:

    ```java
    @Data
    @Builder
    public class Cliente {
        private Long id;
        private String nombre;
        private String correoContacto;
        private int numeroEmpleados;
        private String direccion;
    }

    ```

7. En el paquete `controllers` crea una clase llamada `ClienteController` que represente un servicio REST de Spring:

    ```java
    @RestController
    @RequestMapping("/cliente")
    public class ClienteController {

    }
    ```

8. Coloca un método dentro de esta clase que creará un `Cliente` nuevo.
    ```java
    @PostMapping
    public ResponseEntity<Void> creaCliente(@Validated @RequestBody Cliente cliente){
        return ResponseEntity.created(URI.create("1")).build();
    }
    ```

9. En el directorio de pruebas de Maven agrega una nueva clase llamada `ClienteControllerTest`. Decora la nueva clase con las anotaciones `@AutoConfigureRestDocs` y `@WebMvcTest(ClienteController.class)`. 

    ```java
    @AutoConfigureRestDocs
    @WebMvcTest(ClienteController.class)
    class ClienteControllerTest {

    }
    ```

10. Agrega una instancia de tipo `MockMvc` y decórala con la anotación `@Autowired`:

    ```java
    @Autowired
    private MockMvc mockMvc;
    ```

11. Crea un método llamado `creaClienteTest` para verificar la obtención del cliente:

    ```java
    @Test
    void creaClienteTest() throws Exception {
        Cliente clienteParametro = Cliente.builder().nombre("Nombre").direccion("Direccion").numeroEmpleados(10).correoContacto("contacto@cliente.com").build();

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(clienteParametro)))
                .andExpect(status().isCreated())

    }
    ```

12. Ejecuta la prueba, esta debe pasar de forma correcta:

    ![imagen](img/img_02.png)

13. Indica en la prueba que esta debe generar documentación, y que la misma se debe colocar en el directrio `cliente/post-cliente`. Se documentarán los parámetros de la petición (en este caso todos los atributos del objeto `Cliente`).

    ```java
    @Test
    void creaClienteTest() throws Exception {
        Cliente clienteParametro = Cliente.builder().nombre("Nombre").direccion("Direccion").numeroEmpleados(10).correoContacto("contacto@cliente.com").build();

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(clienteParametro)))
                .andExpect(status().isCreated())

                .andDo(document("cliente/post-cliente",
                        requestFields(
                                fieldWithPath("id").description("El identificador del nuevo cliente"),
                                fieldWithPath("nombre").description("El nombre del cliente"),
                                fieldWithPath("direccion").description("La dirección del cliente"),
                                fieldWithPath("correoContacto").description("La dirección de correo electrónico de contacto"),
                                fieldWithPath("numeroEmpleados").description("El número de personas que trabajan en las oficinas e cliente")
                        )));
    }
    ```

14. Ejecuta la prueba haciendo nuevamente. En el directorio `target` se ha creado un subdirectorio `generated-snippets` y adentro de este un conjunto de archivos `.adoc`, Estos contienen la información generada de la ejecución de la prueba.

    ![imagen](img/img_03.png)

15. Abre el contenido de cualquiera de los archivos. Debes ver la información en texto plano, de la siguiente forma:

    ![imagen](img/img_04.png)

16. Dentro del directorio de código fuente de la aplicación crea un subdirectorio `docs` y dentro otro subdirectorio `asciidocs`. Adentro de este crea un archivo llamado `post-cliente.adoc`:

17. Coloca el siguiente contenido dentro del archivo:

    ```adoc
    [[clientes]]
    == Clientes

    === POST nuevo cliente
    Crea un nuevo cliente

    ==== Ejemplo de petición
    include::{snippets}/cliente/post-cliente/http-request.adoc[]

    ==== Campos de la petición
    include::{snippets}/cliente/post-cliente/request-fields.adoc[]

    ==== Ejemplo de respuesta
    include::{snippets}/cliente/post-cliente/http-response.adoc[]

    ==== Ejemplo usando CURL
    include::{snippets}/cliente/post-cliente/curl-request.adoc[]

    ```

18. En el archivo `pom.xml` del proyecto busca, en la sección de plugins, el plugin `asciidoctor-maven-plugin` y colola las siguientes elementos dentro de la etiqueta `<configuration>`:

    ```xml
    <sourceDirectory>src/docs/asciidocs</sourceDirectory>
    <outputDirectory>target/generated-docs</outputDirectory>
    ```

    El plugin debe uedar de la siguiente forma:
    ```xml
    <plugin>
        <groupId>org.asciidoctor</groupId>
        <artifactId>asciidoctor-maven-plugin</artifactId>
        <version>1.5.8</version>
        <executions>
            <execution>
                <id>generate-docs</id>
                <phase>prepare-package</phase>
                <goals>
                    <goal>process-asciidoc</goal>
                </goals>
                <configuration>
                    <backend>html</backend>
                    <sourceDirectory>src/docs/asciidocs</sourceDirectory>
                    <outputDirectory>target/generated-docs</outputDirectory>
                </configuration>
            </execution>
        </executions>
        <dependencies>
            <dependency>
                <groupId>org.springframework.restdocs</groupId>
                <artifactId>spring-restdocs-asciidoctor</artifactId>
                <version>${spring-restdocs.version}</version>
            </dependency>
        </dependencies>
    </plugin>
    ```

19. Ejecuta nuevamente la prueba. Dentro del directorio `target` debe haberse creado un subdirectorio `generated-docs` y dentro de este un archivo llamado `post-cliente.html`.

    ![imagen](img/img_06.png)

20. Abre este archivo en un navegador. La página con la documentación debe verse de la siguiente forma:

    ![imagen](img/img_07.png)

</details>


<br>

[**`Siguiente`** -> ejemplo 02](../Ejemplo-02/)