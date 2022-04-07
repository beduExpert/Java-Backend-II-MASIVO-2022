## Postwork Sesión 8

### OBJETIVO
- Generar documentación de servicios, basada en las pruebas unitarias de una aplicación.
- Personalizar la documentación generada con RestDoc.
- Distribuir la documentación de los servicios para ser consumida por otro desarrollador.


### DESARROLLO
1. Para cada una de las pruebas, unitarias o de integración, de los servicios REST creados, genera su documentación.

2. Decora la clase de prueba con la anotación `@AutoConfigureRestDocs`. Puedes personalizar la URL de la petición y el puerto si lo consideras necesario.

3. Para cada uno de los métodos HTTP usados en las pruebas (**GET**, **POST**, **PUT** y **DELETE**) genera la documentación con el método `andDo` de la instancia `MockMvc`. Revisa bien qué es lo que ddebes documentar, recuerda que no en todos los métodos se usa un cuerpo de petición o de respuesta. 

4. Dentro del directorio de código fuente de la aplicación crea un subdirectorio `docs` y dentro otro subdirectorio `asciidocs`. Adentro de este crea un archivo llamado `index.adoc`

5. Personaliza el contenido del archivo.

6 En el archivo `pom.xml` del proyecto busca, en la sección de plugins, el plugin `asciidoctor-maven-plugin` y colola los elementos de configuración necesarios para la generació del archivo HTML con la documentación del API.

7. En el archivo `pom.xml` del proyecto configura el `maven-resources-plugin` para distribuir la documentación generada junto dentro del archivo `.jar` generado por Spring Boot.

8. Ejecuta las pruebas de la aplicación. Todas deben ejecutarse de forma correcta.

![imagen](img/img_01.png)

9. Ejecuta la aplicación y entra a la siguiente URL en tu navegador para asegurarte que la documentación se copió de forma correcta:

http://localhost:8080/docs/index.html

Debes ver una página como la siguiente.

![imagen](img/img_02.png)
