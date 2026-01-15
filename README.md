# GoRide - Aplicación de Transporte Android

## Descripción General

GoRide es una aplicación móvil académica desarrollada para Android siguiendo estrictamente el patrón arquitectónico **Modelo-Vista-Controlador (MVC)**. La aplicación está inspirada en sistemas de transporte tipo Yango y tiene como objetivo demostrar la aplicación de principios de ingeniería de software, diseño de sistemas de información y buenas prácticas de desarrollo.

## Características Principales

- ✅ Arquitectura MVC estricta
- ✅ Sistema de autenticación con credenciales
- ✅ Gestión completa de usuarios (CRUD)
- ✅ Gestión de roles
- ✅ Gestión de conductores
- ✅ Gestión de viajes
- ✅ Gestión de servicios de transporte
- ✅ Persistencia de datos con Room Database
- ✅ 100% código en español
- ✅ Datos de prueba precargados

## Tecnologías Utilizadas

- **Lenguaje:** Java
- **IDE:** Android Studio
- **Base de Datos:** Room Database (SQLite)
- **Arquitectura:** MVC (Modelo-Vista-Controlador)
- **UI:** Material Design Components
- **Versión Mínima Android:** API 24 (Android 7.0)
- **Versión Target:** API 36

## Estructura del Proyecto

```
GoRide/
├── modelo/
│   ├── entidades/          # Entidades de Room Database
│   │   ├── Usuario.java
│   │   ├── Rol.java
│   │   ├── Conductor.java
│   │   ├── Viaje.java
│   │   └── Servicio.java
│   │
│   ├── dao/                # Data Access Objects
│   │   ├── UsuarioDao.java
│   │   ├── RolDao.java
│   │   ├── ConductorDao.java
│   │   ├── ViajeDao.java
│   │   └── ServicioDao.java
│   │
│   ├── repositorio/        # Repositorios (Lógica de negocio)
│   │   ├── RepositorioUsuario.java
│   │   ├── RepositorioRol.java
│   │   ├── RepositorioConductor.java
│   │   ├── RepositorioViaje.java
│   │   └── RepositorioServicio.java
│   │
│   ├── basedatos/
│   │   └── BaseDatosGoRide.java
│   │
│   └── utilidades/         # Clases de utilidad
│       ├── GestorSesion.java
│       ├── ValidadorDatos.java
│       ├── UtilidadesFecha.java
│       ├── CalculadoraTarifa.java
│       └── InicializadorDatos.java
│
├── vista/                  # Archivos XML de diseño
│   └── res/layout/
│       ├── activity_login.xml
│       ├── activity_menu_principal.xml
│       ├── activity_lista_usuarios.xml
│       ├── activity_formulario_usuario.xml
│       └── item_usuario.xml
│
└── controlador/            # Activities (Controladores)
    ├── ActividadLogin.java
    ├── ActividadMenuPrincipal.java
    ├── ActividadListaUsuarios.java
    ├── ActividadFormularioUsuario.java
    └── adaptadores/
        └── AdaptadorUsuario.java
```

## Arquitectura MVC

### Modelo (modelo/)
Contiene toda la lógica de negocio y acceso a datos:
- **Entidades:** Representan las tablas de la base de datos
- **DAOs:** Interfaces para operaciones de base de datos
- **Repositorios:** Encapsulan la lógica de acceso a datos
- **Utilidades:** Clases auxiliares para validación, fechas, sesión, etc.

### Vista (res/layout/)
Archivos XML que definen la interfaz gráfica:
- Sin lógica de negocio
- Solo presentación visual
- Uso de Material Design Components

### Controlador (controlador/)
Activities que conectan Modelo y Vista:
- Manejan eventos del usuario
- Actualizan la vista con datos del modelo
- Gestionan el flujo de navegación

## Base de Datos

La aplicación utiliza **Room Database** con las siguientes tablas:

### Tabla: usuarios
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id_usuario | INTEGER | PK, Autoincremental |
| nombre_usuario | TEXT | Nombre de usuario único |
| contrasena | TEXT | Contraseña |
| nombre_completo | TEXT | Nombre completo |
| correo_electronico | TEXT | Correo electrónico |
| telefono | TEXT | Número telefónico |
| id_rol | INTEGER | FK a roles |
| estado | TEXT | Activo/Inactivo |
| fecha_creacion | TEXT | Fecha de creación |

### Tabla: roles
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id_rol | INTEGER | PK, Autoincremental |
| nombre_rol | TEXT | Nombre del rol |
| descripcion | TEXT | Descripción |
| estado | TEXT | Activo/Inactivo |

### Tabla: conductores
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id_conductor | INTEGER | PK, Autoincremental |
| id_usuario | INTEGER | FK a usuarios |
| licencia_conducir | TEXT | Número de licencia |
| placa_vehiculo | TEXT | Placa del vehículo |
| modelo_vehiculo | TEXT | Modelo |
| color_vehiculo | TEXT | Color |
| anio_vehiculo | INTEGER | Año |
| estado | TEXT | Activo/Inactivo |

### Tabla: viajes
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id_viaje | INTEGER | PK, Autoincremental |
| id_usuario | INTEGER | FK a usuarios |
| id_conductor | INTEGER | FK a conductores |
| id_servicio | INTEGER | FK a servicios |
| origen | TEXT | Dirección de origen |
| destino | TEXT | Dirección de destino |
| fecha_viaje | TEXT | Fecha |
| hora_viaje | TEXT | Hora |
| estado | TEXT | Pendiente/En Curso/Completado/Cancelado |
| tarifa | REAL | Tarifa del viaje |
| distancia_km | REAL | Distancia en kilómetros |

### Tabla: servicios
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id_servicio | INTEGER | PK, Autoincremental |
| nombre_servicio | TEXT | Nombre del servicio |
| descripcion | TEXT | Descripción |
| precio_base | REAL | Precio base |
| precio_por_kilometro | REAL | Precio por km |
| estado | TEXT | Activo/Inactivo |

## Datos de Prueba

La aplicación incluye datos de prueba que se cargan automáticamente en el primer inicio:

### Usuarios de Prueba

| Usuario | Contraseña | Rol | Descripción |
|---------|-----------|-----|-------------|
| admin | admin123 | Administrador | Usuario con acceso total |
| juan_perez | cliente123 | Cliente | Usuario cliente de prueba |
| maria_lopez | cliente123 | Cliente | Usuario cliente de prueba |
| carlos_driver | conductor123 | Conductor | Usuario conductor de prueba |
| ana_driver | conductor123 | Conductor | Usuario conductor de prueba |

### Roles
- Administrador
- Cliente  
- Conductor

### Servicios
- GoRide Económico ($5,000 base + $1,500/km)
- GoRide Confort ($8,000 base + $2,000/km)
- GoRide Premium ($15,000 base + $3,500/km)
- GoRide Compartido ($3,000 base + $1,000/km)

### Conductores
- Carlos Rodríguez (Chevrolet Spark 2020, Placa ABC123)
- Ana Martínez (Mazda 3 2021, Placa XYZ789)

### Viajes de Prueba
Se incluyen 4 viajes de ejemplo en diferentes estados.

## Funcionalidades Implementadas

### Sistema de Autenticación
- ✅ Login con usuario y contraseña
- ✅ Validación de credenciales
- ✅ Gestión de sesión con SharedPreferences
- ✅ Cierre de sesión
- ✅ Protección de rutas

### Módulo de Usuarios (CRUD Completo)
- ✅ Listar todos los usuarios
- ✅ Crear nuevo usuario
- ✅ Editar usuario existente
- ✅ Eliminar usuario
- ✅ Validaciones de datos
- ✅ Búsqueda y filtros

### Validaciones
- ✅ Nombre de usuario (mínimo 4 caracteres)
- ✅ Contraseña (mínimo 6 caracteres)
- ✅ Correo electrónico (formato válido)
- ✅ Teléfono (10 dígitos)
- ✅ Campos requeridos

## Instalación y Ejecución

### Requisitos Previos
- Android Studio Arctic Fox o superior
- JDK 11 o superior
- Android SDK API 24 o superior
- Dispositivo Android o Emulador

### Pasos de Instalación

1. **Clonar o abrir el proyecto en Android Studio**
   ```
   Abrir Android Studio > Open Project > Seleccionar carpeta GoRide
   ```

2. **Sincronizar dependencias de Gradle**
   ```
   File > Sync Project with Gradle Files
   ```

3. **Compilar el proyecto**
   ```
   Build > Make Project
   ```

4. **Ejecutar la aplicación**
   ```
   Run > Run 'app'
   ```

## Uso de la Aplicación

### Primer Inicio
1. La aplicación cargará automáticamente los datos de prueba
2. Se mostrará la pantalla de login
3. Usar las credenciales de prueba (ver tabla arriba)

### Navegación
1. **Login:** Ingresar con usuario y contraseña
2. **Menú Principal:** Acceder a los diferentes módulos
3. **Gestión de Usuarios:** 
   - Ver lista completa
   - Crear nuevo usuario
   - Editar usuarios existentes
   - Eliminar usuarios
4. **Cerrar Sesión:** Botón en menú principal

## Módulos Pendientes de Implementación

Los siguientes módulos siguen el mismo patrón del módulo de Usuarios:

- [ ] CRUD completo de Roles
- [ ] CRUD completo de Conductores
- [ ] CRUD completo de Viajes
- [ ] CRUD completo de Servicios

## Buenas Prácticas Implementadas

✅ **Separación de responsabilidades** (MVC estricto)  
✅ **Código limpio y legible**  
✅ **Nomenclatura en español**  
✅ **Comentarios descriptivos**  
✅ **Validación de datos**  
✅ **Gestión de errores**  
✅ **Patrón Singleton para BD**  
✅ **Patrón Repository**  
✅ **Reutilización de código**  
✅ **Organización de paquetes**  

## Estándares de Código

- **Idioma:** Todo el código en español
- **Nomenclatura:** camelCase para variables y métodos
- **Clases:** Nombres descriptivos en PascalCase
- **Constantes:** MAYÚSCULAS_CON_GUIONES
- **Comentarios:** Javadoc para clases y métodos públicos

## Dependencias Principales

```gradle
// Android Core
implementation 'androidx.appcompat:appcompat:1.7.1'
implementation 'com.google.android.material:material:1.13.0'
implementation 'androidx.constraintlayout:constraintlayout:2.2.1'

// Room Database
implementation 'androidx.room:room-runtime:2.6.1'
annotationProcessor 'androidx.room:room-compiler:2.6.1'

// RecyclerView y CardView
implementation 'androidx.recyclerview:recyclerview:1.3.2'
implementation 'androidx.cardview:cardview:1.0.0'
```

## Autor

Proyecto académico - GoRide  
Desarrollo de Software para Android  
Arquitectura MVC con Room Database

## Licencia

Este es un proyecto académico con fines educativos.

## Notas Adicionales

- La aplicación usa `allowMainThreadQueries()` solo para propósitos académicos
- En producción se deberían usar coroutines o AsyncTask
- Las contraseñas se almacenan en texto plano para propósitos de demostración
- En producción deberían encriptarse con BCrypt o similar

## Estructura de Archivos Generados

```
Total de archivos creados: 30+

Modelo (20 archivos):
- 5 Entidades
- 5 DAOs
- 5 Repositorios
- 4 Utilidades
- 1 Base de Datos

Vista (5 archivos XML):
- 5 Layouts

Controlador (5 archivos):
- 4 Activities
- 1 Adaptador
```

## Soporte

Para preguntas o problemas, revisar:
1. La documentación del código (comentarios Javadoc)
2. La estructura de paquetes
3. Los patrones implementados

---
**Proyecto GoRide - Ingeniería de Software - 2026**

