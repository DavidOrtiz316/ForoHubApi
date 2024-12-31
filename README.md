# ForoHub

Es un back-end hecho en Java con ayuda de la herramienta Spring Boot y para eso creo una API REST usando Spring.

Nuestra API va a centrarse específicamente en los **tópicos**, y debe permitir a los usuarios:

-   Crear un nuevo tópico    
-   Mostrar todos los tópicos creados    
-   Mostrar un tópico específico    
-   Actualizar un tópico    
-   Eliminar un tópico
    
Es lo que se conoce comúnmente como CRUD (CREATE, READ, UPDATE, DELETE).

Al final de nuestro desarrollo tendremos una API REST con las siguientes funcionalidades:

1.  API con rutas implementadas siguiendo las mejores prácticas del modelo REST.
    
2.  Validaciones realizadas según reglas de negocio.
    
3.  Implementación de una base de datos para la persistencia de la información.
    
4.  Servicio de autenticación/autorización para restringir el acceso a la información.

## Herramientas utilizadas

-   Java JDK: versión 17     
-   Maven    
-   Spring Boot
-   MySQL 
-   IDE (Entorno de desarrollo integrado) IntelliJ IDEA      
   

Dependencias para agregar al crear el proyecto con [Spring Initializr](https://start.spring.io/):

-   Lombok    
-   Spring Web    
-   Spring Boot DevTools    
-   Spring Data JPA    
-   Flyway Migration    
-   MySQL Driver    
-   Validation    
-   Spring Security

## Diagrama BD
![Diagrama de base de datos](https://github.com/DavidOrtiz316/ForoHubApi/blob/master/src/main/resources/images/diagrama_base_de_datos_forohub.png)


## Funcionalidades

- Registro de tópicos, mediante solicitudes del tipo **POST** para la URI /tópicos.
- Listar todos los tópicos y aceptar solicitudes del tipo **GET** para la URI /tópicos.
- Listar todos los tópicos y aceptar solicitudes del tipo **GET** para la URI /tópicos/{id}.
- Actualizar los datos de un determinado tópico y aceptar solicitudes del tipo **PUT** para la URI /tópicos/{id}.
- Eliminar tópico específico el cual debe aceptar solicitudes del tipo **DELETE** para la URI /tópicos/{id}.
- Se Implementa un mecanismo de autenticación en la API para que los usuarios puedan autenticarse y enviar solicitudes a ella.

## Ejemplo prueba Api en Insomnia.

![Imagen ejemplo insomnia](https://github.com/DavidOrtiz316/ForoHubApi/blob/master/src/main/resources/images/Captura%20de%20pantalla%20insonmia%20forohub.png)
 
