# Script para ejecutar GoRide correctamente
Write-Host "===== EJECUTANDO GORIDE =====" -ForegroundColor Green
Write-Host ""

# Paso 1: Detener Gradle daemons
Write-Host "1. Deteniendo Gradle daemons..." -ForegroundColor Yellow
.\gradlew --stop

# Paso 2: Limpiar proyecto
Write-Host "2. Limpiando proyecto..." -ForegroundColor Yellow
Remove-Item -Recurse -Force .\app\build -ErrorAction SilentlyContinue

# Paso 3: Compilar e instalar en el emulador
Write-Host "3. Compilando e instalando GoRide..." -ForegroundColor Yellow
.\gradlew installDebug

Write-Host ""
Write-Host "===== PROCESO COMPLETADO =====" -ForegroundColor Green
Write-Host "Si el emulador está corriendo, la app GoRide debería estar instalada y lista."
Write-Host ""

