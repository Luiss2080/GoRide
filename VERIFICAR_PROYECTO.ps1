# ============================================
# VERIFICAR PROYECTO GoRide
# ============================================

Write-Host ""
Write-Host "====================================================" -ForegroundColor Cyan
Write-Host "  VERIFICACION DE PROYECTO GoRide                  " -ForegroundColor Cyan
Write-Host "====================================================" -ForegroundColor Cyan
Write-Host ""

Set-Location "C:\Users\LuissxD\AndroidStudioProjects\GoRide"

# Verificar archivos críticos
Write-Host "📋 ARCHIVOS CRITICOS:" -ForegroundColor Yellow
Write-Host ""

$archivos = @(
    "app\build.gradle.kts",
    "build.gradle.kts",
    "gradle.properties",
    "settings.gradle.kts",
    "app\src\main\java\com\example\goride\MainActivity.java",
    "app\src\main\java\com\example\goride\controlador\ActividadLogin.java",
    "app\src\main\java\com\example\goride\modelo\utilidades\ValidadorDatos.java",
    "app\src\main\res\layout\activity_login.xml",
    "app\src\main\AndroidManifest.xml"
)

$todosOk = $true
foreach ($archivo in $archivos) {
    if (Test-Path $archivo) {
        Write-Host "  ✓ $archivo" -ForegroundColor Green
    } else {
        Write-Host "  ✗ $archivo - FALTA" -ForegroundColor Red
        $todosOk = $false
    }
}

Write-Host ""
Write-Host "📊 ESTADISTICAS:" -ForegroundColor Yellow
Write-Host ""

# Contar archivos Java
$javaFiles = (Get-ChildItem -Path "app\src\main\java" -Filter "*.java" -Recurse -ErrorAction SilentlyContinue).Count
Write-Host "  Archivos Java: $javaFiles" -ForegroundColor White

# Contar layouts
$layoutFiles = (Get-ChildItem -Path "app\src\main\res\layout" -Filter "*.xml" -ErrorAction SilentlyContinue).Count
Write-Host "  Layouts XML: $layoutFiles" -ForegroundColor White

# Verificar directorios build
Write-Host ""
Write-Host "🗑️  DIRECTORIOS BUILD:" -ForegroundColor Yellow
Write-Host ""

if (Test-Path "app\build") {
    Write-Host "  ⚠ app\build existe (se limpiará en sync)" -ForegroundColor Yellow
} else {
    Write-Host "  ✓ app\build limpio" -ForegroundColor Green
}

if (Test-Path ".gradle") {
    Write-Host "  ⚠ .gradle existe (se recreará en sync)" -ForegroundColor Yellow
} else {
    Write-Host "  ✓ .gradle limpio" -ForegroundColor Green
}

Write-Host ""
Write-Host "====================================================" -ForegroundColor Cyan
Write-Host "  RESULTADO DE VERIFICACION                        " -ForegroundColor Cyan
Write-Host "====================================================" -ForegroundColor Cyan
Write-Host ""

if ($todosOk) {
    Write-Host "✅ TODOS LOS ARCHIVOS CRITICOS PRESENTES" -ForegroundColor Green
    Write-Host ""
    Write-Host "El proyecto está listo para abrir en Android Studio" -ForegroundColor White
    Write-Host ""
    Write-Host "PASOS SIGUIENTES:" -ForegroundColor Cyan
    Write-Host "  1. Abre Android Studio" -ForegroundColor White
    Write-Host "  2. Abre el proyecto GoRide" -ForegroundColor White
    Write-Host "  3. Cuando aparezca error de JDK:" -ForegroundColor White
    Write-Host "     → Haz clic en 'Change Gradle JDK location'" -ForegroundColor Magenta
    Write-Host "     → Selecciona 'jbr-17' o 'Embedded JDK'" -ForegroundColor Magenta
    Write-Host "  4. Haz clic en 'Sync Now'" -ForegroundColor White
    Write-Host "  5. Espera la sincronización (2-3 min)" -ForegroundColor White
    Write-Host "  6. Presiona Shift+F10 para ejecutar" -ForegroundColor White
} else {
    Write-Host "❌ FALTAN ARCHIVOS CRITICOS" -ForegroundColor Red
    Write-Host ""
    Write-Host "Revisa los archivos marcados con ✗ arriba" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "====================================================" -ForegroundColor Cyan
Write-Host ""

Write-Host "📚 DOCUMENTACION DISPONIBLE:" -ForegroundColor Yellow
Write-Host ""
Write-Host "  • COMO_EJECUTAR_LA_APP.md - Guía paso a paso" -ForegroundColor White
Write-Host "  • REFACTORIZACION.md - Resumen de cambios" -ForegroundColor White
Write-Host "  • README_NUEVO.md - Documentación del proyecto" -ForegroundColor White
Write-Host "  • ERRORES_CORREGIDOS.md - Historial de correcciones" -ForegroundColor White
Write-Host ""

Write-Host "====================================================" -ForegroundColor Green
Write-Host ""

