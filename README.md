# ✈️ VueloDeBiazi - Sistema de Gestión de Reservas

Un sistema web completo desarrollado en **Spring Boot** para la gestión de reservas de vuelos, aerolíneas, tarifas y usuarios. Incluye funcionalidades de búsqueda, reserva y administración de datos de vuelos.

## 🚀 Características principales

- **Gestión de vuelos**: Búsqueda y filtrado de vuelos por destino, fecha y aerolínea
- **Sistema de reservas**: Proceso completo de reserva con validación de datos
- **Gestión de usuarios**: Registro de usuarios
- **Base de datos relacional**: Estructura con MySQL
- **API RESTful**: Endpoints documentados para integración frontend/backend

---

## ✅ Requisitos del sistema

Antes de ejecutar el proyecto, asegurate de tener instalado:

| Componente | Versión Recomendada |
|------------|----------------|
| **Java** | 17 |
| **Maven** | 3.6.0 |
| **MySQL Server** | 8.0 |

### Opcional pero recomendado:
- **phpMyAdmin** o **MySQL Workbench** (gestión visual de BD)
- **IntelliJ IDEA** o **Eclipse** (desarrollo)
- **Postman** (testing de APIs)

---

## 📁 Estructura del proyecto

```
VueloDeBiazi/
├── 📄 pom.xml                    # Dependencias Maven
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/              # Código fuente Java
│   │   │   └── 📂 com/vuelodebiazi/
│   │   │       ├── 📂 controller/  # Controladores REST
│   │   │       ├── 📂 model/       # Entidades JPA
│   │   │       ├── 📂 repository/  # Repositorios Spring Data
│   │   │       └── 📂 service/     # Lógica de negocio
│   │   └── 📂 resources/
│   │       ├── 📄 application.properties  # Configuración
│   │       └── 📂 static/          # Archivos web estáticos
│   └── 📂 test/                   # Tests unitarios
├── 📂 db/
│   └── 📄 vuelodebiazi.sql       # Script de base de datos
├── 📄 README.md
└── 📄 .gitignore
```

---

## ⚙️ Configuración de la base de datos

### 1. Archivo de configuración

El archivo `src/main/resources/application.properties` contiene:

```properties
# Configuración de base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/vuelodebiazi?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Configuración del servidor
server.port=8080
```

### 2. Personalización de credenciales

Si usás credenciales diferentes, modificá estos valores:

```properties
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

---

## 🗃️ Instalación de la base de datos

### phpMyAdmin (Recomendada)

1. **Crear la base de datos**:
   - Abrí phpMyAdmin en `http://localhost/phpmyadmin`
   - Creá una nueva base de datos llamada: `vuelodebiazi`
   - Seleccioná `utf8_spanish_ci` como collation

2. **Importar datos**:
   - Seleccioná la base `vuelodebiazi`
   - Ir a la pestaña **"Importar"**
   - Seleccionar el archivo: `db/vuelodebiazi.sql`
   - Hacer clic en **"Continuar"**

```

### ⚠️ Error conocido y su solución

**Puede aparecer este mensaje**:
```sql
#1452 - Cannot add or update a child row: a foreign key constraint fails...
```

**✅Este error es cosmético y no afecta la funcionalidad. Ocurre por el orden de inserción de datos con claves foráneas, pero todas las tablas y datos se importan correctamente.**

---

## ▶️ Ejecutar el proyecto

### Desde línea de comandos:

```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar la aplicación
mvn spring-boot:run
```

### Desde tu IDE:

1. Importar el proyecto como "Maven Project"
2. Ejecutar la clase principal: `VueloDeBiaziApplication.java`
3. Esperar a que aparezca: `Started VueloDeBiaziApplication`

---

## 🌐 Acceso a la aplicación

Una vez iniciada la aplicación:

| Servicio | URL | Descripción |
|----------|-----|-------------|
| **Frontend** | http://localhost:8080/index.html | Interfaz principal |

---

## 📝 Notas adicionales

- **Base de datos**: Se recrea automáticamente con `hibernate.ddl-auto=update`
- **Logs**: Visibles en consola durante desarrollo
- **Profiles**: Configurar diferentes entornos (dev, prod) modificando `application.properties`
- **Documentación API**: Considerar agregar Swagger para documentación automática

---
