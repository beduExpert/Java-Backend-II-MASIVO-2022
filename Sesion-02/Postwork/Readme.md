## Postwork Sesión 02

### OBJETIVO
- Crear una serie de modelos que representarán la información que es manejada por el CRM.
- Crear la estructura de los servicios que permitirán implementar las diferentes funcionalidades del CRM.
- Crear los paquetes que representarán cada una de las capas de la aplicación.


### DESARROLLO

En esta sesión se definen los manejadores de eventos para las operaciones que realizará el CRM, manejando las altas, bajas y cambios (CRUD) de los clientes, productos, visitas y ventas.

**Asegúrate de comprender:**

- Los diferentes métodos HTTP (GET, POST, PUT, ...) y el significado o propósito de cada uno.
- Los códigos de respuesta de cada uno de los métodos anteriores.
- Las anotaciones que usa Spring MVC para indicar qué método de una clase Java se usa como manejador para cada uno de los métodos HTTP, y cómo recibir los parámetros de las peticiones en cada uno de ellos.


**Indicaciones generales**

El propósito de este Postwork es retomar el proyecto del módulo anterior y realizar las modificaciones descritas a continuación. 

1. Crea los siguientes paquetes en el proyecto principal:
    - *model*
    - *controllers*
    - *persistence*
    - *services*
2. Crea dentro de paquete "`model`" las siguientes clases:
    - *Cliente*
    - *Visita*
    - *Producto*
    - *Venta*
    - *Etapa*

    Estas clases están vacías por el momento (no tendrán atributos)

3. Crea dentro del paquete "`controllers`" las siguientes clases y decóralas con la anotación "`@RestController`".
    - *ClienteController*
    - *ProductoController*
    - *VisitaController*
    - *VentaController*
    - *EtapaController*
    
4. Dentro de cada uno de los servicios coloca métodos que permitan crear, leer, actualizar y eliminar recursos (objetos del paquete `model`). Para ello tendrás que usar los métodos HTTP: **GET**, **POST**, **PUT** y **DELETE**.

    Tus servicios deben seguir este patrón:

    ```java
    @RestController
    @RequestMapping("/cliente")
    public class ClienteController {

        @GetMapping("/{clienteId}")
        public ResponseEntity<Cliente> getCliente(@PathVariable Long clienteId){

        }

        @GetMapping
        public ResponseEntity <List<Cliente>> getClientes(){

        }

        @PostMapping
        public ResponseEntity<Void> creaCliente(@RequestBody Cliente cliente){

        }

        @PutMapping("/{clienteId}")
        public ResponseEntity<Void> actualizaCliente(@PathVariable Long clienteId, @RequestBody Cliente cliente){

        }

        @DeleteMapping("/{clienteId}")
        public ResponseEntity<Void> eliminaCliente(@PathVariable Long clienteId){

        }
    }
    ```


    La estructura de tu proyecto debe quedar de la siguiente forma:

    ![imagen](img/img_01.png)


<br>

[**`Siguiente`** -> sesión 3](../../Sesion-03/)

[**`Regresar`**](../)