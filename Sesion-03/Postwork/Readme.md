## Postwork Sesión 03

### OBJETIVO
- Agregar validaciones a los atributos de las clases que representan el modelo de negocio de la aplicación.
- Agregar un manejador de excepciones global para errores de validaciones y para errores generales de la aplicación, que pueda ser extendido conforme se agregan más - funcionalidades y reglas de negocio.



### DESARROLLO

1. Agrega las validaciones que consideres necesarias. Puedes elegir las validaciones de la siguiente lista:
- @NotNull
- @Null
- @AssertFalse
- @AssertTrue
- @DecimalMax
- @DecimalMin
- @Digits
- @Size
- @Min
- @Max
- @Email
- @NotEmpty
- @NotBlank
- @Pattern
- @Positive y @PositiveOrZero
- @Negative y @NegativeOrZero
- @Past y @PastOrPresent
- @Future y @FutureOrPresent

2. Agrega un manejador global de errores usando la anotación `@RestControllerAdvice`.

3. Agrega un manejador global de errores usando la anotación `@ExceptionHandler(MethodArgumentNotValidException.class)`.

3. Agrega un manejador global de errores usando la anotación `@ExceptionHandler(Exception.class)`.

La estructura de tu proyecto debe quedar de la siguiente forma:

![imagen](img/img_01.png)

