# StayHub - User 

## 📍 Estado del proyecto

🚧 Proyecto en desarrollo

La arquitectura y los componentes evolucionan de forma progresiva conforme se incorporan nuevas funcionalidades y tecnologías.
Para consultar el código del proyecto se debe acceder al branch "testing"

## 📌 Descripción

StayHub – User es el microservicio encargado de gestionar usuarios y propietarios dentro del proyecto StayHub.

Este servicio forma parte de la arquitectura basada en microservicios orientada al aprendizaje y el diseño de sistemas backend actuales, simulando el funcionamiento real de una plataforma de gestión de alojamientos y reservas.

El objetivo principal de este microservicio es centralizar la lógica relacionada con: 

- Registro y autenticación de usuarios
- Registro de propietarios
- Asignacióin de roles (User, Owner)
- Gestión de estados de usuario
- Validación de datos de registro
- Generación de tokens JWT para autenticación segura
- Control de acceso a endpoints según rol

## 🎯 Responsabilidad del microservicio

Este microservicio cumple con las siguientes responsabilidades:
- Registrar usuarios y propietarios
- Autenticar usuarios y propietarios
- Asignar roles y estados
- Validar datos de registro
- Proporcionar tokens JWT para consumo de otros microservicios
- Manejo de excepciones

Este microservicio no es responsable de: 
- Gestión de alojamientos o habitaciones
- Gestión de reservas
- Validación de disponibilidad

## 🧩 Modelo de dominio

**Usuario**

Representa a un cliente dentro del sistema

Campos principales

- UuidUser: identificador único
- FirstName, lastName
- Email, password
- role
- status
- Relación uno a uno con OwnerEntity (esto solo ocurre si el usuario obtiene el rol de propietario)

**Propietario**

Representa a un propietario dentro del sistema

Campos principales

- Mantiene todos los campos nombrados en usuario
- ciudad
- telefono
- Relación uno a uno con UserEntity

## 🔄 Flujo general

**1️⃣ Registro de usuario**

1. Se reciben los datos de registro
2. Se valida que no exista un usuario con el mismo email
3. Se crea el UserEntity con rol usuario y estado true
4. Se almacena en la base de datos

**2️⃣ Registro de propietario**

1. Solo puede realizarlo un cliente previamente registrado como usuario
2. Se asgina el rol de propietario
3. Se crea la entidad OwnerEntity vinculada con UserEntity
4. Se almacenan los datos de ciudad y teléfono
5. Se obtiene el rol al hacer login y obtener el nuevo token

**3️⃣ Login**

1. Se autentica credenciales mediante AuthenticationManager
2. Se comprueba el estado del usuario
3. Se genera un token con:
   - Email
   - Rol
   - Uuid del usuario
4. El token permite acceso a endpoints protegidos de otros microservicios

## 🔐 Seguridad y control de acceso
- Autenticación medainte JWT
- Endpoints accesibles sin token como: signUp, login
- Control de roles para endpoints específicos
- Gestión de sesión

## 🔗 Comunicación con otros microservicios

Este microservicio provee información de usuarios y propietarios para: 
- StayHub - Accommodation (usuarios y propietarios)
- StayHub - Reservation (usuarios y propietarios)

Actuando como fuente de verdad tanto en indetidad como en roles

## 🛠️ Tecnologías utilizadas
- Java
- Spring Boot
- Spring Security
- JWT
- JPA / Hibernate
- gRPC
- REST API
- JSON
- H2 (para desarrollo)
- Git

## 📘 Contexto del proyecto

Este microservicio forma parte del proyecto StayHub, una proyecto backend diseñado con fines de aprendizaje y de arquitectura, orientada a simular escenarios reales utilizados en sistemas de gestión de alojamientos.



