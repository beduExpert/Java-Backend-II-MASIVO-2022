
## Sesión 3: Spring MVC Validation

### INTRODUCCIÓN
La validación de datos de entrada es la actividad de garantizar que solo los datos correctamente formados puedan ingresar en un sistema. Esta operación evita que la entrada mal formada genere comportamientos inesperados. Por esta razón es preferible que la etapa de validación se ejecute tan pronto como se reciban los datos de la parte externa. 

JSR-380 Bean Validation es una especificación cuyo objetivo es estandarizar la validación de Java beans mediante el uso de anotaciones directamente en una clase Java. Esta característica permite que las reglas de validación se especifiquen directamente en la clase que pretenden validar, en lugar de crear reglas de validación en clases separadas. Esta especificación también le permite:

- Expresar restricciones en modelos de objetos a través de anotaciones
- Escribir restricciones personalizadas de forma extensible
- Validar objetos y grafos de objetos usando las API proporcionadas
- Validar parámetros y valores de retorno de métodos y constructores
- Informar el conjunto de infracciones


### OBJETIVOS
- Usar validaciones de una forma sencilla para los datos que llegan a un servicio
- Aprender a manejar errores ocurridos en las validaciones
- Usar un componente de Spring creado para manejo de errores

### ORGANIZACIÓN DE LA CLASE
- Validaciones de Java Beans
  - [Ejemplo 1](Ejemplo-01)
  - [Reto 1](Reto-01)
  
- Manejo de errores en validaciones
  - [Ejemplo 2](Ejemplo-02)
  - [Reto 2](Reto-02)
  
- Spring MCV Controller Advice
  - [Ejemplo 3](Ejemplo-03)


### POSTWORK
- [Validación de datos de entrada](Postwork)
