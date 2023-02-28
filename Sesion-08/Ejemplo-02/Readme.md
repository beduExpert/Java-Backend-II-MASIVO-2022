## Ejemplo 02: Generación de documentación de respuestas y personalización de documentación

### OBJETIVO

- Documentar la respuesta obtenida de la ejecución de un método de prueba.
- Personalizar la página generada, con más información y una tabla de contenido.


#### REQUISITOS
- Tener instalado el IDE IntelliJ Idea Community Edition con el plugin de Lombok activado.
- Tener instalada la última versión del JDK 11 o 17.


### Desarrollo

1. Entra al sitio de <a href="https://start.spring.io/" target="_blank">Spring Initializr</a>. Ahí verás una sola página dividida en dos secciones. Comienza llenando la información de la sección del lado izquierdo. Selecciona:

2. En la ventana que se abre selecciona las siguientes opciones:
    - Grupo, artefacto y nombre del proyecto.
    - Tipo de proyecto: **Maven Project**.
    - Lenguaje: **Java**.
    - Forma de empaquetar la aplicación: **jar**.
    - Versión de Java: **11** o **17**.

3. En la sección de la derecha (las dependencias) presiona el botón `Add dependencies` y en la ventana que se abre busca la dependencia `Spring Web`, `Spring Rest Docs`, y `Lombok`. En automático se agregarán también las dependencias para realizar pruebas unitarias.

4. Dale un nombre y una ubicación al proyecto y presiona el botón *Generate*.

5. En el proyecto que se acaba de crear debes tener el siguiente paquete `org.bedu.java.backend.sesion8.ejemplo2`. Dentro crea los subpaquetes: `controllers` y `model`.

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

8. Coloca un método dentro de esta clase que regresará un `Cliente`.
    
    ```java
    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long clienteId){
        return ResponseEntity.ok(Cliente.builder().id(1L).correoContacto("cliente@contacto.com").nombre("Nombre").build());
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

11. Crea un método llamado `obtenClienteTest` para verificar la obtención del cliente:
    
    ```java
    @Test
    void obtenClienteTest() throws Exception {

        mockMvc.perform(get("/cliente/{clienteId}", 1)
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.correoContacto", is("cliente@contacto.com")))
                .andExpect(jsonPath("$.nombre", is("Nombre")));

    }
    ```

12. Ejecuta la prueba, esta debe pasar de forma correcta:

    ![imagen](img/img_02.png)

13. Indica en la prueba que esta debe generar documentación, y que la misma se debe colocar en el directrio `cliente/get-cliente`. Se documentarán los parámetros de la petición (en este caso el parámetro `clienteId`).
    
    ```java
    @Test
    void obtenClienteTest() throws Exception {

        mockMvc.perform(get("/cliente/{clienteId}", 1)
                .content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.correoContacto", is("cliente@contacto.com")))
                .andExpect(jsonPath("$.nombre", is("Nombre")))

               .andDo(document("cliente/get-cliente",
                        pathParameters(
                                parameterWithName("clienteId").description("Identificador del cliente")
                        ),
                        responseFields(
                                fieldWithPath("id").description("identificador del cliente"),
                                fieldWithPath("nombre").description("nombre del cliente"),
                                fieldWithPath("correoContacto").description("correo de contacto del cliente"),
                                fieldWithPath("numeroEmpleados").description("número de trabajadores del cliente"),
                                fieldWithPath("direccion").description("domicilio del cliente")
                        )));

    }
    ```

14. Ejecuta la prueba haciendo nuevamente. En el directorio `target` se ha creado un subdirectorio `generated-snippets` y adentro de este un conjunto de archivos `.adoc`, Estos contienen la información generada de la ejecución de la prueba.

    ![imagen](img/img_03.png)


15. Dentro del directorio de código fuente de la aplicación crea un subdirectorio `docs` y dentro otro subdirectorio `asciidocs`. Adentro de este crea un archivo llamado `index.adoc`:

16. Coloca el siguiente contenido dentro del archivo:

    ```adoc
    = Curso de Java Backend en Bedu
    Bedu ORG <contacto@bedu.org> 1.0.0;
    :doctype: book
    :icons: font
    :source-highlighter: highlightjs
    :toc: left
    :toclevels: 4
    :sectlinks:
    :sectnums:

    [[resumen]]
    = Resumen
    Este curso muestra el desarrollo de un API usando Spring Framework, con sus módulos Spring Boot, Spring Data JPA y Spring REST Docs.


    [[verbos-http]]
    == Verbos HTTP

    Este curso trate de adherirse lo más posible al estándar RESTful aprovechando las capacidades del protocolo de HTTP
    y siguiendo las convenciones HTTP en su uso de los verbos HTTP.

    |===
    | Verbo | Uso

    | `GET`
    | Recuperar un recurso

    | `POST`
    | Crea un nuevo recurso

    | `PUT`
    | Actualizar un recurso existente, incluyendo actualizaciones parciales

    | `DELETE`
    | Eliminar un recurso existente
    |===

    Este curso trate de adherirse lo más posible al estándar RESTful en el uso de los códigos de estátus HTTP.

    |===
    | Code | uso

    | `200 OK`
    | La petición se completó exitosamente

    | `201 Created`
    | Se creó un nuevo recurso. La URL del reurso está disponible en la cabecera `Location` de la respuesta

    | `204 No Content`
    | Se aplicó correctamente la actualización de un recurso

    | `400 Bad Request`
    | La petición está formada de forma incorrecta. El cuerpo de la respuesta incluirá el error, proporcionando más información

    | `404 Not Found`
    | El recurso especificado no existe
    |===


    [[clientes]]
    == Clientes

    === Get cliente por Id
    Obtiene un cliente específico usando su identificador único.

    ==== Ejemplo de petición
    include::{snippets}/cliente/get-cliente/http-request.adoc[]

    ==== Ejemplo de respuesta
    include::{snippets}/cliente/get-cliente/http-response.adoc[]

    ==== Ejemplo usando CURL
    include::{snippets}/cliente/get-cliente/curl-request.adoc[]

    ==== Parámetros de la petición
    include::{snippets}/cliente/get-cliente/path-parameters.adoc[]


    ```

17. En el archivo `pom.xml` del proyecto busca, en la sección de plugins, el plugin `asciidoctor-maven-plugin` y colola las siguientes elementos dentro de la etiqueta `<configuration>`:

    ```xml
    <sourceDocumentName>index.adoc</sourceDocumentName>
    <attributes>
        <snippets>${project.build.directory}/generated-snippets</snippets>
    </attributes>
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
                    <sourceDocumentName>index.adoc</sourceDocumentName>
                    <attributes>
                        <snippets>${project.build.directory}/generated-snippets</snippets>
                    </attributes>
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

19. Ejecuta nuevamente la prueba. Dentro del directorio `target` debe haberse creado un subdirectorio `generated-docs` y dentro de este un archivo llamado `index.html`.

    ![imagen](img/img_06.png)

20. Abre este archivo en un navegador. La página con la documentación debe verse de la siguiente forma:

    ![imagen](img/img_07.png)


<br>

[**`Siguiente`** -> reto 02](../Reto-02/)