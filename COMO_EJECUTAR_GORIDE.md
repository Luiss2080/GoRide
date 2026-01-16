# ¡IMPORTANTE! - CÓMO EJECUTAR GORIDE CORRECTAMENTE

## Problema Detectado
El emulador está ejecutando una aplicación diferente ("Gestión de Inventario") 
en lugar de GoRide.

## SOLUCIÓN INMEDIATA

### Opción 1: Desde Android Studio (MÁS FÁCIL)
1. Asegúrate de tener Android Studio abierto con el proyecto **GoRide**
2. Cierra cualquier otro proyecto de Android Studio que tengas abierto
3. Ve al menú: Run > Select Device > Pixel 7 Pro API 36.0
4. Haz clic en el botón verde "Run 'app'" (▶️) en la barra de herramientas
5. Espera a que compile e instale

### Opción 2: Desinstalar la app incorrecta del emulador
1. En el emulador, mantén presionado el ícono de la app "Gestión de Inventario"
2. Arrástralo a "Desinstalar" o "Uninstall"
3. Luego ejecuta desde Android Studio o usa el script EJECUTAR_GORIDE.ps1

### Opción 3: Desde la terminal
```powershell
.\EJECUTAR_GORIDE.ps1
```

## Verificación
Después de ejecutar, deberías ver:
- Título: "GoRide" (en azul)
- Subtítulo: "Inicio de Sesión"
- Campos: Usuario y Contraseña
- Botón: "Ingresar"

## Usuarios de Prueba
- Usuario: admin / Contraseña: admin123
- Usuario: juan_perez / Contraseña: cliente123

## ¿Por qué está pasando esto?
Es probable que tengas otro proyecto Android abierto en Android Studio,
o que la app "Gestión de Inventario" ya estaba instalada en el emulador.

## Estado del Proyecto GoRide
✅ Código fuente: Correcto
✅ Layouts: Correctos  
✅ AndroidManifest: Correcto
✅ Package name: com.example.goride
✅ Nombre de la app: GoRide

El proyecto está listo, solo necesitas asegurarte de que Android Studio
esté compilando e instalando EL PROYECTO CORRECTO (GoRide).

