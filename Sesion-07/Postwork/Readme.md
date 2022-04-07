## Postwork Sesión 7

### OBJETIVO
- Integrar JUnit como framework de pruebas unitarias en una aplicación desarrollada con Spring Boot.
- Desarrollar una serie de pruebas unitarias usando los objetos proporcionados por Spring Test para validar el correcto funcionamietno de la aplicación.
- Ejecutar y obtener el resultado de las pruebas unitarias desde el entorno de desarrollo.



### DESARROLLO
1. Termina la implementación de los métodos de negocio, que se encuentran en la capa services de la aplicación, para tener las funcionalidades básicas de guardado, eliminación, bajas y actualizaciones de cada uno de los tipos de entidad.

2. Para el paso anterior será necesario implementar las funcionalidades en todas las capas de la aplicación, desde los controladores hasta los repositorios para el manejo de los datos almacenados.

3. Agrega pruebas unitarias de cada uno de los métodos existentes en los controladores usando el objeto MockMvc de Spring

4. Implementa una serie de pruebas integrales usando el objeto TestRestTemplate proporcionado por Spring. Recuerda que este objeto ejecuta la aplicación, por lo tanto modificará la información existente en tu base de datos.

5. Asegúrate que al final todas las pruebas se ejecuten de forma correcta:


![imagen](img/img_01.png)
