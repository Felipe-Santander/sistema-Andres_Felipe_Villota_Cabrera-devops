# 📚 Sistema de Gestión Académica Distribuido - DevOps  
**Andrés Felipe Villota Cabrera**

Proyecto final de la asignatura **Lenguaje de Programación Avanzado 2**. Implementación de un sistema distribuido con enfoque **DevOps**, arquitectura basada en microservicios, CI/CD, seguridad con JWT, despliegue con Docker Compose y monitoreo del sistema.

---

## 📝 Descripción del Sistema ...

Este proyecto implementa un sistema básico de gestión académica utilizando una arquitectura de microservicios. Permite gestionar usuarios (estudiantes, profesores), asignaturas y matrículas. Cada servicio está desacoplado, es autónomo, se comunica con otros por medio de API REST y está preparado para escalar. El sistema es funcional, seguro, monitoreable y desplegable de manera local mediante contenedores.

---

## 🏗️ Arquitectura

El sistema sigue una arquitectura de microservicios que incluye:

- **API Gateway (Opcional):** Punto único de entrada, a implementar si se decide usar `gateway-servicio`.
- **Service Discovery:** Netflix Eureka (`eureka-server`) permite el descubrimiento dinámico de microservicios.
- **Config Server (Opcional):** Para gestión centralizada de configuración mediante `config-server` y un repositorio externo en GitHub.
- **Comunicación:** Mediante API REST usando **Feign Clients** para simplificar las llamadas entre servicios.
- **Seguridad:** Autenticación y autorización basada en JWT implementada en `usuarios-servicio`, protegiendo los endpoints de acceso.
- **Base de Datos:** Cada microservicio cuenta con su propia instancia de base de datos (se recomienda MongoDB).
- **Despliegue:** Todo el sistema se despliega localmente utilizando **Docker Compose**.
- **Monitoreo:** Se utilizan **Spring Boot Actuator**, Prometheus y Grafana para monitorear el estado de los servicios.
- **CI/CD:** Configuración de un pipeline de integración continua con **GitHub Actions** que ejecuta pruebas automáticas al hacer push.

---

## 🧩 Microservicios

El sistema está compuesto por los siguientes servicios principales:

- `/usuarios-servicio`: Gestiona usuarios (estudiantes, docentes), autenticación y autorización con JWT. Implementa endpoints protegidos y roles (`ROLE_USER`, `ROLE_ADMIN`).
- `/asignaturas-servicio`: Gestiona información sobre asignaturas. Servicio autónomo que provee datos a otros microservicios.
- `/matriculas-servicio`: Encargado del proceso de matrícula. Se comunica con los otros servicios mediante **Feign Clients** para consolidar datos y registrar matrículas.
- `/eureka-server`: Servidor para descubrimiento de servicios. Permite que los microservicios se registren y se comuniquen entre sí.

---

## 🧪 Pruebas

Cada microservicio incluye:

- ✅ Al menos **2 pruebas unitarias** usando **Mockito**.
- ✅ Al menos **1 prueba de integración** con **WebTestClient**.
- ✅ Validación funcional con **Postman** para simular peticiones reales y validar seguridad y flujo de datos.
- ✅ Evidencias capturadas del funcionamiento correcto en cada caso.

---

## 🔐 Seguridad

Se implementa seguridad en `usuarios-servicio` con:

- 🔒 Registro e inicio de sesión.
- 🔒 Generación de tokens **JWT** al autenticarse correctamente.
- 🔒 Protección de rutas y control de acceso basado en roles.
- 🔒 Validación de acceso con herramientas como **Postman** para confirmar el comportamiento esperado.

---

## 🔄 Comunicación entre Servicios

`matriculas-servicio` consume servicios de:

- 🧑‍🎓 `usuarios-servicio` para obtener datos del estudiante.
- 📚 `asignaturas-servicio` para consultar materias.

Esto se realiza mediante **Feign Clients**, facilitando la comunicación declarativa entre servicios.

---

## ⚙️ Configuración y Descubrimiento

- 🔧 Todos los microservicios están registrados en **Eureka**.
- 🛠️ Cada uno cuenta con su archivo `bootstrap.properties` conectado al **config-server**.
- 🗂️ Se gestiona un repositorio externo de configuración para centralizar parámetros como puertos, rutas y BD.

---

## 📦 Despliegue

El sistema se levanta completamente con **Docker Compose**, incluyendo:

- 🚀 Los tres microservicios principales
- 🛢️ MongoDB para cada servicio
- 🧭 Eureka, Config Server y Gateway (opcional)
- 📈 Prometheus y Grafana para monitoreo

```bash
docker-compose up --build
