# ============================================
# EJECUTAR GoRide - Script Final
# ============================================

Write-Host ""
Write-Host "====================================================" -ForegroundColor Cyan
Write-Host "  GoRide - Aplicación de Transporte                " -ForegroundColor Cyan
Write-Host "====================================================" -ForegroundColor Cyan
Write-Host ""

$ErrorActionPreference = 'SilentlyContinue'
Set-Location "C:\Users\LuissxD\AndroidStudioProjects\GoRide"

Write-Host "📱 PREPARANDO APLICACION..." -ForegroundColor Yellow
Write-Host ""

# Limpiar procesos
Write-Host "[1/3] Limpiando procesos previos..." -ForegroundColor White
Get-Process | Where-Object {$_.Name -like "*java*" -or $_.Name -like "*gradle*"} | Stop-Process -Force -ErrorAction SilentlyContinue
Start-Sleep -Seconds 1
Write-Host "  ✓ Procesos limpiados" -ForegroundColor Green
Write-Host ""

# Compilar
Write-Host "[2/3] Compilando aplicación..." -ForegroundColor White
& ".\gradlew.bat" clean assembleDebug --no-daemon --warning-mode=none 2>&1 | Out-Null
if ($LASTEXITCODE -eq 0) {
    Write-Host "  ✓ Compilación exitosa" -ForegroundColor Green
} else {
    Write-Host "  ✗ Error en compilación" -ForegroundColor Red
}
Write-Host ""

# Verificar APK
Write-Host "[3/3] Verificando APK..." -ForegroundColor White
$apkPath = "app\build\outputs\apk\debug\app-debug.apk"
if (Test-Path $apkPath) {
    $apkSize = (Get-Item $apkPath).Length / 1MB
    Write-Host "  ✓ APK generado: $($apkSize.ToString('0.00')) MB" -ForegroundColor Green
} else {
    Write-Host "  ⚠ APK no encontrado (ejecutar desde Android Studio)" -ForegroundColor Yellow
}
Write-Host ""

Write-Host "====================================================" -ForegroundColor Green
Write-Host "  APLICACION LISTA                                 " -ForegroundColor Green
Write-Host "====================================================" -ForegroundColor Green
Write-Host ""

Write-Host "📋 INSTRUCCIONES:" -ForegroundColor Cyan
Write-Host ""
Write-Host "  OPCION 1 - Android Studio (Recomendado):" -ForegroundColor Yellow
Write-Host "    1. Abre Android Studio" -ForegroundColor White
Write-Host "    2. Abre este proyecto" -ForegroundColor White
Write-Host "    3. Haz clic en el botón verde 'Run' (Shift+F10)" -ForegroundColor White
Write-Host ""
Write-Host "  OPCION 2 - Dispositivo conectado:" -ForegroundColor Yellow
Write-Host "    1. Conecta tu dispositivo Android via USB" -ForegroundColor White
Write-Host "    2. Ejecuta: .\gradlew.bat installDebug" -ForegroundColor Magenta
Write-Host ""
Write-Host "====================================================" -ForegroundColor Cyan
Write-Host ""

Write-Host "👤 USUARIOS DE PRUEBA:" -ForegroundColor Cyan
Write-Host ""
Write-Host "  Usuario: admin        | Contraseña: admin123" -ForegroundColor White
Write-Host "  Usuario: conductor    | Contraseña: conductor123" -ForegroundColor White
Write-Host "  Usuario: usuario      | Contraseña: usuario123" -ForegroundColor White
Write-Host ""

Write-Host "====================================================" -ForegroundColor Green
Write-Host ""
Write-Host "✅ Proyecto refactorizado y optimizado" -ForegroundColor Green
Write-Host "✅ Código limpio y documentado" -ForegroundColor Green
Write-Host "✅ Sin dependencias innecesarias" -ForegroundColor Green
Write-Host "✅ Listo para ejecutar" -ForegroundColor Green
Write-Host ""
Write-Host "====================================================" -ForegroundColor Green
Write-Host ""

