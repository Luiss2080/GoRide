# Script para compilar GoRide con configuración automática de JDK

Write-Host "=== Script de Compilación GoRide ===" -ForegroundColor Cyan
Write-Host ""

# Buscar JDK de Android Studio
$posiblesJDK = @(
    "C:\Program Files\Android\Android Studio\jbr",
    "C:\Program Files\Android\Android Studio\jre",
    "$env:LOCALAPPDATA\Android\Sdk\jbr",
    "C:\Program Files\Java\jdk-17",
    "C:\Program Files\Java\jdk-21",
    "C:\Program Files\Eclipse Adoptium\jdk-17*",
    "C:\Program Files\Eclipse Adoptium\jdk-21*"
)

$jdkEncontrado = $null
foreach ($ruta in $posiblesJDK) {
    if (Test-Path $ruta) {
        $jdkEncontrado = $ruta
        Write-Host "✓ JDK encontrado en: $jdkEncontrado" -ForegroundColor Green
        break
    }
}

if (-not $jdkEncontrado) {
    Write-Host "✗ No se encontró JDK instalado" -ForegroundColor Red
    Write-Host ""
    Write-Host "Por favor, realiza una de las siguientes opciones:" -ForegroundColor Yellow
    Write-Host "1. Abre Android Studio y ve a File > Sync Project with Gradle Files" -ForegroundColor Yellow
    Write-Host "2. Instala un JDK (recomendado: JDK 17 o 21)" -ForegroundColor Yellow
    Write-Host "3. Descarga desde: https://adoptium.net/" -ForegroundColor Yellow
    exit 1
}

# Configurar JAVA_HOME temporalmente
$env:JAVA_HOME = $jdkEncontrado
$env:PATH = "$jdkEncontrado\bin;$env:PATH"

Write-Host "✓ JAVA_HOME configurado temporalmente" -ForegroundColor Green
Write-Host ""

# Verificar versión de Java
Write-Host "Verificando versión de Java..." -ForegroundColor Cyan
& "$jdkEncontrado\bin\java.exe" -version
Write-Host ""

# Ir al directorio del proyecto
$proyectoDir = "C:\Users\LuissxD\AndroidStudioProjects\GoRide"
Set-Location $proyectoDir

Write-Host "=== Limpiando proyecto ===" -ForegroundColor Cyan
& .\gradlew clean

if ($LASTEXITCODE -eq 0) {
    Write-Host ""
    Write-Host "=== Compilando proyecto ===" -ForegroundColor Cyan
    & .\gradlew assembleDebug

    if ($LASTEXITCODE -eq 0) {
        Write-Host ""
        Write-Host "✓ ¡Compilación exitosa!" -ForegroundColor Green
        Write-Host "APK generado en: app\build\outputs\apk\debug\app-debug.apk" -ForegroundColor Green
    } else {
        Write-Host ""
        Write-Host "✗ Error en la compilación" -ForegroundColor Red
        Write-Host "Revisa los errores arriba" -ForegroundColor Yellow
    }
} else {
    Write-Host ""
    Write-Host "✗ Error en la limpieza del proyecto" -ForegroundColor Red
}

Write-Host ""
Write-Host "Presiona cualquier tecla para salir..."
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")

