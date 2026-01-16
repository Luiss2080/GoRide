# GoRide 🚗

Sistema de Gestión de Transporte para Android

## 📱 Descripción

GoRide es una aplicación móvil Android que implementa un sistema completo de gestión de transporte. Desarrollada siguiendo el patrón MVC (Modelo-Vista-Controlador) con Java y Room Database.

## ✨ Características

- ✅ Sistema de autenticación seguro (BCrypt)
- ✅ Gestión completa de usuarios (CRUD)
- ✅ Gestión de roles y permisos
- ✅ Gestión de conductores
- ✅ Gestión de viajes
- ✅ Gestión de servicios de transporte
- ✅ Base de datos local (Room)
- ✅ Interfaz Material Design

## 🛠️ Tecnologías

| Tecnología | Versión |
|-----------|---------|
| Java | 11 |
| Android SDK | API 34 |
| Gradle | 8.7.3 |
| Room Database | 2.6.0 |
| Material Design | 1.12.0 |

## 📋 Requisitos

- Android Studio Arctic Fox o superior
- JDK 11 o superior
- Dispositivo/Emulador con Android 7.0+ (API 24+)

## 🚀 Instalación

1. **Clonar el repositorio**
   ```bash
   git clone [URL_DEL_REPO]
   cd GoRide
   ```

2. **Abrir en Android Studio**
   - File → Open → Seleccionar carpeta GoRide

3. **Sincronizar Gradle**
   - Hacer clic en "Sync Now" cuando aparezca

4. **Ejecutar la aplicación**
   - Run → Run 'app' o presionar Shift+F10

## 👥 Usuarios de Prueba

La aplicación incluye usuarios precargados:

| Usuario | Contraseña | Rol |
|---------|-----------|-----|
| admin | admin123 | Administrador |
| conductor | conductor123 | Conductor |
| usuario | usuario123 | Usuario |

## 📂 Estructura del Proyecto

```
app/src/main/java/com/example/goride/
│
├── controlador/              # Controladores (Activities)
│   ├── ActividadLogin.java
│   ├── ActividadMenuPrincipal.java
│   └── usuario/
│       ├── ActividadListaUsuarios.java
│       └── ActividadFormularioUsuario.java
│
├── modelo/                   # Modelos y lógica de negocio
│   ├── entidades/           # Entidades Room
│   │   ├── Usuario.java
│   │   ├── Rol.java
│   │   ├── Conductor.java
│   │   ├── Viaje.java
│   │   └── Servicio.java
│   │
│   ├── dao/                 # Data Access Objects
│   │   ├── UsuarioDao.java
│   │   ├── RolDao.java
│   │   ├── ConductorDao.java
│   │   ├── ViajeDao.java
│   │   └── ServicioDao.java
│   │
│   ├── repositorio/         # Capa de repositorios
│   │   ├── RepositorioUsuario.java
│   │   ├── RepositorioRol.java
│   │   ├── RepositorioConductor.java
│   │   ├── RepositorioViaje.java
│   │   └── RepositorioServicio.java
│   │
│   ├── basedatos/           # Configuración BD
│   │   └── BaseDatosGoRide.java
│   │
│   └── utilidades/          # Utilidades
│       ├── GestorSesion.java
│       ├── ValidadorDatos.java
│       ├── CalculadoraTarifa.java
│       ├── UtilidadesFecha.java
│       └── InicializadorDatos.java
│
└── vista/                   # Vistas y adaptadores
    └── adaptadores/
        ├── AdaptadorUsuario.java
        ├── AdaptadorRol.java
        ├── AdaptadorConductor.java
        ├── AdaptadorViaje.java
        └── AdaptadorServicio.java
```

## 🎯 Funcionalidades

### Autenticación
- Login con validación de credenciales
- Gestión de sesión persistente
- Encriptación de contraseñas con BCrypt

### Gestión de Usuarios
- Listar todos los usuarios
- Crear nuevos usuarios
- Editar usuarios existentes
- Eliminar usuarios
- Validación de datos

### Otros Módulos
- Gestión de roles
- Gestión de conductores
- Gestión de viajes
- Gestión de servicios

## 🔧 Compilación

### Desde Android Studio:
```
Build → Clean Project
Build → Rebuild Project
Run → Run 'app'
```

### Desde Terminal:
```bash
# Limpiar
./gradlew clean

# Compilar
./gradlew build

# Instalar en dispositivo
./gradlew installDebug
```

## 📱 Pantallas Principales

1. **Splash/MainActivity** - Redirige automáticamente al Login
2. **Login** - Autenticación de usuarios
3. **Menú Principal** - Dashboard con acceso a todos los módulos
4. **Lista de Usuarios** - Visualización de todos los usuarios
5. **Formulario de Usuario** - Crear/Editar usuarios

## 🔐 Seguridad

- Contraseñas encriptadas con BCrypt
- Validación de sesión en cada pantalla
- Validación de datos de entrada
- Protección contra inyección SQL (Room)

## 📝 Notas de Desarrollo

- Patrón arquitectónico: **MVC**
- Nomenclatura: Español
- Comentarios: Javadoc en español
- Base de datos: Room (SQLite)
- Gestión de hilos: ExecutorService para operaciones DB

## 🐛 Solución de Problemas

### Error de JDK
Si aparece "Invalid Gradle JDK configuration":
1. File → Project Structure → SDK Location
2. Seleccionar "Use Embedded JDK"

### Error de Sync
Si falla la sincronización de Gradle:
```bash
./gradlew clean
```
Luego: File → Sync Project with Gradle Files

## 📄 Licencia

Proyecto académico - Uso educativo

## 👨‍💻 Autor

Desarrollado como proyecto académico

---

**Versión:** 1.0.0  
**Fecha:** Enero 2026  
**Estado:** ✅ Funcional y Estable

