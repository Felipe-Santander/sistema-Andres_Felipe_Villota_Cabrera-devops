# Sistema de Gestión Académica Distribuido - DevOps Andres Felipe Villota Cabrera

Proyecto final de la asignatura Lenguaje de Programación Avanzado 2. Implementación de un sistema distribuido con enfoque DevOps.

## Descripción del Sistema

Este proyecto implementa un sistema básico de gestión académica utilizando una arquitectura de microservicios. Permite gestionar usuarios (estudiantes, profesores), asignaturas y matrículas.

## Arquitectura

El sistema sigue una arquitectura de microservicios:

* **API Gateway (Opcional):** Punto único de entrada (a implementar si se decide usar `gateway-servicio`).
* **Service Discovery:** Se utiliza Netflix Eureka (`eureka-server`) para que los servicios puedan encontrarse entre sí.
* **Config Server (Opcional):** Para gestión centralizada de la configuración (a implementar si se decide usar `config-server`).
* **Comunicación:** Los servicios se comunican mediante API REST, utilizando Feign Clients para simplificar las llamadas.
* **Seguridad:** Se implementará autenticación y autorización basada en JWT en el `usuarios-servicio`.
* **Base de Datos:** Cada microservicio principal (`usuarios`, `asignaturas`, `matriculas`) utilizará su propia instancia de base de datos (MongoDB recomendado).
* **Despliegue:** El sistema se desplegará localmente utilizando Docker Compose.
* **CI/CD:** Se configurará un pipeline básico con GitHub Actions para ejecutar pruebas automáticamente.

## Microservicios

El sistema está compuesto por los siguientes servicios principales:

* `/usuarios-servicio`: Gestiona la información de los usuarios (estudiantes, docentes) y la autenticación/autorización (JWT).
* `/asignaturas-servicio`: Gestiona la información de las asignaturas ofrecidas.
* `/matriculas-servicio`: Gestiona el proceso de matrícula de estudiantes en asignaturas, interactuando con los otros servicios.
* `/eureka-server`: Servidor de descubrimiento de servicios.
* `/config-server` (Opcional): Servidor de configuración centralizada.
* `/gateway-servicio` (Opcional): API Gateway para enrutar las peticiones.

## Tecnologías Utilizadas

* Java / Spring Boot 3
* Spring Cloud (Eureka, Config, Gateway, OpenFeign)
* Spring Security + JWT
* MongoDB (u otra base de datos por servicio)
* Maven
* Docker / Docker Compose
* GitHub Actions
* JUnit / Mockito / WebTestClient
* VS Code
* Git / GitHub