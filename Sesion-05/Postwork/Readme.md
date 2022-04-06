## Postwork Sesión 5

### OBJETIVO
- Usar **Lombok** como herramienta que genera código común (bolerplate) en objetos Java
- Aplicar **MapStruct** para mapear los atributos de un objeto con los de un objeto diferente.
- Exponer los objetos creados con MapStruct como componentes de Spring.


### DESARROLLO
- Agrega las dependencias de *Lombok* y *MapStruct* en el archivo *pom.xml* del proyecto.

- Los objetos del paquete `model` tienen, hasta ahora, solamente atributos, usa las siguientes anotaciones de Lombok:
    - `@Data`
    - `@Builder`
    - `@RequiredArgsConstructor`
    
- Asegúrate, en el panel de estructura de la clase, que los métodos se hayan generado de forma correcta y completa:

![imagen](img/img_01.png)

- Dentro del paquete `controllers` agrega un subpaquete `mappers` y agrega una interface de mape para cada uno de los tipos de objetos en el paquete `model` (excluyendo `RespuestaError`. 

- Anota estas interfaces con `@Mapper`. Por el momento estas interfaces no tendrán métodos, los colocaremos en la siguiente sesión.

- La estructura del proyecto debe verse de la siguiente forma:

![imagen](img/img_02.png)
