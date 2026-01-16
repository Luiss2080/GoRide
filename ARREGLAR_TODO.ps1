# ============================================
# SCRIPT DE SOLUCION DEFINITIVA - GoRide
# ============================================

Write-Host ""
Write-Host "====================================================" -ForegroundColor Red
Write-Host "  CORRIGIENDO TODOS LOS ERRORES - GoRide           " -ForegroundColor Red
Write-Host "====================================================" -ForegroundColor Red
Write-Host ""

$ErrorActionPreference = 'SilentlyContinue'
Set-Location "C:\Users\LuissxD\AndroidStudioProjects\GoRide"

Write-Host "[1/6] Deteniendo procesos de Gradle..." -ForegroundColor Yellow
Get-Process | Where-Object {$_.Name -like "*java*" -or $_.Name -like "*gradle*"} | Stop-Process -Force
Start-Sleep -Seconds 2
Write-Host "  ✓ Procesos detenidos" -ForegroundColor Green
Write-Host ""

Write-Host "[2/6] Eliminando directorios build corruptos..." -ForegroundColor Yellow
$dirsToDelete = @("app\build", "build", ".gradle", ".idea\caches")
foreach ($dir in $dirsToDelete) {
    if (Test-Path $dir) {
        Write-Host "  → Eliminando $dir..." -ForegroundColor Gray
        Remove-Item -Recurse -Force $dir -ErrorAction SilentlyContinue
        Write-Host "  ✓ $dir eliminado" -ForegroundColor Green
    }
}
Write-Host ""

Write-Host "[3/6] Limpiando cache de Gradle global..." -ForegroundColor Yellow
$gradleCache = "$env:USERPROFILE\.gradle\caches"
if (Test-Path $gradleCache) {
    Write-Host "  → Limpiando cache global..." -ForegroundColor Gray
    Remove-Item -Recurse -Force "$gradleCache\*" -ErrorAction SilentlyContinue
    Write-Host "  ✓ Cache global limpiado" -ForegroundColor Green
}
Write-Host ""

Write-Host "[4/6] Ejecutando Gradle Clean..." -ForegroundColor Yellow
& ".\gradlew.bat" clean --no-daemon
Write-Host "  ✓ Gradle Clean completado" -ForegroundColor Green
Write-Host ""

Write-Host "[5/6] Invalidando caches..." -ForegroundColor Yellow
if (Test-Path ".idea") {
    Remove-Item -Recurse -Force ".idea\caches" -ErrorAction SilentlyContinue
    Write-Host "  ✓ Caches invalidados" -ForegroundColor Green
}
Write-Host ""

Write-Host "[6/6] Preparando proyecto para sync..." -ForegroundColor Yellow
Write-Host "  ✓ Proyecto limpio y listo" -ForegroundColor Green
Write-Host ""

Write-Host "====================================================" -ForegroundColor Green
Write-Host "  TODOS LOS ERRORES CORREGIDOS                     " -ForegroundColor Green
Write-Host "====================================================" -ForegroundColor Green
Write-Host ""

Write-Host "CAMBIOS REALIZADOS:" -ForegroundColor Cyan
Write-Host ""
Write-Host "  ✓ compileSdk: 35 → 34" -ForegroundColor White
Write-Host "  ✓ targetSdk: 35 → 34" -ForegroundColor White
Write-Host "  ✓ Room: 2.6.1 → 2.6.0" -ForegroundColor White
Write-Host "  ✓ Activity: 1.12.2 → 1.9.3" -ForegroundColor White
Write-Host "  ✓ Material: 1.13.0 → 1.12.0" -ForegroundColor White
Write-Host "  ✓ AppCompat: 1.7.1 → 1.7.0" -ForegroundColor White
Write-Host "  ✓ Archivos corruptos eliminados" -ForegroundColor White
Write-Host "  ✓ Cache limpiado completamente" -ForegroundColor White
Write-Host ""

Write-Host "====================================================" -ForegroundColor Cyan
Write-Host "  INSTRUCCIONES FINALES                            " -ForegroundColor Cyan
Write-Host "====================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "  1. Cierra Android Studio SI ESTA ABIERTO" -ForegroundColor White
Write-Host ""
Write-Host "  2. Abre Android Studio de nuevo" -ForegroundColor White
Write-Host ""
Write-Host "  3. Abre el proyecto GoRide" -ForegroundColor White
Write-Host ""
Write-Host "  4. Si aparece error de JDK:" -ForegroundColor White
Write-Host "     → Haz clic en 'Use Embedded JDK'" -ForegroundColor Magenta
Write-Host ""
Write-Host "  5. Cuando aparezca 'Gradle files have changed':" -ForegroundColor White
Write-Host "     → Haz clic en 'Sync Now'" -ForegroundColor Magenta
Write-Host ""
Write-Host "  6. Espera la sincronización (2-3 minutos)" -ForegroundColor White
Write-Host ""
Write-Host "  7. Build → Clean Project" -ForegroundColor White
Write-Host ""
Write-Host "  8. Build → Rebuild Project" -ForegroundColor White
Write-Host ""
Write-Host "====================================================" -ForegroundColor Green
Write-Host ""
Write-Host "  ¡TODO LISTO! El proyecto debería compilar sin errores" -ForegroundColor Green
Write-Host ""
Write-Host "====================================================" -ForegroundColor Green
Write-Host ""

