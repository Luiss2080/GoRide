# Script para FORZAR la instalación de GoRide
Write-Host "====================================" -ForegroundColor Cyan
Write-Host "  INSTALANDO GORIDE EN EL EMULADOR  " -ForegroundColor Cyan
Write-Host "====================================" -ForegroundColor Cyan
Write-Host ""

# Definir el path del SDK
$sdkPath = "C:\Users\LuissxD\AppData\Local\Android\Sdk"
$adb = "$sdkPath\platform-tools\adb.exe"

# Verificar si ADB existe
if (Test-Path $adb) {
    Write-Host "✓ ADB encontrado" -ForegroundColor Green

    # Verificar dispositivos conectados
    Write-Host "`n1. Verificando emuladores conectados..." -ForegroundColor Yellow
    & $adb devices

    # Desinstalar apps anteriores
    Write-Host "`n2. Desinstalando apps anteriores..." -ForegroundColor Yellow
    & $adb uninstall com.example.goride 2>$null
    Write-Host "   - com.example.goride desinstalada" -ForegroundColor Gray

    # Detener Gradle daemons
    Write-Host "`n3. Deteniendo Gradle daemons..." -ForegroundColor Yellow
    .\gradlew --stop

    # Limpiar build
    Write-Host "`n4. Limpiando compilaciones anteriores..." -ForegroundColor Yellow
    Remove-Item -Recurse -Force .\app\build -ErrorAction SilentlyContinue

    # Compilar e instalar
    Write-Host "`n5. Compilando e instalando GoRide..." -ForegroundColor Yellow
    .\gradlew installDebug

    # Lanzar la app
    Write-Host "`n6. Lanzando GoRide en el emulador..." -ForegroundColor Yellow
    & $adb shell am start -n com.example.goride/.MainActivity

    Write-Host "`n====================================" -ForegroundColor Green
    Write-Host "  ✓ PROCESO COMPLETADO  " -ForegroundColor Green
    Write-Host "====================================" -ForegroundColor Green
    Write-Host "`nGoRide debería estar ejecutándose en el emulador." -ForegroundColor White
    Write-Host "Si ves otra app, cierra Android Studio y vuelve a abrirlo" -ForegroundColor White
    Write-Host "asegurándote de abrir SOLO el proyecto GoRide." -ForegroundColor White

} else {
    Write-Host "✗ Error: ADB no encontrado en $adb" -ForegroundColor Red
    Write-Host "  Ejecuta desde Android Studio usando el botón Run (▶️)" -ForegroundColor Yellow
}

Write-Host ""

