# 🚀 CÓMO EJECUTAR GoRide - GUÍA RÁPIDA

## ⚠️ IMPORTANTE: Primero soluciona el error de JDK

Veo que aparece "Invalid Gradle JDK configuration found" en tu pantalla.

### ✅ SOLUCIÓN EN 3 PASOS:

---

## PASO 1: Cerrar Android Studio

**Cierra completamente Android Studio** (X en la esquina superior derecha)

---

## PASO 2: Abrir Android Studio de nuevo

1. Abre **Android Studio**
2. En la pantalla de bienvenida, haz clic en **"Open"**
3. Navega a: `C:\Users\LuissxD\AndroidStudioProjects\GoRide`
4. Haz clic en **"OK"**

---

## PASO 3: Configurar JDK (MUY IMPORTANTE)

Cuando se abra el proyecto, verás el error "Invalid Gradle JDK configuration found".

### Opción A: Hacer clic en el link azul
1. Verás un mensaje con el link: **"Change Gradle JDK location"**
2. Haz clic en ese link
3. En el menú desplegable, selecciona: **"jbr-17"** o **"Embedded JDK"**
4. Haz clic en **"OK"**

### Opción B: Configurar manualmente
1. Ve a: **File → Project Structure** (o presiona `Ctrl+Alt+Shift+S`)
2. En el panel izquierdo, selecciona **"SDK Location"**
3. En **"Gradle Settings"**, encuentra **"Gradle JDK"**
4. Selecciona: **"jbr-17 JetBrains Runtime version 17.x.x"**
5. Haz clic en **"Apply"** y luego **"OK"**

---

## PASO 4: Sincronizar Gradle

Después de configurar el JDK:

1. Aparecerá una barra amarilla arriba que dice: **"Gradle files have changed since last sync"**
2. Haz clic en **"Sync Now"** (botón azul a la derecha)
3. **Espera 2-3 minutos** mientras sincroniza (verás una barra de progreso abajo)
4. ✅ Cuando termine, verás: **"Gradle sync finished"**

---

## PASO 5: Ejecutar la App

### Una vez que Gradle sync termine exitosamente:

1. Conecta un dispositivo Android via USB **O** inicia un emulador:
   - **Tools → Device Manager → Play** (en un dispositivo existente)
   - O crea uno nuevo si no tienes

2. Espera a que el emulador/dispositivo esté listo

3. Haz clic en el **botón verde "Run" (▶️)** en la barra superior
   - O presiona **Shift+F10**

4. Selecciona tu dispositivo en el diálogo que aparece

5. ✅ **¡La app se instalará y ejecutará!**

---

## 🔐 CREDENCIALES DE PRUEBA

Una vez que la app se ejecute, usa estos usuarios para hacer login:

### Administrador:
```
Usuario: admin
Contraseña: admin123
```

### Conductor:
```
Usuario: conductor
Contraseña: conductor123
```

### Usuario:
```
Usuario: usuario
Contraseña: usuario123
```

---

## ❓ SOLUCIÓN DE PROBLEMAS

### Si el error de JDK persiste:

1. **File → Invalidate Caches** → Check "Clear file system cache and Local History" → **"Invalidate and Restart"**
2. Espera a que Android Studio reinicie
3. Repite los pasos desde el PASO 3

### Si Gradle sync falla:

```powershell
# Ejecuta en PowerShell desde la carpeta del proyecto:
cd C:\Users\LuissxD\AndroidStudioProjects\GoRide
.\gradlew.bat clean
```

Luego en Android Studio: **File → Sync Project with Gradle Files**

### Si no encuentras el Embedded JDK:

1. **File → Project Structure → SDK Location**
2. Haz clic en **"Download JDK"**
3. Selecciona: **JetBrains Runtime** versión **17**
4. Haz clic en **"Download"**
5. Una vez descargado, selecciónalo como Gradle JDK

---

## ✅ VERIFICACIÓN EXITOSA

Sabrás que todo funciona cuando:

1. ✅ No hay errores rojos en la pestaña "Build"
2. ✅ La pestaña "Build" muestra: "BUILD SUCCESSFUL"
3. ✅ La app se instala en el emulador/dispositivo
4. ✅ Ves la pantalla de Login de GoRide

---

## 📱 FLUJO DE LA APP

1. **Pantalla de Login** → Ingresa credenciales
2. **Menú Principal** → Verás 6 botones:
   - Gestión de Usuarios
   - Gestión de Roles
   - Gestión de Conductores
   - Gestión de Viajes
   - Gestión de Servicios
   - Cerrar Sesión
3. **Gestión de Usuarios** → Lista de usuarios con opciones CRUD
4. **Formulario** → Crear/Editar usuarios

---

## 🎯 RESUMEN RÁPIDO

```
1. Cierra Android Studio
2. Abre Android Studio
3. Abre proyecto GoRide
4. Configura JDK → Selecciona "jbr-17" o "Embedded JDK"
5. Sync Now → Espera 2-3 minutos
6. Run (▶️) → Selecciona dispositivo
7. ¡La app se ejecuta!
8. Login con: admin / admin123
```

---

## 📞 AYUDA ADICIONAL

Si después de seguir todos estos pasos aún tienes problemas:

1. Toma una captura del mensaje de error completo
2. Revisa la pestaña **"Build Output"** para detalles
3. Verifica que tienes Android Studio Arctic Fox o superior instalado

---

**Creado:** 16/01/2026  
**Estado del proyecto:** ✅ Refactorizado y listo  
**Errores de código:** 0  
**Próximo paso:** Seguir esta guía paso a paso

