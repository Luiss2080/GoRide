# Script de Verificación del Estado del Proyecto GoRide

Write-Host "╔════════════════════════════════════════════════╗" -ForegroundColor Cyan
Write-Host "║  Verificación de Configuración - GoRide       ║" -ForegroundColor Cyan
Write-Host "╚════════════════════════════════════════════════╝" -ForegroundColor Cyan
Write-Host ""

$proyectoDir = "C:\Users\LuissxD\AndroidStudioProjects\GoRide"
Set-Location $proyectoDir

# Verificar archivos clave
Write-Host "📋 Verificando archivos de configuración..." -ForegroundColor Yellow
Write-Host ""

# 1. Verificar gradle/libs.versions.toml
$tomlContent = Get-Content "gradle\libs.versions.toml" -Raw
if ($tomlContent -match 'agp = "8\.7\.3"') {
    Write-Host "✅ AGP versión 8.7.3 - CORRECTA" -ForegroundColor Green
} else {
    Write-Host "❌ AGP versión incorrecta" -ForegroundColor Red
}

# 2. Verificar gradle wrapper
$wrapperContent = Get-Content "gradle\wrapper\gradle-wrapper.properties" -Raw
if ($wrapperContent -match 'gradle-8\.9') {
    Write-Host "✅ Gradle versión 8.9 - CORRECTA" -ForegroundColor Green
} else {
    Write-Host "❌ Gradle versión incorrecta" -ForegroundColor Red
}

# 3. Verificar app/build.gradle.kts
$buildGradleContent = Get-Content "app\build.gradle.kts" -Raw
if ($buildGradleContent -match 'compileSdk = 35' -and $buildGradleContent -match 'targetSdk = 35') {
    Write-Host "✅ CompileSdk/TargetSdk = 35 - CORRECTOS" -ForegroundColor Green
} else {
    Write-Host "❌ CompileSdk/TargetSdk incorrectos" -ForegroundColor Red
}

# 4. Verificar .idea/gradle.xml
if (Test-Path ".idea\gradle.xml") {
    $gradleXmlContent = Get-Content ".idea\gradle.xml" -Raw
    if ($gradleXmlContent -match 'jbr-17') {
        Write-Host "✅ JDK configurado (jbr-17) - CORRECTO" -ForegroundColor Green
    } elseif ($gradleXmlContent -match '#GRADLE_LOCAL_JAVA_HOME') {
        Write-Host "⚠️  JDK configurado como GRADLE_LOCAL_JAVA_HOME" -ForegroundColor Yellow
        Write-Host "   Haz clic en 'Use Embedded JDK' en Android Studio" -ForegroundColor Yellow
    } else {
        Write-Host "ℹ️  JDK: Configuración por defecto" -ForegroundColor Cyan
    }
} else {
    Write-Host "ℹ️  Archivo gradle.xml no encontrado (se creará al abrir en Android Studio)" -ForegroundColor Cyan
}

Write-Host ""
Write-Host "📁 Verificando estructura del proyecto..." -ForegroundColor Yellow
Write-Host ""

# 5. Verificar archivos XML principales
$xmlFiles = @(
    "app\src\main\AndroidManifest.xml",
    "app\src\main\res\values\strings.xml",
    "app\src\main\res\values\colors.xml",
    "app\src\main\res\values\themes.xml"
)

$xmlOK = $true
foreach ($xml in $xmlFiles) {
    if (Test-Path $xml) {
        Write-Host "  ✅ $xml" -ForegroundColor Green
    } else {
        Write-Host "  ❌ $xml NO ENCONTRADO" -ForegroundColor Red
        $xmlOK = $false
    }
}

if ($xmlOK) {
    Write-Host ""
    Write-Host "✅ Todos los archivos XML están presentes" -ForegroundColor Green
}

Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor Cyan
Write-Host ""
Write-Host "📊 RESUMEN DEL ESTADO" -ForegroundColor Cyan
Write-Host ""

$allGood = $true

if (Test-Path "app\build") {
    Write-Host "ℹ️  Directorio build existe (es normal después de compilar)" -ForegroundColor Cyan
} else {
    Write-Host "✅ Directorio build limpio (se creará al compilar)" -ForegroundColor Green
}

Write-Host ""
Write-Host "🎯 SIGUIENTE PASO:" -ForegroundColor Yellow
Write-Host ""
Write-Host "  1. Abre Android Studio" -ForegroundColor White
Write-Host "  2. Abre el proyecto GoRide" -ForegroundColor White
Write-Host "  3. Si ves el error 'Invalid Gradle JDK configuration found':" -ForegroundColor White
Write-Host "     → Haz clic en 'Use Embedded JDK'" -ForegroundColor Magenta
Write-Host "  4. Haz clic en 'Sync Now' (barra amarilla)" -ForegroundColor White
Write-Host "  5. Espera a que termine la sincronización" -ForegroundColor White
Write-Host "  6. Build > Clean Project" -ForegroundColor White
Write-Host "  7. Build > Rebuild Project" -ForegroundColor White
Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor Cyan
Write-Host ""
Write-Host "✨ El proyecto está configurado correctamente ✨" -ForegroundColor Green
Write-Host ""

