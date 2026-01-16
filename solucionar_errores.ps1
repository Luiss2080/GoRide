# Script de Solucion de Errores - GoRide
# Este script limpia todos los archivos intermedios corruptos y prepara el proyecto

Write-Host "================================================" -ForegroundColor Cyan
Write-Host "  Solucionando Errores - GoRide                " -ForegroundColor Cyan
Write-Host "================================================" -ForegroundColor Cyan
Write-Host ""

$proyectoDir = "C:\Users\LuissxD\AndroidStudioProjects\GoRide"
Set-Location $proyectoDir

Write-Host "PASO 1: Limpiando archivos corruptos..." -ForegroundColor Yellow
Write-Host ""

# Eliminar directorio build de app
if (Test-Path "app\build") {
    Write-Host "  Eliminando app\build..." -ForegroundColor Gray
    Remove-Item -Recurse -Force "app\build" -ErrorAction SilentlyContinue
    Write-Host "  OK app\build eliminado" -ForegroundColor Green
}

# Eliminar directorio build raiz
if (Test-Path "build") {
    Write-Host "  Eliminando build raiz..." -ForegroundColor Gray
    Remove-Item -Recurse -Force "build" -ErrorAction SilentlyContinue
    Write-Host "  OK build raiz eliminado" -ForegroundColor Green
}

# Eliminar cache de Gradle
if (Test-Path ".gradle") {
    Write-Host "  Eliminando .gradle..." -ForegroundColor Gray
    Remove-Item -Recurse -Force ".gradle" -ErrorAction SilentlyContinue
    Write-Host "  OK .gradle eliminado" -ForegroundColor Green
}

# Eliminar archivos .idea que puedan causar problemas
if (Test-Path ".idea\caches") {
    Write-Host "  Eliminando .idea\caches..." -ForegroundColor Gray
    Remove-Item -Recurse -Force ".idea\caches" -ErrorAction SilentlyContinue
    Write-Host "  OK .idea\caches eliminado" -ForegroundColor Green
}

Write-Host ""
Write-Host "PASO 2: Ejecutando Gradle Clean..." -ForegroundColor Yellow
Write-Host ""

# Ejecutar gradlew clean
& ".\gradlew.bat" clean

Write-Host ""
Write-Host "LIMPIEZA COMPLETADA" -ForegroundColor Green
Write-Host ""
Write-Host "================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "PROXIMOS PASOS:" -ForegroundColor Yellow
Write-Host ""
Write-Host "  1. Cierra Android Studio completamente" -ForegroundColor White
Write-Host ""
Write-Host "  2. Abre Android Studio de nuevo" -ForegroundColor White
Write-Host ""
Write-Host "  3. Abre el proyecto GoRide" -ForegroundColor White
Write-Host ""
Write-Host "  4. Si aparece el error Invalid Gradle JDK configuration:" -ForegroundColor White
Write-Host "     Haz clic en el boton Use Embedded JDK (rosa/magenta)" -ForegroundColor Magenta
Write-Host ""
Write-Host "  5. Espera a que aparezca la barra amarilla que dice:" -ForegroundColor White
Write-Host "     Gradle files have changed since last sync..." -ForegroundColor Yellow
Write-Host "     Haz clic en Sync Now" -ForegroundColor Magenta
Write-Host ""
Write-Host "  6. Espera a que termine la sincronizacion (1-2 minutos)" -ForegroundColor White
Write-Host ""
Write-Host "  7. Ve al menu Build y selecciona Clean Project" -ForegroundColor White
Write-Host ""
Write-Host "  8. Ve al menu Build y selecciona Rebuild Project" -ForegroundColor White
Write-Host ""
Write-Host "================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "CAUSA DE LOS ERRORES:" -ForegroundColor Cyan
Write-Host ""
Write-Host "Los errores que viste eran causados por archivos XML" -ForegroundColor White
Write-Host "corruptos en el directorio build/intermediates/." -ForegroundColor White
Write-Host ""
Write-Host "Estos archivos se generaron con versiones incompatibles" -ForegroundColor White
Write-Host "de herramientas. Al eliminarlos, Gradle los regenerara" -ForegroundColor White
Write-Host "correctamente con las versiones actuales." -ForegroundColor White
Write-Host ""
Write-Host "================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Todo listo para compilar" -ForegroundColor Green
Write-Host ""

