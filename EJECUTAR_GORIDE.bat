@echo off
echo ====================================
echo   COMPILANDO E INSTALANDO GORIDE
echo ====================================
echo.

cd /d "%~dp0"

echo Paso 1: Deteniendo Gradle daemons...
call gradlew.bat --stop

echo.
echo Paso 2: Limpiando compilaciones anteriores...
if exist app\build rmdir /s /q app\build

echo.
echo Paso 3: Compilando e instalando GoRide en el emulador...
call gradlew.bat installDebug

echo.
echo ====================================
echo   PROCESO COMPLETADO
echo ====================================
echo.
echo Si el emulador esta corriendo, GoRide se instalo correctamente.
echo Busca el icono de GoRide en el emulador y abrelo.
echo.
pause

