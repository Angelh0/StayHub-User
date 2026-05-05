# StayHub - User 

## 📍 Estado del proyecto

🚧 Proyecto en desarrollo

✅ **Finalizado**

Este repositorio contiene el microservicio de **Usuarios e Identidad**. Actúa como el pilar de seguridad del ecosistema StayHub, funcionando como el proveedor central de identidad y gestionando la autenticación, autorización y el control de acceso estricto basado en roles.

---

## 🎯 Hitos del microservicio

### 🛡️ Autenticación JWT y Seguridad
Se ha implementado un sistema de seguridad robusto basado en `Spring Security` y `JSON Web Tokens`:
* **Filtros personalizados:** Creación de un `JwtFilter` para validar tokens en cada petición y proteger los endpoints de la API.
* **Payload optimizado:** Los tokens generados no solo validan el acceso, sino que encriptan información clave en sus *claims* (UUID del usuario, Rol, Nombre y Apellidos). Esto evita que el Frontend o los otros microservicios tengan que hacer peticiones extra a la base de datos para saber quién está navegando.
* **Configuración CORS:** Ajustes en `SecurityConfig` para permitir la comunicación segura y fluida con la interfaz gráfica (Frontend).

### 👥 Sistema de roles escalable y jerárquico
El modelo de dominio está diseñado para gestionar el ciclo de vida del usuario de forma progresiva:
* **Rol [User]:** Entidad base que representa a un cliente registrado en el sistema.
* **Rol [Owner] (Upgrade):** Se ha implementado un sistema de escalado donde un `User` existente puede solicitar ser propietario. Esto crea una relación 1:1 con la entidad `OwnerEntity`, añadiendo datos específicos (ciudad, teléfono) sin duplicar credenciales de acceso. El nuevo rol se actualiza dinámicamente en su próximo login.

### 🕵️ Sesiones de invitado (Guest Mode)
Para mejorar la conversión y accesibilidad de la plataforma sin comprometer la seguridad:
* Se ha implementado el rol temporal `[Guest]`.
* Permite a los usuarios no registrados acceder a las búsquedas complejas de alojamientos y habitaciones.
* Al entrar como invitado, el sistema genera dinámicamente un `uuidGuest` y emite un token válido por 24 horas, garantizando la trazabilidad de sus búsquedas y bloqueando el acceso a zonas protegidas (reservas o creación de alojamientos).

### 🔗 Centralización de la identidad
Este microservicio es la **fuente de la verdad** para todo el sistema distribuido:
* Provee la base de identidad inmutable para `StayHub-Accommodation` y `StayHub-Reservation`.
* Garantiza que las verificaciones de pertenencia de datos (ej: "Solo el creador puede modificar este alojamiento") se basen en UUIDs validados criptográficamente.

---

## 🛠️ Tecnologías utilizadas
* **Lenguaje y Framework:** Java 17, Spring Boot
* **Seguridad y Acceso:** Spring Security, JWT (JSON Web Tokens)
* **Persistencia y ORM:** JPA, Hibernate, PostgreSQL (Producción), H2 (Desarrollo y Testing)
* **Arquitectura y Comunicación:** Patrón Microservicios, API REST, JSON, gRPC
* **Manejo de Errores:** Excepciones personalizadas centralizadas para el manejo de credenciales inválidas y duplicidad de datos.
* **DevOps y Despliegue:** Docker, Docker Compose, Git, GitHub.

---

## 🚀 Próximos pasos en StayHub

StayHub se basa en una arquitectura diseñada en la separación de responsabilidades, lo que facilita futuras integraciones como:

* Integración de OAuth2 para inicio de sesión social (Google / GitHub).
* Sistema de recuperación de contraseñas mediante envío de correos electrónicos.
* Gestión de perfiles extendidos (subida de avatares).

* 🔐 Integración de OAuth2 para inicio de sesión social (Google / GitHub).
* ✉️ Sistema de recuperación de contraseñas mediante envío de correos electrónicos.
* 🖼️ Gestión de perfiles extendidos (subida de avatares).
